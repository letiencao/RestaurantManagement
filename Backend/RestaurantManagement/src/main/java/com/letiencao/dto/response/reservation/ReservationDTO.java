package com.letiencao.dto.response.reservation;

import java.math.BigDecimal;

import com.letiencao.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO extends BaseDTO {
	private BigDecimal deposit;

	private String note;

	private Long expectedDate;

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Long expectedDate) {
		this.expectedDate = expectedDate;
	}
	

}
