package bean;

import java.util.List;

public class GetRecEventStatusResponse {

	private Result result;
	private String totalSize;//	string	查詢時間區間之段落總數
	private List<RecEvent> recEvent	;//array	連線記錄列表，包含
	
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
	public List<RecEvent> getRecEvent() {
		return recEvent;
	}
	public void setRecEvent(List<RecEvent> recEvent) {
		this.recEvent = recEvent;
	}


	
}
