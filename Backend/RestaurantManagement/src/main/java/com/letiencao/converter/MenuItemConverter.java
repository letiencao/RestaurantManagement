package com.letiencao.converter;

import org.springframework.stereotype.Component;

import com.letiencao.dto.request.menuitem.MenuItemInsertionRequest;
import com.letiencao.dto.response.menuitem.MenuItemDTO;
import com.letiencao.entity.MenuItemEntity;

@Component
public class MenuItemConverter {

	public MenuItemEntity toEntity(MenuItemInsertionRequest menuItemInsertionRequest) {
		MenuItemEntity menuItemEntity = new MenuItemEntity();
		menuItemEntity.setName(menuItemInsertionRequest.getName());
		menuItemEntity.setPrice(menuItemInsertionRequest.getPrice());

		return menuItemEntity;
	}

	public MenuItemDTO toDTO(MenuItemEntity menuItemEntity) {
		MenuItemDTO menuItemDTO = new MenuItemDTO();

		menuItemDTO.setId(menuItemEntity.getId());
		menuItemDTO.setStatus(menuItemEntity.getStatus());
		menuItemDTO.setCreatedDate(menuItemEntity.getCreatedDate());
		menuItemDTO.setCreatedBy(menuItemEntity.getCreatedBy());
		menuItemDTO.setModifiedDate(menuItemEntity.getModifiedDate());
		menuItemDTO.setModifiedBy(menuItemEntity.getModifiedBy());
		menuItemDTO.setName(menuItemEntity.getName());
		menuItemDTO.setPrice(menuItemEntity.getPrice());

		return menuItemDTO;
	}

}
