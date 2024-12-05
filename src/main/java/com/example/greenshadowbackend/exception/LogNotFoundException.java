package com.example.greenshadowbackend.exception;

public class LogNotFoundException extends RuntimeException{
    public LogNotFoundException() {
        super();
    }

    public LogNotFoundException(String message) {
        super(message);
    }

    public LogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
