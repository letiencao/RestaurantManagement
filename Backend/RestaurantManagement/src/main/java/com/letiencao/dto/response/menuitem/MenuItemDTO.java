package com.letiencao.dto.response.menuitem;

import java.math.BigDecimal;

import com.letiencao.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class MenuItemDTO extends BaseDTO{

	private String name;
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
