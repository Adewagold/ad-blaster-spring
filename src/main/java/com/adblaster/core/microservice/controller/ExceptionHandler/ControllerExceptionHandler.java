package com.adblaster.core.microservice.controller.ExceptionHandler;

import com.adblaster.core.microservice.response.ErrorResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
@RestControllerAdvice
public class ControllerExceptionHandler extends Exception{
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseMessage responseMessage (AuthenticationException ex){
        return new ErrorResponseMessage("04",ex.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseMessage responseMessage (BaseException ex){
        return new ErrorResponseMessage(ex.getCode(),ex.getMessage());
    }

}
