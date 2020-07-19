package com.adblaster.core.microservice.model.security;

import java.util.ArrayList;
import java.util.List;

/**
 * *  Created by Adewale Adeleye on 2019-07-20
 **/
public class UserResponseObject {
    private String firstname;
    private String lastname;
    private String email;
    private List<Object> roles;

    private User user;

    public UserResponseObject(User user) {
        this.user = user;
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email= user.getEmail();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        List<String> authorities = new ArrayList<>();
        user.getAuthorities().stream().forEach(authority -> authorities.add(authority.getName().toString()));
        return authorities;
    }


}
