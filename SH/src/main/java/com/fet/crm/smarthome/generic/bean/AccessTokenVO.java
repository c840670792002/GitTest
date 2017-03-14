package com.fet.crm.smarthome.generic.bean;

import java.io.Serializable;

/**
 * AccessToken VO
 * 
 * @author LeoLiu
 * @version 1.0.0.0
 */
public class AccessTokenVO implements Serializable {
	private static final long serialVersionUID = 1L;
			
	private String token_type;
	private String access_token;
	private int expires_in;
	private String scope;
	private Long expireDateTime;
	
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public Long getExpireDateTime() {
		return expireDateTime;
	}
	public void setExpireDateTime(Long expireDateTime) {
		this.expireDateTime = expireDateTime;
	}
}