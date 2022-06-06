package com.letiencao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@EnableAutoConfiguration(exclude = { //
//		DataSourceAutoConfiguration.class, //
//		DataSourceTransactionManagerAutoConfiguration.class, //
//		HibernateJpaAutoConfiguration.class })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
// 		ApplicationContext context = SpringApplication.run(Application.class, args);
// 		IRoleService roleService = context.getBean(RoleService.class);
// 		IUserService userService = context.getBean(UserService.class);
// 		ICustomerService customerService = context.getBean(CustomerService.class);
// 		ITableSeatingService tableSeatingService = context.getBean(TableSeatingService.class);
// 		IReservationService reservationService = context.getBean(ReservationService.class);
// 		UserRepository userRepository = context.getBean(UserRepository.class);
// 		IOrderService orderService = context.getBean(OrderService.class);

// 		RoleInsertionRequest roleInsertionRequest = new RoleInsertionRequest();
// 		roleInsertionRequest.setName("Admin");
// 		roleService.insertOne(roleInsertionRequest);

// 		List<Integer> roleIds = new ArrayList<Integer>();
// 		roleIds.add(1);
// //		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
// //		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
// //		try {
// //			Long s = simpleDateFormat.parse("14/02/2022 00:00:00").getTime();
// //			Date date = new Date(s + 86400000 - 1);
// //			System.out.println("S == " + s);
// //			System.out.println("S1 == " + simpleDateFormat.format(date));
// //		} catch (ParseException e) {
// //			// TODO Auto-generated catch block
// //			e.printStackTrace();
// //		}

// //		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
// //		try {
// //			String date = simpleDateFormat1.format(new Date());
// //			System.out.println("Date == " + date);
// ////			System.out.println("Date == " + new Date());
// //
// //			Long s = simpleDateFormat1.parse(date).getTime();
// ////			
// //			s = s + 86399999;
// //
// //			System.out.println("Date + 1 == " + simpleDateFormat1.format(s));
// //
// //		} catch (Exception e) {
// //			// TODO Auto-generated catch block
// //			e.printStackTrace();
// //		}

// //		Date date = new SimpleDateFormat("03/03/2022 00:00:00");
// //		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
// //		System.out.println("Date = " + format.format(date));

// //		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
// //		try {
// //			String date = simpleDateFormat1.format(System.currentTimeMillis());
// ////			String s = simpleDateFormat1.parse(date);
// //			// s là mốc 0h ngày hiện tại (mili giây)
// ////			s = s + 86399999;// 86400000 là số mili giây của 1 ngày // Cộng 86399999 để không trôi sang ngày
// //			// hôm sau
// //			System.out.println("date = " + new Date(date));
// //
// //		} catch (Exception e) {
// //			// TODO Auto-generated catch block
// //			e.printStackTrace();
// //		}

// 		UserInsertionRequest userInsertionRequest = new UserInsertionRequest();
// 		userInsertionRequest.setFirstName("Cao");
// 		userInsertionRequest.setLastName("Le");
// 		userInsertionRequest.setCitizenId("123456789124");
// 		userInsertionRequest.setBirthday(101L);
// 		userInsertionRequest.setEmail("caole28072000@gmail.com");
// 		userInsertionRequest.setPassword("123123");
// 		userInsertionRequest.setPhoneNumber("0982578395");
// 		userInsertionRequest.setRoleIds(roleIds);
// 		userService.insertOne(userInsertionRequest);
// 		// Insert Customer's data samples
// 		CustomerInsertionRequest customerInsertionRequest1 = new CustomerInsertionRequest();
// 		customerInsertionRequest1.setFirstName("Cuong");
// 		customerInsertionRequest1.setLastName("Chau Viet");
// 		customerInsertionRequest1.setPhoneNumber("0999899899");
// 		customerService.insertOne(customerInsertionRequest1);

// //		CustomerInsertionRequest customerInsertionRequest2 = new CustomerInsertionRequest("Trung", "Hoang Chi",
// //				"0982578392");
// //		customerService.insertOne(customerInsertionRequest2);
// //
// //		CustomerInsertionRequest customerInsertionRequest3 = new CustomerInsertionRequest("Duc", "Tran Tien",
// //				"0982578393");
// //		customerService.insertOne(customerInsertionRequest3);
// //		CustomerInsertionRequest customerInsertionRequest4 = new CustomerInsertionRequest("Anh", "Nguyen Viet",
// //				"0982578394");
// //		customerService.insertOne(customerInsertionRequest4);
// //		CustomerInsertionRequest customerInsertionRequest5 = new CustomerInsertionRequest("Tai", "Bui Ngoc",
// //				"0982578395");
// //		customerService.insertOne(customerInsertionRequest5);
// //		CustomerInsertionRequest customerInsertionRequest6 = new CustomerInsertionRequest("Tien", "Vu Dai",
// //				"0982578396");
// //		customerService.insertOne(customerInsertionRequest6);
// //		CustomerInsertionRequest customerInsertionRequest7 = new CustomerInsertionRequest("Cuong", "Chau Viet",
// //				"0982578397");
// //		customerService.insertOne(customerInsertionRequest7);

// 		TableSeatingInsertionRequest tableSeatingInsertionRequest = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest.setName("101");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest);
// 		TableSeatingInsertionRequest tableSeatingInsertionRequest1 = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest1.setName("102");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest1);

// 		TableSeatingInsertionRequest tableSeatingInsertionRequest2 = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest2.setName("103");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest2);
// 		TableSeatingInsertionRequest tableSeatingInsertionRequest3 = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest3.setName("104");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest3);

// 		TableSeatingInsertionRequest tableSeatingInsertionRequest4 = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest4.setName("105");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest4);
// 		TableSeatingInsertionRequest tableSeatingInsertionRequest5 = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest5.setName("106");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest5);

// 		TableSeatingInsertionRequest tableSeatingInsertionRequest6 = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest6.setName("107");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest6);
// 		TableSeatingInsertionRequest tableSeatingInsertionRequest7 = new TableSeatingInsertionRequest();
// 		tableSeatingInsertionRequest7.setName("108");
// 		tableSeatingService.insertOne(tableSeatingInsertionRequest7);
// 		try {
// 			String str_date = "29/04/2022";
// 			DateFormat formatter;
// 			Date date;
// 			formatter = new SimpleDateFormat("dd/MM/yyyy");
// 			date = (Date) formatter.parse(str_date);
// 			long longDate = date.getTime();

// 			List<Integer> list = new ArrayList<Integer>();
// 			list.add(1);
// 			list.add(2);
// 			ReservationInsertionRequest reservationInsertionRequest = new ReservationInsertionRequest();
// 			reservationInsertionRequest.setCustomerId(1);
// //			reservationInsertionRequest.setTableSeatingIds(list);
// 			reservationInsertionRequest.setDeposit(new BigDecimal(500000));
// 			reservationInsertionRequest.setNote("");
// 			reservationInsertionRequest.setExpectedDate(1651251600000L);
// //			reservationInsertionRequest.setCaseId(1);
// 			reservationService.insertOne(reservationInsertionRequest);
// 			List<Integer> list1 = new ArrayList<Integer>();
// 			list1.add(1);
// 			list1.add(2);
// 			ReservationInsertionRequest reservationInsertionRequest1 = new ReservationInsertionRequest();

// 			reservationInsertionRequest.setCustomerId(1);
// //			reservationInsertionRequest.setTableSeatingIds(list1);
// 			reservationInsertionRequest.setDeposit(new BigDecimal(500000));
// 			reservationInsertionRequest.setNote("");
// 			reservationInsertionRequest.setExpectedDate(1651251600000L);
// //			reservationInsertionRequest.setCaseId(2);
// 			reservationService.insertOne(reservationInsertionRequest1);
			
// 			AssignTableRequest assignTableRequest = new AssignTableRequest();
// 			assignTableRequest.setReservationId(1);
// 			List<Integer> integers = new ArrayList<Integer>();
// 			integers.add(1);
// 			integers.add(2);
// 			assignTableRequest.setTableSeatingIds(integers);
// 			reservationService.assignTable(assignTableRequest);
// 			System.out.println("KHÔNG TRY CATCH");

// //			System.out.println("Today is " + longDate);
// //			System.out.println("Hello = "+System.currentTimeMillis());
// 		} catch (ParseException e) {
// 			System.out.println("Exception :" + e);
// 		}

// 		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
// 		System.out.println(dtf.format(System.currentTimeMillis()));
// 		System.out.println("===========");
// 		Date date = (Date) dtf.parse(dtf.format(System.currentTimeMillis()));
// 		long longDate = date.getTime();
// 		System.out.println("Long date = " + longDate);
		
// 		List<Integer> tableSeatingIds = new ArrayList<Integer>();
// 		tableSeatingIds.add(1);
		
// 		OrderInsertionRequest orderInsertionRequest = new OrderInsertionRequest();
// 		orderInsertionRequest.setUserId(1);
// 		orderInsertionRequest.setTableSeatingIds(tableSeatingIds);
// 		orderService.insertOne(orderInsertionRequest);
		
// //		List<Integer> tableSeatingIds1 = new ArrayList<Integer>();
// //		tableSeatingIds1.add(2);
// //		tableSeatingIds1.add(3);
// //		
// //		
// //		
// //		OrderInsertionRequest orderInsertionRequest1 = new OrderInsertionRequest();
// //		orderInsertionRequest1.setUserId(1);
// //		orderInsertionRequest1.setTableSeatingIds(tableSeatingIds1);
// //		orderService.insertOne(orderInsertionRequest1);
// //		System.out.println("USER = " + userRepository.findByEmail("caole28072000@gmail.com"));
		
		
// 		Long longDateNow = System.currentTimeMillis();
// 		System.out.println("So ngay tinh tu 1/1/1970 = " + longDateNow/86400000);
	}
}
