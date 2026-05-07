package com.snackbar.model.products;

import com.snackbar.model.Product;

public class Hamburger extends Product {
    public Hamburger(String name, String description) {
        super(name, description);
    }

    /**
     * The @Override indicates that the 'contract' made in the abstract class is being fulfilled
     */
    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }

    /**
     * Override the method getDetails to make it "look like" Hamburger
     */
    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());
        if (!getAddons().isEmpty()) {
            details.append("\n -> Customizable Addons: ");

            getAddons().forEach(addon ->
                    details.append("\n      + ").append(addon.toString())
            );
        }
        return details.toString();
    }
}
