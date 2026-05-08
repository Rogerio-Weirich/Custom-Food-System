package com.snackbar.model.products;

import com.snackbar.model.Product;
import com.snackbar.persistence.IngredientDAO;
import com.snackbar.persistence.ProductDAO;

public class Beverage extends Product {
    public Beverage(String name, String description) {
        super(name, description);
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
    public void decreaseStock() {
        IngredientDAO.decreaseStock(getName(), 1);
        ProductDAO.decreaseAddonsStock(getAddons());
    }

    @Override
    public boolean isAvailable() {
        return IngredientDAO.getStock(getName()) > 0;
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