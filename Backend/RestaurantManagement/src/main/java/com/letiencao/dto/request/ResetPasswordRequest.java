package com.letiencao.dto.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {
	@NotEmpty(message = "Refresh Token must not be empty")
	private String refreshToken;
	@NotEmpty(message = "The new password must not be empty")
	@Size(min = 6,max = 10,message = "The new password is greater than 5 and smaller than 11 characters")
	private String newPassword;

}
