package com.fet.crm.smarthome.mware.client;

import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config/applicationContext-*-config.xml" })
public class SIGClientTest {
    private static final ILogger LOG = LoggerFactory.getLogger(SIGClientTest.class);
    @Autowired
    private SIGClient sigClient;

    @BeforeClass
    public static void initSigSetting() {
        final URL sigHome = SIGClientTest.class.getResource("/sig_home/");
        LOG.info(sigHome.getPath());
        System.setProperty("SIG_HOME", sigHome.getPath());
    }

    @Test
    public void testRetvKeysByMsisdn() {
        try {
            sigClient.retvKeysByMsisdn("0903504410");
        } catch (Exception e) {
            // igored
        }
    }
}
