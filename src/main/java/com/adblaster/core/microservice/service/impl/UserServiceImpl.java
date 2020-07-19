package com.adblaster.core.microservice.service.impl;

import com.adblaster.core.microservice.controller.ExceptionHandler.EmailExistsException;
import com.adblaster.core.microservice.controller.ExceptionHandler.FieldValidationException;
import com.adblaster.core.microservice.model.security.UserResponseObject;
import com.adblaster.core.microservice.model.userModel.JwtUserDetails;
import com.adblaster.core.microservice.model.userModel.UserDto;
import com.adblaster.core.microservice.model.security.Authority;
import com.adblaster.core.microservice.model.security.AuthorityName;
import com.adblaster.core.microservice.model.security.User;
import com.adblaster.core.microservice.repository.AuthorityRepository;
import com.adblaster.core.microservice.repository.UserRepository;
import com.adblaster.core.microservice.response.RequestResponse;
import com.adblaster.core.microservice.security.JwtTokenUtil;
import com.adblaster.core.microservice.security.JwtUser;
import com.adblaster.core.microservice.security.JwtUserFactory;
import com.adblaster.core.microservice.service.JwtAuthenticationResponse;
import com.adblaster.core.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Value("${email.exists.message}")
    private String emailExistsMessage;
    @Value("${user.created.message}")
    private String userCreatedMessage;
    @Value("${field.validation.message}")
    private String fieldValidationMessage;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RequestResponse saveUser(UserDto userDto) throws EmailExistsException, FieldValidationException {
        //Validate if user's details is not empty
        validateDetails(userDto);
        //Validate if email exists
        emailExist(userDto.getEmail());

        Authority authority = authorityRepository.findByName(AuthorityName.ROLE_USER);

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getEmail());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Date currentDate = new Date();
        user.setLastPasswordResetDate(currentDate);
        user.setAuthorities(Arrays.asList(authority));
        user.setEnabled(true);
        userRepository.save(user);

        User userResponse = userRepository.findByUsername(user.getUsername());
        JwtUser userDetails = JwtUserFactory.create(userResponse);
        String token = jwtTokenUtil.generateToken(userDetails);

        return new RequestResponse("00",userCreatedMessage, JwtUserFactory.createUserWithToken(userResponse,token));
    }

    private boolean emailExist(String email) throws EmailExistsException {
        User findUser = userRepository.findFirstByEmail(email);
        if(findUser!=null){
            throw new EmailExistsException(emailExistsMessage+ String.format(" %s",email));
        }
        return true;
    }

    private Boolean validateDetails(UserDto userDto) throws FieldValidationException {
        if(userDto.getEmail().isEmpty() || userDto.getEmail()==null) {
            throw new FieldValidationException("Email "+fieldValidationMessage);
        }
        else if(userDto.getPassword().isEmpty()||userDto.getPassword()==null){
            throw new FieldValidationException("Password "+fieldValidationMessage);
        }
       else if( userDto.getFirstname().isEmpty()||userDto.getFirstname()==null){
            throw new FieldValidationException("Firstname "+fieldValidationMessage);
        }
       else if(userDto.getLastname().isEmpty()||userDto.getLastname()==null){
            throw new FieldValidationException("Lastname "+fieldValidationMessage);
        }
       return true;
    }

    // Validate confirm password
    private Boolean confirmPassword(String password, String confirmPassword) throws FieldValidationException {
        if(!password.equals(confirmPassword)){
            throw new FieldValidationException("Password confirmation failed");
        }
        return true;
    }
}
