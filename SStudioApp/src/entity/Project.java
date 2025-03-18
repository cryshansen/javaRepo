package entity;
/*
 * * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "projects"
 * using Hibernate 3 Annotations.
 * 
 * Studio Object Entity
 * @author Crystal Hansen
 *  June 29 2020
 * *
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

@Entity						// This is a persistent class
@Table(name="projects")	// This class maps to the table named "employees".
@AccessType("field")		// This class uses field-based annotations.
	
public class Project implements java.io.Serializable{
	@Transient 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )	
	private int projectId;
	
	@Column(length=50)
	private String projectName;
	private String projectDescription;
	private String projectFee;
	private String projectLength;
	private String project_image;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getProjectFee() {
		return projectFee;
	}
	public void setProjectFee(String projectFee) {
		this.projectFee = projectFee;
	}
	public String getProjectLength() {
		return projectLength;
	}
	public void setProjectLength(String projectLength) {
		this.projectLength = projectLength;
	}
	public String getProject_image() {
		return project_image;
	}
	public void setProject_image(String project_image) {
		this.project_image = project_image;
	}
	public Project(int projectId, String projectName, String projectDescription, String projectFee,
			String projectLength, String project_image) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectFee = projectFee;
		this.projectLength = projectLength;
		this.project_image = project_image;
	}
	public Project(int projectId) {
		super();
		this.projectId = projectId;
	}
	
	
	public Project() {
		super();
		
	}
	
}
	
