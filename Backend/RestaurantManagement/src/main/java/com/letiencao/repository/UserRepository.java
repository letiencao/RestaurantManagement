package com.letiencao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letiencao.constant.ConstantValues;
import com.letiencao.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	@SuppressWarnings("unchecked")
	UserEntity save(UserEntity userEntity);

	@Query(value = "SELECT * FROM user u WHERE u.citizen_id = ?1 AND u.status = "
			+ ConstantValues.AVAILABLE, nativeQuery = true)
	UserEntity findByCitizenId(String citizenId);

	@Query(value = "SELECT * FROM user u WHERE u.email = ?1 AND u.status = "
			+ ConstantValues.AVAILABLE, nativeQuery = true)
	UserEntity findByEmail(String email);

	@Query(value = "SELECT * FROM user u WHERE u.phone_number = ?1 AND u.status = "
			+ ConstantValues.AVAILABLE, nativeQuery = true)
	UserEntity findByPhoneNumber(String phoneNumber);

	@Query(value = "SELECT * FROM user u WHERE u.email = ?1 AND u.password = ?2 AND u.status = "
			+ ConstantValues.AVAILABLE, nativeQuery = true)
	UserEntity findByEmailAndPassword(String email, String password);

}
