package com.letiencao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letiencao.constant.ConstantValues;
import com.letiencao.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

	@SuppressWarnings("unchecked")
	OrderEntity save(OrderEntity orderEntity);

	// Tìm order theo tableSeatingId
	@Query(value = "SELECT * FROM _order o WHERE o.table_seating_id = ?1 AND o.status = "
			+ ConstantValues.CHECKED_IN_ORDER, nativeQuery = true)
	OrderEntity findByTableSeatingIdAndStatus(int tableSeatingId);

	// Tìm tat ca order chua check out
	@Query(value = "SELECT * FROM _order o WHERE o.status = "
			+ ConstantValues.CHECKED_IN_ORDER, nativeQuery = true)
	List<OrderEntity> findAll();

}
