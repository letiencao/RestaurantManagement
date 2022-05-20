package com.letiencao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table_seating")
@Getter
@Setter
public class TableSeatingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", columnDefinition = "nvarchar(20)")
	private String name;
	@Column(name = "deleted", columnDefinition = "TINYINT")
	private boolean deleted;
	@Column(name = "created_date", columnDefinition = "BIGINT")
	private long createdDate;

	@Column(name = "created_by", columnDefinition = "nvarchar(50)")
	private String createdBy;

	@Column(name = "modified_date", columnDefinition = "BIGINT")
	private long modifiedDate;

	@Column(name = "modified_by", columnDefinition = "nvarchar(50)")
	private String modifiedBy;
}
