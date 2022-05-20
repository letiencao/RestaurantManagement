package com.letiencao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.letiencao.constant.ConstantValues;
import com.letiencao.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

	@SuppressWarnings("unchecked")
	CustomerEntity save(CustomerEntity customerEntity);
	
	@Query(value = "SELECT * FROM customer c WHERE c.phone_number = ?1 AND c.status = " + ConstantValues.AVAILABLE, nativeQuery = true)
	CustomerEntity findByPhoneNumber(String phoneNumber);
	
	@Query(value = "SELECT * FROM customer c WHERE c.id = ?1 AND c.status = " + ConstantValues.AVAILABLE, nativeQuery = true)
	CustomerEntity findById(int id);
	@Query(value = "SELECT * FROM customer c WHERE c.first_name LIKE %:name% OR c.last_name LIKE %:name% AND c.status = " + ConstantValues.AVAILABLE, nativeQuery = true)
	List<CustomerEntity> searchByName(@Param("name") String name);
}
