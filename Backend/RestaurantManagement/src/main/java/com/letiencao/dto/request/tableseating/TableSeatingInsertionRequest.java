package com.letiencao.dto.request.tableseating;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


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
