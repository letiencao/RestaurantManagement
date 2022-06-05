package com.letiencao.dto.request.authentication;

import org.hibernate.validator.constraints.NotEmpty;


public class RefreshTokenRequest {
	@NotEmpty(message = "Refresh Token must not be empty")
	private String refreshToken;
}
