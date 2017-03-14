package com.fet.crm.smarthome.mware.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config/applicationContext-*-config.xml" })
public class OfferClientTest {
    @Autowired
    private OfferClient offerClient;

    @Test
    public void testQueryOfferList() {
        try {
            offerClient.queryOfferList("800049826");
        } catch (Exception e) {
            // igored
        }
    }
}
