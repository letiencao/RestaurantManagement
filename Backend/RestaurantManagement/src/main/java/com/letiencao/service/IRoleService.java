package com.letiencao.service;

import com.letiencao.dto.request.role.RoleInsertionRequest;
import com.letiencao.dto.response.role.RoleDTO;

public interface IRoleService {
	// Insert a Role
	RoleDTO insertOne(RoleInsertionRequest roleInsertionRequest);

	// Find a Role by id
	RoleDTO findById(int id);

	// Find a Role by name
	RoleDTO findByName(String name);
}
