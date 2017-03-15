package com.fet.api.service;

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
import com.fet.ws.bean.AddAlertNoticeRequest;
import com.fet.ws.bean.AddAlertNoticeResponse;
import com.fet.ws.bean.DelAlertNoticeRequest;
import com.fet.ws.bean.DelAlertNoticeResponse;
import com.fet.ws.bean.GetAlarmEventRequest;
import com.fet.ws.bean.GetAlarmEventResponse;
import com.fet.ws.bean.GetAlertNoticeRequest;
import com.fet.ws.bean.GetAlertNoticeResponse;
import com.fet.ws.bean.GetDeviceStatusRequest;
import com.fet.ws.bean.GetDeviceStatusResponse;
import com.fet.ws.bean.GetDidRequest;
import com.fet.ws.bean.GetDidResponse;
import com.fet.ws.bean.GetUserRequest;
import com.fet.ws.bean.GetUserResponse;

public interface DeviceWsService {

	public String getAlarmEvent(GetAlarmEventReq request,
			GetAlarmEventRequest wsRequest, GetAlarmEventRsp response,
			GetAlarmEventResponse wsResponse);

	public String getDeviceStatus(GetDeviceStatusReq request,
			GetDeviceStatusRequest wsRequest, GetDeviceStatusRsp response,
			GetDeviceStatusResponse wsResponse);

	public String getAlertNotice(GetAlertNoticeReq request,
			GetAlertNoticeRequest wsRequest, GetAlertNoticeRsp response,
			GetAlertNoticeResponse wsResponse);

	public String addAlertNotice(AddAlertNoticeReq request,
			AddAlertNoticeRequest wsRequest, AddAlertNoticeRsp response,
			AddAlertNoticeResponse wsResponse);

	public String delAlertNotice(DelAlertNoticeReq request,
			DelAlertNoticeRequest wsRequest, DelAlertNoticeRsp response,
			DelAlertNoticeResponse wsResponse);

	public String getDID(GetDidReq request, GetDidRequest wsRequest,
			GetDidRsp response, GetDidResponse wsResponse);

	public String getUser(GetUserReq request, GetUserRequest wsRequest,
			GetUserRsp response, GetUserResponse wsResponse);
}
