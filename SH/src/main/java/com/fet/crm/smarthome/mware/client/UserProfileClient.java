package com.fet.crm.smarthome.mware.client;

import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;

/**
 * 呼叫 CSP API 之 client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public interface UserProfileClient {

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
    UserProfile getUserProfile(final String fetuid) throws BusinessException;
}
