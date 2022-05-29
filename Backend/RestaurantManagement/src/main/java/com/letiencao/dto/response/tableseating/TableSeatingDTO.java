package com.letiencao.dto.response.tableseating;

import com.letiencao.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TableSeatingDTO extends BaseDTO{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
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
