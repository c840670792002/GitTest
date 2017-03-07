package bean;

import java.util.List;

public class DID {
	

	private String DID;//	string	攝影機DID
	private Integer status;//	number	DID開通狀態，其值為
//	0:出廠
//	1:啟用
//	2:欠款暫斷
//	3:預備停機
//	-1:永久停機
	private String productID;//	string	申辦方案ProductID
	private String offerID;//	string	申辦方案OfferID
	private List<EDID> EDIDs;//	array	子機EDID列表
	
	
	public String getDID() {
		return DID;
	}
	public void setDID(String dID) {
		DID = dID;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getOfferID() {
		return offerID;
	}
	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}
	public List<EDID> getEDIDs() {
		return EDIDs;
	}
	public void setEDIDs(List<EDID> eDIDs) {
		EDIDs = eDIDs;
	}

	
	
	
}
