package com.adblaster.core.microservice.model.userModel;

/**
 * *  Created by Adewale Adeleye on 2019-07-19
 **/
public abstract class UserTypeFactory {
    private String userType;

    public UserTypeFactory(String userType) {

        this.userType = userType;
    }

    public UserType getType(String userType){
        if(userType==null){
            return null;
        }
        switch (userType){
            case "advertiser":
                return new Publisher();
            case "publisher":
                return new Advertiser();
        }
        return null;
    }
}
