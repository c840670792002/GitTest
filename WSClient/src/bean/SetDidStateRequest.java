package bean;

public class SetDidStateRequest {

	private String userId;//	string	yes	申辦人UID
	private String DID	;//string	no	攝影機DID if existed, 僅設定該DID if not existed, 設定該UserID所有DID
	private String msisdn	;//string	no	申辦人門號
	private String set	;//string	yes	設定動作，其值為 "ON":重新啟用攝影機權限，"OFF":暫斷攝影機權限
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDID() {
		return DID;
	}
	public void setDID(String dID) {
		DID = dID;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getSet() {
		return set;
	}
	public void setSet(String set) {
		this.set = set;
	}

	
}
