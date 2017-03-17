package com.fet.crm.smarthome.generic.model;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class QueryAlertEventResponse extends CommonResponse {
    private static final long serialVersionUID = -8116892004485348267L;
    private Integer totalSize;
    private AlertEvent[] alertEvents;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public Integer getTotalSize() {
        return totalSize;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param totalSize
     *            DOCUMENT ME!
     */
    public void setTotalSize(final Integer totalSize) {
        this.totalSize = totalSize;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public AlertEvent[] getAlertEvents() {
        return alertEvents;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param alertEvents
     *            DOCUMENT ME!
     */
    public void setAlertEvents(final AlertEvent[] alertEvents) {
        this.alertEvents = alertEvents;
    }
}
