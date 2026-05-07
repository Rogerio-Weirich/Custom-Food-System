package com.snackbar.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.snackbar.util.Icon;

public class IngredientDAO {
    public static double getPrice(String ingredientName) {
        String sql = "SELECT price FROM ingredients WHERE name = ?";
        
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, ingredientName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next())  
                    return resultSet.getDouble("price");
            }
        } catch (Exception e) {
            System.err.println(
                Icon.ERROR + 
                " Error fetching price for Ingredient: " +
                ingredientName
            );
        }
        return 0.0;
    }

    public static int getStock(String ingredientName) {
        String sql = "SELECT stock FROM ingredients WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, ingredientName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("stock");
                }
            }
        } catch (Exception e) {
            System.err.println(
                Icon.ERROR + 
                " Error fetching stock for Ingredient: " +
                ingredientName
            );
        }
        return 0;
    }

    public static void decreaseStock(String ingredientName, int quantity) {
        String sql = "UPDATE ingredients SET stock = stock - ? WHERE name = ? AND stock >= ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, quantity);
            statement.setString(2, ingredientName);
            statement.setInt(3, quantity);

            int rows = statement.executeUpdate();
            
            if (rows == 0) {
                System.err.println(
                    Icon.WARNING +
                    " Insuficiente stock for ingredient: " +
                    ingredientName
                );
            }
        } catch (Exception e) {
            System.err.println(
                Icon.ERROR + 
                " Error updating stock for ingredient: " +
                ingredientName
            );
        }
    }
}
