package com.cpjd.utils.exceptions;

/**
 * This exception is thrown when the user tries to call data that isn't there
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String msg) {
        super(msg+". Please double check the parameters you passed in and make sure you have an internet connection.");
    }

}
