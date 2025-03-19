package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import entity.StudioBooking;

public class StudioBookingDao extends HibernateDaoSupport{

	
	public List<StudioBooking> getStudioBookings(int studioId){
		List<StudioBooking> studioList = new ArrayList<StudioBooking>();
//		
//		DetachedCriteria criteria = DetachedCriteria.forClass(StudioBooking.class);
//		criteria.add(Restrictions.like("studioId",studioId , MatchMode.ANYWHERE));
//		criteria.createCriteria("studio").add(Restrictions.sqlRestriction("studioId like ? ","%" + studioId + "%", Hibernate.STRING ) );
//		System.out.println(criteria);
//		studioList =  getHibernateTemplate().findByCriteria(criteria);
//		
		DetachedCriteria criteria = DetachedCriteria.forClass(StudioBooking.class).add( 
				Restrictions.disjunction().add( Restrictions.eq("studio.studioId", studioId) ));
		System.out.println(criteria);
		studioList= (List<StudioBooking>) getHibernateTemplate().findByCriteria(criteria);
		
		
		return studioList;
	}
	
	
	
}
