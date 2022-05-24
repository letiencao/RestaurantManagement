package com.letiencao.api.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letiencao.dto.request.reservation.ReservationInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.reservation.ReservationDTO;
import com.letiencao.service.IReservationService;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationAPI {

	@Autowired
	private IReservationService reservationService;

	@PostMapping()
	public ResponseEntity<HTTPResponse<ReservationDTO>> insertReservation(
			@Valid @RequestBody ReservationInsertionRequest reservationInsertionRequest) {
		return new ResponseEntity<HTTPResponse<ReservationDTO>>(reservationService.insertOne(reservationInsertionRequest), HttpStatus.OK);
	}

}
