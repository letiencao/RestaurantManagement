package com.letiencao.dto.response.order;

import com.letiencao.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO extends BaseDTO{
	private int tableSeatingId;
	private String tableSeatingName;
	private int userId;
	public int getTableSeatingId() {
		return tableSeatingId;
	}
	public void setTableSeatingId(int tableSeatingId) {
		this.tableSeatingId = tableSeatingId;
	}
	public String getTableSeatingName() {
		return tableSeatingName;
	}
	public void setTableSeatingName(String tableSeatingName) {
		this.tableSeatingName = tableSeatingName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
