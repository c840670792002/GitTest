package com.fet.crm.smarthome.device.service.impl;

import com.fet.crm.smarthome.device.service.DeviceService;
import com.fet.crm.smarthome.generic.bean.AlertEventVO;
import com.fet.crm.smarthome.generic.bean.AlertNoticeVO;
import com.fet.crm.smarthome.generic.bean.DeviceResultVO;
import com.fet.crm.smarthome.generic.bean.DeviceVO;
import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.crm.smarthome.generic.model.AlertEvent;
import com.fet.crm.smarthome.generic.model.AlertNotice;
import com.fet.crm.smarthome.generic.model.CommonResponse;
import com.fet.crm.smarthome.generic.model.Device;
import com.fet.crm.smarthome.generic.model.QueryAlertEventResponse;
import com.fet.crm.smarthome.generic.model.QueryAlertNoticeResponse;
import com.fet.crm.smarthome.generic.model.QueryDeviceResponse;
import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.generic.util.ErrorCodeUtil;
import com.fet.crm.smarthome.generic.util.ErrorType;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.crm.smarthome.mware.client.DeviceClient;
import com.fet.crm.smarthome.mware.client.OfferClient;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Device Service implement
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class DeviceServiceImpl implements DeviceService {
    private static final ILogger LOG = LoggerFactory.getLogger(DeviceServiceImpl.class);
    private transient OfferClient offerClient;
    private transient DeviceClient deviceClient;

    /**
     * DOCUMENT ME!
     * 
     * @param offerClient
     *            DOCUMENT ME!
     */
    public void setOfferClient(final OfferClient offerClient) {
        this.offerClient = offerClient;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param deviceClient
     *            DOCUMENT ME!
     */
    public void setDeviceClient(final DeviceClient deviceClient) {
        this.deviceClient = deviceClient;
    }

    /**
     * call CMOfferService.queryOfferList 以 subscriberId 查詢所有設備
     * 
     * @param subscriberId
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public List<OfferVO> queryAllDevicesBySubscriberId(final String subscriberId) {
        return offerClient.queryOfferList(subscriberId);
    }

    /**
     * call 設備API queryDevice method 取得設備狀態
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public List<DeviceVO> queryDevice(final String msisdn, final String deviceSerial) throws BusinessException {
        // call 設備API queryDevice method 取得設備狀態
        final QueryDeviceResponse queryDeviceResult = deviceClient.queryDevice(msisdn, deviceSerial);
        final List<DeviceVO> result = new ArrayList<DeviceVO>();
        for (final Device device : queryDeviceResult.getDevices()) {
            final DeviceVO deviceVO = new DeviceVO();
            deviceVO.setType(device.getType());
            deviceVO.setSerial(device.getSerial());
            deviceVO.setPower(device.getPower());
            deviceVO.setStatus(device.getStatus());
            deviceVO.setConnTime(device.getConnTime());
            deviceVO.setpSerial(device.getpSerial());
            result.add(deviceVO);
        }
        return result;
    }

    /**
     * call 設備API queryAlertEvent method 查詢告警事件
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
    public List<AlertEventVO> queryAlertEvent(final String msisdn, final String deviceSerial, final Date startTime,
            final Date endTime, final int pageNo, final int pageSize) throws BusinessException {
        // call 設備API queryAlertEvent method 查詢告警事件
        final QueryAlertEventResponse queryAlertEventResult = deviceClient.queryAlertEvent(msisdn, deviceSerial,
                startTime, endTime, pageNo - 1, pageSize);
        final Integer totalSize = queryAlertEventResult.getTotalSize();
        int totalPage = 1;
        if (null != totalSize) {
            totalPage = totalSize / pageSize + ((totalSize % pageSize > 0) ? 1 : 0);
        }
        final List<AlertEventVO> result = new ArrayList<AlertEventVO>();
        for (final AlertEvent alertEvent : queryAlertEventResult.getAlertEvents()) {
            final AlertEventVO alertEventVO = new AlertEventVO();
            alertEventVO.setTime(alertEvent.getTime());
            alertEventVO.setPicUrl(alertEvent.getPic());
            final Device device = alertEvent.getDevice();
            final DeviceVO deviceVO = new DeviceVO();
            deviceVO.setType(device.getType());
            deviceVO.setSerial(device.getSerial());
            deviceVO.setpSerial(device.getpSerial());
            alertEventVO.setDevice(deviceVO);
            alertEventVO.setTotalPage(totalPage);
            result.add(alertEventVO);
        }
        return result;
    }

    /**
     * call 設備API queryAlertNotice method 查詢告警通知
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public List<AlertNoticeVO> queryAlertNotice(final String msisdn, final String deviceSerial)
            throws BusinessException {
        // call 設備API queryAlertEvent method 查詢告警通知
        final QueryAlertNoticeResponse alertNoticeResult = deviceClient.queryAlertNotice(msisdn, deviceSerial);
        final List<AlertNoticeVO> result = new ArrayList<AlertNoticeVO>();
        final StringBuffer msgKey = new StringBuffer(30);
        if (null != alertNoticeResult.getAlertNotices() && 0 != alertNoticeResult.getAlertNotices().length) {
            for (final AlertNotice alertNotice : alertNoticeResult.getAlertNotices()) {
                msgKey.delete(0, msgKey.length());
                msgKey.append("query_alert_notice.status.");
                msgKey.append(alertNotice.getStatus());
                final AlertNoticeVO alertNoticeVO = new AlertNoticeVO();
                alertNoticeVO.setValue(alertNotice.getValue());
                alertNoticeVO.setType(alertNotice.getType());
                alertNoticeVO.setStatus(MessageUtil.getStringMessage(msgKey.toString()));
                result.add(alertNoticeVO);
            }
        }
        return result;
    }

    /**
     * call 設備API addAlertNotice method 新增告警通知
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
    public DeviceResultVO addAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException {
        // call 設備API addAlertNotice method 新增告警通知
        final CommonResponse alertNoticeResult = deviceClient.addAlertNotice(msisdn, deviceSerial, type, value);
        final DeviceResultVO result = new DeviceResultVO();
        result.setStatus(alertNoticeResult.getResult().getStatus());
        result.setMsg(alertNoticeResult.getResult().getMsg());
        result.setErrCode(alertNoticeResult.getResult().getErrCode());
        return result;
    }

    /**
     * call 設備API removeAlertNotice method 移除告警通知
     * 
     * @param msisdn
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * @param type
     *            the type
     * @param value
     *            the value
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public DeviceResultVO removeAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException {
        // call 設備API removeAlertNotice method 移除告警通知
        final CommonResponse alertNoticeResult = deviceClient.removeAlertNotice(msisdn, deviceSerial, type, value);
        final DeviceResultVO result = new DeviceResultVO();
        result.setStatus(alertNoticeResult.getResult().getStatus());
        result.setMsg(alertNoticeResult.getResult().getMsg());
        result.setErrCode(alertNoticeResult.getResult().getErrCode());
        return result;
    }

    @Override
    public void validateDateRange(Date startTime, Date endTime) throws BusinessException {
        if (null != startTime && null != endTime) {
            long diff = endTime.getTime() - startTime.getTime();
            if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 3) {
                final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                        SmartHomeConstants.SYSTEM_CODE, ErrorType.UI, "002");
                LOG.error(errCode, errCode);
                throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(
                        ErrorType.UI, "002")));
            }
        }
    }
}
