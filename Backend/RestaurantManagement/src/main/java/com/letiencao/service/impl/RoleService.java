package com.letiencao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letiencao.constant.ConstantValues;
import com.letiencao.converter.RoleConverter;
import com.letiencao.dto.request.role.RoleInsertionRequest;
import com.letiencao.dto.response.role.RoleDTO;
import com.letiencao.entity.RoleEntity;
import com.letiencao.repository.RoleRepository;
import com.letiencao.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;

	@Override
	public RoleDTO insertOne(RoleInsertionRequest roleInsertionRequest) {
		if (findByName(roleInsertionRequest.getName()) == null) {
			RoleEntity roleEntity = roleConverter.toEntity(roleInsertionRequest);
			roleEntity.setCreatedDate(System.currentTimeMillis());
			roleEntity.setCreatedBy(ConstantValues.CREATED_BY);
			roleEntity.setStatus(ConstantValues.AVAILABLE);

			return roleConverter.toDTO(roleRepository.save(roleEntity));
		}
		return null;
	}

	@Override
	public RoleDTO findById(int id) {
		return roleConverter.toDTO(roleRepository.findById(id));
	}

	// Chua check status delete
	@Override
	public RoleDTO findByName(String name) {
		RoleEntity roleEntity = roleRepository.findByName(name);
		return (roleEntity != null) ? roleConverter.toDTO(roleEntity) : null;

	}

}
