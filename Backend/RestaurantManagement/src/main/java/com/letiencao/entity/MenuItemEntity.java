package com.letiencao.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "menu_item")


public class MenuItemEntity extends BaseEntity{
	@Column(name = "name", columnDefinition = "nvarchar(30)")
	private String name;
	@Column(name = "price", columnDefinition = "DECIMAL")
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
