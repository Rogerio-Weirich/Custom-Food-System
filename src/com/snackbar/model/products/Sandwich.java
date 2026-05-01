package com.snackbar.model.products;

import com.snackbar.model.Product;

public class Sandwich extends Product {
    public Sandwich(String name, double basePrice, String description, int initialStock) {
        super(name, basePrice, description, initialStock);
    }

    /**
     * Implementation of the pricing rule: Base price + Extra Filling price
     */
    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());

        if (!getAddons().isEmpty()) {
            details.append("\n -> Fillings and Extras: ");

            getAddons().forEach(addon ->
                    details.append("\n      + ").append(addon.toString())
            );
        }
        return details.toString();
    }
}