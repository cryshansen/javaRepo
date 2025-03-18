package dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;


import entity.Project;
public class ProjectTestDao {
	

	private ApplicationContext ctx;
	private ProjectDao projectDao;
    private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		projectDao = (ProjectDao) ctx.getBean("projectDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}

	@Test
	public void testGetProjectss() {
		List<Project> projectList = projectDao.getProjects();
		assertEquals( 3, projectList.size() );
		for(Project proj : projectList ) {
			System.out.println( proj.getProjectName() + "\t" + proj.getProjectFee());
		}
	}

}
