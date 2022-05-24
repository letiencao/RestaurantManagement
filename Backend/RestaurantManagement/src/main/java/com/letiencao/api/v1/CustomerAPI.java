package com.letiencao.api.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letiencao.dto.request.SearchByNameRequest;
import com.letiencao.dto.request.customer.CustomerInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.customer.CustomerDTO;
import com.letiencao.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerAPI {
	@Autowired
	private ICustomerService customerService;

	@PostMapping
	public ResponseEntity<HTTPResponse<CustomerDTO>> insertCustomer(
			@Valid @RequestBody CustomerInsertionRequest customerInsertionRequest) {
		return new ResponseEntity<HTTPResponse<CustomerDTO>>(customerService.insertOne(customerInsertionRequest),
				HttpStatus.OK);
	}

	@PostMapping("/search-by-name")
	public ResponseEntity<List<CustomerDTO>> searchByName(@Valid @RequestBody SearchByNameRequest searchByNameRequest) {
		List<CustomerDTO> customers = customerService.searchByName(searchByNameRequest.getName());
		return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
	}

}
