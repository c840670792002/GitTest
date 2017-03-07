package bean;

public class SetChangeRegRequest {

	private String userId;//	string	yes	申辦人UID
	private String msisdn	;//string	yes	申辦人手機門號
	private String orgDID;//	string	yes	換機前的攝影機DID
	private String newDID;//	string	yes	換機後的攝影機DID
	
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
	public String getOrgDID() {
		return orgDID;
	}
	public void setOrgDID(String orgDID) {
		this.orgDID = orgDID;
	}
	public String getNewDID() {
		return newDID;
	}
	public void setNewDID(String newDID) {
		this.newDID = newDID;
	}



	
}
