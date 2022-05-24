package com.letiencao.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letiencao.constant.ConstantValues;
import com.letiencao.converter.ReservationConverter;
import com.letiencao.converter.ReservationDetailsConverter;
import com.letiencao.dto.request.reservation.AssignTableRequest;
import com.letiencao.dto.request.reservation.ReservationInsertionRequest;
import com.letiencao.dto.request.reservationdetails.ReservationDetailsInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.reservation.ReservationDTO;
import com.letiencao.entity.CustomerEntity;
import com.letiencao.entity.ReservationDetailsEntity;
import com.letiencao.entity.ReservationEntity;
import com.letiencao.entity.TableSeatingEntity;
import com.letiencao.enumerated.ReservationEnum;
import com.letiencao.repository.CustomerRepository;
import com.letiencao.repository.ReservationDetailsRepository;
import com.letiencao.repository.ReservationRepository;
import com.letiencao.repository.TableSeatingRepository;
import com.letiencao.service.IReservationService;

@Service
public class ReservationService implements IReservationService {

	@Autowired
	private ReservationConverter reservationConverter;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReservationDetailsRepository reservationDetailsRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TableSeatingRepository tableSeatingRepository;
	@Autowired
	private ReservationDetailsConverter reservationDetailsConverter;

	@Override
	public HTTPResponse<ReservationDTO> insertOne(ReservationInsertionRequest reservationInsertionRequest) {
		// Kiem tra xem ban do da duoc dat chua thong qua status
		try {

			CustomerEntity customerEntity = customerRepository.findById(reservationInsertionRequest.getCustomerId());
			if (customerEntity != null) {
				// Set full data for reservationEntity
				ReservationEntity reservationEntity = reservationConverter.toEntity(reservationInsertionRequest);
				reservationEntity.setCustomerEntity(customerEntity);
				reservationEntity.setExpectedDate(reservationInsertionRequest.getExpectedDate());
				reservationEntity.setStatus(ConstantValues.CONFIRMED_RESERVATION);
				// insert reservationEntity into database
				reservationEntity = reservationRepository.save(reservationEntity);
				return new HTTPResponse<ReservationDTO>("Them 1 ban ghi dat ban thanh cong", ConstantValues.CODE_201,
						reservationConverter.toDTO(reservationEntity));
			}
		} catch (Exception e) {
			System.out.println("Exception ReservationService Insert: " + e.getMessage());
		}
		return new HTTPResponse<ReservationDTO>("Thong tin khach hang chua ton tai!", ConstantValues.CODE_200, null);
	}

	// Kiem tra tat ca cac ban phai free thi ok
	private int checkValidReservation(List<Integer> tableSeatingIds) {
		int check = 0;
		for (int i = 0; i < tableSeatingIds.size(); i++) {
//			ReservationDetailsEntity reservationDetailsEntity = reservationDetailsRepository
//					.findExistedReservationDetails(tableSeatingIds.get(i),
//							reservationInsertionRequest.getExpectedDate(), reservationInsertionRequest.getCaseId());
//			// Neu reservation details == null || != null nhung da bi cancelled thi OK
//			if (reservationDetailsEntity == null || (reservationDetailsEntity != null
//					&& reservationRepository.findById(reservationDetailsEntity.getReservationEntity().getId())
//							.getStatus() == ReservationEnum.CANCELED.ordinal() + 1)) {
//
//				// OK
//				check++;
//			}
			if (tableSeatingRepository.findById(tableSeatingIds.get(i)).getStatus() == ConstantValues.FREE_TABLE) {
				check++;
			}
		}
		return check;
	}

	// Kiem tra cac tables co ton tai chua ?
	public boolean isValidTableSeating(List<Integer> tableSeatingIds) {
		for (int i = 0; i < tableSeatingIds.size(); i++) {
			if (tableSeatingRepository.findById(tableSeatingIds.get(i)) == null) {
				return false;
			}
		}
		return true;
	}

//	public boolean isValidExpectedDate(Long expectedDate) {
//		try {
//			SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
//			Date date = (Date) dtf.parse(dtf.format(System.currentTimeMillis()));
//			long currentLongDate = date.getTime();
//			if (expectedDate >= currentLongDate) {
//				return true;
//			}
//		} catch (Exception e) {
//			return false;
//		}
//		return false;
//	}

	public ReservationEntity setDataForReservationEntity(ReservationEntity reservationEntity) {
		reservationEntity.setCreatedBy(ConstantValues.CREATED_BY);
		reservationEntity.setCreatedDate(System.currentTimeMillis());
		reservationEntity.setStatus(ReservationEnum.CONFIRMED.ordinal() + 1);
		return reservationEntity;
	}

	@Override
	public HTTPResponse<Boolean> assignTable(AssignTableRequest assignTableRequest) {
		List<Integer> tableSeatingIds = assignTableRequest.getTableSeatingIds();
		if (isValidTableSeating(tableSeatingIds)
				&& reservationRepository.findById(assignTableRequest.getReservationId()) != null
				&& checkValidReservation(tableSeatingIds) == tableSeatingIds.size()) {

			for (int i = 0; i < tableSeatingIds.size(); i++) {
				//update status of table
				TableSeatingEntity tableSeatingEntity = tableSeatingRepository.findById(tableSeatingIds.get(i));
				tableSeatingEntity.setModifiedBy(ConstantValues.CREATED_BY);
				tableSeatingEntity.setModifiedDate(System.currentTimeMillis());
				tableSeatingEntity.setStatus(ConstantValues.RESERVED_TABLE);
				tableSeatingRepository.save(tableSeatingEntity);
				//insert reservation details
				ReservationDetailsEntity reservationDetailsEntity = new ReservationDetailsEntity();
				reservationDetailsEntity.setReservationEntity(reservationRepository.findById(assignTableRequest.getReservationId()));
				reservationDetailsEntity.setTableSeatingEntity(tableSeatingRepository.findById(tableSeatingIds.get(i)));
				reservationDetailsEntity = reservationDetailsRepository.save(reservationDetailsEntity);
				
			}
			return new HTTPResponse<Boolean>("OK", ConstantValues.CODE_201, true);

		}else {
			return new HTTPResponse<Boolean>("Failed", ConstantValues.CODE_200, false);
		}
//		return null;
	}

}
