package dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import entity.CalendarEvent;

public class CalendarEventDaoTest {
	
	private CalendarEventDao calEventDao;
	
	private ApplicationContext ctx;
	private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;

    
    @Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		calEventDao = (CalendarEventDao) ctx.getBean("calEventDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

	
	@Test
	public void getCalendarEvents() {
		List<CalendarEvent> theList = calEventDao.getCalendarEvent();
		assertNotNull( theList );
		assertEquals(3, theList.size());
		for(CalendarEvent event : theList ) {
			System.out.println(event + " :: bgColor ::" + event);
		}
		
	}
	
	@Test
	public void testGetRowCount() {
		Long count = 	calEventDao.getRowCount();
		assertEquals(3,count);
	}
    
    
	@Test
	public void testAddClendarEvent() {
    	final CalendarEvent event= new CalendarEvent();
    	
    	
    	event.setCalEventTitle("Apothecary");
    	event.setBgColor("#ff8c82");
    	
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		    	calEventDao.addCalendarEvent(event);
		    	assertTrue( event.getCalEventId() > 0 );
		    	CalendarEvent event4 = calEventDao.getCalendarEventByCalendarEventId( event.getCalEventId());
		        
		    	assertEquals( event.getCalEventId(), event4.getCalEventId());
		        assertEquals( event.getCalEventTitle(), event4.getCalEventTitle());
		        assertEquals( event.getBgColor(), event4.getBgColor());
		       // assertSame( event.getStudio(), event4.getStudio());
		        
		       
		        
		        
		        
		        
		        status.setRollbackOnly();
		    }
		});
    	
	}  
	
	

}
