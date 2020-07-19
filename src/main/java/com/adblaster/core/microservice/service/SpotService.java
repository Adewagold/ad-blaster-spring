package com.adblaster.core.microservice.service;

import com.adblaster.core.microservice.model.publisher.Spot;
import com.adblaster.core.microservice.response.RequestResponse;

/**
 * *  Created by Adewale Adeleye on 2019-07-21
 **/
public interface SpotService {
    void saveSpot(Spot spot);

    RequestResponse getSpots();
}
