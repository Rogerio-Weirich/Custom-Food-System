package com.snackbar.util.exception;

/**
 * Exception thrown when there is an attempt to manipulate an invalid item/product
 * (ex.: tries to add a null product to the combo or cart)
 */
public class InvalidItemException extends RuntimeException {
    public InvalidItemException(String message) {
        super(message);
    }
}
