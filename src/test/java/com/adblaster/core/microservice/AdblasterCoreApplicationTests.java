package com.adblaster.core.microservice;

import com.adblaster.core.microservice.service.SpotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdblasterCoreApplicationTests {
    @Autowired
    SpotService spotService;

    @Test
    public void contextLoads() {
    }


}
