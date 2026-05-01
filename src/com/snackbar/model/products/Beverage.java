package com.snackbar.model.products;

import com.snackbar.model.Product;

public class Beverage extends Product {
    public Beverage(String name, double basePrice, String description, int initialStock) {
        super(name, basePrice,description,initialStock);
    }

    /**
     * Business rule to calculate the implemantation of Beverage
     * Base Price + any extra that the client would want to add
     */
    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }


    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());
        if (!getAddons().isEmpty()) {
            details.append("\n -> Extras Beverage: ");

            getAddons().forEach(addon ->
                    details.append("\n      + ").append(addon.toString())
            );
        }
        return details.toString();
    }
}