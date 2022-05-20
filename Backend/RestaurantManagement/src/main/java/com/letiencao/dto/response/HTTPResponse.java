package com.letiencao.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class HTTPResponse<T> {
	private String message;
	private int code;
	private T data;
}
