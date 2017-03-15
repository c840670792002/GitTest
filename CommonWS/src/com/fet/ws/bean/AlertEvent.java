package com.fet.ws.bean;

public class AlertEvent {
	
	private String time;//	string	告警時間，格式為"YYYY/MM/DD hh:mm:ss"
	private String pic;//	string	告警事件照片網址
	private Device device;//	object	告警設備資訊
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
}
