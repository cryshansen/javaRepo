package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import entity.Customer;

public class CustomerDaoTest {

	private ApplicationContext ctx;
	private CustomerDao customerDao;
    private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		customerDao = (CustomerDao) ctx.getBean("customerDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

	@Test
	public void testGetCustomers() {
		List<Customer> customerList = customerDao.getCustomers();
		assertEquals( 3, customerList.size() );
		for(Customer customer : customerList ) {
			System.out.println( customer.getCustomerName() + "\t" + customer.getCreditLimit() );
		}
	}
//
//	@Test
//	public void testGetCustomerByCustomerNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteCustomer() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testGetCustomerCountForEmployee() {
		Long count = customerDao.getCustomerCountForEmployee(1401);
		assertEquals( 10, count );
	}

	@Test
	public void testGetRowCount() {
		Long count = customerDao.getRowCount();
		assertEquals( 3, count );
	}

}
