package com.fet.crm.smarthome.generic.model;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class ModifyAlertNotice implements Serializable {
    private static final long serialVersionUID = 3768506228703016472L;
    private String value;
    private String type;

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
}
