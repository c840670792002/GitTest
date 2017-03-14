package com.fet.crm.smarthome.generic.model;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class CommonQueryDeviceRequest implements Serializable {
    private static final long serialVersionUID = 2149654473889151816L;
    private String msisdn;
    private DeviceRequest device;

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
    public DeviceRequest getDevice() {
        return device;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param device
     *            DOCUMENT ME!
     */
    public void setDevice(final DeviceRequest device) {
        this.device = device;
    }
}
