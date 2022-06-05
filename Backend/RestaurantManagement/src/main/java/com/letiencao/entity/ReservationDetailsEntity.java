package com.letiencao.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation_details")
public class ReservationDetailsEntity {

	// reservationId
	// tableSeatingId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private ReservationEntity reservationEntity;
	@ManyToOne
	@JoinColumn(name = "table_seating_id")
	private TableSeatingEntity tableSeatingEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReservationEntity getReservationEntity() {
		return reservationEntity;
	}

	public void setReservationEntity(ReservationEntity reservationEntity) {
		this.reservationEntity = reservationEntity;
	}

	public TableSeatingEntity getTableSeatingEntity() {
		return tableSeatingEntity;
	}

	public void setTableSeatingEntity(TableSeatingEntity tableSeatingEntity) {
		this.tableSeatingEntity = tableSeatingEntity;
	}
}
