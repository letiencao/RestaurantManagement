package com.letiencao.dto.request.menuitem;

import java.math.BigDecimal;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

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
