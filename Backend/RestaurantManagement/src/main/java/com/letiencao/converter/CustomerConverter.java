package com.letiencao.converter;

import org.springframework.stereotype.Component;

import com.letiencao.dto.request.customer.CustomerInsertionRequest;
import com.letiencao.dto.response.customer.CustomerDTO;
import com.letiencao.entity.CustomerEntity;

@Component
public class CustomerConverter {
	public CustomerEntity toEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName(customerDTO.getFirstName());
		customerEntity.setLastName(customerDTO.getLastName());
		customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
//		customerEntity.setBirthday(customerDTO.getBirthday());
//		customerEntity.setEmail(customerDTO.getEmail());
//		customerEntity.setTaxCode(customerDTO.getTaxCode());
		customerEntity.setCreatedBy(customerDTO.getCreatedBy());
		customerEntity.setCreatedDate(customerDTO.getCreatedDate());
		customerEntity.setModifiedBy(customerDTO.getModifiedBy());
		customerEntity.setModifiedDate(customerDTO.getModifiedDate());
		customerEntity.setStatus(customerDTO.getStatus());

		return customerEntity;
	}

	public CustomerDTO toDTO(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName(customerEntity.getFirstName());
		customerDTO.setLastName(customerEntity.getLastName());
		customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
//		customerDTO.setBirthday(customerEntity.getBirthday());
//		customerDTO.setEmail(customerEntity.getEmail());
//		customerDTO.setTaxCode(customerEntity.getTaxCode());
		customerDTO.setCreatedBy(customerEntity.getCreatedBy());
		customerDTO.setCreatedDate(customerEntity.getCreatedDate());
		customerDTO.setModifiedBy(customerEntity.getModifiedBy());
		customerDTO.setModifiedDate(customerEntity.getModifiedDate());
		customerDTO.setStatus(customerEntity.getStatus());
		customerDTO.setId(customerEntity.getId());

		return customerDTO;
	}

	public CustomerEntity toEntity(CustomerInsertionRequest customerInsertionRequest) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName(customerInsertionRequest.getFirstName());
		customerEntity.setLastName(customerInsertionRequest.getLastName());
		customerEntity.setPhoneNumber(customerInsertionRequest.getPhoneNumber());
//		customerEntity.setBirthday(customerInsertionRequest.getBirthday());
//		customerEntity.setEmail(customerInsertionRequest.getEmail());
//		customerEntity.setTaxCode(customerInsertionRequest.getTaxCode());
		return customerEntity;
	}
}
