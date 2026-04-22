package com.snackbar.model;

public class Side extends Product {
    public Side(String name, double basePrice, String description, int initalStock) {
        super(name, basePrice,description,initalStock);
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

        // Verify is there is addons (like bacon, etc.)
        if (!getAddons().isEmpty()) {
            details.append("\n -> Extra Sides: ");

            getAddons().forEach(addon ->
                details.append(addon.getDisplayName()).append(", ")
            );

            details.setLength(details.length() - 2);
        }

        return details.toString();
    }
}
