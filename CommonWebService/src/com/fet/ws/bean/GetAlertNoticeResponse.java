package com.fet.ws.bean;

import java.util.List;

public class GetAlertNoticeResponse {

	private Result result;
	private List<AlertNotice> alertNotices;//	array	報警對象資訊列表

	public List<AlertNotice> getAlertNotices() {
		return alertNotices;
	}

	public void setAlertNotices(List<AlertNotice> alertNotices) {
		this.alertNotices = alertNotices;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}


}
