package com.letiencao.service;

import java.util.List;

import com.letiencao.dto.request.order.OrderInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.order.OrderDTO;

public interface IOrderService {
	
	//Insert list orders
	HTTPResponse<List<OrderDTO>> insertOne(OrderInsertionRequest orderInsertionRequest);
	
	//Find all orders have not checked out
	List<OrderDTO> findAll();

}
