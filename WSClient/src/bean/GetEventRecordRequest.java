package bean;

public class GetEventRecordRequest {

	
	private String DID;//	string	yes	攝影機DID
	private String userId;//	string	no	申辦人UID
	private Integer type	;//number	yes	事件類型，包含1	佈防|撤防（警報設定異動）2	錄影設置3	密碼設置
	private String startTime	;//string	yes	查詢區間開始時間，格式為YYYYMMDDhhmm
	private String endTime	;//string	yes	查詢區間結束時間，格式為YYYYMMDDhhmm	查詢區間為3日，最久查詢1個月前（+前1）記錄
	private Integer pageNum	;//number	yes	查詢起始頁數
	private Integer pageSize	;//number	yes	查詢每頁筆數
	
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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

	
}
