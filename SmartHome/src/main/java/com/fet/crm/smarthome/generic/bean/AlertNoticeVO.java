package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class AlertNoticeVO implements Serializable {
    private static final long serialVersionUID = -6647102448679311235L;
    private String value;
    private String type;
    private String status;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getValue() {
        return value;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param value
     *            DOCUMENT ME!
     */
    public void setValue(final String value) {
        this.value = value;
    }

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
}
