package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import entity.BookingEvent;
import entity.Studio;

public class StudioDaoTest {
	
	private ApplicationContext ctx;
	
	private StudioDao studioDao;
	private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		//bookingEventDao = (BookingEventDao) ctx.getBean("bookingEventDao");
		studioDao = (StudioDao) ctx.getBean("studioDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

	
	
	
	@Test
	public void testGetRowCount() {
		Long count = studioDao.getRowCount();
		assertEquals( 4, count );
	}
	
	@Test
	public void testStudioByStudioId() {
		Studio studio = studioDao.getStudioByStudioId(4);
		assertEquals(4, studio.getStudioId());
		
		assertEquals("Apothecary", studio.getStudioName());
		//assertEquals(1,s);		
	}
	
	
	

}
