package util;

public final class Constants {
	
	//維熹API對應methodName
	/**1.取得攝影機報警記錄*/
    public static final String GetAlarmEvent = "GetAlarmEvent";
	/**2.取得攝影機週邊設備及附屬子機狀況*/
    public static final String GetDeviceStatus = "GetDeviceStatus";
    /**3.取得攝影機所有報警門號及email*/
    public static final String GetAlertNotice = "GetAlertNotice";
    /**4.新增報警門號/email*/
    public static final String AddAlertNotice = "AddAlertNotice";
    /**5.刪除報警門號/email*/
    public static final String DelAlertNotice = "DelAlertNotice";
    /**6.取得申辦人的主機及附屬子機資料*/
    public static final String GetDid = "GetDid";
    /**7.取得DID的申辦人資料*/
    public static final String GetUser = "GetUser";
    /**8.設定攝影機：暫斷／重新啟用*/
    public static final String SetDidState = "SetDidState";
    /**9.設定攝影機：開通啟用*/
    public static final String SetAddReg = "SetAddReg";
    /**10.設定攝影機：退租停機*/
    public static final String SetDelReg = "SetDelReg";
    /**11. 申辦人更換攝影機*/
    public static final String SetChangeReg = "SetChangeReg";
    /**12. 申辦人更換手機門號*/
    public static final String SetChangeCell = "SetChangeCell";
    /**13. 取得攝影機連線記錄*/
    public static final String GetP2PLoginRecord = "GetP2PLoginRecord";
    /**14. 取得攝影機即時連線狀態*/
    public static final String GetP2PLoginStatus = "GetP2PLoginStatus";
    /**15. 取得攝影機日誌事件記錄*/
    public static final String GetEventRecord = "GetEventRecord";
    /**16. 取得攝影機錄影設置記錄*/
    public static final String GetRecEventRecord = "GetRecEventRecord";
    /**17. 取得攝影機即時錄影狀態*/
    public static final String GetRecEventStatus = "GetRecEventStatus";
    

}
