package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import entity.BookingEvent;


public class BookingEventDao extends HibernateDaoSupport {
	
	@SuppressWarnings("unchecked")
	public List<BookingEvent> getBookingEvents(){
		return getHibernateTemplate().loadAll(BookingEvent.class);
	}
	
	
	public BookingEvent getBookingEventByBookingEventId(int eventId) {
		return (BookingEvent) getHibernateTemplate().get(BookingEvent.class, eventId);	
	}
	
	public int addBookingEvent(BookingEvent event) {
		
		
		int success = 1;
			try {
				//System.out.println(event.getBookingTitle().toString());
				
				

				 getHibernateTemplate().save(event);	
			}catch (Exception e){
				 success=0;
				 e.printStackTrace();
				 System.out.println("addBookingEvent failed." + e.getMessage().toString());
			}
		
		return success;
		
	}
	
	public int updateBookingEvent(BookingEvent event) {
		
		int success = 1;
		try {
			getHibernateTemplate().update(event);		
		}catch (Exception e){
			 success=0;
			 e.printStackTrace();
			 //System.out.println("updateBookingEvent failed." + e.getStackTrace().toString());
		}
	
	return success;
	}
	
	public void deleteBookingEvent(BookingEvent event) {
		getHibernateTemplate().delete(event);	
	}
	
	
	public Long getRowCount() {
		Session dbSession = getSession();
		Query dbQuery= dbSession.createQuery(
			"select count(bookingId) from entity.BookingEvent");
		Long count = (Long) dbQuery.uniqueResult();
		dbSession.close();
		return count;
	}

}
