package com.letiencao.dto.request.role;

import org.hibernate.validator.constraints.NotEmpty;


public class RoleInsertionRequest {
	@NotEmpty(message = "Role name must not be empty")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
