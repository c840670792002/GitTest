package com.fet.util;

import java.util.HashMap;

public final class Constants {
	
	//-----------------維熹API對應methodName------------------------//
	/**1.取得攝影機報警記錄*/
    public static final String GetAlarmEvent = "getAlarmEvent";
	/**2.取得攝影機週邊設備及附屬子機狀況*/
    public static final String GetDeviceStatus = "getDeviceStatus";
    /**3.取得攝影機所有報警門號及email*/
    public static final String GetAlertNotice = "getAlertNotice";
    /**4.新增報警門號/email*/
    public static final String AddAlertNotice = "addAlertNotice";
    /**5.刪除報警門號/email*/
    public static final String DelAlertNotice = "delAlertNotice";
    /**6.取得申辦人的主機及附屬子機資料*/
    public static final String GetDID = "getDID";
    /**7.取得DID的申辦人資料*/
    public static final String GetUser = "getUser";
    /**8.設定攝影機：暫斷／重新啟用*/
    public static final String SetDidState = "setDIDState";
    /**9.設定攝影機：開通啟用*/
    public static final String SetAddReg = "setAddReg";
    /**10.設定攝影機：退租停機*/
    public static final String SetDelReg = "setDelReg";
    /**11. 申辦人更換攝影機*/
    public static final String SetChangeReg = "setChangeReg";
    /**12. 申辦人更換手機門號*/
    public static final String SetChangeCell = "setChangeCell";
    /**13. 取得攝影機連線記錄*/
    public static final String GetP2PLoginRecord = "getP2PLoginRecord";
    /**14. 取得攝影機即時連線狀態*/
    public static final String GetP2PLoginStatus = "getP2PLoginStatus";
    /**15. 取得攝影機日誌事件記錄*/
    public static final String GetEventRecord = "getEventRecord";
    /**16. 取得攝影機錄影設置記錄*/
    public static final String GetRecEventRecord = "getRecEventRecord";
    /**17. 取得攝影機即時錄影狀態*/
    public static final String GetRecEventStatus = "getRecEventStatus";
    
    
    //-------------Digit 1: System code-------------//
	/**S: Smart Home*/
	public static String SMART_HOME = "S";
	
	//-------------Digit 2-3: Function type code-------------//
	/**00 : Common type return code*/
	public static String COMMON_TYPE = "00";
	/**01 : API*/
	public static String API = "01";
	
	//-------------Digit 4-6: Function code-------------//
	/**001 : API No*/
	public static String API_NO = "001";
	
	//-------------Digit 7-8: Error type code-------------//
	/**00 : Custom errors*/
	public static String CUSTOM_ERROR = "00";
	/**01 : Parameter errors*/
	public static String PARAM_ERROR = "01";
	/**02 : DB error*/
	public static String DB_ERROR = "02";
	/**98 : Bank-End error*/
	public static String BANK_END_ERROR = "98";
	/**99 : System level errors*/
	public static String SYSTEM_LEVEL_ERROR = "99";
	
	//-------------Digit 9-10: Error codes-------------//
	/**01-Parameter error- 01 Channel Information 不正確*/
	public static String PARAM_ERROR_CHANNEL = "01";
	/**01-Parameter error- 02 Partner Information 不正確*/
	public static String PARAM_ERROR_PARTNER = "02";
	/**01-Parameter error- 03 parameter was null*/
	public static String PARAM_ERROR_NULL = "03";
	
	/**02-DB error-01*/
	public static String DB_ERROR_1 = "01";
	/**02-DB error-02*/
	public static String DB_ERROR_2 = "02";
	
	/**98-Bank-End error-維熹errorCode轉換*/
	public static HashMap codeMap = new HashMap();
	static{
//		codeMap.put("1", "00");//設定成功
		codeMap.put("0", "00");//設定失敗 或 查無資料
		codeMap.put("-1", "01");//Key incorrect
		codeMap.put("-2", "02");//格式錯誤
		codeMap.put("-3", "03");//時間不正確
		codeMap.put("-4", "04");//DID 不存在
		codeMap.put("-5", "05");//DataBase 連線失敗
		codeMap.put("-6", "06");//新增或更新資料失敗
		codeMap.put("-7", "07");//簡訊傳送失敗
		codeMap.put("-8", "08");//門號不屬於FET
		codeMap.put("-9", "09");//找不到方案
		codeMap.put("-10", "10");//設定數超過上限
		codeMap.put("-11", "11");//DID 尚未配對
		codeMap.put("-12", "12");//Email寄送失敗
		codeMap.put("-13", "13");//URL已失效
	}
	/**呼叫維熹時的其他異常(http error 404...500...)*/
	public static String OTHER_ERROR = "99";
	
	//------------------Digit 7-10 : 轉換錯誤訊息--------------------------//
	/**code對應msg, REST回傳使用*/
	public static HashMap msgMap = new HashMap();
	static{
		//成功訊息
		msgMap.put("0000", "設定成功");
		//param訊息
		msgMap.put("0101", "Channel Information 不正確");
		msgMap.put("0102", "Partner Information 不正確");
		msgMap.put("0103", "parameter was null");
		//DB訊息
		msgMap.put("0201", "DB error-01");
		msgMap.put("0202", "DB error-02");
		//維熹訊息
		msgMap.put("9800", "設定失敗 或 查無資料");
		msgMap.put("9801", "Key incorrect");
		msgMap.put("9802", "格式錯誤");
		msgMap.put("9803", "時間不正確");
		msgMap.put("9804", "DID 不存在");
		msgMap.put("9805", "DataBase 連線失敗");
		msgMap.put("9806", "新增或更新資料失敗");
		msgMap.put("9807", "簡訊傳送失敗");
		msgMap.put("9808", "門號不屬於FET");
		msgMap.put("9809", "找不到方案");
		msgMap.put("9810", "設定數超過上限");
		msgMap.put("9811", "DID 尚未配對");
		msgMap.put("9812", "Email寄送失敗");
		msgMap.put("9813", "URL已失效");
		//維熹其他錯誤 ex http 404,500
		msgMap.put("9899", "Http連線異常");
	}
	
	//-------------Other----------------------
	/**0000000000:成功代碼*/
	public static String SUCCESS = "0000000000";
	/**01:Channel-End User Web*/
	public static String CHANNEL_END_USER = "01";
	/**02:Channel-CSR*/
	public static String CHANNEL_CSR= "02";
	/**二代PartnerId*/
	public static String PARTNER_SEC = "DSES000001";
	
	/**預設子雞名稱*/
	public static String EDID_NAME = "子機";
	
	/**透過errorCode後四碼轉換訊息內容
	 * @param code
	 * @return
	 */
	public static String getMsg(String code){
		return (String) msgMap.get(code.substring(code.length()-4,code.length()));
	}
	
}
