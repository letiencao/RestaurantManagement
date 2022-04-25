package com.letiencao.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HTTPResponse {
	private String message;
	private int code;
}
