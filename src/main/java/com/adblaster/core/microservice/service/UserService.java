package com.adblaster.core.microservice.service;

import com.adblaster.core.microservice.controller.ExceptionHandler.EmailExistsException;
import com.adblaster.core.microservice.controller.ExceptionHandler.FieldValidationException;
import com.adblaster.core.microservice.model.userModel.UserDto;
import com.adblaster.core.microservice.response.RequestResponse;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
public interface UserService {
     RequestResponse saveUser(UserDto userDto) throws EmailExistsException, FieldValidationException;
}
