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

public class CustomerEntity extends BaseEntity {
	@Column(name = "first_name", columnDefinition = "nvarchar(50)")
	private String firstName;
	@Column(name = "last_name", columnDefinition = "nvarchar(50)")
	private String lastName;
	@Column(name = "phone_number", columnDefinition = "varchar(10)")
	private String phoneNumber;
	@OneToMany(mappedBy = "customerEntity")
	private List<ReservationEntity> reservationEntities;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<ReservationEntity> getReservationEntities() {
		return reservationEntities;
	}

	public void setReservationEntities(List<ReservationEntity> reservationEntities) {
		this.reservationEntities = reservationEntities;
	}
}
