package com.adblaster.core.microservice.model.userModel;

import com.adblaster.core.microservice.model.security.Authority;
import com.adblaster.core.microservice.model.security.User;

import java.util.List;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
public class UserDto extends User {
    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setFirstname(String firstname) {
        super.setFirstname(firstname);
    }

    @Override
    public void setLastname(String lastname) {
        super.setLastname(lastname);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setAuthorities(List<Authority> authorities) {
        super.setAuthorities(authorities);
    }
}
