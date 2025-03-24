package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomerDao;
import dao.EmployeeDao;
import dao.OfficeDao;
import dao.ProductDao;
import dao.StudioBookingDao;
import dao.StudioDao;

/*
 * rewrite from course instructions 
 * rewrite from scratch to understand completely.
 * @author: Crystal Hansen 
 * @Date 2020 05 27
 * macbookpro
 * */
public class SpringFactory {
	
	//this file will create the connection to the DAO class with the application context model
	private static ApplicationContext ctx;
	private static ProductDao productDao;
	private static EmployeeDao employeeDao;
	private static OfficeDao officeDao;
	private static CustomerDao customerDao;
	private static StudioDao studioDao;
	private static StudioBookingDao studioBookingDao;
	
	public static ProductDao getProductDao() {
	
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		productDao = (ProductDao) ctx.getBean("productDao");
		
		
		return productDao;
	}

	public static EmployeeDao getEmployeeDao() {
		
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		employeeDao = (EmployeeDao) ctx.getBean("employeeDao");
		
		
		return employeeDao;
	}
	public static OfficeDao getOfficeDao() {
		
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		officeDao = (OfficeDao) ctx.getBean("officeDao");
		
		
		return officeDao;
	}

	public static CustomerDao getCustomerDao() {
	
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		customerDao = (CustomerDao) ctx.getBean("customerDao");
		
		
		return customerDao;
	}

	
	public static StudioDao getStudioDao() {
		
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		studioDao = (StudioDao) ctx.getBean("studioDao");
		
		
		return studioDao;
	}

	public static StudioBookingDao getStudioBookingDao() {
		
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		studioBookingDao = (StudioBookingDao) ctx.getBean("studioBookingDao");
		
		
		return studioBookingDao;
	}

	
	//In the dao tests we had to call a transaction manager and its Template to implement the database call. 
	// similar to the transactional formats of .net
	
	// all dao have a been to instanciate in this class to access through the bean manager
	
	
	
	

}
