package com.fet.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fet.api.service.DeviceWsService;
import com.fet.rest.bean.AddAlertNoticeReq;
import com.fet.rest.bean.AddAlertNoticeRsp;
import com.fet.rest.bean.DelAlertNoticeReq;
import com.fet.rest.bean.DelAlertNoticeRsp;
import com.fet.rest.bean.GetAlertEventReq;
import com.fet.rest.bean.GetAlertEventRsp;
import com.fet.rest.bean.GetAlertNoticeReq;
import com.fet.rest.bean.GetAlertNoticeRsp;
import com.fet.rest.bean.GetDeviceStatusReq;
import com.fet.rest.bean.GetDeviceStatusRsp;
import com.fet.rest.bean.GetDidReq;
import com.fet.rest.bean.GetDidRsp;
import com.fet.rest.bean.GetUserReq;
import com.fet.rest.bean.GetUserRsp;
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

/**
 * SmartHome WS (RESTful Web Service)
 * 
 * @author LeoLiu
 */
@Path("/sh")
@Component
public class SmartHomeWS {
	

	final Logger log = Logger.getLogger(SmartHomeWS.class);
	
	final Gson gson = new Gson();

	@Autowired
	private DeviceWsService deviceWsService;
	

	/**1.取得攝影機報警記錄
	 * @param jsonStr
	 * @return
	 */
	@POST
	@Path("/GetAlertEvent")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetAlertEvent(String jsonStr) {
		//localhost:8080/ApiGateway/sh/GetAlertEvent/

		
		//parse json to obj(含channelId,partnerId等資訊)
		final GetAlertEventReq request = gson.fromJson(jsonStr, GetAlertEventReq.class);
		//傳送給維熹使用的request,需避免呈現channelId,partnerId
		final GetAlertEventRequest wsRequest = new GetAlertEventRequest();
		
		BeanUtils.copyProperties(request, wsRequest);

		GetAlertEventResponse wsResponse = null;
		GetAlertEventRsp response = new GetAlertEventRsp();
		
		String rtnStr = deviceWsService.GetAlertEvent(request,wsRequest,response,wsResponse);
		
		
		return rtnStr;
	}

	/**2.取得攝影機週邊設備及附屬子機狀況
	 * @param jsonStr
	 * @return
	 */
	@POST
	@Path("/getDeviceStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDeviceStatus(String jsonStr) {
		//localhost:8080/ApiGateway/sh/getDeviceStatus/

		//parse json to obj(含channelId,partnerId等資訊)
		final GetDeviceStatusReq request = gson.fromJson(jsonStr, GetDeviceStatusReq.class);
		//傳送給維熹使用的request,需避免呈現channelId,partnerId
		final GetDeviceStatusRequest wsRequest = new GetDeviceStatusRequest();
		
		BeanUtils.copyProperties(request, wsRequest);

		GetDeviceStatusResponse wsResponse = null;
		GetDeviceStatusRsp response = new GetDeviceStatusRsp();
		
		String rtnStr = deviceWsService.getDeviceStatus(request,wsRequest,response,wsResponse);
		
		return rtnStr;
	}

	/**3.取得攝影機所有報警門號及email
	 * @param jsonStr
	 * @return
	 */
	@POST
	@Path("/getAlertNotice")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAlertNotice(String jsonStr) {
		//localhost:8080/ApiGateway/sh/getAlertNotice/
		
		//parse json to obj(含channelId,partnerId等資訊)
		final GetAlertNoticeReq request = gson.fromJson(jsonStr, GetAlertNoticeReq.class);
		//傳送給維熹使用的request,需避免呈現channelId,partnerId
		final GetAlertNoticeRequest wsRequest = new GetAlertNoticeRequest();
		
		BeanUtils.copyProperties(request, wsRequest);

		GetAlertNoticeResponse wsResponse = null;
		GetAlertNoticeRsp response = new GetAlertNoticeRsp();
		
		String rtnStr = deviceWsService.getAlertNotice(request,wsRequest,response,wsResponse);
		
		return rtnStr;
	}

	/**4.新增報警門號/email
	 * @param jsonStr
	 * @return
	 */
	@POST
	@Path("/addAlertNotice")
	@Produces(MediaType.APPLICATION_JSON)
	public String addAlertNotice(String jsonStr) {
		//localhost:8080/ApiGateway/sh/addAlertNotice/

		
		
		//parse json to obj(含channelId,partnerId等資訊)
		final AddAlertNoticeReq request = gson.fromJson(jsonStr, AddAlertNoticeReq.class);
		//傳送給維熹使用的request,需避免呈現channelId,partnerId
		final AddAlertNoticeRequest wsRequest = new AddAlertNoticeRequest();
		
		BeanUtils.copyProperties(request, wsRequest);

		AddAlertNoticeResponse wsResponse = null;
		AddAlertNoticeRsp response = new AddAlertNoticeRsp();
		
		String rtnStr = deviceWsService.addAlertNotice(request,wsRequest,response,wsResponse);

		return rtnStr;
	}

	/**5.刪除報警門號/email
	 * @param jsonStr
	 * @return
	 */
	@POST
	@Path("/delAlertNotice")
	@Produces(MediaType.APPLICATION_JSON)
	public String delAlertNotice(String jsonStr) {
		//localhost:8080/ApiGateway/sh/delAlertNotice/

		
		
		//parse json to obj(含channelId,partnerId等資訊)
		final DelAlertNoticeReq request = gson.fromJson(jsonStr, DelAlertNoticeReq.class);
		//傳送給維熹使用的request,需避免呈現channelId,partnerId
		final DelAlertNoticeRequest wsRequest = new DelAlertNoticeRequest();
		
		BeanUtils.copyProperties(request, wsRequest);

		DelAlertNoticeResponse wsResponse = null;
		DelAlertNoticeRsp response = new DelAlertNoticeRsp();
		
		String rtnStr = deviceWsService.delAlertNotice(request,wsRequest,response,wsResponse);

		return rtnStr;
	}

