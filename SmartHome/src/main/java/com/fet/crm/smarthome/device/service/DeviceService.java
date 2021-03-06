package com.fet.crm.smarthome.device.service;

import com.fet.crm.smarthome.generic.bean.AlertEventVO;
import com.fet.crm.smarthome.generic.bean.AlertNoticeVO;
import com.fet.crm.smarthome.generic.bean.DeviceResultVO;
import com.fet.crm.smarthome.generic.bean.DeviceVO;
import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.crm.smarthome.generic.util.BusinessException;

import java.util.Date;
import java.util.List;

/**
 * Device Service
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public interface DeviceService {
    /**
     * call CMOfferService.queryOfferList 以 subscriberId 查詢所有設備
     * 
     * @param subscriberId
     *            the subscriberId
     * 
     * @return
     */
    List<OfferVO> queryAllDevicesBySubscriberId(final String subscriberId);

    /**
     * call 設備API queryDevice method 取得設備狀態
     * 
     * @param msisdn
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * 
     * @return
     * @throws BusinessException
     */
    List<DeviceVO> queryDevice(final String msisdn, final String deviceSerial) throws BusinessException;


    /**
     * 驗證查詢告警事件日期區間條件是否超過3天
     * 
     * @param serial
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * @param type
     *            the type
     * @param value
     *            the value
     * 
     * @return
     * @throws BusinessException
     */
    public void validateDateRange(Date startTime, Date endTime) throws BusinessException;
    /**
     * call 設備API queryAlertEvent method 查詢告警事件
     * 
     * @param serial
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * @param startTime
     *            the startTime
     * @param endTime
     *            the endTime
     * @param pageNo
     *            the pageNo
     * @param pageSize
     *            the pageSize
     * 
     * @return
     * @throws BusinessException
     */
    List<AlertEventVO> queryAlertEvent(final String msisdn, final String deviceSerial, final Date startTime,
            final Date endTime, final int pageNo, final int pageSize) throws BusinessException;

    /**
     * call 設備API queryAlertNotice method 查詢告警通知
     * 
     * @param serial
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * 
     * @return
     * @throws BusinessException
     */
    List<AlertNoticeVO> queryAlertNotice(final String msisdn, final String deviceSerial) throws BusinessException;

    /**
     * call 設備API addAlertNotice method 新增告警通知
     * 
     * @param serial
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * @param type
     *            the type
     * @param value
     *            the value
     * 
     * @return
     * @throws BusinessException
     */
    DeviceResultVO addAlertNotice(final String msisdn, final String deviceSerial, final String type, final String value)
            throws BusinessException;

    /**
     * call 設備API removeAlertNotice method 移除告警通知
     * 
     * @param serial
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * @param type
     *            the type
     * @param value
     *            the value
     * 
     * @return
     * @throws BusinessException
     */
    DeviceResultVO removeAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException;

}
