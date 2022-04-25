package com.letiencao.enumerated;

public enum BaseEnum {
	AVAILABLE("Khả dụng"), UNAVAILABLE("Không khả dụng");

	private String status;

	private BaseEnum(String status) {
		this.status = status;
	}

}
