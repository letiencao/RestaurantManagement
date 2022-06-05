package com.letiencao.dto.response.reservationdetails;

import com.letiencao.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservationDetailsDTO extends BaseDTO {
	private int tableSeatingId;
	private int reservationId;
	private int caseId;
	private long expectedDate;
}
