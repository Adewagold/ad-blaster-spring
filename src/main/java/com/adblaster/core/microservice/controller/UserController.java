package com.adblaster.core.microservice.controller;

import com.adblaster.core.microservice.controller.ExceptionHandler.EmailExistsException;
import com.adblaster.core.microservice.controller.ExceptionHandler.FieldValidationException;
import com.adblaster.core.microservice.model.userModel.JwtLogin;
import com.adblaster.core.microservice.model.userModel.UserDto;
import com.adblaster.core.microservice.response.RequestResponse;
import com.adblaster.core.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<RequestResponse> signup(@RequestBody UserDto userDto) throws EmailExistsException, FieldValidationException {
        return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtLogin jwtLogin){
        return new ResponseEntity<>(new JwtLogin("",""),HttpStatus.OK);
    }

}
