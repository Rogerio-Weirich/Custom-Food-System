package com.snackbar.main;

import com.snackbar.model.Hamburger;
import com.snackbar.model.Ingredient;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Starting the Custom Food System ====");

        Hamburger simpleBurger = new Hamburger("Classic Burger", 18.90, "Traditional Beef Patty", 50);
        System.out.println("--- Order 1: Simple ---");
        System.out.println(simpleBurger.getDetails());
        System.out.println("Stock Status: " + simpleBurger.getStockQuantity() + "units.\n");

        Hamburger customBurger = new Hamburger ("Custom Burger", 22.90, "Monster Beef Patty", 30);

        customBurger.addIngredient(Ingredient.BACON);
        customBurger.addIngredient(Ingredient.CHEDDAR_CHEESE);
        customBurger.addIngredient(Ingredient.SPICY_SAUCE);

        System.out.println("--- Order 2: Custom ---");
        System.out.println(customBurger.getDetails());

        customBurger.decreaseStock(1);
        System.out.println("Stock status after a sell: " + customBurger.getStockQuantity() + " units.");
    }
}
