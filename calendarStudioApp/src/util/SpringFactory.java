package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.BookingEventDao;
import dao.StudioBookingDao;
import dao.StudioDao;
import dao.UserDao;
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
	private static UserDao userDao;
	private static StudioDao studioDao;
	private static StudioBookingDao studioBookingDao;
	private static BookingEventDao bookEventDao;
	
	public static UserDao getUserDao() {
		
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		userDao = (UserDao) ctx.getBean("userDao");
		
		
		return userDao;
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

	public static BookingEventDao getBookEventDao() {
		
		if(ctx==null) {
			ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
		}
		bookEventDao = (BookingEventDao) ctx.getBean("bookingEventDao");
		
		
		return bookEventDao;
	}
	
	 ;
	//In the dao tests we had to call a transaction manager and its Template to implement the database call. 
	// similar to the transactional formats of .net
	
	// all dao have a been to instanciate in this class to access through the bean manager
	
	
	
	

}
