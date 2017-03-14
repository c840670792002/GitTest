package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class CustomerVO implements Serializable {
    private static final long serialVersionUID = 7094861313719609464L;
    private String msisdn;
    private String subscriberId;
    private String productType;

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
    public String getProductType() {
        return productType;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param productType
     *            DOCUMENT ME!
     */
    public void setProductType(final String productType) {
        this.productType = productType;
    }
}
