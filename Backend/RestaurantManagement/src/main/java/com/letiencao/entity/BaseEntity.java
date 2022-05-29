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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
