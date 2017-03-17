package com.fet.crm.smarthome.mware.client;

import com.fet.crm.smarthome.generic.bean.OfferVO;

import java.util.List;

/**
 * 呼叫 bus CMOffer 之 client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public interface OfferClient {

    /**
     * DOCUMENT ME!
     * 
     * @param subscriberId
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    List<OfferVO> queryOfferList(final String subscriberId);
}
