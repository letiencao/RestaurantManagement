package com.letiencao.service;

import com.letiencao.dto.request.menuitem.MenuItemInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.menuitem.MenuItemDTO;

public interface IMenuItemService {
	// Insert 1 menu item
	HTTPResponse<MenuItemDTO> insertOne(MenuItemInsertionRequest menuItemInsertionRequest);

	// find by name
	MenuItemDTO findByName(String name);
}
