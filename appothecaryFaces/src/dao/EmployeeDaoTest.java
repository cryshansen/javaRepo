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

import entity.Employee;

public class EmployeeDaoTest {
	
	private ApplicationContext ctx;
	private EmployeeDao employeeDao;
	private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		employeeDao = (EmployeeDao) ctx.getBean("employeeDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

	@Test
	public void testAddEmployee() {
    	final Employee employee1= new Employee();
    	employee1.setLastName("lastName1");
    	employee1.setFirstName("firstName1");
    	employee1.setExtension("ext1");
    	employee1.setEmail("noemail@email.com");
    	OfficeDao officeDao = (OfficeDao) ctx.getBean("officeDao");
    	employee1.setOffice( officeDao.getOfficeByOfficeCode("1") );
    	employee1.setSupervisor( employeeDao.getEmployeeByEmployeeNumber(1143) );
    	employee1.setJobTitle("jobTitle1");
		
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		    	employeeDao.addEmployee(employee1);
		    	assertTrue( employee1.getEmployeeNumber() > 0 );
		        Employee employee2 = employeeDao.getEmployeeByEmployeeNumber( employee1.getEmployeeNumber() );
		        assertEquals( employee1.getEmployeeNumber(), employee2.getEmployeeNumber() );
		        assertEquals( employee1.getLastName(), employee2.getLastName() );
		        assertEquals( employee1.getFirstName(), employee2.getFirstName() );
		        assertEquals( employee1.getExtension(), employee2.getExtension() );
		        assertEquals( employee1.getEmail(), employee2.getEmail() );
		        assertSame( employee1.getOffice(), employee2.getOffice() );
		        assertSame( employee1.getSupervisor(), employee2.getSupervisor() );
		        assertEquals( employee1.getJobTitle(), employee2.getJobTitle() );
		        
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testUpdateEmployee() {
    	final Employee employee1 = employeeDao.getEmployeeByEmployeeNumber(1143);
    	employee1.setLastName(" new lastName");
    	employee1.setFirstName("new firstName");
    	employee1.setExtension(" new ext");
    	employee1.setEmail("newemail@email.com");
    	OfficeDao officeDao = (OfficeDao) ctx.getBean("officeDao");
    	employee1.setOffice( officeDao.getOfficeByOfficeCode("2") );
    	employee1.setJobTitle("new jobTitle");
    	
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		    	employeeDao.updateEmployee(employee1);
		        Employee employee2 = employeeDao.getEmployeeByEmployeeNumber(1143);
		        assertEquals( employee1.getEmployeeNumber(), employee2.getEmployeeNumber() );
		        assertEquals( employee1.getLastName(), employee2.getLastName() );
		        assertEquals( employee1.getFirstName(), employee2.getFirstName() );
		        assertEquals( employee1.getExtension(), employee2.getExtension() );
		        assertEquals( employee1.getEmail(), employee2.getEmail() );
		        assertSame( employee1.getOffice(), employee2.getOffice() );
		        assertSame( employee1.getSupervisor(), employee2.getSupervisor() );
		        assertEquals( employee1.getJobTitle(), employee2.getJobTitle() );
		        
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testDeleteEmployee() {
		final Employee employee1 = employeeDao.getEmployeeByEmployeeNumber(1143);
		
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		    	employeeDao.deleteEmployee( employee1 );
		        assertNull( employeeDao.getEmployeeByEmployeeNumber( employee1.getEmployeeNumber() ) );
		        
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testGetEmployees() {
		List<Employee> employeeList = employeeDao.getEmployees();
		assertNotNull( employeeList );
		assertEquals(24, employeeList.size());
		for(Employee emp : employeeList ) {
			System.out.println(emp.getFirstName() + " " + emp.getLastName() + "\t" + emp.getOffice().getCity());
		}
		
	}

	@Test
	public void testGetEmployeesByOfficeCode() {
		List<Employee> employeeList = employeeDao.getEmployeesByOfficeCode("1");
		assertNotNull( employeeList );
		assertEquals( 6, employeeList.size() );
	}

	@Test
	public void testGetEmployeesBySupervisor() {
		List<Employee> employeeList = employeeDao.getEmployeesBySupervisor(1143);
		assertNotNull( employeeList );
		assertEquals( 6, employeeList.size() );
	}

	@Test
	public void testGetEmployeeByEmployeeNumber() {
		Employee employee = employeeDao.getEmployeeByEmployeeNumber(1143);
		assertEquals(1143, employee.getEmployeeNumber());
		assertEquals("Bow", employee.getLastName() );
		assertEquals("Anthony", employee.getFirstName() );		
	}
	
	@Test
	public void testGetEmployeesByEmployeeNumberNotFound() {
		Employee emp = employeeDao.getEmployeeByEmployeeNumber(1);
		assertNull( emp );
	}

	@Test
	public void testGetEmployeeCountForSupervisor() {
		Long count = employeeDao.getEmployeeCountForSupervisor(1143);
		assertEquals(6, count.intValue());
	}

}
