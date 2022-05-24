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
import com.letiencao.dto.request.tableseating.TableSeatingInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.tableseating.TableSeatingDTO;
import com.letiencao.service.ITableSeatingService;

@RestController
@RequestMapping("/api/v1/table-seatings")
public class TableSeatingAPI {

	@Autowired
	private ITableSeatingService tableSeatingService;

	@PostMapping
	public ResponseEntity<HTTPResponse<TableSeatingDTO>> insertTableSeating(
			@Valid @RequestBody TableSeatingInsertionRequest tableSeatingInsertionRequest) {
		return new ResponseEntity<HTTPResponse<TableSeatingDTO>>(
				tableSeatingService.insertOne(tableSeatingInsertionRequest), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<HTTPResponse<List<TableSeatingDTO>>> findAll() {
		HTTPResponse<List<TableSeatingDTO>> httpResponse = new HTTPResponse<List<TableSeatingDTO>>("OK",
				ConstantValues.CODE_200, tableSeatingService.findAvaibleTables());
		return new ResponseEntity<HTTPResponse<List<TableSeatingDTO>>>(httpResponse, HttpStatus.OK);
	}

}
