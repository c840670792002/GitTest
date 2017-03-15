package com.fet.rest.bean;

import java.util.List;

import com.fet.ws.bean.Device;
import com.fet.ws.bean.EDID;

public class GetDeviceStatusRsp {
	
	private RestResult result;
	private List<Device> devices;//	array	攝影機週邊資訊列表
	private List<EDID> EDIDs;//	array	子機資訊列表


	public RestResult getResult() {
		return result;
	}
	public void setResult(RestResult result) {
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
