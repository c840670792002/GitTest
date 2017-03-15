package com.fet.ws.bean;

import java.util.List;

public class GetAlarmEventResponse  {
	
	private Result result;
	private String totalSize;//	string	查詢時間區間之總數
	private List<AlertEvent> alertEvents;//	array	告警事件資訊列表
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	public List<AlertEvent> getAlertEvents() {
		return alertEvents;
	}
	public void setAlertEvents(List<AlertEvent> alertEvents) {
		this.alertEvents = alertEvents;
	}

	
}
