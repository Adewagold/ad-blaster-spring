package com.adblaster.core.microservice.service.impl;

import com.adblaster.core.microservice.model.publisher.Spot;
import com.adblaster.core.microservice.model.userModel.Publisher;
import com.adblaster.core.microservice.repository.SpotRepository;
import com.adblaster.core.microservice.response.RequestResponse;
import com.adblaster.core.microservice.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

/**
 * *  Created by Adewale Adeleye on 2019-07-21
 **/
@Service
public class SpotServiceImpl implements SpotService {

    @Autowired
    private SpotRepository spotRepository;

    @Override
    public void saveSpot(Spot spotRequest) {
        Spot spot = new Spot();
        spot.setAvailaleSlot(spotRequest.getAvailaleSlot());
        spot.setDescription(spotRequest.getDescription());
        spot.setLocation(spotRequest.getLocation());
        spot.setName(spotRequest.getName());
        spot.setThumbnail(spotRequest.getThumbnail());
        spotRepository.save(spot);
    }

    @Override
    public RequestResponse getSpots() {
        return new RequestResponse("00","Spots retrieved",spotRepository.findAll());
    }

    public Publisher getPublisher(){
        Publisher publisher = null;
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal()==null){
//             throw new AuthenticationException("Publisher not found");
        }
        publisher =(Publisher) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return publisher;
    }
}
