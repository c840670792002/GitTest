package bean;

public class P2PLogin {
	private String stime;//	string	查詢區間段落開始時間	格式為"YYYY/MM/DD hh:mm"
	private String etime;//		string	查詢區間段落開始時間	格式為"YYYY/MM/DD hh:mm"
	private Integer status;//		number	區間段落之連線狀態，其值為	0	已離線	1	連線中
	
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
