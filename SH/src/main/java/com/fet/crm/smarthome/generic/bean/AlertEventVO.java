package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class AlertEventVO implements Serializable {
    private static final long serialVersionUID = 8445993828589751187L;
    private int totalPage;
    private String time;
    private String picUrl;
    private DeviceVO device;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param totalPage
     *            DOCUMENT ME!
     */
    public void setTotalPage(final int totalPage) {
        this.totalPage = totalPage;
    }

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
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param picUrl
     *            DOCUMENT ME!
     */
    public void setPicUrl(final String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public DeviceVO getDevice() {
        return device;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param device
     *            DOCUMENT ME!
     */
    public void setDevice(final DeviceVO device) {
        this.device = device;
    }
}
