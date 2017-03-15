package com.fet.api.service;

import org.springframework.util.StringUtils;

import com.fet.rest.bean.AddAlertNoticeReq;
import com.fet.rest.bean.DelAlertNoticeReq;
import com.fet.rest.bean.GetAlarmEventReq;
import com.fet.rest.bean.GetAlertNoticeReq;
import com.fet.rest.bean.GetDeviceStatusReq;
import com.fet.rest.bean.GetDidReq;
import com.fet.rest.bean.GetUserReq;
import com.fet.util.Constants;

public class BaseService {
	
	/**欄位檢核
	 * @param <T>
	 * @param request
	 * @return
	 */
	protected <T> String checkRequestParam(T request) {

		//	1.取得攝影機報警記錄
		if(request instanceof GetAlarmEventReq){
			GetAlarmEventReq r = (GetAlarmEventReq) request;
			if(StringUtils.isEmpty(r.getDID()) || StringUtils.isEmpty(r.getStartTime()) || StringUtils.isEmpty(r.getEndTime()) 
					|| StringUtils.isEmpty(r.getPageNum()) || StringUtils.isEmpty(r.getPageSize()) ){
				return Constants.PARAM_ERROR_NULL;
			}
			if(!Constants.CHANNEL_END_USER.equals(r.getChannelId()) && !Constants.CHANNEL_CSR.equals(r.getChannelId())){
				return Constants.PARAM_ERROR_CHANNEL;
			}
			if(!Constants.PARTNER_SEC.equals(r.getPartnerId())){
				return Constants.PARAM_ERROR_PARTNER;
			}
			
			//2.取得攝影機週邊設備及附屬子機狀況
		}else if(request instanceof GetDeviceStatusReq){
			GetDeviceStatusReq r = (GetDeviceStatusReq) request;
			if(StringUtils.isEmpty(r.getDID())){
				return Constants.PARAM_ERROR_NULL;
			}
			if(!Constants.CHANNEL_END_USER.equals(r.getChannelId()) && !Constants.CHANNEL_CSR.equals(r.getChannelId())){
				return Constants.PARAM_ERROR_CHANNEL;
			}
			if(!Constants.PARTNER_SEC.equals(r.getPartnerId())){
				return Constants.PARAM_ERROR_PARTNER;
			}
			
			//3.取得攝影機所有報警門號及email
		}else if(request instanceof GetAlertNoticeReq){
			GetAlertNoticeReq r = (GetAlertNoticeReq) request;
			if(StringUtils.isEmpty(r.getDID())){
				return Constants.PARAM_ERROR_NULL;
			}
			if(!Constants.CHANNEL_END_USER.equals(r.getChannelId()) && !Constants.CHANNEL_CSR.equals(r.getChannelId())){
				return Constants.PARAM_ERROR_CHANNEL;
			}
			if(!Constants.PARTNER_SEC.equals(r.getPartnerId())){
				return Constants.PARAM_ERROR_PARTNER;
			}
			//4.新增報警門號/email
		}else if(request instanceof AddAlertNoticeReq){
			AddAlertNoticeReq r = (AddAlertNoticeReq) request;
			if(StringUtils.isEmpty(r.getDID()) || StringUtils.isEmpty(r.getAlertNotice())){
				return Constants.PARAM_ERROR_NULL;
			}
			if(!Constants.CHANNEL_END_USER.equals(r.getChannelId()) && !Constants.CHANNEL_CSR.equals(r.getChannelId())){
				return Constants.PARAM_ERROR_CHANNEL;
			}
			if(!Constants.PARTNER_SEC.equals(r.getPartnerId())){
				return Constants.PARAM_ERROR_PARTNER;
			}
			//5.刪除報警門號/email
		}else if(request instanceof DelAlertNoticeReq){
			DelAlertNoticeReq r = (DelAlertNoticeReq) request;
			if(StringUtils.isEmpty(r.getDID()) || StringUtils.isEmpty(r.getAlertNotice())){
				return Constants.PARAM_ERROR_NULL;
			}
			if(!Constants.CHANNEL_END_USER.equals(r.getChannelId()) && !Constants.CHANNEL_CSR.equals(r.getChannelId())){
				return Constants.PARAM_ERROR_CHANNEL;
			}
			if(!Constants.PARTNER_SEC.equals(r.getPartnerId())){
				return Constants.PARAM_ERROR_PARTNER;
			}
			//6.取得申辦人的主機及附屬子機資料
		}else if(request instanceof GetDidReq){
			GetDidReq r = (GetDidReq) request;
			if(StringUtils.isEmpty(r.getUserId())){
				return Constants.PARAM_ERROR_NULL;
			}
			if(!Constants.CHANNEL_END_USER.equals(r.getChannelId()) && !Constants.CHANNEL_CSR.equals(r.getChannelId())){
				return Constants.PARAM_ERROR_CHANNEL;
			}
			if(!Constants.PARTNER_SEC.equals(r.getPartnerId())){
				return Constants.PARAM_ERROR_PARTNER;
			}
			//7.取得DID的申辦人資料
		}else if(request instanceof GetUserReq){
			GetUserReq r = (GetUserReq) request;
			if(StringUtils.isEmpty(r.getDID())){
				return Constants.PARAM_ERROR_NULL;
			}
			if(!Constants.CHANNEL_END_USER.equals(r.getChannelId()) && !Constants.CHANNEL_CSR.equals(r.getChannelId())){
				return Constants.PARAM_ERROR_CHANNEL;
			}
			if(!Constants.PARTNER_SEC.equals(r.getPartnerId())){
				return Constants.PARAM_ERROR_PARTNER;
			}
		}
		
		return Constants.SUCCESS;
	}
	
}
