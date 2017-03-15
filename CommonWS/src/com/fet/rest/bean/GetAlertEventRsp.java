package com.fet.rest.bean;

import java.util.List;

import com.fet.ws.bean.AlertEvent;

public class GetAlertEventRsp  {
	
	private RestResult result;
	private String totalSize;//	string	查詢時間區間之總數
	private List<AlertEvent> alertEvents;//	array	告警事件資訊列表
	

	public RestResult getResult() {
		return result;
	}
	public void setResult(RestResult result) {
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
