package entity;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;

/**
 * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "employees"
 * using Hibernate 3 Annotations.
 * 
 * @author Crystal Hansen
 * 05-30-2020
 */
@Entity						// This is a persistent class
@Table(name="employees")	// This class maps to the table named "employees".
@AccessType("field")		// This class uses field-based annotations.
public class Employee implements java.io.Serializable {

	@Transient 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )	
	private int employeeNumber;
	
	@Column(length=50)
	private String lastName;
	
	@Column(length=50)
	private String firstName;
	
	@Column(length=10)
	private String extension;
	
	@Column(length=100, unique=true)
	private String email;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="officeCode")
	private Office office;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional=true )
	@JoinColumn(name="reportsTo")
	private Employee supervisor;
	
	@Column(length=50)
	private String jobTitle;

	public Employee() {
	}

	public Employee(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Employee(int employeeNumber, String lastName, String firstName,
			String extension, String email, Office office, Employee supervisor,
			String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.office = office;
		this.supervisor = supervisor;
		this.jobTitle = jobTitle;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
		
}
