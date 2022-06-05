package com.letiencao.dto.request.user;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class UserInsertionRequest {

	@NotEmpty(message = "First name must not be empty")
	private String firstName;

	@NotEmpty(message = "Last name must not be empty")
	private String lastName;

	@NotEmpty(message = "Citizen ID must not be empty")
	private String citizenId;

	@Min(value = 1, message = "Birthday must be greater than 0")
	private Long birthday;

	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Your input is not a email address")
	private String email;

	@NotEmpty(message = "Password must not be empty")
	@Size(min = 6, message = "Password must have 6 charaters or more characters")
	private String password;

	@NotEmpty(message = "Phone number must not be empty")
	@Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Phone number pattern is incorrect")
	private String phoneNumber;

	@Size(min = 1, message = "User must have at least one role")
	private List<Integer> roleIds;

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

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
}
