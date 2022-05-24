package com.letiencao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.entity.ReservationDetailsEntity;

public interface ReservationDetailsRepository extends JpaRepository<ReservationDetailsEntity, Integer> {

	// Tim reservation thong qua
	// table_seating_id, expected_date,case_id
	@Query(value = "SELECT * FROM reservation_details r INNER JOIN reservation ON reservation.id = r.reservation_id WHERE r.table_seating_id = ?1 AND reservation.expected_date = ?2 AND r.case_id = ?3", nativeQuery = true)
	ReservationDetailsEntity findExistedReservationDetails(int tableSeatingId, long expectedDate, int caseId);
	
	@SuppressWarnings("unchecked")
	ReservationDetailsEntity save(ReservationDetailsEntity reservationDetailsEntity);
}
