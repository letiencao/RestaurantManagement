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

}
