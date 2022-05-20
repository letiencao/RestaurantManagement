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

}
