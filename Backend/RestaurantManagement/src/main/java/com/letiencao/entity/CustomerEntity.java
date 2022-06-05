package com.letiencao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity extends BaseEntity {
	@Column(name = "first_name", columnDefinition = "nvarchar(50)")
	private String firstName;
	@Column(name = "last_name", columnDefinition = "nvarchar(50)")
	private String lastName;
	@Column(name = "phone_number", columnDefinition = "varchar(10)")
	private String phoneNumber;
	@OneToMany(mappedBy = "customerEntity")
	private List<ReservationEntity> reservationEntities;

}
