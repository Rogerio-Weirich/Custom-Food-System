package com.snackbar.model;

import com.snackbar.model.enums.Ingredient;
import com.snackbar.persistence.ProductDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class Product {
    private final String id;
    private String name;
    private double basePrice;
    private String description;

    protected final List<Ingredient> addons;

    public Product(String name, String description) {
        this.id = UUID.randomUUID().toString(); //random unique ID
        this.name = name;
        this.basePrice = ProductDAO.getPrice(name);
        this.description = description;
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
        return ProductDAO.isAvailable(name);
    }

    public void decreaseStock() {
        ProductDAO.decreaseRecipeStock(name);
        ProductDAO.decreaseAddonsStock(addons);
    }
    

    protected double calculateAddonsPrice() {
        return addons.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    public String getDetails() {
        String shortId = id.substring(0, 8);
        return String.format("ID: [%s]  | PRODUCT: %s \nPRICE: R$ %.2f | \nDESCRIPTION: %s",
                shortId, name, getBasePrice(),description);
    }
}
