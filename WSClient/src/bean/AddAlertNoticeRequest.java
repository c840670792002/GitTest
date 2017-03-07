package bean;


public class AddAlertNoticeRequest {
	
	private String DID	;//string	yes	攝影機DID
	private String userId	;//string	no	申辦人UID
	private AlertNotice alertNotice;//	報警對象資訊 
	
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
	public AlertNotice getAlertNotice() {
		return alertNotice;
	}
	public void setAlertNotice(AlertNotice alertNotice) {
		this.alertNotice = alertNotice;
	}
	


}
