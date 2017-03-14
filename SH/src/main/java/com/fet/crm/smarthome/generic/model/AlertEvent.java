package com.fet.crm.smarthome.generic.model;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class AlertEvent implements Serializable {
    private static final long serialVersionUID = 6868493405963424561L;
    private String time;
    private String pic;
    private Device device;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getTime() {
        return time;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param time
     *            DOCUMENT ME!
     */
    public void setTime(final String time) {
        this.time = time;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getPic() {
        return pic;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param pic
     *            DOCUMENT ME!
     */
    public void setPic(final String pic) {
        this.pic = pic;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Device getDevice() {
        return device;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param device
     *            DOCUMENT ME!
     */
    public void setDevice(final Device device) {
        this.device = device;
    }
}
