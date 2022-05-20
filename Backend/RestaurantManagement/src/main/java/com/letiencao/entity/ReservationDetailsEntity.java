package com.letiencao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservation_details")
@Getter
@Setter
@ToString
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
	@Column(name = "case_id", columnDefinition = "int")
	private int caseId;

}
