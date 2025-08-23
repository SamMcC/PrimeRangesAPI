package com.mccormack.exception;

public class NonCalculableInputException extends RuntimeException {
    public NonCalculableInputException(String message) {
        super(message);
    }
}
