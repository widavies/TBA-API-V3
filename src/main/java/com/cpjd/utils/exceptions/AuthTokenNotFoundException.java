package com.cpjd.utils.exceptions;

/**
 * Thrown when the user forgets to set their Auth token with TBA.setAuthToken()
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class AuthTokenNotFoundException extends RuntimeException {

    public AuthTokenNotFoundException(String msg) {
        super(msg);
    }
}
