package com.letiencao.dto.request.customer;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;


public class CustomerInsertionRequest {

	@NotEmpty(message = "First name must not be empty")
	private String firstName;

	@NotEmpty(message = "First name must not be empty")
	private String lastName;

	@NotEmpty(message = "Phone number must not be empty")
	@Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Phone number pattern is incorrect")
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
