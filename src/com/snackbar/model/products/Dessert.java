package com.snackbar.model.products;

import com.snackbar.model.Product;
import com.snackbar.persistence.IngredientDAO;
import com.snackbar.persistence.ProductDAO;

public class Dessert extends Product {
    public Dessert(String name, String description) {
        super(name, description);
    }

    /**
     * Implements the rule price for Disserts
     * Base price + cost of coverage/extras
     */
    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + calculateAddonsPrice();
    }

    @Override
    public void decreaseStock() {
        IngredientDAO.decreaseStock(getName(), 1);
        ProductDAO.decreaseAddonsStock(getAddons());
    }

    @Override
    public boolean isAvailable() {
        return IngredientDAO.getStock(getName()) > 0;
    }

    /**
     * Customize the exhibition of details, changing the term "Addons" to "Coverage/Extras"
     */
    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());

        if (!getAddons().isEmpty()) {
            details.append("\n -> Coverage/Extras: ");

            getAddons().forEach(addon ->
                    details.append("\n      + ").append(addon.toString())
            );
        }
        return details.toString();
    }
}
