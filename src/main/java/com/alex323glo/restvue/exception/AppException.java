package com.alex323glo.restvue.exception;

/**
 * Created by alex323glo on 18.03.18.
 */
public class AppException extends Exception {

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
