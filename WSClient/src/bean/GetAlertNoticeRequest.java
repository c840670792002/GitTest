package bean;

public class GetAlertNoticeRequest {
	
	private String DID;//	string	yes	攝影機DID
	private String userId;//	string	no	申辦人UID
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
	
	
}
