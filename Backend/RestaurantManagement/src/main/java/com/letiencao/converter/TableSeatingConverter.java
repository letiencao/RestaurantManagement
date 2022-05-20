package com.letiencao.converter;

import org.springframework.stereotype.Component;

import com.letiencao.dto.request.tableseating.TableSeatingInsertionRequest;
import com.letiencao.dto.response.tableseating.TableSeatingDTO;
import com.letiencao.entity.TableSeatingEntity;

@Component
public class TableSeatingConverter {
	public TableSeatingEntity toEntity(TableSeatingInsertionRequest tableSeatingInsertionRequest) {
		TableSeatingEntity tableSeatingEntity = new TableSeatingEntity();
		tableSeatingEntity.setName(tableSeatingInsertionRequest.getName());

		return tableSeatingEntity;
	}

	public TableSeatingDTO toDTO(TableSeatingEntity tableSeatingEntity) {
		TableSeatingDTO tableSeatingDTO = new TableSeatingDTO();
		tableSeatingDTO.setId(tableSeatingEntity.getId());
		tableSeatingDTO.setCreatedBy(tableSeatingEntity.getCreatedBy());
		tableSeatingDTO.setCreatedDate(tableSeatingEntity.getCreatedDate());
		tableSeatingDTO.setModifiedBy(tableSeatingEntity.getModifiedBy());
		tableSeatingDTO.setModifiedDate(tableSeatingEntity.getModifiedDate());
		tableSeatingDTO.setDeleted(tableSeatingEntity.isDeleted());
		tableSeatingDTO.setName(tableSeatingEntity.getName());
//		tableSeatingDTO.setMaximumSeats(tableSeatingEntity.getMaximumSeats());
//		tableSeatingDTO.setReservationEntities(tableSeatingEntity.getReservationEntities());

		return tableSeatingDTO;
	}
}
