package com.fet.rest;
import org.apache.log4j.Logger;

import com.fet.rest.bean.AddAlertNoticeReq;
import com.fet.rest.bean.AddAlertNoticeRsp;
import com.fet.rest.bean.DelAlertNoticeReq;
import com.fet.rest.bean.DelAlertNoticeRsp;
import com.fet.rest.bean.GetAlarmEventReq;
import com.fet.rest.bean.GetAlarmEventRsp;
import com.fet.rest.bean.GetAlertNoticeReq;
import com.fet.rest.bean.GetAlertNoticeRsp;
import com.fet.rest.bean.GetDeviceStatusReq;
import com.fet.rest.bean.GetDeviceStatusRsp;
import com.fet.rest.bean.GetDidReq;
import com.fet.rest.bean.GetDidRsp;
import com.fet.rest.bean.GetUserReq;
import com.fet.rest.bean.GetUserRsp;
import com.fet.util.Constants;
import com.fet.util.HttpPostUtil;
import com.google.gson.Gson;

/** 透過httpPost方式取得ApiGateway資訊
 * @author T
 *
 */
public class ApiGwClient {
	
	final Logger log = Logger.getLogger(ApiGwClient.class);
	final Gson gson = new Gson();
	final HttpPostUtil postUtil = new HttpPostUtil();
	
	/**
	 * 1.取得攝影機報警記錄(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public  GetAlarmEventRsp getAlarmEvent(GetAlarmEventReq request, String URL ) throws Exception {

		
		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetAlarmEvent, requestJson);
		
		GetAlarmEventRsp response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetAlarmEventRsp.class);
		}
		return response;
	}
	

	/**
	 * 2.取得攝影機週邊設備及附屬子機狀況(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public GetDeviceStatusRsp getDeviceStatus(GetDeviceStatusReq request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetDeviceStatus, requestJson);
		
		GetDeviceStatusRsp response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetDeviceStatusRsp.class);
		}
		return response;
	}

	/**
	 * 3.取得攝影機所有報警門號及email(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public GetAlertNoticeRsp getAlertNotice(GetAlertNoticeReq request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetAlertNotice, requestJson);
		
		GetAlertNoticeRsp response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetAlertNoticeRsp.class);
		}
		return response;
	}
	

	/**
	 * 4.新增報警門號/email(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public AddAlertNoticeRsp addAlertNotice(AddAlertNoticeReq request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.AddAlertNotice, requestJson);
		
		AddAlertNoticeRsp response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, AddAlertNoticeRsp.class);
		}
		return response;
	}

	/**
	 * 5.刪除報警門號/email(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public DelAlertNoticeRsp delAlertNotice(DelAlertNoticeReq request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.DelAlertNotice, requestJson);
		
		DelAlertNoticeRsp response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, DelAlertNoticeRsp.class);
		}
		return response;
	}

	/**
	 * 6.取得申辦人的主機及附屬子機資料(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public GetDidRsp getDID(GetDidReq request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetDID, requestJson);
		
		GetDidRsp response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetDidRsp.class);
		}
		return response;
	}

	/**
	 * 7.取得DID的申辦人資料(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public GetUserRsp getUser(GetUserReq request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetUser, requestJson);
		
		GetUserRsp response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetUserRsp.class);
		}
		return response;
	}

//	/**
//	 * 8. 設定攝影機：暫斷／重新啟用(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public SetDidStateRsp setDidState(SetDidStateReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetDidState, requestJson);
//		
//		SetDidStateRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetDidStateRsp.class);
//		}
//		return response;
//	}
//	
//	/**
//	 * 9. 設定攝影機：開通啟用(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public SetAddRegRsp setAddReg(SetAddRegReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetAddReg, requestJson);
//		
//		SetAddRegRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetAddRegRsp.class);
//		}
//		return response;
//	}
//	
//	/**
//	 * 10. 設定攝影機：退租停機(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public SetDelRegRsp setDelReg(SetDelRegReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetDelReg, requestJson);
//		
//		SetDelRegRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetDelRegRsp.class);
//		}
//		return response;
//	}
//	
//	/**
//	 * 11. 申辦人更換攝影機(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public SetChangeRegRsp setChangeReg(SetChangeRegReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetChangeReg, requestJson);
//		
//		SetChangeRegRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetChangeRegRsp.class);
//		}
//		return response;
//	}
//	
//	/**
//	 * 12. 申辦人更換手機門號(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public SetChangeCellRsp setChangeCell(SetChangeCellReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetChangeCell, requestJson);
//		
//		SetChangeCellRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetChangeCellRsp.class);
//		}
//		return response;
//	}
//
//	/**
//	 * 13. 取得攝影機連線記錄(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public GetP2PLoginRecordRsp getP2PLoginRecord(GetP2PLoginRecordReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetP2PLoginRecord, requestJson);
//		
//		GetP2PLoginRecordRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetP2PLoginRecordRsp.class);
//		}
//		return response;
//	}
//
//	/**
//	 * 14. 取得攝影機即時連線狀態(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public GetP2PLoginStatusRsp getP2PLoginStatus(GetP2PLoginStatusReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetP2PLoginStatus, requestJson);
//		
//		GetP2PLoginStatusRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetP2PLoginStatusRsp.class);
//		}
//		return response;
//	}
//
//	/**
//	 * 15. 取得攝影機日誌事件記錄(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public GetEventRecordRsp getEventRecord(GetEventRecordReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetEventRecord, requestJson);
//		
//		GetEventRecordRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetEventRecordRsp.class);
//		}
//		return response;
//	}
//
//	/**
//	 * 16. 取得攝影機錄影設置記錄(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public GetRecEventRecordRsp getRecEventRecord(GetRecEventRecordReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetRecEventRecord, requestJson);
//		
//		GetRecEventRecordRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetRecEventRecordRsp.class);
//		}
//		return response;
//	}
//
//	/**
//	 * 17. 取得攝影機即時錄影狀態(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public GetRecEventStatusRsp getRecEventStatus(GetRecEventStatusReq request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetRecEventStatus, requestJson);
//		
//		GetRecEventStatusRsp response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetRecEventStatusRsp.class);
//		}
//		return response;
//	}
	
}
