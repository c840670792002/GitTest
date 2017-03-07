package bean;

public class Device {
	
	
	private String name;//	string	設備名稱
	private String qrSN;//	string	設備QR code編號
	private Integer power;//	number	電壓狀態，其值為1:正常; 0:異常
	private Integer status;//	number	設備狀態，其值為1:正常; 0:低電壓或離線
	private String connTime;//	string	最近連線時間 格式為"YYYY/MM/DD hh:mm:ss"
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQrSN() {
		return qrSN;
	}
	public void setQrSN(String qrSN) {
		this.qrSN = qrSN;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getConnTime() {
		return connTime;
	}
	public void setConnTime(String connTime) {
		this.connTime = connTime;
	}

	
	
}
