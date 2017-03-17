package com.fet.crm.smarthome.mware.client;

import com.fet.crm.smarthome.generic.model.CommonResponse;
import com.fet.crm.smarthome.generic.model.QueryAlertEventResponse;
import com.fet.crm.smarthome.generic.model.QueryAlertNoticeResponse;
import com.fet.crm.smarthome.generic.model.QueryDeviceResponse;
import com.fet.crm.smarthome.generic.util.BusinessException;

import java.util.Date;

/**
 * 呼叫設備 API 之 middleware client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public interface DeviceClient {

    /**
     * call 設備API queryDevice method 取得設備狀態
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @throws BusinessException
     */
    QueryDeviceResponse queryDevice(final String msisdn, final String deviceSerial) throws BusinessException;

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param startTime
     *            DOCUMENT ME!
     * @param endTime
     *            DOCUMENT ME!
     * @param pageNo
     *            DOCUMENT ME!
     * @param pageSize
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException 
     */
    QueryAlertEventResponse queryAlertEvent(final String msisdn, final String deviceSerial, final Date startTime,
            final Date endTime, final int pageNo, final int pageSize) throws BusinessException;

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException 
     */
    QueryAlertNoticeResponse queryAlertNotice(final String msisdn, final String deviceSerial) throws BusinessException;

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param type
     *            DOCUMENT ME!
     * @param value
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException 
     */
    CommonResponse addAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException;

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param type
     *            DOCUMENT ME!
     * @param value
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException 
     */
    CommonResponse removeAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException;
}
