package com.alex323glo.restvue.exception;

/**
 * Created by alex323glo on 18.03.18.
 */
public class ValidationException extends AppException {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
