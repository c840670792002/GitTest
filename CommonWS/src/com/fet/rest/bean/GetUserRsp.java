package com.fet.rest.bean;


public class GetUserRsp  {
	
	private RestResult result;
	private String userId;//	string	申辦人UID
	private String productId;//	string	申辦方案ProductID
	private String offerId;//	string	申辦方案OfferID
	private String msisdn;//PC,WO未來使用
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
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
	public RestResult getResult() {
		return result;
	}
	public void setResult(RestResult result) {
		this.result = result;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


}
