package com.letiencao.enumerated;

public enum TableSeatingEnum {
	
	FREE("free"),RESERVED("reserved"),OCCUPIED("occupied"),OTHER("other");
	
	private String status;
	
	private TableSeatingEnum(String status) {
		this.status = status;
	}
}
