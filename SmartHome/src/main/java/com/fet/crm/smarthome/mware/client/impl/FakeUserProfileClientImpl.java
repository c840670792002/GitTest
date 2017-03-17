package com.fet.crm.smarthome.mware.client.impl;

import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.mware.client.UserProfileClient;

/**
 * 呼叫 CSP API 之 client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class FakeUserProfileClientImpl implements UserProfileClient {
    public static final String CSP_API_SUCCESS_CODE = "00000000";

    /**
     * DOCUMENT ME!
     * 
     * @param fetuid
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * 
     * @throws BusinessException
     *             DOCUMENT ME!
     */
    public UserProfile getUserProfile(final String fetuid) throws BusinessException {
        final UserProfile cspSDKOutput = new UserProfile();
        cspSDKOutput.setMsisdn(fetuid);
        return cspSDKOutput;
    }
}
