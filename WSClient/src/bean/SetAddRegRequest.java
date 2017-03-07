package bean;

public class SetAddRegRequest {

	private String DID;//	string	yes	攝影機DID
	private String userId;//	string	yes	申辦人UID
	private String msisdn	;//string	yes	申辦人手機門號
	private String productId	;//string	yes	申辦方案ProductID
	private String offerId	;//string	yes	申辦方案OfferID
	
	public String getDID() {
		return DID;
	}
	public void setDID(String dID) {
		DID = dID;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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


	
}
