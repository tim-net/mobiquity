package com.mobiquityinc.packer.exception;

/**
 * Exception is used when parsing of input is unsuccessful.
 */
public class ParseException extends Exception{
    public ParseException(String message) {
        super(message);
    }
}
