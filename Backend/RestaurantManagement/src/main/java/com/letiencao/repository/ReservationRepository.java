package com.letiencao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letiencao.constant.ConstantValues;
import com.letiencao.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
	@SuppressWarnings("unchecked")
	ReservationEntity save(ReservationEntity reservationEntity);

	@Query(value = "SELECT * FROM reservation r WHERE r.id = ?1 AND r.status = "
			+ ConstantValues.CONFIRMED_RESERVATION, nativeQuery = true)
	ReservationEntity findById(int id);

	// Lấy ra danh sách reservation của một bàn tableSeatingId trong 1 ngày nào đó
	// và đã được
	// tiếp nhận
	@Query(value = "SELECT * FROM reservation r WHERE r.table_seating_id = ?1 AND r.arrival_time >= ?2 AND r.arrival_time < ?3 AND r.status = "
			+ ConstantValues.CONFIRMED_RESERVATION, nativeQuery = true)
	List<ReservationEntity> findByTableSeatingId(int tableSeatingId, long startOfDay, long endOfDay);

//	// Lấy ra danh sách reservation của tất cả các bàn trong 1 ngày nào đó
//	// và đã được
//	// tiếp nhận
//	@Query(value = "SELECT * FROM reservation r WHERE r.arrival_time = ?1 AND r.status = "
//			+ ConstantValues.CONFIRMED_RESERVATION, nativeQuery = true)
//	List<ReservationEntity> findByArrivalTime(long arrivalTime);

}
