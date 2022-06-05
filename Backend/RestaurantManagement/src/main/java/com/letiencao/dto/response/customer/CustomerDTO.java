package com.letiencao.dto.response.customer;

import java.util.List;

import com.letiencao.dto.BaseDTO;
import com.letiencao.dto.response.reservation.ReservationDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDTO extends BaseDTO {

	private String firstName;

	private String lastName;

	private String phoneNumber;
	
	private List<ReservationDTO> reservations;
}
