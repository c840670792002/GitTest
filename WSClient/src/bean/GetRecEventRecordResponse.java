package bean;

import java.util.List;

public class GetRecEventRecordResponse {

	private Result result;
	private String totalSize	;//string	查詢時間區間之段落總數
	private List<RecEvent> recEvents;//	array	連線記錄列表
	
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
	public List<RecEvent> getRecEvents() {
		return recEvents;
	}
	public void setRecEvents(List<RecEvent> recEvents) {
		this.recEvents = recEvents;
	}
	
	

}
