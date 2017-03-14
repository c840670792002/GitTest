package com.fet.crm.smarthome.generic.model;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class QueryAlertEventRequest extends CommonQueryDeviceRequest {
    private static final long serialVersionUID = 1829314467257729895L;
    private String startTime;
    private String endTime;
    private int pageNum;
    private int pageSize;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param startTime
     *            DOCUMENT ME!
     */
    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param endTime
     *            DOCUMENT ME!
     */
    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getPageNum() {
        return pageNum;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param pageNum
     *            DOCUMENT ME!
     */
    public void setPageNum(final int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param pageSize
     *            DOCUMENT ME!
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }
}
