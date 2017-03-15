package com.fet.rest.bean;

import com.fet.ws.bean.GetUserRequest;


public class GetUserReq extends GetUserRequest {

	private String channelId;
	private String partnerId;
	private String msisdn;//PC,WO未來使用
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
}
