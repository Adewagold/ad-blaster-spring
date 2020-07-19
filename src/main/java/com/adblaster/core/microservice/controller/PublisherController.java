package com.adblaster.core.microservice.controller;

import com.adblaster.core.microservice.controller.ExceptionHandler.EmailExistsException;
import com.adblaster.core.microservice.controller.ExceptionHandler.FieldValidationException;
import com.adblaster.core.microservice.model.userModel.UserDto;
import com.adblaster.core.microservice.response.RequestResponse;
import com.adblaster.core.microservice.service.SpotService;
import com.adblaster.core.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *  Created by Adewale Adeleye on 2019-07-21
 **/
@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {
    @Autowired
    private UserService userService;

    @Autowired
    private SpotService spotService;

    @GetMapping("update-profile")
    public ResponseEntity<RequestResponse> updateProfile(@RequestBody UserDto userDto) throws EmailExistsException, FieldValidationException {
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/spots")
    public ResponseEntity<RequestResponse> getSlots(){
        return new ResponseEntity<>(spotService.getSpots(),HttpStatus.OK);
    }
}
