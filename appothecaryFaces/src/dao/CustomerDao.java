package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Customer;

/**
 * This is the DAO class for the customers table.
 * @author swu
 *
 */
public class CustomerDao extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		return getHibernateTemplate().loadAll(Customer.class);
	}
	
	public Customer getCustomerByCustomerNumber(int customerNumber) {
		return (Customer) getHibernateTemplate().get(Customer.class, customerNumber);	
	}
	
	public void addCustomer(Customer customer) {
		getHibernateTemplate().save(customer);	
	}
	
	public void updateCustomer(Customer customer) {
		getHibernateTemplate().update(customer);	
	}
	
	public void deleteCustomer(Customer customer) {
		getHibernateTemplate().delete(customer);	
	}
	
	public Long getCustomerCountForEmployee(int employeeNumber) {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(salesRepEmployeeNumber) from entity.Customer where salesREpEmployeeNumber = :employeeNo");
		dbQuery.setInteger("employeeNo", employeeNumber);		
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(customerNumber) from entity.Customer");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
}
