package com.snackbar.model;

import com.snackbar.model.enums.Ingredient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class Product {
    private final String id;
    private String name;
    private double basePrice;
    private String description;
    private int stockQuantity;

    protected final List<Ingredient> addons;

    public Product(String name, double basePrice, String description, int initialStock) {
        this.id = UUID.randomUUID().toString(); //random unique ID
        this.name = name;
        this.basePrice = basePrice;
        this.description = description;
        this.stockQuantity = initialStock;
        this.addons = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getDescription() {
        return description;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public List<Ingredient> getAddons() {
        return Collections.unmodifiableList(addons);
    }

    //Business rule
    public abstract double calculateFinalPrice();

    public void addIngredient(Ingredient ingredient) {
        if (ingredient != null) {
            this.addons.add(ingredient);
        }
    }

    // Stcok management
    public boolean isAvailable() {
        return stockQuantity > 0;
    }

    public void decreaseStock(int quantity) {
        if (quantity > 0 && quantity <= stockQuantity) {
            stockQuantity -= quantity;
        }
    }

    protected double calculateAddonsPrice() {
        return addons.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    public String getDetails() {
        String shortId = id.substring(0, 8);
        return String.format("ID: [%s]  | Product: %s \nPrice: R$ %.2f | \nDescription: %s",
                shortId, name, getBasePrice(),description);
    }
}
