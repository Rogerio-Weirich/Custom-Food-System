package com.snackbar.util.exception;

/**
 * Exception thrown when occurs a forbidden status transition according to the business rule
 * (ex.: Tries to cancel a product which has already been delivered)
 */
public class InvalidOrderStatusException extends RuntimeException {
    public InvalidOrderStatusException(String message) {
        super(message);
    }
}
