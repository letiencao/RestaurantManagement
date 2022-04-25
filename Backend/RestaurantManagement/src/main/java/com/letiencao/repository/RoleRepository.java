package com.letiencao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letiencao.constant.ConstantValues;
import com.letiencao.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	@Query(value = "SELECT * FROM role r WHERE r.name = ?1 AND r.status = " + ConstantValues.AVAILABLE, nativeQuery = true)
	RoleEntity findByName(String name);

	@SuppressWarnings("unchecked")
	RoleEntity save(RoleEntity roleEntity);

	@Query(value = "SELECT * FROM role r WHERE r.id = ?1 AND r.status = " + ConstantValues.AVAILABLE, nativeQuery = true)
	RoleEntity findById(int id);
}
