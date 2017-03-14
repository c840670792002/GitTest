package com.fet.crm.smarthome.mware.client;

import com.fet.crm.smarthome.generic.bean.AccessTokenVO;

/**
 * APIM Client
 * 
 * @author LiuLeo
 * @version 1.0.0.0
 */
public interface ApimClient {
	
	AccessTokenVO checkAccessToken();
}
