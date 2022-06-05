package com.letiencao.dto.response.user;

import com.letiencao.dto.BaseDTO;

import java.util.List;


public class UserDTO extends BaseDTO {
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String firstName, String lastName, String citizenId, Long birthday, String email, String password,
			String phoneNumber, List<Integer> roleIds) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.citizenId = citizenId;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roleIds = roleIds;
	}

//	@NotEmpty(message = "First name must not be empty")
	private String firstName;

//	@NotEmpty(message = "Last name must not be empty")
	private String lastName;

//	@NotEmpty(message = "Citizen ID must not be empty")
	private String citizenId;

	private Long birthday;

//	@NotEmpty(message = "Email must not be empty")
//	@Email(message = "Your input is not a email address")
	private String email;

//	@NotEmpty(message = "Password must not be empty")
//	@Size(min = 6, message = "Password must have 6 charaters or more characters")
	private String password;

//	@NotEmpty(message = "Phone number must not be empty")
//	@Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Phone number pattern is incorrect")
	private String phoneNumber;

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
