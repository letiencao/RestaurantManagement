package com.letiencao.dto.request.order;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderInsertionRequest {
	
	@Size(min = 1,message = "The table seating id list must be have 1 element at least")
	private List<Integer> tableSeatingIds;
	@Min(message = "The user id must be greater than 0", value = 1)
	private int userId;

}
