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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<ReservationDTO> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationDTO> reservations) {
		this.reservations = reservations;
	}
	
}
