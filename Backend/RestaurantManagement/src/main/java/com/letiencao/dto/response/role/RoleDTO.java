package com.letiencao.dto.response.role;

import com.letiencao.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoleDTO extends BaseDTO {
	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}
//	@NotEmpty(message = "Role name must not be empty")
	private String name;
}