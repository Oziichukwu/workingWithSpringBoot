package com.phoenixStore.web.exception;

public class ProductDoesNotExistException extends PhoenixExceptions {
    public ProductDoesNotExistException() {
    }

    public ProductDoesNotExistException(String message) {
        super(message);
    }

    public ProductDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
