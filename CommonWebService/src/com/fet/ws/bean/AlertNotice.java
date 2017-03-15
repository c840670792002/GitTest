package com.fet.ws.bean;

public class AlertNotice {

	private String value;//	string	門號或email
	private String type	;//string	value屬性
	private Integer status	;//number	status	number	門號或email狀態，其值為0:未驗證; 1:已驗證
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
