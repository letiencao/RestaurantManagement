package com.letiencao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letiencao.constant.ConstantValues;
import com.letiencao.converter.CustomerConverter;
import com.letiencao.dto.request.customer.CustomerInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.customer.CustomerDTO;
import com.letiencao.entity.CustomerEntity;
import com.letiencao.repository.CustomerRepository;
import com.letiencao.service.BaseService;
import com.letiencao.service.ICustomerService;

@Service
public class CustomerService extends BaseService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerConverter customerConverter;

	@Override
	public HTTPResponse<CustomerDTO> insertOne(CustomerInsertionRequest customerInsertionRequest) {
		String firstName = customerInsertionRequest.getFirstName();
		String lastName = customerInsertionRequest.getLastName();
		if (findByPhoneNumber(customerInsertionRequest.getPhoneNumber()) == null && !hasSpecialCharacter(firstName)
				&& !hasSpecialCharacter(lastName)) {
			CustomerEntity customerEntity = customerConverter.toEntity(customerInsertionRequest);
			customerEntity.setCreatedDate(System.currentTimeMillis());
			customerEntity.setCreatedBy(ConstantValues.CREATED_BY);
			customerEntity.setStatus(ConstantValues.AVAILABLE);
			return new HTTPResponse<CustomerDTO>("The new customer has been inserted", ConstantValues.CODE_201,
					customerConverter.toDTO(customerRepository.save(customerEntity)));
		} else if (hasSpecialCharacter(firstName)) {
			return new HTTPResponse<CustomerDTO>("The customer first name has had the special character",
					ConstantValues.CODE_200, null);
		} else if (hasSpecialCharacter(lastName)) {
			return new HTTPResponse<CustomerDTO>("The customer last name has had the special character",
					ConstantValues.CODE_200, null);
		} else {
			return new HTTPResponse<CustomerDTO>("The customer phone number has existed", ConstantValues.CODE_200,
					null);
		}
	}

	@Override
	public CustomerDTO findByPhoneNumber(String phoneNumber) {
		CustomerEntity customerEntity = customerRepository.findByPhoneNumber(phoneNumber);
		return customerEntity != null ? customerConverter.toDTO(customerEntity) : null;
	}

	@Override
	public List<CustomerDTO> searchByName(String name) {
		System.out.println("Name = " + name);
		List<CustomerEntity> customerEntities = customerRepository.searchByName(name);
		return convertEntitesToDTO(customerEntities);
	}

	private List<CustomerDTO> convertEntitesToDTO(List<CustomerEntity> customerEntities) {
		List<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		for (int i = 0; i < customerEntities.size(); i++) {
			dtos.add(customerConverter.toDTO(customerEntities.get(i)));
		}

		return dtos;
	}

}
