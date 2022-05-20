package com.letiencao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letiencao.constant.ConstantValues;
import com.letiencao.converter.MenuItemConverter;
import com.letiencao.dto.request.menuitem.MenuItemInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.menuitem.MenuItemDTO;
import com.letiencao.entity.MenuItemEntity;
import com.letiencao.repository.MenuItemRepository;
import com.letiencao.service.BaseService;
import com.letiencao.service.IMenuItemService;

@Service
public class MenuItemService extends BaseService implements IMenuItemService {

	@Autowired
	private MenuItemConverter menuItemConverter;
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public HTTPResponse<MenuItemDTO> insertOne(MenuItemInsertionRequest menuItemInsertionRequest) {
		String name = menuItemInsertionRequest.getName();
		MenuItemDTO menuItemDTO = findByName(name);
		if (!hasSpecialCharacter(name) && menuItemDTO == null) {
			MenuItemEntity menuItemEntity = new MenuItemEntity();
			menuItemEntity.setCreatedBy(ConstantValues.CREATED_BY);
			menuItemEntity.setCreatedDate(System.currentTimeMillis());
			menuItemEntity.setStatus(ConstantValues.AVAILABLE);
			menuItemEntity.setName(menuItemInsertionRequest.getName());
			menuItemEntity.setPrice(menuItemInsertionRequest.getPrice());

			menuItemEntity = menuItemRepository.save(menuItemEntity);
			return new HTTPResponse<MenuItemDTO>("The new menu item has been inserted", ConstantValues.CODE_201,
					menuItemConverter.toDTO(menuItemEntity));

		} else if (hasSpecialCharacter(name)) {
			return new HTTPResponse<MenuItemDTO>("The name has special character!", ConstantValues.CODE_200, null);
		} else {
			return new HTTPResponse<MenuItemDTO>("The name has existed", ConstantValues.CODE_200, null);

		}
	}

	@Override
	public MenuItemDTO findByName(String name) {
		MenuItemEntity menuItemEntity = menuItemRepository.findByName(name);
		return menuItemEntity != null ? menuItemConverter.toDTO(menuItemEntity) : null;
	}

}
