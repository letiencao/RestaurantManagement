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
	public int getCaseId() {
		return caseId;
	}
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	public long getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(long expectedDate) {
		this.expectedDate = expectedDate;
	}
	
}
