package com.letiencao.api.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letiencao.constant.ConstantValues;
import com.letiencao.dto.request.order.OrderInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.order.OrderDTO;
import com.letiencao.service.IOrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderAPI {
	@Autowired
	private IOrderService orderService;

	@PostMapping
	public ResponseEntity<HTTPResponse<List<OrderDTO>>> insertOrder(
			@Valid @RequestBody OrderInsertionRequest orderInsertionRequest) {
		return new ResponseEntity<HTTPResponse<List<OrderDTO>>>(orderService.insertOne(orderInsertionRequest),
				HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<HTTPResponse<List<OrderDTO>>> findAllOrders() {
		HTTPResponse<List<OrderDTO>> httpResponse = new HTTPResponse<List<OrderDTO>>("OK", ConstantValues.CODE_200,
				orderService.findAll());
		return new ResponseEntity<HTTPResponse<List<OrderDTO>>>(httpResponse, HttpStatus.OK);

	}

}
