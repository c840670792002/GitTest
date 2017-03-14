package com.fet.crm.smarthome.mware.client.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.mware.client.WSClient;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;
import com.fet.rest.ApiGwClient;
import com.fet.rest.bean.AddAlertNoticeReq;
import com.fet.rest.bean.AddAlertNoticeRsp;
import com.fet.rest.bean.DelAlertNoticeReq;
import com.fet.rest.bean.DelAlertNoticeRsp;
import com.fet.rest.bean.GetAlarmEventReq;
import com.fet.rest.bean.GetAlarmEventRsp;
import com.fet.rest.bean.GetAlertNoticeReq;
import com.fet.rest.bean.GetAlertNoticeRsp;
import com.fet.rest.bean.GetDeviceStatusReq;
import com.fet.rest.bean.GetDeviceStatusRsp;
import com.fet.rest.bean.GetDidReq;
import com.fet.rest.bean.GetDidRsp;
import com.fet.rest.bean.RestResult;
import com.fet.util.Constants;
import com.fet.ws.bean.AlertNotice;
import com.fet.ws.bean.DID;

/**
 * 呼叫 SmartHomeWS 之 client
 * 
 * @author T
 * @version 1.0.0.0
 */
public class WSClientImpl implements WSClient {
    private static final ILogger LOG = LoggerFactory.getLogger(WSClientImpl.class);
    private static final Comparator<OfferVO> COMPARATOR;
    private static final String QUERY_TIME_PATTERN = "yyyyMMddHHmmss";
    private static final ApiGwClient postUtil = new ApiGwClient();
    
    static {
        COMPARATOR = new Comparator<OfferVO>() {

            @Override
            public int compare(OfferVO o1, OfferVO o2) {
                int result = 0;
                // FETT0000020FHDEKHC
                if (null != o1 && null != o2 && null != o1.getDeviceSerial() && null != o2.getDeviceSerial()) {
                    final String tmpDID1 = o1.getDeviceSerial().substring(4, 11);
                    final String tmpDID2 = o2.getDeviceSerial().substring(4, 11);
                    result = tmpDID2.compareTo(tmpDID1);
                }
                return result;
            }
        };
    }

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
    public List<OfferVO> queryOfferList(final String channel ,final String fetuid) throws Exception {
    	
    	GetDidReq req = new GetDidReq();;
    	req.setChannelId(channel);
    	req.setPartnerId("DSES000001");
		req.setUserId(fetuid);
		
		GetDidRsp rsp = postUtil.getDid(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		
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
        Collections.sort(result, COMPARATOR);
        return result;
    }
    

    @Override
    public GetDeviceStatusRsp queryDeviceFor2(final String channel,String deviceSerial, String fetuid) throws Exception {
		
    	GetDeviceStatusReq req = new GetDeviceStatusReq();;
		req.setChannelId(channel);
		req.setPartnerId("DSES000001");
		req.setUserId(fetuid);
		req.setDID(deviceSerial);
    	
		GetDeviceStatusRsp rsp = postUtil.getDeviceStatus(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		
        return rsp;
    
    }


	@Override
	public GetAlarmEventRsp queryAlertEventFor2(String channel,String deviceSerial, String fetuid, Date startTime, Date endTime,int pageNum, int pageSize) throws Exception {

        final SimpleDateFormat queryTimeFormat = new SimpleDateFormat(QUERY_TIME_PATTERN, Locale.US);
        
    	GetAlarmEventReq req = new GetAlarmEventReq();;
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
		req.setPageNum(pageNum);
		req.setPageSize(pageSize);
		
		GetAlarmEventRsp rsp = postUtil.getAlarmEvent(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		
        return rsp;
    
	}


	@Override
	public GetAlertNoticeRsp queryAlertNoticeFor2(String channel ,String deviceSerial,	String fetuid) throws Exception {
		
        GetAlertNoticeReq req = new GetAlertNoticeReq();;
		req.setChannelId(channel);
		req.setPartnerId("DSES000001");
		req.setDID(deviceSerial);
		req.setUserId(fetuid);
		
		GetAlertNoticeRsp rsp = postUtil.getAlertNotice(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		
        return rsp;
    
	}    


	@Override
	public AddAlertNoticeRsp addAlertNoticeFor2(String channel, String fetuid, String msisdn, String deviceSerial, String type, String value) throws Exception {
		
        AddAlertNoticeReq req = new AddAlertNoticeReq();;
		req.setChannelId(channel);
		req.setPartnerId("DSES000001");
		req.setDID(deviceSerial);
		req.setUserId(fetuid);
		
		AlertNotice alertNotice = new AlertNotice();
		alertNotice.setType(type);
		alertNotice.setValue(value);
		req.setAlertNotice(alertNotice);
		
		AddAlertNoticeRsp rsp = postUtil.addAlertNotice(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		
        return rsp;
    
	}


	@Override
	public DelAlertNoticeRsp removeAlertNoticeFor2(String channel,
			String fetuid, String msisdn, String deviceSerial, String type,
			String value) throws Exception {

        DelAlertNoticeReq req = new DelAlertNoticeReq();;
		req.setChannelId(channel);
		req.setPartnerId("DSES000001");
		req.setDID(deviceSerial);
		req.setUserId(fetuid);
		
		AlertNotice alertNotice = new AlertNotice();
		alertNotice.setType(type);
		alertNotice.setValue(value);
		req.setAlertNotice(alertNotice);
		
		DelAlertNoticeRsp rsp = postUtil.delAlertNotice(req, MessageUtil.getStringMessage("smarthome2.ws.url"));
		
        return rsp;
	}    
	
//	/** 透過httpPost方式介接API(json)
//	 * @param url
//	 * @param methodName
//	 * @param requestJson
//	 * @return
//	 * @throws IOException 
//	 * @throws ClientProtocolException 
//	 * @throws Exception
//	 */
//	private String post(String url , String methodName , String requestJson) throws Exception{
//		
//		LOG.info(url + methodName+"|||"+" request === "+requestJson);
//		
//		HttpClient httpClient = HttpClientBuilder.create().build();
//
//		// Post 
//		StringEntity params =new StringEntity(requestJson,"UTF-8");
//		
//		HttpPost httpPost = new HttpPost(url + methodName+"/");
//		httpPost.setHeader("Content-type", "application/json; charset=utf-8");
//		httpPost.setEntity(params);
//		HttpResponse httpResponse = httpClient.execute(httpPost);
//		String responseString = null;
//		 // 如果回傳是 200 OK 的話才回傳jsonStr
//		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//			responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
//			LOG.info("send To apiGateway ok!! response === "+responseString);
//		} else {
//			// TODO 連線失敗回傳null
//			LOG.info("send To apiGateway  fail!! === "+httpResponse.getStatusLine());
//		}
//		
//		// 關閉httpClient
//		httpClient.getConnectionManager().shutdown();
//
//		return responseString;
//		
//	}

}
