package util;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import util.Constants;
import bean.AddAlertNoticeRequest;
import bean.AddAlertNoticeResponse;
import bean.AlertNotice;
import bean.DelAlertNoticeRequest;
import bean.DelAlertNoticeResponse;
import bean.GetAlarmEventRequest;
import bean.GetAlarmEventResponse;
import bean.GetAlertNoticeRequest;
import bean.GetAlertNoticeResponse;
import bean.GetDeviceStatusRequest;
import bean.GetDeviceStatusResponse;
import bean.GetDidRequest;
import bean.GetDidResponse;
import bean.GetEventRecordRequest;
import bean.GetEventRecordResponse;
import bean.GetP2PLoginRecordRequest;
import bean.GetP2PLoginRecordResponse;
import bean.GetP2PLoginStatusRequest;
import bean.GetP2PLoginStatusResponse;
import bean.GetRecEventRecordRequest;
import bean.GetRecEventRecordResponse;
import bean.GetRecEventStatusRequest;
import bean.GetRecEventStatusResponse;
import bean.GetUserRequest;
import bean.GetUserResponse;
import bean.Result;
import bean.SetAddRegRequest;
import bean.SetAddRegResponse;
import bean.SetChangeCellRequest;
import bean.SetChangeCellResponse;
import bean.SetChangeRegRequest;
import bean.SetChangeRegResponse;
import bean.SetDelRegRequest;
import bean.SetDelRegResponse;
import bean.SetDidStateRequest;
import bean.SetDidStateResponse;

import com.google.gson.Gson;

/** 透過httpPost方式取得資訊
 * @author T
 *
 */
public class HttpPostUtil {
	
	final Logger log = Logger.getLogger(HttpPostUtil.class);
	final Gson gson = new Gson();
	final ResourceBundle bundle = ResourceBundle.getBundle("system");
	final String URL = bundle.getString("WS.API.URL");//按照環境不同properties設定不同
	
