package com.fet.crm.smarthome.device.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
import com.fet.rest.ApiGwClient;
import com.fet.rest.bean.AddAlertNoticeReq;
import com.fet.rest.bean.AddAlertNoticeRsp;
import com.fet.rest.bean.DelAlertNoticeReq;
import com.fet.rest.bean.DelAlertNoticeRsp;
import com.fet.rest.bean.GetAlertEventReq;
import com.fet.rest.bean.GetAlertEventRsp;
import com.fet.rest.bean.GetAlertNoticeReq;
import com.fet.rest.bean.GetAlertNoticeRsp;
import com.fet.rest.bean.GetDeviceStatusReq;
import com.fet.rest.bean.GetDeviceStatusRsp;
import com.fet.rest.bean.GetDidReq;
import com.fet.rest.bean.GetDidRsp;
import com.fet.rest.bean.RestResult;
import com.fet.util.Constants;
import com.fet.ws.bean.DID;
import com.fet.ws.bean.EDID;

/**
 * Device Service implement
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class DeviceServiceImpl implements DeviceService {
    private static final ILogger LOG = LoggerFactory.getLogger(DeviceServiceImpl.class);
    private transient OfferClient offerClient;
    private transient DeviceClient deviceClient;;

    private static final String QUERY_TIME_PATTERN = "yyyyMMddHHmmss";
    private static final ApiGwClient postUtil = new ApiGwClient();
    

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
     * call SmartHomeWS.getDid  以 fetuid 查詢所有設備
     * 
     * @param channel
     * @param fetuid
     * 
     * @return
     * @throws Exception 
     */
    public List<OfferVO> queryAllDevicesByFetuid(final String channel ,final String fetuid) throws Exception{
    	
    	GetDidReq req = new GetDidReq();;
    	req.setChannelId(channel);
    	req.setPartnerId("DSES000001");
		req.setUserId(fetuid);
		
		GetDidRsp rsp = postUtil.getDID(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		
//    	GetDidRsp rsp = wsClient.getDID(channel,fetuid);
		
        final List<OfferVO> result = new ArrayList<OfferVO>();

        if (null != rsp) {
        	RestResult rst = rsp.getResult();
        	if(null != rst ){
        		if(Constants.SUCCESS.equals(rst.getCode())){
        			
                    final StringBuffer offerNameKey = new StringBuffer();
                    
        			for(DID d : rsp.getDIDs()){

        	            final OfferVO offerVO = new OfferVO();

        	            // 取得的Offer Code 需對應設定檔，顯示方案名稱於畫面上。
        	            final String offerCode = d.getOfferId();
        	            offerVO.setOfferCode(offerCode);

        	            offerNameKey.delete(0, offerNameKey.length());
        	            offerNameKey.append("offer_name.");
        	            offerNameKey.append(offerCode);

        	            // TODO 如果對應設定檔找不到的話暫定擺入 ???? 待確認。
        	            final String offerName = MessageUtil.getStringMessage(offerNameKey.toString(), "如果對應設定檔找不到的話暫定擺入 ???? ");
        	            offerVO.setOfferName(offerName);
        	            // 取陣列的第一個值。此值代表設備編號。可用來查詢設備API 使用。
        	            offerVO.setDeviceSerial(d.getDID());
        	            result.add(offerVO);
        			}
        		}else{
        			LOG.info("result Code error");
        		}
        	}else{
        		LOG.info("result was empty");
        	}
        }else{
        	LOG.info("call Apigateway fail");
        }
        
    	return result;
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
     * call 設備API queryDevice method 取得設備狀態(二代)
     * 
     * @param deviceSerial
     *            the deviceSerial
     * @param fetuid
     * 
     * @return
     * @throws BusinessException
     */
    public List<DeviceVO> queryDeviceFor2(final String channel,final String deviceSerial,final String fetuid) throws BusinessException{
    	
    	// call 設備API queryDevice method 取得設備狀態
    	GetDeviceStatusRsp response = null;
		try {

	    	GetDeviceStatusReq req = new GetDeviceStatusReq();;
			req.setChannelId(channel);
			req.setPartnerId("DSES000001");
			req.setUserId(fetuid);
			req.setDID(deviceSerial);
	    	
			response = postUtil.getDeviceStatus(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		} catch (Exception e) {
			e.printStackTrace();
		}

        final List<DeviceVO> result = new ArrayList<DeviceVO>();

        // “SUCCESS” 代表成功，其他代表失敗。
        if(null != response && Constants.SUCCESS.equals(response.getResult().getCode())){
    	
        	RestResult rst = response.getResult();
        	if(null != rst ){
        		if(Constants.SUCCESS.equals(rst.getCode())){
        			for(com.fet.ws.bean.Device d : response.getDevices()){
        	            final DeviceVO deviceVO = new DeviceVO();
        	            deviceVO.setType(d.getName());
        	            deviceVO.setSerial(d.getQrSN());
        	            deviceVO.setPower(d.getPower().toString());
        	            deviceVO.setStatus(d.getStatus().toString());
        	            deviceVO.setConnTime(d.getConnTime());
//	        	            deviceVO.setpSerial(d.getpSerial());
        	            result.add(deviceVO);
        			}
        			for(EDID d : response.getEDIDs()){
        	            final DeviceVO deviceVO = new DeviceVO();
        	            deviceVO.setType(d.getName());
        	            deviceVO.setSerial(d.getEDID());
//	        	            deviceVO.setPower(d.getPower().toString());
        	            deviceVO.setStatus(d.getStatus().toString());
        	            deviceVO.setConnTime(d.getLastConn());
//	        	            deviceVO.setpSerial(d.getpSerial());
        	            result.add(deviceVO);
        			}
        		}else{
        			LOG.info("result Code error");
        		}
        	}else{
        		LOG.info("result was empty");
        	}
        }else{
        	LOG.info("call Apigateway fail");
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
     * call 設備API queryAlertEvent method 查詢告警事件(二代)
     * 
     * @param channel
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param fetuid
     * 
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
    public List<AlertEventVO> queryAlertEventFor2(final String channel, final String deviceSerial, final String fetuid, final Date startTime,
            final Date endTime, final int pageNo, final int pageSize) throws BusinessException {

    	GetAlertEventRsp response = null;
    	// call 設備API queryAlertEvent method 查詢告警事件
    	try{

            final SimpleDateFormat queryTimeFormat = new SimpleDateFormat(QUERY_TIME_PATTERN, Locale.US);
            
        	GetAlertEventReq req = new GetAlertEventReq();;
    		req.setChannelId(channel);
    		req.setPartnerId("DSES000001");
    		req.setDID(deviceSerial);
    		req.setUserId(fetuid);
    		if (null != startTime) {
    			req.setStartTime(queryTimeFormat.format(startTime));
    		}
    		if (null != endTime) {
    			req.setEndTime(queryTimeFormat.format(endTime));
    		}
    		req.setPageNum(pageNo);
    		req.setPageSize(pageSize);
    		
    		response = postUtil.GetAlertEvent(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        List<AlertEventVO> result = null;
        if(null != response && Constants.SUCCESS.equals(response.getResult().getCode())){
        	final Integer totalSize = Integer.parseInt(response.getTotalSize());
        	result = new ArrayList<AlertEventVO>();
        	int totalPage = 1;
        	if (null != totalSize) {
        		totalPage = totalSize / pageSize + ((totalSize % pageSize > 0) ? 1 : 0);
        	}
        	for (final com.fet.ws.bean.AlertEvent alertEvent : response.getAlertEvents()) {
        		final AlertEventVO alertEventVO = new AlertEventVO();
        		alertEventVO.setTime(alertEvent.getTime());
        		alertEventVO.setPicUrl(alertEvent.getPic());
        		final com.fet.ws.bean.Device device = alertEvent.getDevice();
        		final DeviceVO deviceVO = new DeviceVO();
        		deviceVO.setType(device.getName());
        		deviceVO.setSerial(device.getQrSN());
//        		deviceVO.setpSerial(device.getpSerial());
        		alertEventVO.setDevice(deviceVO);
        		alertEventVO.setTotalPage(totalPage);
        		result.add(alertEventVO);
        	}
        	
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
     * call 設備API queryAlertNotice method 查詢告警通知(二代)
     * 
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param fetuid
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public List<AlertNoticeVO> queryAlertNoticeFor2(final String channel,final String deviceSerial ,final String fetuid) throws BusinessException {
        // call 設備API queryAlertEvent method 查詢告警通知

    	GetAlertNoticeRsp response = null;
		try {

	        GetAlertNoticeReq req = new GetAlertNoticeReq();;
			req.setChannelId(channel);
			req.setPartnerId("DSES000001");
			req.setDID(deviceSerial);
			req.setUserId(fetuid);
			
			response = postUtil.getAlertNotice(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        List<AlertNoticeVO> result = null;
        final StringBuffer msgKey = new StringBuffer(30);
        
        if (null != response.getAlertNotices() && 0 != response.getAlertNotices().size()) {
        	result = new ArrayList<AlertNoticeVO>();
            for (final com.fet.ws.bean.AlertNotice alertNotice : response.getAlertNotices()) {
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
    public DeviceResultVO addAlertNoticeFor2(final String channel, final String fetuid, final String msisdn, final String deviceSerial, final String type, final String value) throws BusinessException{
    	
    	AddAlertNoticeRsp alertNoticeResult = null;
    	// call 設備API addAlertNotice method 新增告警通知
    	try{

            AddAlertNoticeReq req = new AddAlertNoticeReq();;
    		req.setChannelId(channel);
    		req.setPartnerId("DSES000001");
    		req.setDID(deviceSerial);
    		req.setUserId(fetuid);
    		
    		com.fet.ws.bean.AlertNotice alertNotice = new com.fet.ws.bean.AlertNotice();
    		alertNotice.setType(type);
    		alertNotice.setValue(value);
    		req.setAlertNotice(alertNotice);
    		
    		alertNoticeResult = postUtil.addAlertNotice(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
        final DeviceResultVO result = new DeviceResultVO();
        result.setStatus(alertNoticeResult.getResult().getCode());
        result.setMsg(alertNoticeResult.getResult().getMsg());
        result.setErrCode(alertNoticeResult.getResult().getCode());
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
            final String value) throws BusinessException{

    	DelAlertNoticeRsp alertNoticeResult = null;
    	// call 設備API removeAlertNotice method 移除告警通知
    	try{

            DelAlertNoticeReq req = new DelAlertNoticeReq();;
    		req.setChannelId(channel);
    		req.setPartnerId("DSES000001");
    		req.setDID(deviceSerial);
    		req.setUserId(fetuid);
    		
    		com.fet.ws.bean.AlertNotice alertNotice = new com.fet.ws.bean.AlertNotice();
    		alertNotice.setType(type);
    		alertNotice.setValue(value);
    		req.setAlertNotice(alertNotice);
    		
    		alertNoticeResult = postUtil.delAlertNotice(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
    	} catch (Exception e) {
			e.printStackTrace();
		}
        final DeviceResultVO result = new DeviceResultVO();
        result.setStatus(alertNoticeResult.getResult().getCode());
        result.setMsg(alertNoticeResult.getResult().getMsg());
        result.setErrCode(alertNoticeResult.getResult().getCode());
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
