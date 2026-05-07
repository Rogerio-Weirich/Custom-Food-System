package com.snackbar.model;

import com.snackbar.model.enums.OrderStatus;
import com.snackbar.util.Icon;
import com.snackbar.util.exception.InvalidItemException;
import com.snackbar.util.exception.InvalidOrderStatusException;
import com.snackbar.util.exception.OutOfStockException;

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
        this.orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
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

    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }

    // Order business rule

    /**
     *  Adds a product to the order, if available in stock
     */
    public void addProduct(Product product) {
        if (product == null) {
            throw new InvalidItemException(
                Icon.WARNING + "Failed to add: \nThe product provided is invalid or inexistent"

            );
        }

        if (!product.isAvailable()) {
            throw new OutOfStockException(
                Icon.WARNING + 
                "The product: '" + product.getName() + 
                "' is currently out of stock"
        );
        }

        this.items.add(product);
        product.decreaseStock(1);
    }

    public void setStatus(OrderStatus newStatus) {
        if (this.status == OrderStatus.DELIVERED || this.status == OrderStatus.CANCELED) {
            throw new InvalidOrderStatusException(
                Icon.WARNING +
                "It's not possible to change the Order Status that is already" +
                this.status.getDescription()
            );
        }

        boolean valid = switch (this.status) {
            case PENDING   -> newStatus == OrderStatus.PREPARING || newStatus == OrderStatus.CANCELED;
            case PREPARING -> newStatus == OrderStatus.READY     || newStatus == OrderStatus.CANCELED;
            case READY     -> newStatus == OrderStatus.DELIVERED || newStatus == OrderStatus.CANCELED;
            default -> false;
        };

        if (!valid) throw new InvalidOrderStatusException(
            "Invalid transaction: " +
            this.status +
            " -> " +
            newStatus
        );
        this.status = newStatus;
    }

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
        receipt.append("          CUSTOM FOOD RECEIPT            \n");
        receipt.append("=========================================\n");
        receipt.append(String.format("Order: #%s  | Status: %s\n", orderId, status.getDescription()));
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
        receipt.append(String.format("Total amount due:          R$ %.2f\n",
                calculateTotalOrder()));
        receipt.append("==========================================\n");

        return receipt.toString();
    }
}
