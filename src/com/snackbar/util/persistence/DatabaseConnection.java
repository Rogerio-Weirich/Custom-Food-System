package com.snackbar.util.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/custom_food_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("[ X ] MySQL Driver not found! Ensure the library was correctly added.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("[ X ] Database connection failed!");
            System.err.println("Check if MySQL is running. \nCheck if the password is correct.");
            throw new RuntimeException(e);
        }
    }
}
