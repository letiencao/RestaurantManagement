package com.letiencao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class UserEntity extends BaseEntity {
	@Column(name = "first_name", columnDefinition = "nvarchar(20)")
	private String firstName;
	@Column(name = "last_name", columnDefinition = "nvarchar(20)")
	private String lastName;
	@Column(name = "citizen_id", columnDefinition = "varchar(12)")
	private String citizenId;
	@Column(name = "birthday", columnDefinition = "BIGINT")
	private Long birthday;
	@Column(name = "email", columnDefinition = "nvarchar(50)")
	private String email;
	@Column(name = "password", columnDefinition = "TEXT")
	private String password;
	@Column(name = "phone_number", columnDefinition = "varchar(10)")
	private String phoneNumber;
	@ManyToMany(fetch = FetchType.EAGER) // Show toan bo data ke ca phan JOIN// LAZY : Ben trong da co data day du,nhung
											// chi khi goi truc tiep,moi show hang
	@JoinTable(name = "user_role", // Tạo ra một join Table tên là "user_role"
			joinColumns = @JoinColumn(name = "user_id"), // TRong đó, khóa ngoại chính là user_id trỏ tới class
															// hiện tại (UserEntity)
			inverseJoinColumns = @JoinColumn(name = "role_id") // Khóa ngoại thứ 2 trỏ tới thuộc tính role_id
																// (RoleEntity)
	)
	private List<RoleEntity> roleEntities;

//	@OneToMany(mappedBy = "user") // @OneToMany(cascade = CascadeType.ALL) Khi xoa Action thi toan bo history thuoc ve action do deu bi xoa o bang history
//	private List<HistoryEntity> historyEntities;
}
