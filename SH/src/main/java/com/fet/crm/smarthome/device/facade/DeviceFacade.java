package com.fet.crm.smarthome.device.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fet.crm.smarthome.generic.bean.AlertEventVO;
import com.fet.crm.smarthome.generic.bean.AlertNoticeVO;
import com.fet.crm.smarthome.generic.bean.DeviceResultVO;
import com.fet.crm.smarthome.generic.bean.DeviceVO;
import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;

/**
 * Device Facade, transaction boundary
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public interface DeviceFacade {
    /**
     * DOCUMENT ME!
     * 
     * @param cspUser
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException 
     */
    UserProfile getUserProfile(final String cspUser) throws BusinessException;

    /**
     * 用門號取得Subscriber id
     * 
     * @param msisdn
     *            the msisdn
     * 
     * @return
     * @throws BusinessException 
     */
    String getSubscriberId(final String msisdn) throws BusinessException;

    /**
     * 依照subscriberId取得一代全部設備編號
     * 
     * @param subscriberId
     *            the subscriberId
     * 
     * @return
     * @throws BusinessException 
     */
    List<OfferVO> queryAllDevicesBySubscriberId(final String subscriberId) throws BusinessException;

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
    List<OfferVO> queryAllDevices(final String channel ,final String subscriberId,final String fetuid) throws BusinessException;

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
    List<DeviceVO> queryDevice(final String msisdn, final String deviceSerial) throws BusinessException;

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
    List<DeviceVO> queryDeviceFor2(final String channel, final String deviceSerial, final String fetuid) throws BusinessException;

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
     * 
     * @return
     * @throws BusinessException 
     */
    List<AlertEventVO> queryAlertEvent(final String msisdn, final String deviceSerial, final Date startTime,
            final Date endTime, final int pageNo) throws BusinessException;


    /**
     * 告警紀錄查詢頁，列出所選設備之告警紀錄(二代)
     * 
     * @param channel
     *            the channel
     * @param deviceSerial
     *            the deviceSerial
     * @param fetuid
     * 
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
    List<AlertEventVO> queryAlertEventFor2(final String channel, final String deviceSerial,final String fetuid , final Date startTime,
            final Date endTime, final int pageNo) throws BusinessException; 
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
    Map<String, List<AlertNoticeVO>> listAlertNotice(final String msisdn, final String deviceSerial) throws BusinessException;


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
    Map<String, List<AlertNoticeVO>> listAlertNoticeFor2(final String channel , final String deviceSerial, final String fetuid) throws BusinessException ;

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
    DeviceResultVO addAlertNotice(final String msisdn, final String deviceSerial, final String type, final String value) throws BusinessException;

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
    DeviceResultVO addAlertNoticeFor2(final String channel , final String fetuid , final String msisdn, final String deviceSerial, final String type, final String value) throws BusinessException;

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
    DeviceResultVO removeAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException;
    

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
    DeviceResultVO removeAlertNoticeFor2(final String channel , final String fetuid, final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException;
}
