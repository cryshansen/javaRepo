package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import dao.StudioBookingDao;
import dao.StudioDao;
import dao.CustomerDao;
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
	private static CustomerDao customerDao;
	private static StudioDao studioDao;
	private static StudioBookingDao studioBookingDao;
	
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
