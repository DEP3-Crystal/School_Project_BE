package com.crystal.school.exception;

public class UserTakenException extends RuntimeException {
    public UserTakenException() {
    }

    public UserTakenException(String message) {
        super(message);
    }

    public UserTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
