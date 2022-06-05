package com.letiencao.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String description;

	public ExceptionResponse(Date timestamp, String message, String description) {
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}
}