	/**
	 * 1.取得攝影機報警記錄(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public  GetAlarmEventResponse getAlarmEvent(GetAlarmEventRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		//post to 維熹 
		try {
			responseJson = post(URL, Constants.GetAlarmEvent, requestJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GetAlarmEventResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetAlarmEventResponse.class);
		}
		return response;
	}
	

	/**
	 * 2.取得攝影機週邊設備及附屬子機狀況(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public GetDeviceStatusResponse getDeviceStatus(GetDeviceStatusRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetDeviceStatus, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
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
	 */
	public GetAlertNoticeResponse getAlertNotice(GetAlertNoticeRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetAlertNotice, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
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
	 */
	public AddAlertNoticeResponse addAlertNotice(AddAlertNoticeRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.AddAlertNotice, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
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
	 */
	public DelAlertNoticeResponse delAlertNotice(DelAlertNoticeRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.DelAlertNotice, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
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
	 */
	public GetDidResponse getDid(GetDidRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetDid, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
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
	 */
	public GetUserResponse getUser(GetUserRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetUser, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		GetUserResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetUserResponse.class);
		}
		return response;
	}

	/**
	 * 8. 設定攝影機：暫斷／重新啟用(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public SetDidStateResponse setDidState(SetDidStateRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.SetDidState, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		SetDidStateResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, SetDidStateResponse.class);
		}
		return response;
	}
	
	/**
	 * 9. 設定攝影機：開通啟用(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public SetAddRegResponse setAddReg(SetAddRegRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.SetAddReg, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		SetAddRegResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, SetAddRegResponse.class);
		}
		return response;
	}
	
	/**
	 * 10. 設定攝影機：退租停機(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public SetDelRegResponse setDelReg(SetDelRegRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.SetDelReg, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		SetDelRegResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, SetDelRegResponse.class);
		}
		return response;
	}
	
	/**
	 * 11. 申辦人更換攝影機(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public SetChangeRegResponse setChangeReg(SetChangeRegRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.SetChangeReg, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		SetChangeRegResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, SetChangeRegResponse.class);
		}
		return response;
	}
	
	/**
	 * 12. 申辦人更換手機門號(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public SetChangeCellResponse setChangeCell(SetChangeCellRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.SetChangeCell, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		SetChangeCellResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, SetChangeCellResponse.class);
		}
		return response;
	}

	/**
	 * 13. 取得攝影機連線記錄(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public GetP2PLoginRecordResponse getP2PLoginRecord(GetP2PLoginRecordRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetP2PLoginRecord, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		GetP2PLoginRecordResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetP2PLoginRecordResponse.class);
		}
		return response;
	}

	/**
	 * 14. 取得攝影機即時連線狀態(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public GetP2PLoginStatusResponse getP2PLoginStatus(GetP2PLoginStatusRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetP2PLoginStatus, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		GetP2PLoginStatusResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetP2PLoginStatusResponse.class);
		}
		return response;
	}

	/**
	 * 15. 取得攝影機日誌事件記錄(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public GetEventRecordResponse getEventRecord(GetEventRecordRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetEventRecord, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		GetEventRecordResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetEventRecordResponse.class);
		}
		return response;
	}

	/**
	 * 16. 取得攝影機錄影設置記錄(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public GetRecEventRecordResponse getRecEventRecord(GetRecEventRecordRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetRecEventRecord, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		GetRecEventRecordResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetRecEventRecordResponse.class);
		}
		return response;
	}

	/**
	 * 17. 取得攝影機即時錄影狀態(維熹)
	 * 
	 * @param request
	 * @return
	 */
	public GetRecEventStatusResponse getRecEventStatus(GetRecEventStatusRequest request) {

		//parse Obj to Json
		final String requestJson = gson.toJson(request);
		String responseJson = null ;
		
		try {
			//post to 維熹 
			responseJson = post(URL, Constants.GetRecEventStatus, requestJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		GetRecEventStatusResponse response = null;
		if(null != responseJson){
			//parse Json to Obj, then return 
			response = gson.fromJson(responseJson, GetRecEventStatusResponse.class);
		}
		return response;
	}

//	public void main(String[] argv){

//		GetAlarmEventRequest request = new GetAlarmEventRequest();
//		request.setDID("PRX0000123XXXX");
//		request.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//		request.setStartTime("20060102150405");
//		request.setEndTime("20060102150405");
//		request.setPageNum(1);
//		request.setPageSize(20);
//		GetAlarmEventResponse response = getAlarmEvent(request);
//		log.info("function_1 STATUS = "+response.getResult().getStatus());

//		GetDeviceStatusRequest request2 = new GetDeviceStatusRequest();
//		request2.setDID("PRX0000123XXXX");
//		request2.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//		GetDeviceStatusResponse response2 = getDeviceStatus(request2);
//		log.info("function_2 STATUS = "+response2.getResult().getStatus());
		
//		GetAlertNoticeRequest request3 = new GetAlertNoticeRequest();
//		request3.setDID("PRX0000123XXXX");
//		request3.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//		GetAlertNoticeResponse response3 = getAlertNotice(request3);
//		log.info("function_3 STATUS = "+response3.getResult().getStatus());

//		AddAlertNoticeRequest request4 = new AddAlertNoticeRequest();
//		request4.setDID("PRX0000123XXXX");
//		request4.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//		AlertNotice vo4 = new AlertNotice();
//		vo4.setValue("p1232423@fareastone.com.tw");
//		vo4.setType("email");
//		request4.setAlertNotice(vo4);
//		AddAlertNoticeResponse response4 = addAlertNotice(request4);
//		log.info("function_4 STATUS = "+response4.getResult().getStatus());
		

//		DelAlertNoticeRequest request5 = new DelAlertNoticeRequest();
//		request5.setDID("PRX0000123XXXX");
//		request5.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//		AlertNotice vo5 = new AlertNotice();
//		vo5.setValue("p1232423@fareastone.com.tw");
//		vo5.setType("email");
//		request5.setAlertNotice(vo5);
//		Result response5 = delAlertNotice(request5);
//		log.info("function_5 STATUS = "+response5.getStatus());
		

//		GetDidRequest request6 = new GetDidRequest();
//		request6.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//		GetDidResponse response6 = getDid(request6);
//		log.info("function_6 STATUS = "+response6.getResult().getStatus());

//		GetUserRequest request7 = new GetUserRequest();
//		request7.setDID("PRX0000123XXXX");
//		GetUserResponse response7 = getUser(request7);
//		log.info("function_7 STATUS = "+response7.getResult().getStatus());
		
//	}
	
	/** 透過httpPost方式介接API(json)
	 * @param url
	 * @param methodName
	 * @param requestJson
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws Exception
	 */
	private String post(String url , String methodName , String requestJson) throws Exception{
		
		log.info(url + methodName+"|||"+" request === "+requestJson);
		
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Post 
		StringEntity params =new StringEntity(requestJson);
		
		HttpPost httpPost = new HttpPost(url + methodName);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(params);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		String responseString = null;
		 // 如果回傳是 200 OK 的話才回傳jsonStr
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			responseString = EntityUtils.toString(httpResponse.getEntity());
			log.info("send ok!! response === "+responseString);
		} else {
			// TODO 連線失敗回傳null
			log.info("send fail!! === "+httpResponse.getStatusLine());
		}
		
		// 關閉httpClient
		httpClient.getConnectionManager().shutdown();

		return responseString;
		
	}
	
}
