package com.fet.ws;
import org.apache.log4j.Logger;

import com.fet.util.Constants;
import com.fet.util.HttpPostUtil;
import com.fet.ws.bean.AddAlertNoticeRequest;
import com.fet.ws.bean.AddAlertNoticeResponse;
import com.fet.ws.bean.DelAlertNoticeRequest;
import com.fet.ws.bean.DelAlertNoticeResponse;
import com.fet.ws.bean.GetAlertEventRequest;
import com.fet.ws.bean.GetAlertEventResponse;
import com.fet.ws.bean.GetAlertNoticeRequest;
import com.fet.ws.bean.GetAlertNoticeResponse;
import com.fet.ws.bean.GetDeviceStatusRequest;
import com.fet.ws.bean.GetDeviceStatusResponse;
import com.fet.ws.bean.GetDidRequest;
import com.fet.ws.bean.GetDidResponse;
import com.fet.ws.bean.GetUserRequest;
import com.fet.ws.bean.GetUserResponse;
import com.google.gson.Gson;

/** 透過httpPost方式取得維熹資訊
 * @author T
 *
 */
public class DeviceWsClient {
	
	final Logger log = Logger.getLogger(DeviceWsClient.class);
	final Gson gson = new Gson();
	final HttpPostUtil postUtil = new HttpPostUtil();
	
	/**
	 * 1.取得攝影機報警記錄(維熹)
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public  GetAlertEventResponse getAlertEvent(GetAlertEventRequest request, String URL ) throws Exception {

		
		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetAlarmEvent, requestJson);
		
		GetAlertEventResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetAlertEventResponse.class);
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
	public GetDeviceStatusResponse getDeviceStatus(GetDeviceStatusRequest request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetDeviceStatus, requestJson);
		
		GetDeviceStatusResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetDeviceStatusResponse.class);
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
	public GetAlertNoticeResponse getAlertNotice(GetAlertNoticeRequest request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetAlertNotice, requestJson);
		
		GetAlertNoticeResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetAlertNoticeResponse.class);
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
	public AddAlertNoticeResponse addAlertNotice(AddAlertNoticeRequest request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.AddAlertNotice, requestJson);
		
		AddAlertNoticeResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, AddAlertNoticeResponse.class);
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
	public DelAlertNoticeResponse delAlertNotice(DelAlertNoticeRequest request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.DelAlertNotice, requestJson);
		
		DelAlertNoticeResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, DelAlertNoticeResponse.class);
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
	public GetDidResponse getDid(GetDidRequest request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetDID, requestJson);
		
		GetDidResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetDidResponse.class);
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
	public GetUserResponse getUser(GetUserRequest request,String URL ) throws Exception {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		responseJson = postUtil.post(URL, Constants.GetUser, requestJson);
		
		GetUserResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetUserResponse.class);
		}
		return response;
	}
//
//	/**
//	 * 8. 設定攝影機：暫斷／重新啟用(維熹)
//	 * 
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	public SetDidStateResponse setDidState(SetDidStateRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetDidState, requestJson);
//		
//		SetDidStateResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetDidStateResponse.class);
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
//	public SetAddRegResponse setAddReg(SetAddRegRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetAddReg, requestJson);
//		
//		SetAddRegResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetAddRegResponse.class);
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
//	public SetDelRegResponse setDelReg(SetDelRegRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetDelReg, requestJson);
//		
//		SetDelRegResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetDelRegResponse.class);
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
//	public SetChangeRegResponse setChangeReg(SetChangeRegRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetChangeReg, requestJson);
//		
//		SetChangeRegResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetChangeRegResponse.class);
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
//	public SetChangeCellResponse setChangeCell(SetChangeCellRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.SetChangeCell, requestJson);
//		
//		SetChangeCellResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, SetChangeCellResponse.class);
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
//	public GetP2PLoginRecordResponse getP2PLoginRecord(GetP2PLoginRecordRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetP2PLoginRecord, requestJson);
//		
//		GetP2PLoginRecordResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetP2PLoginRecordResponse.class);
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
//	public GetP2PLoginStatusResponse getP2PLoginStatus(GetP2PLoginStatusRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetP2PLoginStatus, requestJson);
//		
//		GetP2PLoginStatusResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetP2PLoginStatusResponse.class);
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
//	public GetEventRecordResponse getEventRecord(GetEventRecordRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetEventRecord, requestJson);
//		
//		GetEventRecordResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetEventRecordResponse.class);
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
//	public GetRecEventRecordResponse getRecEventRecord(GetRecEventRecordRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetRecEventRecord, requestJson);
//		
//		GetRecEventRecordResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetRecEventRecordResponse.class);
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
//	public GetRecEventStatusResponse getRecEventStatus(GetRecEventStatusRequest request,String URL ) throws Exception {
//
//		//parse Obj to Json
//		final String requestJson = gson.toJson(request);
//		String responseJson = null ;
//		
//		//post to 維熹 
//		responseJson = postUtil.post(URL, Constants.GetRecEventStatus, requestJson);
//		
//		GetRecEventStatusResponse response = null;
//		if(null != responseJson){
//			//parse Json to Obj, then return 
//			response = gson.fromJson(responseJson, GetRecEventStatusResponse.class);
//		}
//		return response;
//	}
	
}
