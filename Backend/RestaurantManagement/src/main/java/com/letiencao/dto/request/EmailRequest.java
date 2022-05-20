package com.letiencao.dto.request;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Your input is not a email address")
	private String email;
}
