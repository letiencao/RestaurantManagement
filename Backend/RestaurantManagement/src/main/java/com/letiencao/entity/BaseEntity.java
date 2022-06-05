package com.letiencao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "status", columnDefinition = "int") // 1,2,3
	private int status;

	@Column(name = "created_date", columnDefinition = "BIGINT")
	private long createdDate;

	@Column(name = "created_by", columnDefinition = "nvarchar(50)")
	private String createdBy;

	@Column(name = "modified_date", columnDefinition = "BIGINT")
	private long modifiedDate;

	@Column(name = "modified_by", columnDefinition = "nvarchar(50)")
	private String modifiedBy;
}
