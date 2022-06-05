package com.letiencao.dto.response.reservationdetails;

import com.letiencao.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class ReservationDetailsDTO extends BaseDTO {
	private int tableSeatingId;
	private int reservationId;
	private int caseId;
	private long expectedDate;

	public ReservationDetailsDTO(int tableSeatingId, int reservationId, int caseId, long expectedDate) {
		this.tableSeatingId = tableSeatingId;
		this.reservationId = reservationId;
		this.caseId = caseId;
		this.expectedDate = expectedDate;
	}
}
