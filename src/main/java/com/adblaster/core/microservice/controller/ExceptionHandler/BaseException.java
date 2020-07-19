package com.adblaster.core.microservice.controller.ExceptionHandler;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
public class BaseException extends Exception {
    private final String code;

    public BaseException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
