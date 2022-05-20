package com.letiencao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letiencao.constant.ConstantValues;
import com.letiencao.converter.OrderConverter;
import com.letiencao.dto.request.order.OrderInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.order.OrderDTO;
import com.letiencao.entity.OrderEntity;
import com.letiencao.entity.UserEntity;
import com.letiencao.repository.OrderRepository;
import com.letiencao.repository.TableSeatingRepository;
import com.letiencao.repository.UserRepository;
import com.letiencao.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderConverter orderConverter;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TableSeatingRepository tableSeatingRepository;

	@Override
	public HTTPResponse<List<OrderDTO>> insertOne(OrderInsertionRequest orderInsertionRequest) {
		List<Integer> tableSeatingIds = orderInsertionRequest.getTableSeatingIds();
		List<OrderEntity> orderEntities = new ArrayList<OrderEntity>();
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		UserEntity userEntity = userRepository.findById(orderInsertionRequest.getUserId());
		if (userEntity != null && isValidTableSeatingId(tableSeatingIds) && isCheckedOutTables(tableSeatingIds)) {

			for (int i = 0; i < tableSeatingIds.size(); i++) {
				OrderEntity orderEntity = new OrderEntity();
				orderEntity.setCreatedDate(System.currentTimeMillis());
				orderEntity.setCreatedBy(ConstantValues.CREATED_BY);
				orderEntity.setStatus(ConstantValues.CHECKED_IN_ORDER);
				orderEntity.setTableSeatingEntity(tableSeatingRepository.findById(tableSeatingIds.get(i)));
				orderEntity.setUserEntity(userEntity);
				orderEntity = orderRepository.save(orderEntity);
				orderEntities.add(orderEntity);

			}

			for (int i = 0; i < tableSeatingIds.size(); i++) {
				OrderDTO orderDTO = orderConverter.toDTO(orderEntities.get(i));
				orderDTO.setTableSeatingId(tableSeatingIds.get(i));
				orderDTO.setUserId(userEntity.getId());
				orderDTOs.add(orderDTO);
			}
			return new HTTPResponse<List<OrderDTO>>("The new order has been inserted", ConstantValues.CODE_201,
					orderDTOs);

		} else if (userEntity == null) {
			return new HTTPResponse<List<OrderDTO>>("The user id is invalid", ConstantValues.CODE_200, null);
		} else if (!isValidTableSeatingId(tableSeatingIds)) {
			return new HTTPResponse<List<OrderDTO>>("The table seating id has not existed", ConstantValues.CODE_200,
					null);
		} else {
			return new HTTPResponse<List<OrderDTO>>("The table seating id has not checked out", ConstantValues.CODE_200,
					null);
		}

	}

//	public List<OrderDTO> toDTOList(List<Integer> tableSeatingIds,List<OrderEntity> orderEntities,){
//		for (int i = 0; i < tableSeatingIds.size(); i++) {
//			OrderDTO orderDTO = orderConverter.toDTO(orderEntities.get(i));
//			orderDTO.setTableSeatingId(tableSeatingIds.get(i));
//			orderDTO.setUserId(userEntity.getId());
//			orderDTOs.add(orderDTO);
//		}
//	}

	public boolean isCheckedOutTables(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (orderRepository.findByTableSeatingIdAndStatus(list.get(i)) != null) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidTableSeatingId(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (tableSeatingRepository.findById(list.get(i)) == null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<OrderDTO> findAll() {
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();

		List<OrderEntity> orderEntities = orderRepository.findAll();
		for (int i = 0; i < orderEntities.size(); i++) {
			OrderEntity orderEntity = orderEntities.get(i);
			OrderDTO orderDTO = orderConverter.toDTO(orderEntity);
			orderDTO.setTableSeatingId(orderEntity.getTableSeatingEntity().getId());
			orderDTO.setUserId(orderEntity.getUserEntity().getId());
			orderDTO.setTableSeatingName(orderEntities.get(i).getTableSeatingEntity().getName());
			orderDTOs.add(orderDTO);
		}
		return orderDTOs;
	}

}
