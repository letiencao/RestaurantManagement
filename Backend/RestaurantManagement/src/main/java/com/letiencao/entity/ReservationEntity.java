package com.letiencao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "reservation")

public class ReservationEntity extends BaseEntity {

	@Column(name = "deposit", columnDefinition = "DECIMAL")
	private BigDecimal deposit;

	@Column(name = "note", columnDefinition = "TEXT")
	private String note;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customerEntity;
	@Column(name = "expected_date", columnDefinition = "bigint")
	private long expectedDate;

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public long getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(long expectedDate) {
		this.expectedDate = expectedDate;
	}
//	@ManyToMany(fetch = FetchType.EAGER) // Show toan bo data ke ca phan JOIN// LAZY : Ben trong da co data day du,nhung
//	// chi khi goi truc tiep,moi show hang
//	@JoinTable(name = "reservation_table_seating", // Táº¡o ra má»™t join Table tÃªn lÃ  "reservation_table_seating"
//			joinColumns = @JoinColumn(name = "reservation_id"), // TRong Ä‘Ã³, khÃ³a ngoáº¡i chÃ­nh lÃ  reservation_id trá»� tá»›i
//			// class hiá»‡n táº¡i (ReservationEntity)
//			inverseJoinColumns = @JoinColumn(name = "table_seating_id")) // KhÃ³a ngoáº¡i thá»© 2 trá»� tá»›i thuá»™c tÃ­nh
//	// table_seating_id// (TableSeatingEntity))
//	private List<TableSeatingEntity> tableSeatingEntities;
}
