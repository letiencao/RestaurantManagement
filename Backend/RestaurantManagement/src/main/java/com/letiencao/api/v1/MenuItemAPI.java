package com.letiencao.api.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letiencao.dto.request.menuitem.MenuItemInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.menuitem.MenuItemDTO;
import com.letiencao.service.IMenuItemService;

@RestController
@RequestMapping("/api/v1/menu-items")
public class MenuItemAPI {

	@Autowired
	private IMenuItemService menuItemService;

	@PostMapping
	public ResponseEntity<HTTPResponse<MenuItemDTO>> insertMenuItem(
			@Valid @RequestBody MenuItemInsertionRequest menuItemInsertionRequest) {
		return new ResponseEntity<HTTPResponse<MenuItemDTO>>(menuItemService.insertOne(menuItemInsertionRequest),
				HttpStatus.OK);
	}

}
