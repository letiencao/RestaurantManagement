package com.letiencao.dto.response.tableseating;

import com.letiencao.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

public class TableSeatingDTO extends BaseDTO{
	private int id;
	private String name;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//	private List<ReservationEntity> reservationEntities;
}
