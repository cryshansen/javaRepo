package dao;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import entity.Office;


public class OfficeDaoTest {

	private ApplicationContext ctx;
	private OfficeDao officeDao;
    private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		officeDao = (OfficeDao) ctx.getBean("officeDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}
	
	@Test
	public void testGetOffices() {
		List<Office> officeList = officeDao.getOffices();
		assertTrue( officeList.size() > 0 );
		assertEquals(4, officeList.size() );
		for(Office office : officeList) {
			System.out.println( office.getOfficeCode() + "\t" + office.getCity() + "\t\t" + office.getCountry() );
		}
	}

	@Test
	public void testGetOffice() {
    
        Office office = officeDao.getOfficeByOfficeCode("1");
        assertEquals( "1", office.getOfficeCode() );
        assertEquals( "Edmonton", office.getCity() );
        assertEquals( "780-998-7654" , office.getPhone() );
        assertEquals( "8765 Jasper Ave", office.getAddressLine1() );
        assertEquals( "", office.getAddressLine2().trim() );
        assertEquals( "Alberta", office.getProvince() );
        assertEquals( "Canada", office.getCountry());
        assertEquals( "T5A4J8", office.getPostalCode() );
        assertEquals( "1", office.getTerritory() );
		        
	}
	
	@Test
	public void testAddOffice() {
    	final Office office1 = new Office("5","edmonton1","7803785286","NAIT HP Center","W309","AB","Canada","T5G2R1","CAN");				
		
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		        officeDao.addOffice(office1);
		        Office office2 = officeDao.getOfficeByOfficeCode("5");
		        assertEquals( office1.getOfficeCode(), office2.getOfficeCode() );
		        assertEquals( office1.getCity(), office2.getCity() );
		        assertEquals( office1.getPhone(), office2.getPhone() );
		        assertEquals( office1.getAddressLine1(), office2.getAddressLine1() );
		        assertEquals( office1.getAddressLine2(), office2.getAddressLine2() );
		        assertEquals( office1.getProvince(), office2.getProvince() );
		        assertEquals( office1.getCountry(), office2.getCountry() );
		        assertEquals( office1.getPostalCode(), office2.getPostalCode() );
		        assertEquals( office1.getTerritory(), office2.getTerritory() );
		        
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testUpdateOffice() {
		final Office office1 = officeDao.getOfficeByOfficeCode("1");
		office1.setCity("city1");
		office1.setPhone("phone1");
		office1.setAddressLine1("addressLine1");
		office1.setAddressLine2("addressLine2");
		office1.setProvince("state1");
		office1.setCountry("country1");
		office1.setPostalCode("postal1");
		office1.setTerritory("territory1");
		
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		        officeDao.updateOffice(office1);
		        Office office2 = officeDao.getOfficeByOfficeCode("1");
		        assertEquals( office1.getOfficeCode(), office2.getOfficeCode() );
		        assertEquals( office1.getCity(), office2.getCity() );
		        assertEquals( office1.getPhone(), office2.getPhone() );
		        assertEquals( office1.getAddressLine1(), office2.getAddressLine1() );
		        assertEquals( office1.getAddressLine2(), office2.getAddressLine2() );
		        assertEquals( office1.getProvince(), office2.getProvince() );
		        assertEquals( office1.getCountry(), office2.getCountry() );
		        assertEquals( office1.getPostalCode(), office2.getPostalCode() );
		        assertEquals( office1.getTerritory(), office2.getTerritory() );
		        
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testDeleteOfficeWithNoChildRecords() {
				
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		    	Office office = new Office("5","edmonton1","7803785286","NAIT HP Center","W309","AB","Canada","T5G2R1","CAN");				
		        officeDao.addOffice(office);
				officeDao.deleteOffice( office );
		        assertNull( officeDao.getOfficeByOfficeCode( office.getOfficeCode() ) );
		        
//		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testGetRowCount() {
		Long rowCount = officeDao.getRowCount();
		assertEquals( 4, rowCount );
	}
	
	
}
