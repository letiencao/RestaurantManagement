package com.letiencao.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.letiencao.dto.request.user.UserInsertionRequest;
import com.letiencao.dto.response.user.UserDTO;
import com.letiencao.entity.RoleEntity;
import com.letiencao.entity.UserEntity;

@Component
public class UserConverter {
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setCreatedDate(userDTO.getCreatedDate());
		userEntity.setCreatedBy(userDTO.getCreatedBy());
		userEntity.setModifiedDate(userDTO.getModifiedDate());
		userEntity.setModifiedBy(userDTO.getModifiedBy());
		userEntity.setBirthday(userDTO.getBirthday());
		userEntity.setCitizenId(userDTO.getCitizenId());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setPhoneNumber(userDTO.getPhoneNumber());
		userEntity.setStatus(userDTO.getStatus());
		return userEntity;

	}

	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setCreatedDate(userEntity.getCreatedDate());
		userDTO.setCreatedBy(userEntity.getCreatedBy());
		userDTO.setModifiedDate(userEntity.getModifiedDate());
		userDTO.setModifiedBy(userEntity.getModifiedBy());
		userDTO.setBirthday(userEntity.getBirthday());
		userDTO.setCitizenId(userEntity.getCitizenId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setPhoneNumber(userEntity.getPhoneNumber());
		userDTO.setStatus(userEntity.getStatus());
		userDTO.setRoleIds(getListRoleIds(userEntity));
		return userDTO;
	}

	public List<Integer> getListRoleIds(UserEntity userEntity) {
		List<Integer> list = new ArrayList<Integer>();
		for (RoleEntity roleEntity : userEntity.getRoleEntities()) {
			if (roleEntity != null) {
				list.add(roleEntity.getId());
			}
		}
		return list;
	}

	public UserEntity toEntity(UserInsertionRequest userInsertionRequest) {
		UserEntity userEntity = new UserEntity();
		userEntity.setBirthday(userInsertionRequest.getBirthday());
		userEntity.setCitizenId(userInsertionRequest.getCitizenId());
		userEntity.setFirstName(userInsertionRequest.getFirstName());
		userEntity.setLastName(userInsertionRequest.getLastName());
		userEntity.setEmail(userInsertionRequest.getEmail());
		userEntity.setPassword(userInsertionRequest.getPassword());
		userEntity.setPhoneNumber(userInsertionRequest.getPhoneNumber());
		return userEntity;
	}

}
