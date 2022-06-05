package com.letiencao.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@ToString
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

//	@ManyToMany(fetch = FetchType.EAGER) // Show toan bo data ke ca phan JOIN// LAZY : Ben trong da co data day du,nhung
//	// chi khi goi truc tiep,moi show hang
//	@JoinTable(name = "reservation_table_seating", // Táº¡o ra má»™t join Table tÃªn lÃ  "reservation_table_seating"
//			joinColumns = @JoinColumn(name = "reservation_id"), // TRong Ä‘Ã³, khÃ³a ngoáº¡i chÃ­nh lÃ  reservation_id trá»� tá»›i
//			// class hiá»‡n táº¡i (ReservationEntity)
//			inverseJoinColumns = @JoinColumn(name = "table_seating_id")) // KhÃ³a ngoáº¡i thá»© 2 trá»� tá»›i thuá»™c tÃ­nh
//	// table_seating_id// (TableSeatingEntity))
//	private List<TableSeatingEntity> tableSeatingEntities;
}
