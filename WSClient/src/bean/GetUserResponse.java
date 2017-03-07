package bean;


public class GetUserResponse  {
	
	private Result result;
	private String userId;//	string	申辦人UID
	private String productId;//	string	申辦方案ProductID
	private String offerId;//	string	申辦方案OfferID
	private String msisdn;//	string	申辦人手機門號
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	


}
