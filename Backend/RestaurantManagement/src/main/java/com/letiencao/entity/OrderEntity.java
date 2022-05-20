package com.letiencao.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "_order")
@Getter
@Setter
@ToString
public class OrderEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;
	@ManyToOne
	@JoinColumn(name = "table_seating_id")
	private TableSeatingEntity tableSeatingEntity;
}