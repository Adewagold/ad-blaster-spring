package com.adblaster.core.microservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *  Created by Adewale Adeleye on 2019-07-20
 **/
@RestController
@RequestMapping("/api/v1/advertiser")
public class AdvertiserController {

    @GetMapping("/profile")
    public ResponseEntity<String> profile(){
        return new ResponseEntity<>("Welcome to the advertiser's area",HttpStatus.OK);
    }

}
