package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class DeviceResultVO implements Serializable {
    private static final long serialVersionUID = 5646726941512195270L;
    private String status;
    private String msg;
    private String errCode;

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
    public String getMsg() {
        return msg;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param msg
     *            DOCUMENT ME!
     */
    public void setMsg(final String msg) {
        this.msg = msg;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param errCode
     *            DOCUMENT ME!
     */
    public void setErrCode(final String errCode) {
        this.errCode = errCode;
    }
}
