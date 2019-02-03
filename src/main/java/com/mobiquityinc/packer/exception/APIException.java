package com.mobiquityinc.packer.exception;

/**
 * Exception is used when wrong input is passed.
 */
public class APIException extends Exception {
    public APIException(String message) {
        super(message);
    }
}
