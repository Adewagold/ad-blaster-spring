package com.adblaster.core.microservice.model.userModel;

import com.adblaster.core.microservice.model.BaseEntity;
import com.adblaster.core.microservice.model.security.User;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * *  Created by Adewale Adeleye on 2019-07-19
 **/
@MappedSuperclass
public class UserType extends BaseEntity {

    private String address;
    private String phoneNumber;
    private String country;
    private String state;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
