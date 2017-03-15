package com.fet.ws.bean;

public class EDID {

	private String EDID	;//string	子機EDID
	private Integer status	;//number	目前連線狀態，其值為1:連線中; 0:離線
	private String lastConn;//	string	上次連線時間，只有status=0才有	格式為"YYYY/MM/DD hh:mm"

	private String name;//string edidName

	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLastConn() {
		return lastConn;
	}
	public void setLastConn(String lastConn) {
		this.lastConn = lastConn;
	}
	public String getEDID() {
		return EDID;
	}
	public void setEDID(String eDID) {
		EDID = eDID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
}
