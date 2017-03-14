package com.fet.crm.smarthome.mware.client;

import java.util.Date;
import java.util.List;

import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.rest.bean.AddAlertNoticeRsp;
import com.fet.rest.bean.DelAlertNoticeReq;
import com.fet.rest.bean.DelAlertNoticeRsp;
import com.fet.rest.bean.GetAlarmEventRsp;
import com.fet.rest.bean.GetAlertNoticeRsp;
import com.fet.rest.bean.GetDeviceStatusRsp;

/**
 * 呼叫 SmartHomeWS 之 client
 * 
 * @author T
 * @version 1.0.0.0
 */
public interface WSClient {

    /**
     * DOCUMENT ME!
     * 
     * @param channel
     * @param fetuid
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws Exception 
     */
    List<OfferVO> queryOfferList(String channel ,String fetuid) throws Exception;

    GetDeviceStatusRsp queryDeviceFor2(String channel,String deviceSerial, String fetuid) throws Exception;

	GetAlarmEventRsp queryAlertEventFor2(String channel,	String deviceSerial, String fetuid, Date startTime, Date endTime,	int  pageNum, int pageSize) throws Exception;

	GetAlertNoticeRsp queryAlertNoticeFor2(String channel ,String deviceSerial, String fetuid) throws Exception;

	AddAlertNoticeRsp addAlertNoticeFor2(String channel, String fetuid, String msisdn, String deviceSerial, String type, String value)throws Exception;

	DelAlertNoticeRsp removeAlertNoticeFor2(String channel, String fetuid,
			String msisdn, String deviceSerial, String type, String value) throws Exception;
}
