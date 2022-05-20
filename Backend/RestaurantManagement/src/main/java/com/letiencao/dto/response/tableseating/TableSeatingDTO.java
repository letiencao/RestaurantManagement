package com.letiencao.dto.response.tableseating;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TableSeatingDTO{
	private int id;
	private String createdBy;
	private String modifiedBy;
	private Long createdDate;
	private Long modifiedDate;
	private boolean deleted;
	private String name;

//	private List<ReservationEntity> reservationEntities;
}
