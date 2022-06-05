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

}
