package com.fet.crm.smarthome.generic.model;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class QueryDeviceResponse extends CommonResponse {
    private static final long serialVersionUID = -3739161693864736187L;
    private Device[] devices;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Device[] getDevices() {
        return devices;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param devices
     *            DOCUMENT ME!
     */
    public void setDevices(final Device[] devices) {
        this.devices = devices;
    }
}
