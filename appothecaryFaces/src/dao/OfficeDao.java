package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Office;

/**
 * This is the DAO class for the offices table.
 * @author Sam Wu
 *
 */
public class OfficeDao extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Office> getOffices() {
		return getHibernateTemplate().loadAll(Office.class);
	}
	
	public Office getOfficeByOfficeCode(String officeCode) {
		return (Office) getHibernateTemplate().get(Office.class, officeCode);	
	}
	
	public void addOffice(Office office) {
		getHibernateTemplate().save(office);	
	}
	
	public void updateOffice(Office office) {
		getHibernateTemplate().update(office);	
	}
	
	public void deleteOffice(Office office) {
		getHibernateTemplate().delete(office);	
	}
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(officeCode) from entity.Office");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
}
