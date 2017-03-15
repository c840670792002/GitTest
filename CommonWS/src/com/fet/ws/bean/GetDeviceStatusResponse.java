package com.fet.ws.bean;

import java.util.List;

public class GetDeviceStatusResponse {
	
	private Result result;
	private List<Device> devices;//	array	攝影機週邊資訊列表
	private List<EDID> EDIDs;//	array	子機資訊列表
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public List<EDID> getEDIDs() {
		return EDIDs;
	}
	public void setEDIDs(List<EDID> eDIDs) {
		EDIDs = eDIDs;
	}

			


}
