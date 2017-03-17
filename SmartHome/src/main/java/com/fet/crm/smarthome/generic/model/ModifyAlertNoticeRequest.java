package com.fet.crm.smarthome.generic.model;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class ModifyAlertNoticeRequest extends CommonQueryDeviceRequest {
    private static final long serialVersionUID = -3676988513322128055L;
    private ModifyAlertNotice alertNotice;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public ModifyAlertNotice getAlertNotice() {
        return alertNotice;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param alertNotice
     *            DOCUMENT ME!
     */
    public void setAlertNotice(final ModifyAlertNotice alertNotice) {
        this.alertNotice = alertNotice;
    }
}
