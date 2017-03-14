package com.fet.crm.smarthome.device.facade.impl;

import com.fet.crm.smarthome.device.facade.DeviceFacade;
import com.fet.crm.smarthome.device.service.CustomerService;
import com.fet.crm.smarthome.device.service.DeviceService;
import com.fet.crm.smarthome.generic.bean.AlertEventVO;
import com.fet.crm.smarthome.generic.bean.AlertNoticeVO;
import com.fet.crm.smarthome.generic.bean.CustomerVO;
import com.fet.crm.smarthome.generic.bean.DeviceResultVO;
import com.fet.crm.smarthome.generic.bean.DeviceVO;
import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.generic.util.ErrorCodeUtil;
import com.fet.crm.smarthome.generic.util.ErrorType;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Device Facade implement
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class DeviceFacadeImpl implements DeviceFacade {
    private static final ILogger LOG = LoggerFactory.getLogger(DeviceFacadeImpl.class);
    private transient CustomerService customerService;
    private transient DeviceService deviceService;

    /**
     * DOCUMENT ME!
     * 
     * @param customerService
     *            DOCUMENT ME!
     */
    public void setCustomerService(final CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param deviceService
     *            DOCUMENT ME!
     */
    public void setDeviceService(final DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param cspUser
     *            DOCUMENT ME!
     * @param sessionMsisdn
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public UserProfile getUserProfile(final String cspUser) throws BusinessException {
        return customerService.getUserProfile(cspUser);
    }

    /**
     * 用門號取得Subscriber id
     * 
     * @param msisdn
     *            the msisdn
     * 
     * @return
     * @throws BusinessException
     */
    public String getSubscriberId(final String msisdn) throws BusinessException {
        String subscriberId = null;

        try {
            // call SIG, 用門號取得Subscriber id
            final CustomerVO customerVO = customerService.getSubscriberIdByMsisdn(msisdn);
            subscriberId = customerVO.getSubscriberId();
        } catch (final BusinessException e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "002");
            LOG.error(errCode, e.getMessage(), e);
            throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "002")));

        }

        return subscriberId;
    }

    /**
     * 依照subscriberId取得一代全部設備編號
     * 
     * @param subscriberId
     *            the subscriberId
     * 
     * @return
     * @throws BusinessException
     */
    public List<OfferVO> queryAllDevicesBySubscriberId(final String subscriberId) throws BusinessException {
        final List<OfferVO> offerList = new ArrayList<OfferVO>();

        try {
            // call 設備 API 查詢設備相關資訊, 將查詢結果 mapping 到頁面上
            offerList.addAll(deviceService.queryAllDevicesBySubscriberId(subscriberId));
            
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "003");
            LOG.error(errCode, e.getMessage(), e);
            throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "003")));
        }
        return offerList;
    }

    /**
     * 依照subscriberId,fetuid取得一二代全部設備編號
     * 
     * @param channel
     * @param subscriberId
     *            the subscriberId
     * @param fetuid
     * 
     * @return
     * @throws BusinessException
     */
    public List<OfferVO> queryAllDevices(final String channel , final String subscriberId,final String fetuid) throws BusinessException {
    	//TODO offerVO需增加變數來判斷SH、SH2
        final List<OfferVO> offerList = new ArrayList<OfferVO>();

        try {
            // call 設備 API 查詢設備相關資訊, 將查詢結果 mapping 到頁面上
//            offerList.addAll(deviceService.queryAllDevicesBySubscriberId(subscriberId)); FIXME 先mark
            
            // TODO call 二代 API 查詢設備相關資訊, 將查詢結果 mapping 到頁面上
            offerList.addAll(deviceService.queryAllDevicesByFetuid(channel,fetuid));
            
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "003");
            LOG.error(errCode, e.getMessage(), e);
            throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "003")));
        }
        return offerList;
    }

    /**
     * 告警設備查詢頁，列出所選設備以及其子設備狀態
     * 
     * @param msisdn
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * 
     * @return
     * @throws BusinessException
     */
    public List<DeviceVO> queryDevice(final String msisdn, final String deviceSerial) throws BusinessException {
    	//call 一代API
    	List<DeviceVO> rtnList = deviceService.queryDevice(msisdn, deviceSerial);
        return rtnList;
    }

    /**
     * 告警設備查詢頁，列出所選設備以及其子設備狀態(二代)
     * 
     * @param deviceSerial
     *            the deviceSerial
     * @param fetuid
     * 
     * @return
     * @throws BusinessException 
     */
    public List<DeviceVO> queryDeviceFor2(final String channel ,final String deviceSerial, final String fetuid) throws BusinessException{

    	List<DeviceVO> rtnList = deviceService.queryDeviceFor2(channel,deviceSerial, fetuid);
        return rtnList;
    }


    /**
     * 告警紀錄查詢頁，列出所選設備之告警紀錄
     * 
     * @param msisdn
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * @param startTime
     *            the startTime
     * @param msisdendTimen
     *            the endTime
     * @param pageNo
     *            the pageNo
     * @return
     * 
     * @return
     * @throws BusinessException
     */
    public List<AlertEventVO> queryAlertEvent(final String msisdn, final String deviceSerial, final Date startTime,
            final Date endTime, final int pageNo) throws BusinessException {
        deviceService.validateDateRange(startTime, endTime);
        // call 設備API queryAlertEvent method 查詢告警事件
        List<AlertEventVO> rtnList = deviceService.queryAlertEvent(msisdn, deviceSerial, startTime, endTime, pageNo, getPageSize());
        // TODO call 二代API 查詢告警事件
//        rtnList.addAll();
        
        return rtnList;
    }

    /**
     * 告警紀錄查詢頁，列出所選設備之告警紀錄(二代)
     * 
     * @param channel
     *            the channel
     * @param deviceSerial
     *            the deviceSerial
     * @param fetuid
     * @param startTime
     *            the startTime
     * @param msisdendTimen
     *            the endTime
     * @param pageNo
     *            the pageNo
     * @return
     * 
     * @return
     * @throws BusinessException
     */
    public List<AlertEventVO> queryAlertEventFor2(final String channel, final String deviceSerial,final String fetuid, final Date startTime,
            final Date endTime, final int pageNo) throws BusinessException {
        deviceService.validateDateRange(startTime, endTime);
        List<AlertEventVO> rtnList = deviceService.queryAlertEventFor2(channel, deviceSerial,fetuid, startTime, endTime, pageNo, getPageSize());
        
        return rtnList;
    }

    private int getPageSize() {
        return MessageUtil.getInteger("device.page.size", 10);
    }

    /**
     * 告警通知設定查詢頁，列出所選設備之所有告警通知設定
     * 
     * @param msisdn
     *            the msisdn
     * @param deviceSerial
     *            the deviceSerial
     * 
     * @return
     * @throws BusinessException
     */
    public Map<String, List<AlertNoticeVO>> listAlertNotice(final String msisdn, final String deviceSerial)
            throws BusinessException {
        // call 設備API queryAlertNotice method 查詢告警通知
        final List<AlertNoticeVO> alertNoticeList = deviceService.queryAlertNotice(msisdn, deviceSerial);
        final Map<String, List<AlertNoticeVO>> result = new HashMap<String, List<AlertNoticeVO>>();
        for (final AlertNoticeVO alertNotice : alertNoticeList) {
            List<AlertNoticeVO> tmpList = null;
            if (result.containsKey(alertNotice.getType())) {
                tmpList = result.get(alertNotice.getType());
            } else {
                tmpList = new ArrayList<AlertNoticeVO>();
                result.put(alertNotice.getType(), tmpList);
            }
            tmpList.add(alertNotice);
        }
        
        return result;
    }

    /**
     * 告警通知設定查詢頁，列出所選設備之所有告警通知設定(二代)
     * 
     * @param deviceSerial
     *            the deviceSerial
     * @param fetuid
     * 
     * @return
     * @throws BusinessException
     */
    public Map<String, List<AlertNoticeVO>> listAlertNoticeFor2(final String channel , final String deviceSerial, final String fetuid) throws BusinessException {
        // call 設備API queryAlertNotice method 查詢告警通知
        final List<AlertNoticeVO> alertNoticeList = deviceService.queryAlertNoticeFor2(channel,deviceSerial,fetuid);
        final Map<String, List<AlertNoticeVO>> result = new HashMap<String, List<AlertNoticeVO>>();
        for (final AlertNoticeVO alertNotice : alertNoticeList) {
            List<AlertNoticeVO> tmpList = null;
            if (result.containsKey(alertNotice.getType())) {
                tmpList = result.get(alertNotice.getType());
            } else {
                tmpList = new ArrayList<AlertNoticeVO>();
                result.put(alertNotice.getType(), tmpList);
            }
            tmpList.add(alertNotice);
        }
        
        return result;
    }

    /**
     * 告警通知設定頁，新增所選設備之告警通知設定
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
     * @return
     * @throws BusinessException
     */
    public DeviceResultVO addAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException {

    	DeviceResultVO rtnVO = null;
    	// call 設備API addAlertNotice method 新增告警通知
    	rtnVO = deviceService.addAlertNotice(msisdn, deviceSerial, type, value);
    	
        return rtnVO;
    }

    /**
     * 告警通知設定頁，新增所選設備之告警通知設定(維熹)
     * 
     * @param channel
     * @param fetuid
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
     * @return
     * @throws BusinessException 
     */
    public DeviceResultVO addAlertNoticeFor2(final String channel , final String fetuid , final String msisdn, final String deviceSerial, final String type, final String value) throws BusinessException{

    	DeviceResultVO rtnVO = null;
    	// call 設備API addAlertNotice method 新增告警通知
    	rtnVO = deviceService.addAlertNoticeFor2(channel , fetuid, msisdn, deviceSerial, type, value);
    	
    	return rtnVO;
    }


    /**
     * 告警通知設定頁，移除所選設備之告警通知設定
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
     * @return
     * @throws BusinessException
     */
    public DeviceResultVO removeAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException {
        // call 設備API removeAlertNotice method 移除告警通知
        return deviceService.removeAlertNotice(msisdn, deviceSerial, type, value);
    }


    /**
     * 告警通知設定頁，移除所選設備之告警通知設定(維熹)
     * 
     * @param channel
     * @param fetuid
     * @param msisdn
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
    public DeviceResultVO removeAlertNoticeFor2(final String channel , final String fetuid, final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException {
        // call 設備API removeAlertNotice method 移除告警通知
        return deviceService.removeAlertNoticeFor2(channel , fetuid, msisdn, deviceSerial, type, value);
    }
}
