package com.alex323glo.restvue.exception;

/**
 * Created by alex323glo on 18.03.18.
 */
public class AuthorizationException extends AppException {

    public AuthorizationException() {
    }

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
