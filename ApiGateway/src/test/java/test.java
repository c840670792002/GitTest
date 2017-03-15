import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;

import com.fet.rest.bean.GetAlarmEventReq;
import com.google.gson.Gson;


public class test {

	public static void main(String[] args) {

		try {
		
			Gson gson = new Gson();
			
			
			GetAlarmEventReq r1 = new GetAlarmEventReq();
			r1.setChannelId("01");
			r1.setPartnerId("DSES000001");
			r1.setDID("PRX0000123XXXX");
			r1.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
			r1.setStartTime("20060102150405");
			r1.setEndTime("20060102150405");
			r1.setPageNum(1);
			r1.setPageSize(20);
			
			doPost("getAlarmEvent",gson.toJson(r1));
			
//			GetDeviceStatusReq r2 = new GetDeviceStatusReq();
//			r2.setDID("PRX0000123XXXX");
//			r2.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//			doPost("getDeviceStatus",gson.toJson(r2));

//			GetAlertNoticeReq r3 = new GetAlertNoticeReq();
//			r3.setDID("PRX0000123XXXX");
//			r3.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//			doPost("getAlertNotice",gson.toJson(r3));
//
			//500error
//			AddAlertNoticeReq r4 = new AddAlertNoticeReq();
//			r4.setDID("PRX0000123XXXX");
//			r4.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//			AlertNotice vo4 = new AlertNotice();
//			vo4.setValue("p1232423@fareastone.com.tw");
//			vo4.setType("email");
//			r4.setAlertNotice(vo4);
//			doPost("addAlertNotice",gson.toJson(r4));
//
			//缺少result 階層
//			DelAlertNoticeReq r5 = new DelAlertNoticeReq();
//			r5.setDID("PRX0000123XXXX");
//			r5.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//			AlertNotice vo5 = new AlertNotice();
//			vo5.setValue("p1232423@fareastone.com.tw");
//			vo5.setType("email");
//			r5.setAlertNotice(vo5);
//			doPost("delAlertNotice",gson.toJson(r5));
//
//			GetDidReq r6 = new GetDidReq();;
//			r6.setChannelId("01");
//			r6.setPartnerId("DSES000001");
//			r6.setUserId("7f4377fc-fb12-11e6-bc64-92361f002671");
//			doPost("getDid",gson.toJson(r6));
//
//			GetUserReq r7 = new GetUserReq();
//			r7.setDID("PRX0000123XXXX");
//			doPost("getUser",gson.toJson(r7));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void doPost(String method,String json) throws Exception {

		HttpClient httpClient = HttpClientBuilder.create().build();

		// Post 
		StringEntity params;
		params = new StringEntity(json);

		HttpPost httpPost = new HttpPost(
				"http://localhost:8080/ApiGateway/sh/"+method+"/");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(params);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		String responseString = null;
		// 如果回傳是 200 OK 的話才回傳jsonStr
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			responseString = EntityUtils.toString(httpResponse.getEntity());
			System.out.println("send ok!! response === " + responseString);
		} else {
			// TODO 連線失敗回傳null
			System.out.println("send fail!! === "
					+ httpResponse.getStatusLine());
		}

		// 關閉httpClient
		httpClient.getConnectionManager().shutdown();

		System.out.println(responseString);

	}

}
