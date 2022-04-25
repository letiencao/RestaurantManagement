package com.letiencao.converter;

import org.springframework.stereotype.Component;

import com.letiencao.dto.request.role.RoleInsertionRequest;
import com.letiencao.dto.response.role.RoleDTO;
import com.letiencao.entity.RoleEntity;

@Component
public class RoleConverter {

	public RoleEntity toEntity(RoleDTO roleDTO) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setCreatedDate(roleDTO.getCreatedDate());
		roleEntity.setCreatedBy(roleDTO.getCreatedBy());
		roleEntity.setModifiedDate(roleDTO.getModifiedDate());
		roleEntity.setModifiedBy(roleDTO.getModifiedBy());
		roleEntity.setStatus(roleDTO.getStatus());
		roleEntity.setName(roleDTO.getName());

		return roleEntity;
	}

	public RoleDTO toDTO(RoleEntity roleEntity) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(roleEntity.getId());
		roleDTO.setName(roleEntity.getName());
		roleDTO.setCreatedDate(roleEntity.getCreatedDate());
		roleDTO.setCreatedBy(roleEntity.getCreatedBy());
		roleDTO.setModifiedDate(roleEntity.getModifiedDate());
		roleDTO.setModifiedBy(roleEntity.getModifiedBy());
		roleDTO.setStatus(roleEntity.getStatus());
		return roleDTO;

	}

	public RoleEntity toEntity(RoleInsertionRequest roleInsertionRequest) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName(roleInsertionRequest.getName());
		return roleEntity;
	}
}
