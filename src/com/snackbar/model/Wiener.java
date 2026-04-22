package com.snackbar.model;

public class Wiener extends Product {
    public Wiener(String name, double basePrice, String description, int initialStock) {
        super(name, basePrice, description, initialStock);
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());

        if (!getAddons().isEmpty()) {
            details.append("\n -> Sausages and Extras: ");

            getAddons().forEach(addon ->
                details.append(addon.getDisplayName()).append(", ")
            );

            details.setLength(details.length() - 2);
        }

        return details.toString();
    }
}