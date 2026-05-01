package com.snackbar.util;

import com.snackbar.model.enums.Ingredient;
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
                System.out.println("Detailed order saved at DB.");
            } catch (Exception e) {
                conn.rollback();
                System.err.println(
                        "[ X ] Error to save Order. Transaction undone (Rollback). Error: " + e.getMessage()
                );
            }
        } catch (Exception e) {
            System.err.println(
                    "[ X ] Connection error with Database: " + e.getMessage()
            );
        }
    }
}