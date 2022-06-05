package com.letiencao.dto.response.role;

import com.letiencao.dto.BaseDTO;


public class RoleDTO extends BaseDTO {
	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}
//	@NotEmpty(message = "Role name must not be empty")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
