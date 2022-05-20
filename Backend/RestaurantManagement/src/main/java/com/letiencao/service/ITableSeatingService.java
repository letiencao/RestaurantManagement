package com.letiencao.service;

import java.util.List;

import com.letiencao.dto.request.tableseating.TableSeatingInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.tableseating.TableSeatingDTO;

public interface ITableSeatingService {

	// Insert a table seating
	HTTPResponse<TableSeatingDTO> insertOne(TableSeatingInsertionRequest tableSeatingInsertionRequest);

	// Find a table seating by name
	TableSeatingDTO findByName(String name);
	
	// Find all table seatings
	
	List<TableSeatingDTO> findAll();
	// Tim cac ban con trong
	List<TableSeatingDTO> findAvaibleTables();

}
