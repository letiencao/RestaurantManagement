package com.letiencao.dto.request.tableseating;

import org.hibernate.validator.constraints.NotEmpty;


public class TableSeatingInsertionRequest {
	@NotEmpty(message = "Name must not be empty")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
