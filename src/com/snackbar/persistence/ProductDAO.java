package com.snackbar.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.snackbar.model.enums.Ingredient;
import com.snackbar.util.Icon;

public class ProductDAO {
    public static double getPrice(String productName) {
        String sql = "SELECT base_price FROM products WHERE name = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, productName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next())
                    return resultSet.getDouble("base_price");
            }
        } catch (Exception e) {
            System.err.println(
                Icon.ERROR +
                " Error fetching price for product: "
                + productName
            );
        }
        return 0.0;
    }

    public static boolean isAvailable(String productName) {
        String sql = """
                SELECT i.stock, pr.quantity
                FROM product_recipes pr
                JOIN ingredients i ON pr.ingredient_id = i.id
                JOIN products p ON pr.product_id = p.id
                WHERE p.name = ?
                """;
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, productName);
            try (ResultSet resultSet = statement.executeQuery()) {
                
                if (!resultSet.isBeforeFirst()) return true;

                while (resultSet.next()) {
                    if (resultSet.getInt("stock") < resultSet.getInt("quantity")) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(
                Icon.ERROR + 
                " Error checking availability for: " +
                productName
            );
        }
        return true;
    }

    public static void decreaseRecipeStock(String productName) {
        String sql = """
                SELECT i.name, pr.quantity
                FROM product_recipes pr
                JOIN ingredients i ON pr.igredient_id = i.id
                JOIN products p ON pr.product_id = p.id
                WHERE p.name = ?
                """;
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, productName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    IngredientDAO.decreaseStock(resultSet.getString("name"), 
                    resultSet.getInt("quantity"));
                }
            }
        } catch (Exception e) {
            System.err.println(
                Icon.ERROR +
                " Error decreasing recipe stock for: " +
                productName
            );
        }
    }

    public static void decreaseAddonsStock(List<Ingredient> addons) {
        for (Ingredient addon : addons) {
            IngredientDAO.decreaseStock(addon.getDisplayName(), 1);
        }
    }
}
