package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import entity.BookingEvent;



public class BookingEventDaoTest {

	private ApplicationContext ctx;
	private BookingEventDao bookingEventDao;
	private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		bookingEventDao = (BookingEventDao) ctx.getBean("bookingEventDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

//	@Test
//	public void getBookingEvents() {
//		List<BookingEvent> bookingList = bookingEventDao.getBookingEvents();
//		assertNotNull( bookingList );
//		assertEquals(6, bookingList.size());
//		for(BookingEvent event : bookingList ) {
//			System.out.println(event.getBookingTitle() + " " + event.getBookingstart() + "\t" + event.getStudio().getStudioId());
//		}
//		
//	}
	
//	@Test
//	public void testGetRowCount() {
//		Long count = bookingEventDao.getRowCount();
//		assertEquals( 6, count );
//	}
//	
////	@Test
////	public void getBookingEventByBookingEventId() {
////		BookingEvent event = bookingEventDao.getBookingEventByBookingEventId(1);
////		assertEquals(1, event.getBookingId());
////		assertEquals("White Room", event.getBookingTitle());
////		assertEquals(1,event.getStudio().getStudioId() );		
////	}
//	
//	
//	@Test
//	public void testAddBookingEvent() throws ParseException {
//    	final BookingEvent event= new BookingEvent();
//    	
//  
//    	String startS = "2020-07-23 17:00:00";
//    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd H:mm:ss"); 
//    	Date stime = new Timestamp((sdf.parse("2020-07-23 17:00:00.0")).getTime());
//    	System.out.println(stime);
//    	Date startDate=stime;
//    	System.out.println(startDate);
//    	event.setBookingstart(startDate); 
//    	
//    	
//    	String endS = "2020-07-23 19:00:00";  
//    	Date etime = new Timestamp((sdf.parse("2020-07-23 19:00:00.0")).getTime());
//    	System.out.println(etime);
//    	Date endDate=etime;
//    	event.setBookingend(endDate);
//    	System.out.println(endDate);
//    	event.setBackgroundColor("#ff8c82");
//    	String hourstart = startS.substring(startS.indexOf(" "), startS.length());
//    	System.out.println(hourstart);
//    	String hourend =  endS.substring(endS.indexOf(" "), endS.length());
//    	System.out.println(hourend);
//    	event.setBookingHourStart(hourstart);
//    	event.setBookingHourEnd(hourend);
//
//
//    	// this goes in cart,'$90.00',
//    	event.setBookingHourStart("17:00:00");
//    	event.setBookingHourEnd("19:00:00");
//    	event.setEventStatus("Reserved"); 
//    	event.setStudioNumberInAttendance(3);
//
//    	StudioDao studioDao = (StudioDao) ctx.getBean("studioDao");
//    	
//    	//covers the price add covers
//    	event.setStudio(studioDao.getStudioByStudioId(1)); 
//    	event.setBookingTitle(event.getStudio().getStudioName());
//    	
//    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//
//		    protected void doInTransactionWithoutResult(TransactionStatus status) {
//		    	bookingEventDao.addBookingEvent(event);
//		    	assertTrue( event.getBookingId() > 0 );
//		    	BookingEvent event4 = bookingEventDao.getBookingEventByBookingEventId( event.getBookingId());
//		        
//		    	assertEquals( event.getBookingId(), event4.getBookingId());
//		        assertEquals( event.getBookingTitle(), event4.getBookingTitle());
//		        assertEquals( event.getBookingstart(), event4.getBookingstart());
//		        assertEquals( event.getBookingend(),event4.getBookingend());
//		       
//		        assertSame( event.getStudio(), event4.getStudio());
//		        
//		       
//		        
//		        
//		        
//		        
//		        status.setRollbackOnly();
//		    }
//		    
//		});
//	}
	
//	@Test
//	public void testAddBookingEvent2() throws ParseException {
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd H:mm:ss"); 
//		Date etime2 = new Timestamp((sdf.parse("2020-06-29 00:00:00.0")).getTime());
//		final BookingEvent event2= new BookingEvent();
//		final BookingEvent event3= new BookingEvent();
//		StudioDao studioDao = (StudioDao) ctx.getBean("studioDao");
//		StudioDao studioDao1 = (StudioDao) ctx.getBean("studioDao");
//    	event2.setBookingstart(etime2)  ;
//    	event2.setBookingend(etime2) ; 
//    	event2.setBookingTitle("Apothecary");
//    	event2.setAllDay("1") ; 
//    	event2.setBackgroundColor("#cde9b5");
//    	event2.setBookingHourEnd("19:00:00") ;
//    	event2.setBookingHourStart(  "17:00:00" );
//    	event2.setEventStatus("Reserved") ;
//    	event2.setStudioNumberInAttendance(2) ;
//		event2.setStudio(studioDao.getStudioByStudioId(4));
//	
//		event3.setBookingstart(etime2)  ;
//		event3.setBookingend(etime2) ; 
//		event3.setBookingTitle("Apothecary");
//		event3.setAllDay("1") ; 
//		event3.setBackgroundColor("#cde9b5");
//		
//		event3.setBookingHourEnd("21:00:00 ");
//		event3.setBookingHourStart("19:00:00") ;
//		event3.setEventStatus("Reserved") ; 
//		event3.setStudioNumberInAttendance(2) ; 
//		event3.setStudio(studioDao1.getStudioByStudioId(4)); 
//		
//		
//		
//		
//		 
//        
//        bookingEventDao.addBookingEvent(event2);
//        assertTrue( event2.getBookingId() > 0 );
//        
//        BookingEvent event5 = bookingEventDao.getBookingEventByBookingEventId( event2.getBookingId());
//        
//    	assertEquals( event2.getBookingId(), event5.getBookingId());
//        assertEquals( event2.getBookingTitle(), event5.getBookingTitle());
//        assertEquals( event2.getBookingstart(), event5.getBookingstart());
//        assertEquals( event2.getBookingend(),event5.getBookingend());
//       
//        assertSame( event2.getStudio(), event5.getStudio());
//        
//        bookingEventDao.addBookingEvent(event3);
//        assertTrue( event3.getBookingId() > 0 );
//        
//        BookingEvent event6 = bookingEventDao.getBookingEventByBookingEventId( event3.getBookingId());
//        
//    	assertEquals( event3.getBookingId(), event6.getBookingId());
//        assertEquals( event3.getBookingTitle(), event6.getBookingTitle());
//        assertEquals( event3.getBookingstart(), event6.getBookingstart());
//        assertEquals( event3.getBookingend(),event6.getBookingend());
//       
//        assertSame( event3.getStudio(), event6.getStudio());
//        
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//
//		    protected void doInTransactionWithoutResult(TransactionStatus status) {
//		    	bookingEventDao.addBookingEvent(event2);
//		    	assertTrue( event2.getBookingId() > 0 );
//		    	BookingEvent event4 = bookingEventDao.getBookingEventByBookingEventId( event2.getBookingId());
//		        
//		    	assertEquals( event2.getBookingId(), event4.getBookingId());
//		        assertEquals( event2.getBookingTitle(), event4.getBookingTitle());
//		        assertEquals( event2.getBookingstart(), event4.getBookingstart());
//		        assertEquals( event2.getBookingend(),event4.getBookingend());
//		       
//		        assertSame( event2.getStudio(), event4.getStudio());
//		        
//		        bookingEventDao.addBookingEvent(event3);
//		    	assertTrue( event3.getBookingId() > 0 );
//		    	
//		    	BookingEvent event5 = bookingEventDao.getBookingEventByBookingEventId( event3.getBookingId());
//		        
//		    	assertEquals( event3.getBookingId(), event5.getBookingId());
//		        assertEquals( event3.getBookingTitle(), event5.getBookingTitle());
//		        assertEquals( event3.getBookingstart(), event5.getBookingstart());
//		        assertEquals( event3.getBookingend(),event5.getBookingend());
//		       
//		        assertSame( event3.getStudio(), event5.getStudio());
//		        
//		        
//		        
//		        
//		        status.setRollbackOnly();
//		    }
//		    
//		});
//		
//		
//	}
	
	
}
