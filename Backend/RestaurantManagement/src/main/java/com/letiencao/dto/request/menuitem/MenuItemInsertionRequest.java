package com.letiencao.dto.request.menuitem;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class MenuItemInsertionRequest {
	@NotEmpty(message = "Name must not be empty")
	private String name;
	@Min(value = 1, message = "The price must be greater than 0")
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
