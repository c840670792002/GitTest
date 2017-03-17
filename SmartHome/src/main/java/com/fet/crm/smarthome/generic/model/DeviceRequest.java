package com.fet.crm.smarthome.generic.model;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class DeviceRequest implements Serializable {
    private static final long serialVersionUID = 6331989597188423452L;
    private String serial;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getSerial() {
        return serial;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param serial
     *            DOCUMENT ME!
     */
    public void setSerial(final String serial) {
        this.serial = serial;
    }
}
