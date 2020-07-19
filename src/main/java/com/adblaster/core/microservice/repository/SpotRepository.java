package com.adblaster.core.microservice.repository;

import com.adblaster.core.microservice.model.publisher.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * *  Created by Adewale Adeleye on 2019-07-21
 **/
@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {
}
