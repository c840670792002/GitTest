package com.fet.crm.smarthome.generic.model;

import java.io.Serializable;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = 1451087308194950358L;
    private CommonResult result;

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public CommonResult getResult() {
        return result;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param result
     *            DOCUMENT ME!
     */
    public void setResult(final CommonResult result) {
        this.result = result;
    }
}
