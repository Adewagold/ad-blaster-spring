package com.adblaster.core.microservice.response;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
public class RequestResponse extends BaseResponse {
    private Object data;

    public Object getData() {
        return data;
    }
    public String token;

    public RequestResponse(String code, String message, Object data) {
        super(code, message);
        this.data = data;
    }
}
