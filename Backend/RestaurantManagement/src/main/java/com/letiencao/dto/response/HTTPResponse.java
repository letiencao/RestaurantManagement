package com.letiencao.dto.response;

public class HTTPResponse<T> {
	private String message;
	private int code;
	private T data;

	public HTTPResponse(String message, int code, T data) {
		this.message = message;
		this.code = code;
		this.data = data;
	}
}
