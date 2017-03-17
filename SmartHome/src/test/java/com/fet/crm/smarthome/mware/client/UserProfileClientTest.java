package com.fet.crm.smarthome.mware.client;

import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.mware.client.impl.UserProfileClientImpl;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import org.junit.Before;
import org.junit.Test;

public class UserProfileClientTest {

    private static final ILogger LOG = LoggerFactory.getLogger(UserProfileClientTest.class);
    private UserProfileClient userProfileClient;

    @Before
    public void setup() {
        userProfileClient = new UserProfileClientImpl();
    }

    @Test
    public void testGetUserProfile() {
        try {
            UserProfile up = userProfileClient.getUserProfile("0976551645");
        } catch (BusinessException e) {
            // ignored
        }
    }
}
