package com.money_converter.exception;

public class InvalidOperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidOperationException(String s) {
        super(s);
    }
}
