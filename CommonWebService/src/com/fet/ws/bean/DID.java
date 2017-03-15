package com.fet.ws.bean;

import java.util.List;

public class DID {
	

	private String DID;//	string	攝影機DID
	private Integer status;//	number	DID開通狀態，其值為
//	0:出廠
//	1:啟用
//	2:欠款暫斷
//	3:預備停機
//	-1:永久停機
	private String productId;//	string	申辦方案ProductID
	private String offerId;//	string	申辦方案OfferID
	private List<String> EDIDs;//	array	子機EDID列表
	
	
	public String getDID() {
		return DID;
	}
	public void setDID(String dID) {
		DID = dID;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public List<String> getEDIDs() {
		return EDIDs;
	}
	public void setEDIDs(List<String> eDIDs) {
		EDIDs = eDIDs;
	}

	
	
	
}
