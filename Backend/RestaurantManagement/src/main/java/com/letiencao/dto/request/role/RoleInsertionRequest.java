package com.letiencao.dto.request.role;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoleInsertionRequest {
	@NotEmpty(message = "Role name must not be empty")
	private String name;

}
