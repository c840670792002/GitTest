package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class DeviceVO implements Serializable {
    private static final long serialVersionUID = 8562010122454245094L;
    private String type;
    private String serial;
    private String power;
    private String status;
    private String connTime;
    private String pSerial;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getType() {
        return type;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param type
     *            DOCUMENT ME!
     */
    public void setType(final String type) {
        this.type = type;
    }

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

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getPower() {
        return power;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param power
     *            DOCUMENT ME!
     */
    public void setPower(final String power) {
        this.power = power;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getStatus() {
        return status;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param status
     *            DOCUMENT ME!
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getConnTime() {
        return connTime;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param connTime
     *            DOCUMENT ME!
     */
    public void setConnTime(final String connTime) {
        this.connTime = connTime;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getpSerial() {
        return pSerial;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param pSerial
     *            DOCUMENT ME!
     */
    public void setpSerial(final String pSerial) {
        this.pSerial = pSerial;
    }
}
