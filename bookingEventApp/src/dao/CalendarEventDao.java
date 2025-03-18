package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.CalendarEvent;

public class CalendarEventDao extends HibernateDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List<CalendarEvent> getCalendarEvent() {
		
		return getHibernateTemplate().loadAll(CalendarEvent.class);
	
	}
	
	public CalendarEvent getCalendarEventByCalendarEventId(int calEventId) {
		return (CalendarEvent) getHibernateTemplate().get(CalendarEvent.class, calEventId);	
	}
	
	public void addCalendarEvent(CalendarEvent calEvent) {
		getHibernateTemplate().save(calEvent);	
	}
	
	public void updateCalendarEvent(CalendarEvent calEvent) {
		getHibernateTemplate().update(calEvent);	
	}
	
	public void deleteCalendarEvent(CalendarEvent calEvent) {
		getHibernateTemplate().delete(calEvent);	
	}
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(calEventId) from entity.CalendarEvent");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}
	
	

}
