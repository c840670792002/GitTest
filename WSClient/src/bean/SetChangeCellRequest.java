package bean;

public class SetChangeCellRequest {

	private String userId;//	string	yes	申辦人UID
	private String productId;//	string	no	申辦方案ProductID (不檢核)
	private String orgMsisdn;//	string	no	原來的申辦人手機門號 (不檢核)
	private String newMsisdn;//	string	yes	更新的申辦人手機門號
	
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
	public String getOrgMsisdn() {
		return orgMsisdn;
	}
	public void setOrgMsisdn(String orgMsisdn) {
		this.orgMsisdn = orgMsisdn;
	}
	public String getNewMsisdn() {
		return newMsisdn;
	}
	public void setNewMsisdn(String newMsisdn) {
		this.newMsisdn = newMsisdn;
	}



}
