package com.letiencao.dto.request.reservation;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignTableRequest {
	
	@Min(value = 1,message = "Reservation Id must be greater or equal 1")
	private int reservationId;
	@Size(min = 1, message = "The size of list is zero")
	private List<Integer> tableSeatingIds;
}
