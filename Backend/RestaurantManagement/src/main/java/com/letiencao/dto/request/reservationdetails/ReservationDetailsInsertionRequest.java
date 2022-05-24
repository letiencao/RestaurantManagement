package com.letiencao.dto.request.reservationdetails;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReservationDetailsInsertionRequest {
	@Min(value = 1, message = "Table Seating Id must be greater than 0")
	private int tableSeatingId;
	@Min(value = 1,message = "Reservation id must be greater than 0")
	private int reservationId;
}
