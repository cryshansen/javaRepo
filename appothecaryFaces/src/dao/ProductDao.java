package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Product;

public class ProductDao extends HibernateDaoSupport {
	
	public List<Product> findProductsByAll(java.util.Hashtable<String, String> searchTable) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		java.util.Enumeration<String> e = searchTable.keys();
		while( e.hasMoreElements() ) {
			String fieldName = e.nextElement();
			String fieldValue = searchTable.get(  fieldName );
//			criteria.add(  Restrictions.like(fieldName, "%" + fieldValue + "%")  );
			criteria.add(  Restrictions.sqlRestriction( 
					fieldName + "   like ? ", "%" + fieldValue + "%", org.hibernate.Hibernate.STRING ) );
		}
		return getHibernateTemplate().findByCriteria(criteria);
		
	}
	
	public List<Product> findProductsByAll(
			String productCode,
			String productName,
			String productDescription,
			String productScale,
			String productVendor,
			String productLine) {
		
		List<Product> productList = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(  Restrictions.like("productCode",  
				productCode, org.hibernate.criterion.MatchMode.ANYWHERE ) );
		criteria.add(  Restrictions.like("productName", "%" + productName + "%") );
		criteria.add(  Restrictions.like("productDescription", "%" + productDescription + "%") );
		criteria.add(  Restrictions.like("productVendor", "%" + productVendor + "%") );
		criteria.add(  Restrictions.like("productScale", "%" + productScale + "%") );
		criteria.add(  Restrictions.like("productLine.productLine", "%" + productLine + "%") );
		
		criteria.addOrder(  Order.asc("productLine.productLine") );
		criteria.addOrder(  Order.desc("productName") );
		
		productList = getHibernateTemplate().findByCriteria(criteria);
		
//		productList = getHibernateTemplate().find(
//			"from entity.Product where productCode like ? and productName like ? "
//			+ " and productDescription like ? and productScale like ? "
//			+ " and productVendor like ? and productLine.productLine like ?",  
//			new Object[] { 
//					"%" + productCode + "%", 
//					"%" + productName + "%" ,
//					"%" + productDescription + "%" ,
//					"%" + productScale + "%" ,
//					"%" + productVendor + "%" ,
//					"%" + productLine + "%" 
//			}	
//		);
		
		return productList;
		
	}
	
	public List<Product> findProductsByAny(	String searchValue) {
		
		List<Product> productList = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(  Restrictions.disjunction()
				.add( Restrictions.like("productCode", "%" + searchValue + "%") )
				.add( Restrictions.like("productName", "%" + searchValue + "%") )
				.add( Restrictions.like("productDescription", "%" + searchValue + "%") )
				.add( Restrictions.like("productVendor", "%" + searchValue + "%") )
				.add( Restrictions.like("productScale", "%" + searchValue + "%") )
				.add( Restrictions.like("productLine.productLine", "%" + searchValue + "%") )
				);
		criteria.addOrder(  Order.asc("productLine.productLine") );
		criteria.addOrder(  Order.desc("productName") );

		productList = getHibernateTemplate().findByCriteria(criteria);
		
//		productList = getHibernateTemplate().find(
//			"from entity.Product where productCode like ? or productName like ? "
//			+ " or productDescription like ? or productScale like ? "
//			+ " or productVendor like ? or productLine.productLine like ?",  
//			new Object[] { 
//					"%" + searchValue + "%", 
//					"%" + searchValue + "%" ,
//					"%" + searchValue + "%" ,
//					"%" + searchValue + "%" ,
//					"%" + searchValue + "%" ,
//					"%" + searchValue + "%" 
//			}	
//		);
		
		return productList;
		
	}
	
	
	
	
	
	
	
	
}
