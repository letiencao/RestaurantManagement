//package com.letiencao.api.v1;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.letiencao.dto.request.role.RoleInsertionRequest;
//import com.letiencao.dto.response.role.RoleDTO;
//import com.letiencao.service.IRoleService;
//
//@RestController
//@RequestMapping("/api/v1/roles")
//public class RoleAPI {
//
//	@Autowired
//	private IRoleService roleService;
//
//	@PostMapping
//	public ResponseEntity<RoleDTO> insertRole(@Valid @RequestBody RoleInsertionRequest roleInsertionRequest) {
//		return new ResponseEntity<RoleDTO>(roleService.insertOne(roleInsertionRequest), HttpStatus.OK);
//	}
//
//}
