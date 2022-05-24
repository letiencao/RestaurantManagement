package com.letiencao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letiencao.entity.TableSeatingEntity;

@Repository
public interface TableSeatingRepository extends JpaRepository<TableSeatingEntity, Integer> {

	@SuppressWarnings("unchecked")
	TableSeatingEntity save(TableSeatingEntity tableSeatingEntity);

	@Query(value = "SELECT * FROM table_seating t WHERE t.name = ?", nativeQuery = true)
	TableSeatingEntity findByName(String name);

	@Query(value = "SELECT * FROM table_seating t WHERE t.id = ?1", nativeQuery = true)
	TableSeatingEntity findById(int id);

	@Query(value = "SELECT * FROM table_seating t INNER JOIN _order o ON  t.id = o.table_seating_id WHERE o.status = 1 AND t.deleted = 0", nativeQuery = true)
	List<TableSeatingEntity> findCheckedInTables();

	@Query(value = "SELECT * FROM table_seating t WHERE t.deleted = 0", nativeQuery = true)
	List<TableSeatingEntity> findAll();

//	@Modifying
//	@Query(value = "UPDATE table_seating t SET t.status = ?2 WHERE t.id = ?1", nativeQuery = true)
//	int setFixedStatusFor(int id, int status);

//	@Query("update User u set u.firstname = ?1 where u.lastname = ?2")
//	int setFixedFirstnameFor(String firstname, String lastname);
}
