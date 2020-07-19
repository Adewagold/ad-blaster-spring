package com.adblaster.core.microservice.model.userModel;

/**
 * *  Created by Adewale Adeleye on 2019-08-05
 **/
public class JwtLogin {
    private final String username;
    private final String password;

    public JwtLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
