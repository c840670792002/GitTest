package com.fet.crm.smarthome.generic.model;


/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class QueryAlertNoticeResponse extends CommonResponse {
    private static final long serialVersionUID = 1071015833090005791L;
    private AlertNotice[] alertNotices;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public AlertNotice[] getAlertNotices() {
        return alertNotices;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param alertNotices
     *            DOCUMENT ME!
     */
    public void setAlertNotices(final AlertNotice[] alertNotices) {
        this.alertNotices = alertNotices;
    }
}
