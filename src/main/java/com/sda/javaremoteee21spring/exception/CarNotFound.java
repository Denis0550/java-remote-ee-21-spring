package com.sda.javaremoteee21spring.exception;

public class CarNotFound extends RuntimeException {

    public CarNotFound() {
    }

    public CarNotFound(String message) {
        super(message);
    }

    public CarNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNotFound(Throwable cause) {
        super(cause);
    }

    public CarNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
