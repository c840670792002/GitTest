package com.fet.rest.bean;

import java.util.List;

import com.fet.ws.bean.AlertNotice;

public class GetAlertNoticeRsp {

	private RestResult result;
	private List<AlertNotice> alertNotices;//	array	報警對象資訊列表

	public List<AlertNotice> getAlertNotices() {
		return alertNotices;
	}

	public void setAlertNotices(List<AlertNotice> alertNotices) {
		this.alertNotices = alertNotices;
	}

	public RestResult getResult() {
		return result;
	}
	public void setResult(RestResult result) {
		this.result = result;
	}


}
