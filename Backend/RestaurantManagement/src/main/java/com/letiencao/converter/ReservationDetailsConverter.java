package com.letiencao.converter;

import org.springframework.stereotype.Component;

import com.letiencao.dto.request.reservationdetails.ReservationDetailsInsertionRequest;
import com.letiencao.entity.ReservationDetailsEntity;

@Component
public class ReservationDetailsConverter {

	public ReservationDetailsEntity toEntity(ReservationDetailsInsertionRequest reservationDetailsInsertionRequest) {
		ReservationDetailsEntity reservationDetailsEntity = new ReservationDetailsEntity();
//		reservationDetailsEntity.setCreatedDate(reservationDetailsInsertionRequest.getCreatedDate());
//		reservationDetailsEntity.setCreatedBy(reservationDetailsInsertionRequest.getCreatedBy());
//		reservationDetailsEntity.setModifiedDate(reservationDetailsInsertionRequest.getModifiedDate());
//		reservationDetailsEntity.setModifiedBy(reservationDetailsInsertionRequest.getModifiedBy());
//		reservationDetailsEntity.setStatus(reservationDetailsInsertionRequest.getStatus());
		
		reservationDetailsEntity.setCaseId(reservationDetailsInsertionRequest.getCaseId());
		return reservationDetailsEntity;
	}
}
