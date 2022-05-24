package com.letiencao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letiencao.constant.ConstantValues;
import com.letiencao.converter.TableSeatingConverter;
import com.letiencao.dto.request.tableseating.TableSeatingInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.tableseating.TableSeatingDTO;
import com.letiencao.entity.TableSeatingEntity;
import com.letiencao.repository.TableSeatingRepository;
import com.letiencao.service.ITableSeatingService;

@Service
public class TableSeatingService implements ITableSeatingService {
	@Autowired
	private TableSeatingConverter tableSeatingConverter;
	@Autowired
	private TableSeatingRepository tableSeatingRepository;

	@Override
	public HTTPResponse<TableSeatingDTO> insertOne(TableSeatingInsertionRequest tableSeatingInsertionRequest) {
		if (findByName(tableSeatingInsertionRequest.getName()) == null) {
			TableSeatingEntity tableSeatingEntity = tableSeatingConverter.toEntity(tableSeatingInsertionRequest);
			tableSeatingEntity.setCreatedBy(ConstantValues.CREATED_BY);
			tableSeatingEntity.setCreatedDate(System.currentTimeMillis());
			tableSeatingEntity.setStatus(ConstantValues.FREE_TABLE);

			return new HTTPResponse<TableSeatingDTO>("The new table seating has been inserted", ConstantValues.CODE_201,
					tableSeatingConverter.toDTO(tableSeatingRepository.save(tableSeatingEntity)));
		}
		return new HTTPResponse<TableSeatingDTO>("The table seating name has existed", ConstantValues.CODE_200, null);
	}

	@Override
	public TableSeatingDTO findByName(String name) {
		TableSeatingEntity tableSeatingEntity = tableSeatingRepository.findByName(name);
		return tableSeatingEntity != null ? tableSeatingConverter.toDTO(tableSeatingEntity) : null;
	}

	@Override
	public List<TableSeatingDTO> findAll() {
		List<TableSeatingEntity> tableSeatingEntities = tableSeatingRepository.findAll();
		List<TableSeatingDTO> list = new ArrayList<TableSeatingDTO>();
		if(tableSeatingEntities != null) {
			for(int i = 0;i < tableSeatingEntities.size();i++) {
				list.add(tableSeatingConverter.toDTO(tableSeatingEntities.get(i)));
			}
		}
		return list;
	}

	@Override
	public List<TableSeatingDTO> findAvaibleTables() {
		List<TableSeatingEntity> list = tableSeatingRepository.findCheckedInTables();
		System.out.println("===============Size = " + list.size());
		List<TableSeatingDTO> tableSeatingDTOs = findAll();
		int size = tableSeatingDTOs.size();
		
		for(int i = 0;i < list.size();i++) {
			for(int j = 0;j < size;j++) {
				if(tableSeatingDTOs.get(j).getId() == list.get(i).getId()) {
					tableSeatingDTOs.remove(tableSeatingDTOs.get(j));
					size --;
				}
			}
		}
		return tableSeatingDTOs;
	}
	
	

}
