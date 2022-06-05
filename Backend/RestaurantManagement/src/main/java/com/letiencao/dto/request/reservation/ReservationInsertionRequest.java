package com.letiencao.dto.request.reservation;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;



public class ReservationInsertionRequest {
	@Min(value = 1, message = "Customer ID must be greater than 0")
	private int customerId;
	@Min(value = 0, message = "Deposit must be greater than or equal 0")
	private BigDecimal deposit;
	private String note;
	@Min(value = 1, message = "Expected date must be greater than 0")
	private Long expectedDate;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

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
