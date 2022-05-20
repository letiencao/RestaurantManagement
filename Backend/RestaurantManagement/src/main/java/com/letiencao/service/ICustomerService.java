package com.letiencao.service;

import java.util.List;

import com.letiencao.dto.request.customer.CustomerInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.customer.CustomerDTO;

public interface ICustomerService {
	//Insert a Customer 
	HTTPResponse<CustomerDTO> insertOne(CustomerInsertionRequest customerInsertionRequest);

	//Find a Customer by phone number
	CustomerDTO findByPhoneNumber(String phoneNumber);

	//Find all customers
	List<CustomerDTO> searchByName(String name);
}
