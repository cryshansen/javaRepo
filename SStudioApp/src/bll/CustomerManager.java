package bll;

import java.util.List;

import dao.CustomerDao;
import entity.Customer;


public class CustomerManager {

	private CustomerDao customerDao = util.SpringFactory.getCustomerDao();
	
	public int registerCustomer(Customer customer) {
		int success = 1; 
		try {
			customerDao.addCustomer(customer);
			// customerDao.getCustomerByCustomerNumber(customer.getCustomerNumber());
			
		}catch(Exception e) {
			System.out.print("failed to add Customer");
			success = 0;
		}
		
		return success;
		
	}
	
	public int updateCustomer(Customer customer) {
		int success = 1; 
		try {
			
			customerDao.updateCustomer(customer);
			// customerDao.getCustomerByCustomerNumber(customer.getCustomerNumber());
			
		}catch(Exception e) {
			System.out.print("failed to update Customer");
			success = 0;
		}
		
		return success;
		
	}
	
	
	
	public int deleteCustomer(Customer cust) {
		int success = 1;
		try {
			
		}catch (Exception e){
			success=0;
			System.out.print("failed to delete Customer");
		}
		return success;
	}
	
	public Customer getSingleCustomer(int customerNumber){
		return customerDao.getCustomerByCustomerNumber(customerNumber);
	}
	public List<Customer> listCustomers(){
		
		return customerDao.getCustomers();
		
		
	}
	
	
}
