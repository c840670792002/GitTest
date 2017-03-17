package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class OfferVO implements Serializable {
    private static final long serialVersionUID = 676333094890159546L;
    private String offerCode;
    private String offerName;
    private String deviceSerial;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getOfferCode() {
        return offerCode;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param offerCode
     *            DOCUMENT ME!
     */
    public void setOfferCode(final String offerCode) {
        this.offerCode = offerCode;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getOfferName() {
        return offerName;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param offerName
     *            DOCUMENT ME!
     */
    public void setOfferName(final String offerName) {
        this.offerName = offerName;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getDeviceSerial() {
        return deviceSerial;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param deviceSerial
     *            DOCUMENT ME!
     */
    public void setDeviceSerial(final String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }
}
