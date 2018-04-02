package com.alex323glo.restvue.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alex323glo on 18.03.18.
 */
public class Validator {

    private static final Logger LOG = LoggerFactory.getLogger(Validator.class);

    public static final int DEFAULT_PASSWORD_LENGTH = 8;

    /**
     * Validates email address.
     * Email is valid, if:
     *  - it is not Null;
     *  - it is not empty;
     *  - it contains '@' char.
     */
    public static boolean validateEmail(String email) {
        if (email == null || email.length() < 1) {
            LOG.trace("email is null or its String is empty");
            return false;
        }

        if (!email.contains("@")) {
            LOG.trace("email doesn't match required pattern");
            return false;
        }

        LOG.trace("email is valid");
        return true;
    }

    /**
     * Validates password.
     * Password is valid, if:
     *  - it is not Null;
     *  - it is not empty;
     *  - it is not shorter then required minimum (second parameter).
     */
    public static boolean validatePassword(String password, int minPasswordLength) {
        if (password == null) {
            LOG.trace("password is null");
            return false;
        }

        if (password.length() < minPasswordLength) {
            LOG.trace("password String length is less then required minimum");
            return false;
        }

        LOG.trace("password is valid");
        return true;
    }

}
