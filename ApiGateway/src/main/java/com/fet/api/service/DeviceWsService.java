package com.fet.api.service;

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


public interface DeviceWsService {

	/**1.取得攝影機報警記錄
	 * @param request
	 * @param wsRequest
	 * @param response
	 * @param wsResponse
	 * @return
	 */
	public String GetAlertEvent(GetAlertEventReq request,
			GetAlertEventRequest wsRequest, GetAlertEventRsp response,
			GetAlertEventResponse wsResponse);

	/**2.取得攝影機週邊設備及附屬子機狀況(維熹)
	 * @param request
	 * @param wsRequest
	 * @param response
	 * @param wsResponse
	 * @return
	 */
	public String getDeviceStatus(GetDeviceStatusReq request,
			GetDeviceStatusRequest wsRequest, GetDeviceStatusRsp response,
			GetDeviceStatusResponse wsResponse);

	/**3.取得攝影機所有報警門號及email(維熹)
	 * @param request
	 * @param wsRequest
	 * @param response
	 * @param wsResponse
	 * @return
	 */
	public String getAlertNotice(GetAlertNoticeReq request,
			GetAlertNoticeRequest wsRequest, GetAlertNoticeRsp response,
			GetAlertNoticeResponse wsResponse);

	/**4.新增報警門號/email(維熹)
	 * @param request
	 * @param wsRequest
	 * @param response
	 * @param wsResponse
	 * @return
	 */
	public String addAlertNotice(AddAlertNoticeReq request,
			AddAlertNoticeRequest wsRequest, AddAlertNoticeRsp response,
			AddAlertNoticeResponse wsResponse);

	/**5.刪除報警門號/email(維熹)
	 * @param request
	 * @param wsRequest
	 * @param response
	 * @param wsResponse
	 * @return
	 */
	public String delAlertNotice(DelAlertNoticeReq request,
			DelAlertNoticeRequest wsRequest, DelAlertNoticeRsp response,
			DelAlertNoticeResponse wsResponse);

	/**6.取得申辦人的主機及附屬子機資料(維熹)
	 * @param request
	 * @param wsRequest
	 * @param response
	 * @param wsResponse
	 * @return
	 */
	public String getDID(GetDidReq request, GetDidRequest wsRequest,
			GetDidRsp response, GetDidResponse wsResponse);

	/**7.取得DID的申辦人資料(維熹)
	 * @param request
	 * @param wsRequest
	 * @param response
	 * @param wsResponse
	 * @return
	 */
	public String getUser(GetUserReq request, GetUserRequest wsRequest,
			GetUserRsp response, GetUserResponse wsResponse);
}
