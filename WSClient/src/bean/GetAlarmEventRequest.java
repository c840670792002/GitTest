package bean;

public class GetAlarmEventRequest {
	
	private String DID;//	string	攝影機DID
	private String userId;//	string	no		申辦人UID
	private String startTime;//	string	yes	查詢區間開始時間，格式為YYYYMMDDhhmmss
	private String endTime;//	string	yes	查詢區間結束時間，格式為YYYYMMDDhhmmss
	private Integer pageNum;//	number	yes	查詢起始頁數
	private Integer pageSize;//	number	yes	查詢每頁筆數
	
	public String getDID() {
		return DID;
	}
	public void setDID(String dID) {
		DID = dID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
