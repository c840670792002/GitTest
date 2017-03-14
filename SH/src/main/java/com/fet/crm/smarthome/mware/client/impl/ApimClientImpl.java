package com.fet.crm.smarthome.mware.client.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.xml.security.utils.Base64;
import org.springframework.beans.factory.annotation.Value;

import com.fet.crm.smarthome.generic.bean.AccessTokenVO;
import com.fet.crm.smarthome.mware.client.ApimClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * APIM Client implement
 * 
 * @author LiuLeo
 * @version 1.0.0.0
 */
public class ApimClientImpl implements ApimClient {
	@Value("${apim.url}") 
	private final String apimUrl = null;
	@Value("${apim.apigw.client.id}") 
	private final String apiGwClientId = null;
	@Value("${apim.apigw.client.secret}") 
	private final String apiGwClientSecret = null;
	@Value("${apim.apigw.scope}")
	private final String apiGwScope = null;
	
	/** AccessToken */
	private AccessTokenVO accessToken = null;

	
	/**
	 * Check AccessToken Life Cycle
	 */
	public AccessTokenVO checkAccessToken() {
		if (accessToken == null) {
			accessToken = this.getAccessToken();
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			if (calendar.getTimeInMillis() >= accessToken.getExpireDateTime()) {
				accessToken = this.getAccessToken();
			}
		}
		return accessToken;
	}

	/**
	 * Get AccessToken
	 * 
	 * @return
	 * 		AccessToken
	 */
	private AccessTokenVO getAccessToken() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(apimUrl);
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("grant_type", "client_credentials"));
			nvps.add(new BasicNameValuePair("scope", apiGwScope)); // Set Scope
	
			// Basic Authentication
			final byte[] authCode = (apiGwClientId + apiGwClientSecret).getBytes("UTF-8");
			final String encodeAuthCode = new String("Basic " + Base64.encode(authCode));
			System.out.println(encodeAuthCode);
			
			// Set Header, Entity
			httpPost.setHeader("Authorization", 
					"Basic NTdjZjBjY2MtNzIzNC00ZTkyLThlZjEtN2FjYjE4ODFhYmMxOmxJM3ZZMnJONHFDN2xNNGRDMm1XMGFQNm9RNndTNmVNMnNUN3dKN3hOMWxOMWpWMXZL");
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			
			// HttpPost response
			HttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				BufferedReader br = new BufferedReader(
	                    new InputStreamReader((response.getEntity().getContent())));
				Gson gson = new GsonBuilder().create();
				accessToken = gson.fromJson(IOUtils.toString(br), AccessTokenVO.class);
				
				// Set Token expire date time
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(new Date().getTime() + accessToken.getExpires_in()*1000);
				accessToken.setExpireDateTime(calendar.getTimeInMillis());
			} else {
				accessToken = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}
}
