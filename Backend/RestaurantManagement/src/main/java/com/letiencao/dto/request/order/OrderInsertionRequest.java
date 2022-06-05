package com.letiencao.dto.request.order;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;


public class OrderInsertionRequest {
	
	@Size(min = 1,message = "The table seating id list must be have 1 element at least")
	private List<Integer> tableSeatingIds;
	@Min(message = "The user id must be greater than 0", value = 1)
	private int userId;

	public List<Integer> getTableSeatingIds() {
		return tableSeatingIds;
	}

	public void setTableSeatingIds(List<Integer> tableSeatingIds) {
		this.tableSeatingIds = tableSeatingIds;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
