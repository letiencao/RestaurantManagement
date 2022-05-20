package com.letiencao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letiencao.constant.ConstantValues;
import com.letiencao.entity.MenuItemEntity;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Integer>{
	
	@SuppressWarnings("unchecked")
	MenuItemEntity save(MenuItemEntity menuItemEntity);
	
	@Query(value = "SELECT * FROM menu_item m WHERE m.name = ?1 AND m.status = " + ConstantValues.AVAILABLE, nativeQuery = true)
	MenuItemEntity findByName(String name);

}
