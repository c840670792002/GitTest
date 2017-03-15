package com.fet.api.service.impl;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.fet.api.service.BaseService;
import com.fet.api.service.DeviceWsService;
import com.fet.rest.SmartHomeWS;
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
import com.fet.rest.bean.GetUserReq;
import com.fet.rest.bean.GetUserRsp;
import com.fet.rest.bean.RestResult;
import com.fet.util.Constants;
import com.fet.ws.DeviceWsClient;
import com.fet.ws.bean.AddAlertNoticeRequest;
import com.fet.ws.bean.AddAlertNoticeResponse;
import com.fet.ws.bean.DelAlertNoticeRequest;
import com.fet.ws.bean.DelAlertNoticeResponse;
import com.fet.ws.bean.GetAlarmEventRequest;
import com.fet.ws.bean.GetAlarmEventResponse;
import com.fet.ws.bean.GetAlertNoticeRequest;
import com.fet.ws.bean.GetAlertNoticeResponse;
import com.fet.ws.bean.GetDeviceStatusRequest;
import com.fet.ws.bean.GetDeviceStatusResponse;
import com.fet.ws.bean.GetDidRequest;
import com.fet.ws.bean.GetDidResponse;
import com.fet.ws.bean.GetUserRequest;
import com.fet.ws.bean.GetUserResponse;
import com.google.gson.Gson;

public class DeviceWsServiceImpl extends BaseService implements DeviceWsService {


	final Logger log = Logger.getLogger(SmartHomeWS.class);

	final Gson gson = new Gson();
	
	final DeviceWsClient postUtil = new DeviceWsClient();
	
	final protected ResourceBundle bundle = ResourceBundle.getBundle("system");
	
	final protected String URL = bundle.getString("WS.API.URL");//按照環境不同properties設定不同
	
	/* 1.取得攝影機報警記錄
	 * @see com.fet.api.service.DeviceWsService#getAlarmEvent(com.fet.rest.bean.GetAlarmEventReq, com.fet.ws.bean.GetAlarmEventRequest, com.fet.rest.bean.GetAlarmEventRsp, com.fet.ws.bean.GetAlarmEventResponse)
	 */
	@Override
	public String getAlarmEvent(GetAlarmEventReq request,
			GetAlarmEventRequest wsRequest, GetAlarmEventRsp response,
			GetAlarmEventResponse wsResponse) {

		//預設responseCode前6碼
		StringBuilder errorCode = new StringBuilder(Constants.SMART_HOME+Constants.API+Constants.API_NO);
		//check request param
		final String verifyCode = super.checkRequestParam(request);
		
		if(Constants.SUCCESS.equals(verifyCode)){
			log.info("verify pass...");
			try {
				//post to 維熹
				errorCode.append(Constants.BANK_END_ERROR);
				
				wsResponse = postUtil.getAlarmEvent(wsRequest,URL);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("call 維熹...error log............");
			}finally{
				//change status => code
				if(null != wsResponse){
					
					String status = null;
					if(null != wsResponse.getResult()){
						status = wsResponse.getResult().getStatus();
					}
					if(null != status){
						BeanUtils.copyProperties(wsResponse, response);
						if(Constants.codeMap.containsKey(status)){
							errorCode.append(Constants.codeMap.get(status));
						}else{
							errorCode.setLength(0);
							errorCode.append(Constants.SUCCESS);
						}
						
					}else{//有response,卻沒有Result的status (理論上不會發生)
						errorCode.append(Constants.OTHER_ERROR);
					}
					
				}else{
					//與維熹連線發生錯誤(404、500、連線異常...)
					errorCode.append(Constants.OTHER_ERROR);
				}
			}
		}else{
			log.info("verify fail...");
			errorCode.append(Constants.PARAM_ERROR+verifyCode);
		}
		//set errorCode to result 
		RestResult result = new RestResult();
		result.setCode(errorCode.toString());
		result.setMsg(Constants.getMsg(errorCode.toString()));
		response.setResult(result);
		//return jsonStr
		String rtnStr = gson.toJson(response);
		
		return rtnStr;
	}

	@Override
	public String getDeviceStatus(GetDeviceStatusReq request,
			GetDeviceStatusRequest wsRequest, GetDeviceStatusRsp response,
			GetDeviceStatusResponse wsResponse) {

		StringBuilder errorCode = new StringBuilder(Constants.SMART_HOME+Constants.API+Constants.API_NO);
		
		final String verifyCode = super.checkRequestParam(request);//check request param
		
		if(Constants.SUCCESS.equals(verifyCode)){
			log.info("verify pass...");
			try {
				//post to 維熹
				errorCode.append(Constants.BANK_END_ERROR);
				
				
				wsResponse = postUtil.getDeviceStatus(wsRequest,URL);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("call 維熹...error log............");
			}finally{
				//change status => code
				if(null != wsResponse){
					
					String status = null;
					if(null != wsResponse.getResult()){
						status = wsResponse.getResult().getStatus();
					}
					if(null != status){
						BeanUtils.copyProperties(wsResponse, response);
						if(Constants.codeMap.containsKey(status)){
							errorCode.append(Constants.codeMap.get(status));
						}else{
							errorCode.setLength(0);
							errorCode.append(Constants.SUCCESS);
						}
						
					}else{//有response,卻沒有Result的status (理論上不會發生)
						errorCode.append(Constants.OTHER_ERROR);
					}
					
				}else{
					//與維熹連線發生錯誤(404、500、連線異常...)
					errorCode.append(Constants.OTHER_ERROR);
				}
			}
		}else{
			log.info("verify fail...");
			errorCode.append(Constants.PARAM_ERROR+verifyCode);
		}
		//set errorCode to result 
		RestResult result = new RestResult();
		result.setCode(errorCode.toString());
		result.setMsg(Constants.getMsg(errorCode.toString()));
		response.setResult(result);
		//return jsonStr
		String rtnStr = gson.toJson(response);
		
		return rtnStr;
	}

