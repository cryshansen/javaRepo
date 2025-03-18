package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import entity.Studio;

public class StudioDao extends HibernateDaoSupport {


	@SuppressWarnings("unchecked")
	public List<Studio> getStudios() {
		return getHibernateTemplate().loadAll(Studio.class);
	}
	
	public Studio getStudioByStudioId(int studioId) {
		return (Studio) getHibernateTemplate().get(Studio.class, studioId);	
	}
	
	public void addStudio(Studio studio) {
		getHibernateTemplate().save(studio);	
	}
	
	public void updateStudio(Studio studio) {
		getHibernateTemplate().update(studio);	
	}
	
	public void deleteStudio(Studio studio) {
		getHibernateTemplate().delete(studio);	
	}
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(studioId) from entity.Studio");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
	
}
