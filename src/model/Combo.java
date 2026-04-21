package model;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Product {
    private List<Product> items;
    private double discountPercentage;

    /**
     *  Combo class constructor
     * @param discountPercentage Decimal Value representing the discount (e.g., 0.10 = 10%)
     */
    public Combo(String name, String description, double discountPercentage, int initialStock) {
        super(name, 0.0, description, initialStock);
        this.items = new ArrayList<>();
        this.discountPercentage = discountPercentage;
    }

    /**
     *  Adds a product (Hamburger, Beverage, Dessert) to the combo.
     */
    public void addItem(Product product) {
        if (product != null) {
            this.items.add(product);
        }
    }

    /**
     * Calculates the combo's final price
     * Adds the final price of all items then applies the discount
     */
    @Override
    public double calculateFinalPrice() {
        double totalItemsPrice = 0.0;

        // Add up the price of each product within the combo
        for (Product item : items) {
            totalItemsPrice += item.calculateFinalPrice(); // <- Polymorphism
        }

        // This also includes any additional charges that may apply directly to the combo
        double comboAddonsPrice = calculateAddonsPrice();

        double subtotal = totalItemsPrice + comboAddonsPrice;

        return subtotal - (subtotal * discountPercentage); // Applies the discount
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails());

        if (!items.isEmpty()) {
            details.append("\n -> Combo items:\n");

            for (Product item : items) {
                details.append(String.format("        - %s (R$ %.2f)\n", item.getName(), item.calculateFinalPrice()));
            }
            details.setLength(details.length() - 1);
        }
        return details.toString();
    }
}
