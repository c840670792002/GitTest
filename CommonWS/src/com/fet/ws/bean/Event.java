package com.fet.ws.bean;

public class Event {

	private String time	;//string	日誌事件時間	格式為"YYYY/MM/DD hh:mm:ss"
	private Integer source ;//	number	事件觸發來源，包含	0	主機或排程計畫	1	APP	2	遙控器
	private Integer status	;//number	區間段落之連線狀態，其值為	if Type=1, 1 - 佈防，0 - 撤防	if Type=2, 1 - 錄影，0 - 停止錄影	if Type=3, 1 - 成功，0 - 失敗
	private Integer zone	;//number	防區分組，只有Type=1時才有，包含	0	全防區	1	防區分組1 	2	防區分組2
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getZone() {
		return zone;
	}
	public void setZone(Integer zone) {
		this.zone = zone;
	}

	
}
