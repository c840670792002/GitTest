package com.fet.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpPostUtil {

	final Logger log = Logger.getLogger(HttpPostUtil.class);
	
	/** 透過httpPost方式介接API(json)
	 * @param url
	 * @param methodName
	 * @param requestJson
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws Exception
	 */
	public String post(String url , String methodName , String requestJson) throws Exception{
		
		log.info(url + methodName+"|||"+" request === "+requestJson);
		
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Post 
		StringEntity params =new StringEntity(requestJson,"UTF-8");
		
		HttpPost httpPost = new HttpPost(url + methodName);
		httpPost.setHeader("Content-type", "application/json; charset=utf-8");
		httpPost.setEntity(params);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		String responseString = null;
		 // 如果回傳是 200 OK 的話才回傳jsonStr
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
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
