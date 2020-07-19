package com.adblaster.core.microservice.response;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
public class BaseResponse {
    private final String code;
    private final String message;

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
