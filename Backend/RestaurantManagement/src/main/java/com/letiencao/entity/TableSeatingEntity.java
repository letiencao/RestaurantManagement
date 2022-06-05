package com.letiencao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "table_seating")

public class TableSeatingEntity extends BaseEntity{
	@Column(name = "name", columnDefinition = "nvarchar(20)")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
