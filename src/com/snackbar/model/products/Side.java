package com.snackbar.model.products;

import com.snackbar.model.Product;

public class Side extends Product {
    public Side(String name, String description) {
        super(name, description);
    }

    /**
     * Mandatory implementation of the pricing rule.
     * Add up the base price of the side dish to any extra charges added.
     */
    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());

        if (!getAddons().isEmpty()) {
            details.append("\n -> Extra Sides: ");

            getAddons().forEach(addon ->
                    details.append("\n      + ").append(addon.toString())
            );
        }
        return details.toString();
    }
}
