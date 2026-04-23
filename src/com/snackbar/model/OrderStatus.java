package com.snackbar.model;

// Enum that represents the possible status of an order at the system
public enum OrderStatus {
    PENDING("Pending"),
    PREPARING("Preparing"),
    READY("Ready"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
