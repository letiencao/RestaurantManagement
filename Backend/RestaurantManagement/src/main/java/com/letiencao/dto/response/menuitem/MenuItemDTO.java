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
}
