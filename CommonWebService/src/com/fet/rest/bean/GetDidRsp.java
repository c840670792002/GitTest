package com.fet.rest.bean;

import java.util.List;

import com.fet.ws.bean.DID;
public class GetDidRsp  {
	
	private RestResult result;
	private List<DID> DIDs;//	array	手機門號配對之DID


	public RestResult getResult() {
		return result;
	}
	public void setResult(RestResult result) {
		this.result = result;
	}

	public List<DID> getDIDs() {
		return DIDs;
	}

	public void setDIDs(List<DID> dIDs) {
		DIDs = dIDs;
	}


}
