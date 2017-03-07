package bean;

import java.util.List;

public class GetEventRecordResponse {
	
	private Result result;
	private String totalSize	;//string	查詢時間區間之段落總數
	private Integer type;//	number	事件類型，包含	1	佈防|撤防（警報設定異動）	2	錄影設置	3	密碼設置
	private List<Event> events	;//array	日誌事件記錄列表
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}



}
