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
import com.letiencao.dto.request.reservation.ReservationInsertionRequest;
import com.letiencao.dto.request.reservationdetails.ReservationDetailsInsertionRequest;
import com.letiencao.dto.response.HTTPResponse;
import com.letiencao.dto.response.reservation.ReservationDTO;
import com.letiencao.entity.CustomerEntity;
import com.letiencao.entity.ReservationDetailsEntity;
import com.letiencao.entity.ReservationEntity;
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
		// Kiem tra xem ban do da duoc dat chua thong qua
		// expectedDate,tableSeatingId,caseId
		// Neu ma tat ca deu OK thi insert
		try {

			CustomerEntity customerEntity = customerRepository.findById(reservationInsertionRequest.getCustomerId());
			List<Integer> tableSeatingIds = reservationInsertionRequest.getTableSeatingIds();
			if (customerEntity != null && isValidTableSeating(reservationInsertionRequest.getTableSeatingIds())
					&& isValidExpectedDate(reservationInsertionRequest.getExpectedDate())
					&& checkValidReservation(reservationInsertionRequest) == tableSeatingIds.size()) {
				// Set full data for reservationEntity
				ReservationEntity reservationEntity = reservationConverter.toEntity(reservationInsertionRequest);
				reservationEntity.setCustomerEntity(customerEntity);
				reservationEntity.setExpectedDate(reservationInsertionRequest.getExpectedDate());
				// insert reservationEntity into database
				reservationEntity = reservationRepository.save(reservationEntity);

				for (int i = 0; i < tableSeatingIds.size(); i++) {
					// Set full data for reservationDetailsInsertionRequest
					ReservationDetailsInsertionRequest reservationDetailsInsertionRequest = new ReservationDetailsInsertionRequest(
							tableSeatingIds.get(i), reservationEntity.getId(), reservationInsertionRequest.getCaseId(),
							reservationInsertionRequest.getExpectedDate());
					// convert reservationDetailsInsertionRequest to reservationDetailsEntity
					ReservationDetailsEntity reservationDetailsEntity = reservationDetailsConverter
							.toEntity(reservationDetailsInsertionRequest);
					// Set full data for reservationDetailsEntity
					reservationDetailsEntity
							.setTableSeatingEntity(tableSeatingRepository.findById(tableSeatingIds.get(i)));
					reservationDetailsEntity.setReservationEntity(reservationEntity);
					// Insert reservationDetailsEntity into database
					reservationDetailsRepository.save(reservationDetailsEntity);

				}
				return new HTTPResponse<ReservationDTO>("The new reservation has been inserted", ConstantValues.CODE_201, reservationConverter.toDTO(reservationEntity));
			} else if (customerEntity == null) {
				return new HTTPResponse<ReservationDTO>(
						"The customer has not existed! Add this customer into database now!", ConstantValues.CODE_200, null);
			} else if (!isValidTableSeating(reservationInsertionRequest.getTableSeatingIds())) {
				return new HTTPResponse<ReservationDTO>("Table has not existed.", ConstantValues.CODE_200, null);
			} else if (!isValidExpectedDate(reservationInsertionRequest.getExpectedDate())) {
				return new HTTPResponse<ReservationDTO>("Expected Date must be greater than or equal long date today!",
						ConstantValues.CODE_200, null);
			}
		} catch (Exception e) {
			System.out.println("Exception ReservationService Insert: " + e.getMessage());
		}

		return new HTTPResponse<ReservationDTO>("This case of this table has been reserved", ConstantValues.CODE_200, null);

	}

	private int checkValidReservation(ReservationInsertionRequest reservationInsertionRequest) {
		int check = 0;
		List<Integer> tableSeatingIds = reservationInsertionRequest.getTableSeatingIds();
		for (int i = 0; i < tableSeatingIds.size(); i++) {
			ReservationDetailsEntity reservationDetailsEntity = reservationDetailsRepository
					.findExistedReservationDetails(tableSeatingIds.get(i),
							reservationInsertionRequest.getExpectedDate(), reservationInsertionRequest.getCaseId());
			// Neu reservation details == null || != null nhung da bi cancelled thi OK
			if (reservationDetailsEntity == null || (reservationDetailsEntity != null
					&& reservationRepository.findById(reservationDetailsEntity.getReservationEntity().getId())
							.getStatus() == ReservationEnum.CANCELED.ordinal() + 1)) {

				// OK
				check++;
			}
		}
		return check;
	}

	public boolean isValidTableSeating(List<Integer> tableSeatingIds) {
		for (int i = 0; i < tableSeatingIds.size(); i++) {
			if (tableSeatingRepository.findById(tableSeatingIds.get(i)) == null) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidExpectedDate(Long expectedDate) {
		try {
			SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = (Date) dtf.parse(dtf.format(System.currentTimeMillis()));
			long currentLongDate = date.getTime();
			if (expectedDate >= currentLongDate) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public ReservationEntity setDataForReservationEntity(ReservationEntity reservationEntity) {
		reservationEntity.setCreatedBy(ConstantValues.CREATED_BY);
		reservationEntity.setCreatedDate(System.currentTimeMillis());
		reservationEntity.setStatus(ReservationEnum.CONFIRMED.ordinal() + 1);
		return reservationEntity;
	}

}
