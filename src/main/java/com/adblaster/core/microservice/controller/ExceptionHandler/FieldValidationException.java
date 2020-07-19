package com.adblaster.core.microservice.controller.ExceptionHandler;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
public class FieldValidationException extends BaseException {
    private static final String CODE = "04";
    public FieldValidationException(String message) {
        super(message, CODE);
    }
}
