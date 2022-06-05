package com.letiencao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
	private int id;
//	@Min(value = 1, message = "Status must be greater than 1")
	private int status;

	private long createdDate;
	private String createdBy;
	private long modifiedDate;
	private String modifiedBy;
}
