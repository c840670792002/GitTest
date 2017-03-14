package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;
import java.util.List;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class QueryDeviceVO implements Serializable {
    private static final long serialVersionUID = -2859041667549014174L;
    private String msisdn;
    private String subscriberId;
    private List<OfferVO> offers;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     */
    public void setMsisdn(final String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param subscriberId
     *            DOCUMENT ME!
     */
    public void setSubscriberId(final String subscriberId) {
        this.subscriberId = subscriberId;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public List<OfferVO> getOffers() {
        return offers;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param offers
     *            DOCUMENT ME!
     */
    public void setOffers(final List<OfferVO> offers) {
        this.offers = offers;
    }
}
