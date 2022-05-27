package com.letiencao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table_seating")
@Getter
@Setter
public class TableSeatingEntity extends BaseEntity{
	@Column(name = "name", columnDefinition = "nvarchar(20)")
	private String name;
}
