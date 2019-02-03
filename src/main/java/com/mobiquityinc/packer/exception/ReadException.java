package com.mobiquityinc.packer.exception;

/**
 * Exception is thrown when reading an input is unsuccessful.
 */
public class ReadException extends Exception {
    public ReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
