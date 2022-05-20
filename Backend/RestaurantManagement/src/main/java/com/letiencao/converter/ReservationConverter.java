package com.letiencao.converter;

import org.springframework.stereotype.Component;

import com.letiencao.dto.request.reservation.ReservationInsertionRequest;
import com.letiencao.dto.response.reservation.ReservationDTO;
import com.letiencao.entity.ReservationEntity;

@Component
public class ReservationConverter {
	public ReservationEntity toEntity(ReservationInsertionRequest reservationInsertionRequest) {
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setNote(reservationInsertionRequest.getNote());
//		reservationEntity.setNumberOfPeople(reservationInsertionRequest.getNumberOfPeople());
		reservationEntity.setDeposit(reservationInsertionRequest.getDeposit());
//		reservationEntity.setArrivalTime(reservationInsertionRequest.getArrivalTime());
		
		return reservationEntity;
	}
	
	public ReservationDTO toDTO(ReservationEntity reservationEntity) {
		ReservationDTO reservationDTO = new ReservationDTO();
		reservationDTO.setNote(reservationEntity.getNote());
		reservationDTO.setCreatedBy(reservationEntity.getCreatedBy());
		reservationDTO.setCreatedDate(reservationEntity.getCreatedDate());
		reservationDTO.setModifiedBy(reservationEntity.getModifiedBy());
		reservationDTO.setModifiedDate(reservationEntity.getModifiedDate());
		reservationDTO.setStatus(reservationEntity.getStatus());
		reservationDTO.setDeposit(reservationEntity.getDeposit());
		
		return reservationDTO;
		
		
		
	}
}
