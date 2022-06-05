package com.letiencao.dto.request.reservationdetails;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



public class ReservationDetailsInsertionRequest {
	@Min(value = 1, message = "Table Seating Id must be greater than 0")
	private int tableSeatingId;
	@Min(value = 1,message = "Reservation id must be greater than 0")
	private int reservationId;

	public int getTableSeatingId() {
		return tableSeatingId;
	}

	public void setTableSeatingId(int tableSeatingId) {
		this.tableSeatingId = tableSeatingId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
}