	@Override
	public String getAlertNotice(GetAlertNoticeReq request,
			GetAlertNoticeRequest wsRequest, GetAlertNoticeRsp response,
			GetAlertNoticeResponse wsResponse) {
		StringBuilder errorCode = new StringBuilder(Constants.SMART_HOME+Constants.API+Constants.API_NO);
		final String verifyCode = super.checkRequestParam(request);//check request param
		
		if(Constants.SUCCESS.equals(verifyCode)){
			log.info("verify pass...");
			try {
				//post to 維熹
				errorCode.append(Constants.BANK_END_ERROR);
				
				wsResponse = postUtil.getAlertNotice(wsRequest,URL);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("call 維熹...error log............");
			}finally{
				//change status => code
				if(null != wsResponse){
					
					String status = null;
					if(null != wsResponse.getResult()){
						status = wsResponse.getResult().getStatus();
					}
					if(null != status){
						BeanUtils.copyProperties(wsResponse, response);
						if(Constants.codeMap.containsKey(status)){
							errorCode.append(Constants.codeMap.get(status));
						}else{
							errorCode.setLength(0);
							errorCode.append(Constants.SUCCESS);
						}
						
					}else{//有response,卻沒有Result的status (理論上不會發生)
						errorCode.append(Constants.OTHER_ERROR);
					}
					
				}else{
					//與維熹連線發生錯誤(404、500、連線異常...)
					errorCode.append(Constants.OTHER_ERROR);
				}
			}
		}else{
			log.info("verify fail...");
			errorCode.append(Constants.PARAM_ERROR+verifyCode);
		}
		//set errorCode to result 
		RestResult result = new RestResult();
		result.setCode(errorCode.toString());
		result.setMsg(Constants.getMsg(errorCode.toString()));
		response.setResult(result);
		//return jsonStr
		String rtnStr = gson.toJson(response);
		
		return rtnStr;
	}

	@Override
	public String addAlertNotice(AddAlertNoticeReq request,
			AddAlertNoticeRequest wsRequest, AddAlertNoticeRsp response,
			AddAlertNoticeResponse wsResponse) {

		StringBuilder errorCode = new StringBuilder(Constants.SMART_HOME+Constants.API+Constants.API_NO);
		final String verifyCode = super.checkRequestParam(request);//check request param
		
		if(Constants.SUCCESS.equals(verifyCode)){
			log.info("verify pass...");
			try {
				//post to 維熹
				errorCode.append(Constants.BANK_END_ERROR);
				
				wsResponse = postUtil.addAlertNotice(wsRequest,URL);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("call 維熹...error log............");
			}finally{
				//change status => code
				if(null != wsResponse){
					
					String status = null;
					if(null != wsResponse.getResult()){
						status = wsResponse.getResult().getStatus();
					}
					if(null != status){
						BeanUtils.copyProperties(wsResponse, response);
						if(Constants.codeMap.containsKey(status)){
							errorCode.append(Constants.codeMap.get(status));
						}else{
							errorCode.setLength(0);
							errorCode.append(Constants.SUCCESS);
						}
						
					}else{//有response,卻沒有Result的status (理論上不會發生)
						errorCode.append(Constants.OTHER_ERROR);
					}
					
				}else{
					//與維熹連線發生錯誤(404、500、連線異常...)
					errorCode.append(Constants.OTHER_ERROR);
				}
			}
		}else{
			log.info("verify fail...");
			errorCode.append(Constants.PARAM_ERROR+verifyCode);
		}
		//set errorCode to result 
		RestResult result = new RestResult();
		result.setCode(errorCode.toString());
		result.setMsg(Constants.getMsg(errorCode.toString()));
		response.setResult(result);
		//return jsonStr
		String rtnStr = gson.toJson(response);
		
		return rtnStr;
	}

