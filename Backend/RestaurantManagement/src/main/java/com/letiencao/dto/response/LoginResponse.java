package com.letiencao.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

	public LoginResponse(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	private String accessToken;
	private String refreshToken;
	private String type = "Bearer";
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
