package com.letiencao.converter;

import org.springframework.stereotype.Component;

import com.letiencao.dto.response.order.OrderDTO;
import com.letiencao.entity.OrderEntity;

@Component
public class OrderConverter {

	public OrderDTO toDTO(OrderEntity orderEntity) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(orderEntity.getId());
		orderDTO.setCreatedDate(orderEntity.getCreatedDate());
		orderDTO.setCreatedBy(orderEntity.getCreatedBy());
		orderDTO.setModifiedDate(orderEntity.getModifiedDate());
		orderDTO.setModifiedBy(orderEntity.getModifiedBy());
		orderDTO.setStatus(orderEntity.getStatus());

		
		return orderDTO;
		
	}
}
