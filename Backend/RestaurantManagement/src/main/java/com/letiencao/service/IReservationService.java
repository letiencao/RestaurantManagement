package com.letiencao.service;

import com.letiencao.dto.request.reservation.ReservationInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.reservation.ReservationDTO;

public interface IReservationService {
	//Thêm 1 reservation
	HTTPResponse<ReservationDTO> insertOne(ReservationInsertionRequest reservationInsertionRequest);
	
}
