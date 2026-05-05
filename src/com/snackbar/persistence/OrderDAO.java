package com.snackbar.persistence;

import com.snackbar.model.enums.Ingredient;
import com.snackbar.util.Icon;
import com.snackbar.model.Order;
import com.snackbar.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDAO {
    public static void saveOrderToDatabase(Order order) {
        String insertOrderSQL = "INSERT INTO orders " +
                "(order_hash, customer_name, status, total_amount) " +
                "VALUES (?, ?, ?, ?)";
        String insertItemSQL  = "INSERT INTO order_items " +
                "(order_id, product_name, base_price, ingredient_name, addon_price, product_type, total_price)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement orderStatement = conn.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS)){

                orderStatement.setString(1, order.getOrderId());
                orderStatement.setString(2, order.getCustomerName());
                orderStatement.setString(3, order.getStatus().name());
                orderStatement.setDouble(4, order.calculateTotalOrder());
                orderStatement.executeUpdate();

                ResultSet orderKeys = orderStatement.getGeneratedKeys();
                if (orderKeys.next()) {
                    int dbOrderId = orderKeys.getInt(1);

                    try (PreparedStatement itemStatement = conn.prepareStatement(insertItemSQL)) {
                        for (Product product : order.getItems()) {
                            if (product.getAddons() != null && !product.getAddons().isEmpty()) {
                                for (Object addonObject : product.getAddons()) {
                                    Ingredient ingredient = (Ingredient) addonObject;

                                    itemStatement.setInt(1, dbOrderId);
                                    itemStatement.setString(2, product.getName());
                                    itemStatement.setDouble(3, product.getBasePrice());
                                    itemStatement.setString(4, ingredient.getDisplayName());
                                    itemStatement.setDouble(5, ingredient.getPrice());
                                    itemStatement.setString(6, product.getDescription());
                                    itemStatement.setDouble(7, product.calculateFinalPrice());
                                    itemStatement.addBatch();
                                }

                            } else {
                                itemStatement.setInt(1, dbOrderId);
                                itemStatement.setString(2, product.getName());
                                itemStatement.setDouble(3, product.getBasePrice());
                                itemStatement.setString(4, "-");
                                itemStatement.setDouble(5, 0.00);
                                itemStatement.setString(6, product.getDescription());
                                itemStatement.setDouble(7, product.calculateFinalPrice());
                                itemStatement.addBatch();
                            }
                        }
                        itemStatement.executeBatch();
                    }
                }
                conn.commit();
                System.out.println(
                    Icon.SAVE + 
                    " Detailed order saved at DB."

                );
            } catch (Exception e) {
                conn.rollback();
                System.err.println(
                        Icon.ERROR + 
                        " Error to save Order. Transaction undone (Rollback). \nError: " + 
                        e.getMessage()
                );
            }
        } catch (Exception e) {
            System.err.println(
                    Icon.ERROR + 
                    " Connection error with Database: " + 
                    e.getMessage()
            );
        }
    }

    public static void updateOrderStatus(int orderId, String newStatus) {
        String updateSQL = "UPDATE orders SET status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(updateSQL)) {
            
            statement.setString(1, newStatus);
            statement.setInt(2, orderId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(
                    Icon.SAVE + 
                    "Order Status #" + 
                    orderId + 
                    " updated to: " + 
                    newStatus
                );
            } else {
                System.out.println(
                    Icon.WARNING + 
                    "No order found with the ID #" + 
                    orderId
                );
            }
        } catch (Exception e) {
            System.err.println(
                Icon.ERROR + 
                "Error updating order status: " + 
                e.getMessage()
            );
        }
    }

    public static void displayActiveOrder() {
        String queryOrders = "SELECT * FROM orders WHERE status IN ('PENDING', 'PREPARING')";
        String queryItems = "SELECT * FROM order_items WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statementOrders = conn.prepareStatement(queryOrders);
            ResultSet resultSetOrders = statementOrders.executeQuery()) {

            boolean hasOrders = false;
        
            System.out.println("\n=======  ACTIVE ORDERS =======");

            while (resultSetOrders.next()) {
                hasOrders = true;
                int orderId = resultSetOrders.getInt("id");
                String customer = resultSetOrders.getString("customer_name");
                String status = resultSetOrders.getString("status");

                System.out.println(
                    "\n[ ORDER #" + 
                    orderId + 
                    " ] - Customer " + 
                    customer + 
                    " | Current Status: " + 
                    status
                );
                System.out.println("Pending: ");

                try (PreparedStatement statementItems = conn.prepareStatement(queryItems)) {
                    statementItems.setInt(1, orderId);
                    try (ResultSet resultSetItems = statementItems.executeQuery()) {
                        while (resultSetItems.next()) {
                            String product = resultSetItems.getString("product_name");
                            String type = resultSetItems.getString("product_type");
                            String ingredient = resultSetItems.getString("ingredient_name");

                            System.out.println(
                                "  ->" + 
                                product + 
                                " (" + type + 
                                ") | Extra/Ingredient: " + 
                                ingredient    
                            );
                        }
                    }
                }
            }

            if (!hasOrders) {
                System.out.println("No active orders.");
            }

        } catch (Exception e) {
            System.err.println(
                Icon.ERROR + 
                "Error retrieving orders from the Kitchen: " + 
                e.getMessage()
            );
        }
    }

    public static int getPendingOrdersCount() {
        String query = "SELECT COUNT(*) FROM orders WHERE status in ('PENDING', 'PREPARING')";

        int count = 0;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {
            
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (Exception e) {
            System.err.println(
                Icon.ERROR + 
                "Error checking kitchen queries: " +
                e.getMessage()
            );
        }
        
        return count;
    }
}