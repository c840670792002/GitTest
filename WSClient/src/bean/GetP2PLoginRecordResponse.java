package bean;

import java.util.List;

public class GetP2PLoginRecordResponse {

	private Result result;
	private String totalSize;//	string	查詢時間區間之段落總數
	private List<P2PLogin> P2PLogins;//	array	連線記錄列表
	
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
	public List<P2PLogin> getP2PLogins() {
		return P2PLogins;
	}
	public void setP2PLogins(List<P2PLogin> p2pLogins) {
		P2PLogins = p2pLogins;
	}


}
