package dao;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Project;

public class ProjectDao extends HibernateDaoSupport{


	@SuppressWarnings("unchecked")
	public List<Project> getProjects() {
		return getHibernateTemplate().loadAll(Project.class);
	}
	
	public Project getProjectByProjectId(int studioId) {
		return (Project) getHibernateTemplate().get(Project.class, studioId);	
	}
	
	public void addProject(Project studio) {
		getHibernateTemplate().save(studio);	
	}
	
	public void updateProject(Project studio) {
		getHibernateTemplate().update(studio);	
	}
	
	public void deleteProject(Project studio) {
		getHibernateTemplate().delete(studio);	
	}
	
	
	
}
