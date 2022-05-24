package com.letiencao.dto.request.reservation;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReservationInsertionRequest {
	@Min(value = 1, message = "Customer ID must be greater than 0")
	private int customerId;
	@Min(value = 0, message = "Deposit must be greater than or equal 0")
	private BigDecimal deposit;
	private String note;
	@Min(value = 1, message = "Expected date must be greater than 0")
	private Long expectedDate;

}
