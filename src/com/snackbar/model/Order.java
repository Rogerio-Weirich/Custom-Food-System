package com.snackbar.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderId;
    private String customerName;
    private List<Product> items;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public Order(String customerName) {
        // Generates a short ID with 6 char to simulate a panel's password
        this.orderId = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus () {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }

    // Order business rule

    /**
     *  Adds a product to the order, if available in stock
     */
    public void addProduct(Product product) {
        if (product != null && product.isAvailable()) {
            this.items.add(product);
            product.decreaseStock(1); // It automatically updates the inventory when add item to cart
        } else {
            System.out.println("[ X ] Product" +
            (product != null ? product.getName() : "invalid") +
            "No current stock");
        }
    }

    /**
     * Calculates the total price of all order items
     */
    public double calculateTotalOrder() {
        return items.stream()
                   .mapToDouble(Product::calculateFinalPrice)
                   .sum();
    }

    /**
     * Generates a "Final Receipt" formated to exhibition
     */
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        receipt.append("=========================================\n");
        receipt.append("       🍔 CUSTOM BURGER RECEIPT 🍔       \n");
        receipt.append("=========================================\n");
        receipt.append(String.format("Order: #%s | Status: %s\n", orderId, status.getDescription()));
        receipt.append(String.format("Customer: %s\n", customerName));
        receipt.append(String.format("Date: %s\n", createdAt.format(formatter)));
        receipt.append("-----------------------------------------\n");
        receipt.append("ITEMS:\n");

        if (items.isEmpty()) {
            receipt.append("  (No item added)\n");
        } else {
            for (Product item : items) {
                receipt.append(item.getDetails()).append("\n\n");
            }
        }

        receipt.append("-----------------------------------------\n");
        receipt.append(String.format("Total amount due:          R$ %.2f\\n", calculateTotalOrder()));
        receipt.append("==========================================\n");

        return receipt.toString();
    }
}
