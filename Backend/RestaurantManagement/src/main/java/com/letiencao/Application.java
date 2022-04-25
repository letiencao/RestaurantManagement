package com.letiencao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.letiencao.dto.request.role.RoleInsertionRequest;
import com.letiencao.dto.request.user.UserInsertionRequest;
import com.letiencao.repository.UserRepository;
import com.letiencao.service.IRoleService;
import com.letiencao.service.IUserService;
import com.letiencao.service.impl.RoleService;
import com.letiencao.service.impl.UserService;

@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class })
@ComponentScan(basePackages = { "com.letiencao" })
//@EnableAutoConfiguration(exclude = { //
//		DataSourceAutoConfiguration.class, //
//		DataSourceTransactionManagerAutoConfiguration.class, //
//		HibernateJpaAutoConfiguration.class })
public class Application {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		IRoleService roleService = context.getBean(RoleService.class);
		IUserService userService = context.getBean(UserService.class);
//		ICustomerService customerService = context.getBean(CustomerService.class);
//		ITableSeatingService tableSeatingService = context.getBean(TableSeatingService.class);
//		IReservationService reservationService = context.getBean(ReservationService.class);
		UserRepository userRepository = context.getBean(UserRepository.class);

		RoleInsertionRequest roleInsertionRequest = new RoleInsertionRequest("Admin");
		roleService.insertOne(roleInsertionRequest);
		RoleInsertionRequest roleInsertionRequest1 = new RoleInsertionRequest("Cashier");
		roleService.insertOne(roleInsertionRequest1);
		RoleInsertionRequest roleInsertionRequest2 = new RoleInsertionRequest("Staff");
		roleService.insertOne(roleInsertionRequest2);
		RoleInsertionRequest roleInsertionRequest3 = new RoleInsertionRequest("Chef");
		roleService.insertOne(roleInsertionRequest3);

		List<Integer> roleIds = new ArrayList<Integer>();
		roleIds.add(1);
		roleIds.add(2);
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			Long s = simpleDateFormat.parse("14/02/2022 00:00:00").getTime();
//			Date date = new Date(s + 86400000 - 1);
//			System.out.println("S == " + s);
//			System.out.println("S1 == " + simpleDateFormat.format(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			String date = simpleDateFormat1.format(new Date());
//			System.out.println("Date == " + date);
////			System.out.println("Date == " + new Date());
//
//			Long s = simpleDateFormat1.parse(date).getTime();
////			
//			s = s + 86399999;
//
//			System.out.println("Date + 1 == " + simpleDateFormat1.format(s));
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		Date date = new SimpleDateFormat("03/03/2022 00:00:00");
//		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println("Date = " + format.format(date));

		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String date = simpleDateFormat1.format(1646499600000L);
//			String s = simpleDateFormat1.parse(date);
			// s là mốc 0h ngày hiện tại (mili giây)
//			s = s + 86399999;// 86400000 là số mili giây của 1 ngày // Cộng 86399999 để không trôi sang ngày
			// hôm sau
			System.out.println("date = " + date);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UserInsertionRequest userInsertionRequest = new UserInsertionRequest("Cao", "Le", "123456789124", 101L,
				"caole28072000@gmail.com", "123123", "0982578395", roleIds);
		userService.insertOne(userInsertionRequest);
		// Insert Customer's data samples
//		CustomerInsertionRequest customerInsertionRequest1 = new CustomerInsertionRequest("Cao", "Le Tien",
//				"0982578391", 110, "caole28072000@gmail.com", "123456789012");
//		customerService.insertOne(customerInsertionRequest1);
//
//		CustomerInsertionRequest customerInsertionRequest2 = new CustomerInsertionRequest("Trung", "Hoang Chi",
//				"0982578392", 110, "caole28072001@gmail.com", "123456789013");
//		customerService.insertOne(customerInsertionRequest2);
//
//		CustomerInsertionRequest customerInsertionRequest3 = new CustomerInsertionRequest("Duc", "Tran Tien",
//				"0982578393", 110, "caole28072002@gmail.com", "123456789014");
//		customerService.insertOne(customerInsertionRequest3);
//		CustomerInsertionRequest customerInsertionRequest4 = new CustomerInsertionRequest("Anh", "Nguyen Viet",
//				"0982578394", 110, "caole28072003@gmail.com", "123456789015");
//		customerService.insertOne(customerInsertionRequest4);
//		CustomerInsertionRequest customerInsertionRequest5 = new CustomerInsertionRequest("Tai", "Bui Ngoc",
//				"0982578395", 110, "caole28072004@gmail.com", "123456789016");
//		customerService.insertOne(customerInsertionRequest5);
//		CustomerInsertionRequest customerInsertionRequest6 = new CustomerInsertionRequest("Tien", "Vu Dai",
//				"0982578396", 110, "caole28072005@gmail.com", "123456789017");
//		customerService.insertOne(customerInsertionRequest6);
//		CustomerInsertionRequest customerInsertionRequest7 = new CustomerInsertionRequest("Cuong", "Chau Viet",
//				"0982578397", 110, "caole28072006@gmail.com", "123456789018");
//		customerService.insertOne(customerInsertionRequest7);
//
//		TableSeatingInsertionRequest tableSeatingInsertionRequest = new TableSeatingInsertionRequest("1", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest);
//		TableSeatingInsertionRequest tableSeatingInsertionRequest1 = new TableSeatingInsertionRequest("2", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest1);
//
//		TableSeatingInsertionRequest tableSeatingInsertionRequest2 = new TableSeatingInsertionRequest("3", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest2);
//		TableSeatingInsertionRequest tableSeatingInsertionRequest3 = new TableSeatingInsertionRequest("4", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest3);
//
//		TableSeatingInsertionRequest tableSeatingInsertionRequest4 = new TableSeatingInsertionRequest("5", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest4);
//		TableSeatingInsertionRequest tableSeatingInsertionRequest5 = new TableSeatingInsertionRequest("6", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest5);
//
//		TableSeatingInsertionRequest tableSeatingInsertionRequest6 = new TableSeatingInsertionRequest("7", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest6);
//		TableSeatingInsertionRequest tableSeatingInsertionRequest7 = new TableSeatingInsertionRequest("8", 6);
//		tableSeatingService.insertOne(tableSeatingInsertionRequest7);
//
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		ReservationInsertionRequest reservationInsertionRequest = new ReservationInsertionRequest(1, list,
//				new BigDecimal(500000), "", 4, 1646499600000L);
//		reservationService.insertOne(reservationInsertionRequest);
//		System.out.println("==================================================================");
//		List<Integer> list1 = new ArrayList<Integer>();
//		list1.add(1);
//		list1.add(2);
//		ReservationInsertionRequest reservationInsertionRequest1 = new ReservationInsertionRequest(1, list1,
//				new BigDecimal(500000), "", 4, 1646499600000L);
//		reservationService.insertOne(reservationInsertionRequest1);

//		System.out.println("USER = " + userRepository.findByEmail("caole28072000@gmail.com"));
	}
}