	@Override
	public String delAlertNotice(DelAlertNoticeReq request,
			DelAlertNoticeRequest wsRequest, DelAlertNoticeRsp response,
			DelAlertNoticeResponse wsResponse) {

		StringBuilder errorCode = new StringBuilder(Constants.SMART_HOME+Constants.API+Constants.API_NO);
		final String verifyCode = super.checkRequestParam(request);//check request param
		
		if(Constants.SUCCESS.equals(verifyCode)){
			log.info("verify pass...");
			try {
				//post to 維熹
				errorCode.append(Constants.BANK_END_ERROR);
				
				wsResponse = postUtil.delAlertNotice(wsRequest,URL);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("call 維熹...error log............");
			}finally{
				//change status => code
				if(null != wsResponse){
					
					String status = null;
					if(null != wsResponse.getResult()){
						status = wsResponse.getResult().getStatus();
					}
					if(null != status){
						BeanUtils.copyProperties(wsResponse, response);
						if(Constants.codeMap.containsKey(status)){
							errorCode.append(Constants.codeMap.get(status));
						}else{
							errorCode.setLength(0);
							errorCode.append(Constants.SUCCESS);
						}
						
					}else{//有response,卻沒有Result的status (理論上不會發生)
						errorCode.append(Constants.OTHER_ERROR);
					}
					
				}else{
					//與維熹連線發生錯誤(404、500、連線異常...)
					errorCode.append(Constants.OTHER_ERROR);
				}
			}
		}else{
			log.info("verify fail...");
			errorCode.append(Constants.PARAM_ERROR+verifyCode);
		}
		//set errorCode to result 
		RestResult result = new RestResult();
		result.setCode(errorCode.toString());
		result.setMsg(Constants.getMsg(errorCode.toString()));
		response.setResult(result);
		//return jsonStr
		String rtnStr = gson.toJson(response);
		
		return rtnStr;
	}

	@Override
	public String getDID(GetDidReq request, GetDidRequest wsRequest,
			GetDidRsp response, GetDidResponse wsResponse) {

		StringBuilder errorCode = new StringBuilder(Constants.SMART_HOME+Constants.API+Constants.API_NO);
		final String verifyCode = super.checkRequestParam(request);//check request param
		
		if(Constants.SUCCESS.equals(verifyCode)){
			log.info("verify pass...");
			try {
				//post to 維熹
				errorCode.append(Constants.BANK_END_ERROR);
				
				wsResponse = postUtil.getDid(wsRequest,URL);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("call 維熹...error log............");
			}finally{
				//change status => code
				if(null != wsResponse){
					
					String status = null;
					if(null != wsResponse.getResult()){
						status = wsResponse.getResult().getStatus();
					}
					if(null != status){
						BeanUtils.copyProperties(wsResponse, response);
						if(Constants.codeMap.containsKey(status)){
							errorCode.append(Constants.codeMap.get(status));
						}else{
							errorCode.setLength(0);
							errorCode.append(Constants.SUCCESS);
						}
						
					}else{//有response,卻沒有Result的status (理論上不會發生)
						errorCode.append(Constants.OTHER_ERROR);
					}
					
				}else{
					//與維熹連線發生錯誤(404、500、連線異常...)
					errorCode.append(Constants.OTHER_ERROR);
				}
			}
		}else{
			log.info("verify fail...");
			errorCode.append(Constants.PARAM_ERROR+verifyCode);
		}
		//set errorCode to result 
		RestResult result = new RestResult();
		result.setCode(errorCode.toString());
		result.setMsg(Constants.getMsg(errorCode.toString()));
		response.setResult(result);
		//return jsonStr
		String rtnStr = gson.toJson(response);
		return rtnStr;
	}

	@Override
	public String getUser(GetUserReq request, GetUserRequest wsRequest,
			GetUserRsp response, GetUserResponse wsResponse) {
		
		StringBuilder errorCode = new StringBuilder(Constants.SMART_HOME+Constants.API+Constants.API_NO);
		final String verifyCode = super.checkRequestParam(request);//check request param
		
		if(Constants.SUCCESS.equals(verifyCode)){
			log.info("verify pass...");
			try {
				//post to 維熹
				errorCode.append(Constants.BANK_END_ERROR);
				
				wsResponse = postUtil.getUser(wsRequest,URL);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("call 維熹...error log............");
			}finally{
				//change status => code
				if(null != wsResponse){
					
					String status = null;
					if(null != wsResponse.getResult()){
						status = wsResponse.getResult().getStatus();
					}
					if(null != status){
						BeanUtils.copyProperties(wsResponse, response);
						if(Constants.codeMap.containsKey(status)){
							errorCode.append(Constants.codeMap.get(status));
						}else{
							errorCode.setLength(0);
							errorCode.append(Constants.SUCCESS);
						}
						
					}else{//有response,卻沒有Result的status (理論上不會發生)
						errorCode.append(Constants.OTHER_ERROR);
					}
					
				}else{
					//與維熹連線發生錯誤(404、500、連線異常...)
					errorCode.append(Constants.OTHER_ERROR);
				}
			}
		}else{
			log.info("verify fail...");
			errorCode.append(Constants.PARAM_ERROR+verifyCode);
		}
		//set errorCode to result 
		RestResult result = new RestResult();
		result.setCode(errorCode.toString());
		result.setMsg(Constants.getMsg(errorCode.toString()));
		response.setResult(result);
		//return jsonStr
		String rtnStr = gson.toJson(response);
		return rtnStr;
	}

}
