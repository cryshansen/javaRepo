package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.User;

public class UserDao extends HibernateDaoSupport{

	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getHibernateTemplate().loadAll(User.class);
	}
	
	public User getUserByUserId(int userId) {
		return (User) getHibernateTemplate().get(User.class, userId);	
	}
	
	public void addUser(User user) {
		getHibernateTemplate().save(user);	
	}
	
	public void updateUser(User user) {
		getHibernateTemplate().update(user);	
	}
	
	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);	
	}
	
	
	
}
