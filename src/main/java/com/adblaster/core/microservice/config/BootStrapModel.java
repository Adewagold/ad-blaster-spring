package com.adblaster.core.microservice.config;

import com.adblaster.core.microservice.model.publisher.Spot;
import com.adblaster.core.microservice.model.security.User;
import com.adblaster.core.microservice.model.userModel.Publisher;
import com.adblaster.core.microservice.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;

/**
 * *  Created by Adewale Adeleye on 2020-07-19
 **/
@Component
public class BootStrapModel implements CommandLineRunner {
    @Autowired
    SpotService spotService;

    @Override
    public void run(String... args) throws Exception {
        Spot spot1 = new Spot();
        User user = new User();
        user.setUsername("Adewale");
        user.setEnabled(true);
        user.setLastPasswordResetDate(Date.from(Instant.now()));
        user.setLastname("Adeleye");
        user.setEmail("adewagold@gm.com");
        user.setPassword("*****encoded***");

        Publisher publisher = new Publisher();
        publisher.setUser(user);

        publisher.setWebsite("www.man.hey.com");

        spot1.setName("Spot one");
        spot1.setLocation("Lagos, Nigeria");
        spot1.setAvailaleSlot(100L);

        spotService.saveSpot(spot1);
    }
}
