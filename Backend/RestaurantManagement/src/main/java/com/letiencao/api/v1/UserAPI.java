package com.letiencao.api.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letiencao.dto.request.user.UserInsertionRequest;
import com.letiencao.dto.response.user.UserDTO;
import com.letiencao.service.IUserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserAPI {

	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> insertUser(@Valid @RequestBody UserInsertionRequest userInsertionRequest) {
		UserDTO userInsertion = userService.insertOne(userInsertionRequest);
		return new ResponseEntity<UserDTO>(userInsertion, HttpStatus.OK);

	}

}
