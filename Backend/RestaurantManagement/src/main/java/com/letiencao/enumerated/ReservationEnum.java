package com.letiencao.enumerated;

public enum ReservationEnum {

	CONFIRMED("Confirmed"), CHECKEDIN("Checked-in"), CANCELED("Canceled");

	private String status;

	private ReservationEnum(String status) {
		this.status = status;
	}
}
