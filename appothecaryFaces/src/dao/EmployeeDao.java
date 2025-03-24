package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Employee;

/**
 * This is the DAO class for the employees table.
 * @author Sam Wu
 *
 */
public class EmployeeDao extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return getHibernateTemplate().loadAll(Employee.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByOfficeCode(String officeCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class).add( 
			Restrictions.disjunction().add( Restrictions.eq("office.officeCode", officeCode) ));
		return (List<Employee>) getHibernateTemplate().findByCriteria(criteria);
		
//		return (List<Employee>) getHibernateTemplate().find(" from entity.Employee where office.officeCode = ?", officeCode);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesBySupervisor(int employeeNumber) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class).add( 
			Restrictions.disjunction().add( Restrictions.eq("supervisor.employeeNumber", employeeNumber) ));
		return (List<Employee>) getHibernateTemplate().findByCriteria(criteria);
			
//		return (List<Employee>) getHibernateTemplate().find(" from entity.Employee where supervisor.employeeNumber = ?", employeeNumber);
	}
	
	public Employee getEmployeeByEmployeeNumber(int employeeNumber) {
		return (Employee) getHibernateTemplate().get(Employee.class, employeeNumber);
	}
	
	public Long getEmployeeCountForSupervisor(int employeeNumber) {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(employeeNumber) from entity.Employee where reportsTo = :employeeNo");
		dbQuery.setInteger("employeeNo", employeeNumber);		
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
	
	public void addEmployee(Employee employee) {
		getHibernateTemplate().save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		getHibernateTemplate().update(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		getHibernateTemplate().delete(employee);
	}

	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(employeeNumber) from entity.Employee");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
}
