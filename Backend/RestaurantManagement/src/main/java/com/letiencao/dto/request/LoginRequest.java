package com.letiencao.dto.request;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;


public class LoginRequest {
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Your input is not a email address")
	private String email;
	@NotEmpty(message = "Password must not be empty")
	@Size(min = 6,message = "Password must be greater than 5 characters")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
