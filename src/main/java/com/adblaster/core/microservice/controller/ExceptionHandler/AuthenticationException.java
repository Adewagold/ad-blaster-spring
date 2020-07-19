package com.adblaster.core.microservice.controller.ExceptionHandler;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