	/**6.取得申辦人的主機及附屬子機資料
	 * @param jsonStr
	 * @return
	 */
	@POST
	@Path("/getDID")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDID(String jsonStr) {
		//localhost:8080/ApiGateway/sh/getDid/
		
		//parse json to obj(含channelId,partnerId等資訊)
		final GetDidReq request = gson.fromJson(jsonStr, GetDidReq.class);
		final String channelId = request.getChannelId();
		final String partnerId = request.getPartnerId();
		final String msisdn = request.getMsisdn();
		//傳送給維熹使用的request,需避免呈現channelId,partnerId
		final GetDidRequest wsRequest = new GetDidRequest();
		
		BeanUtils.copyProperties(request, wsRequest);

		GetDidResponse wsResponse = null;
		GetDidRsp response = new GetDidRsp();
		
		String rtnStr = deviceWsService.getDID(request,wsRequest,response,wsResponse);

		return rtnStr;
	}


	/**7.取得DID的申辦人資料
	 * @param jsonStr
	 * @return
	 */
	@POST
	@Path("/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUser(String jsonStr) {
		//localhost:8080/ApiGateway/sh/getUser/
		
		//parse json to obj(含channelId,partnerId等資訊)
		final GetUserReq request = gson.fromJson(jsonStr, GetUserReq.class);
		//傳送給維熹使用的request,需避免呈現channelId,partnerId
		final GetUserRequest wsRequest = new GetUserRequest();
		
		BeanUtils.copyProperties(request, wsRequest);

		GetUserResponse wsResponse = null;
		GetUserRsp response = new GetUserRsp();
		
		String rtnStr = deviceWsService.getUser(request,wsRequest,response,wsResponse);
		
		return rtnStr;
	}

//	/**
//	 * doGet
//	 * @param ref
//	 * @return
//	 */
//	@GET 
//	@Path("/getIbm/{ref}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public InquireCatalog doGet(@PathParam("ref") String ref) {
//		return inquireCatalogService.dataBean(ref);
//	}
//
//	/**
//	 * doPost
//	 * @param headerAuth
//	 * @param jsonData
//	 * @return
//	 */
//	@POST
//	@Path("/postIbm")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response doPostString(@HeaderParam("authorization") String headerAuth, String jsonData) {
//		try {
//			log.info("----- Server doPost ----------------------------------------------");
//			log.info("headerAuth:" + headerAuth);
//			log.info("jsonData:" + jsonData);
//			
//			// JDK 1.8
//			// Base64 to decode data
//			// String decodeData = new String(Base64.getDecoder().decode(headerAuth), "UTF-8");
//			// log.info("\ndecode:" + decodeData);
//			String decodeData = null;
//			
//			// Read JSON data
//			JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
//			JsonObject jsonObj = jsonReader.readObject();
//			jsonReader.close();
//			log.info("\n\njson:" + jsonData);
//			
//			JsonObject jsonMain = jsonObj.getJsonObject("DFH0XVDSOperation");
//			log.info("\n 1.DFH0XVDSOperation:" + jsonMain);
//			
//			JsonObject jsonInqcin = jsonMain.getJsonObject("inqcin");
//			log.info("\n 2.inqcin:" + jsonInqcin);
//			log.info("\n 2.inqcin.request_id:" + jsonInqcin.get("ca_request_id"));
//			log.info("\n 2.inqcin.inquireRequest:" + jsonInqcin.get("ca_inquire_request"));
//			
//			JsonObject jsonInquireRequest = jsonInqcin.getJsonObject("ca_inquire_request");
//			log.info("\n 3.ca_inquire_request:" + jsonInquireRequest);
//		} catch (Exception ex) {
//			ex.getStackTrace();
//		}
//		return Response.status(200).entity(jsonData).build();
//	}
//	
//	
//	/**
//	 * doInquireCatalog
//	 * @param headerAuth
//	 * @param jsonData
//	 * @return
//	 */
//	@POST
//	@Path("/inquireCatalog")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response doInquireCatalog(@HeaderParam("authorization") String headerAuth, String jsonData) {
//		String result = null;
//		
//		try {
//			log.info("----- Server doPost ----------------------------------------------");
//			log.info("headerAuth:" + headerAuth);
//			log.info("jsonData:" + jsonData);
//			/** "DFH0XVDSOperation":{
//			 * 		"ca_request_id": "01INQC",
//			 * 		"ca_inquire_request": "0100"
//			 * 	} 
//			 */
//			
//			// Base64 to decode data
//			// String decodeData = new String(Base64.getDecoder().decode(headerAuth), "UTF-8");
//			// log.info("\ndecode:" + decodeData);
//			
//			JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
//			JsonObject jsonObj = jsonReader.readObject();
//			jsonReader.close();
//			
//			JsonObject jsonOper = jsonObj.getJsonObject("DFH0XVDSOperation");
//			String requestId = jsonOper.getString("ca_request_id");
//			String inquireRequest = jsonOper.getString("ca_inquire_request");
//			log.info("server requestId:" + requestId);
//			log.info("server inquireRequest:" + inquireRequest);
//			
//			if (!StringUtils.equals("0000", inquireRequest)) {
//				result = inquireCatalogService.dataJson();
//			}
//			log.info("result:" + result);
//		} catch (Exception ex) {
//			ex.getStackTrace();
//		}
//		return Response.status(200).entity(result).build();
//	}
}
