package com.moby.dashboard.exception;

public class NotExistIdException extends RuntimeException {
    public NotExistIdException(String message) {
        super(message);
    }
}
