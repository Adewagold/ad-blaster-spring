package com.adblaster.core.microservice.model.userModel;

import com.adblaster.core.microservice.model.security.User;
import com.adblaster.core.microservice.model.security.UserResponseObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * *  Created by Adewale Adeleye on 2019-07-20
 **/
public class JwtUserDetails implements UserDetails {
    private String username;
    private UserResponseObject credentials;

    public JwtUserDetails(String username, UserResponseObject user) {
        this.username = username;
        this.credentials = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public UserResponseObject getCredentials() {
        return credentials;
    }

}
