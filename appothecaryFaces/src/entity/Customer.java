package entity;

import java.math.BigDecimal;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;

/**
 * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "customers"
 * using Hibernate 3 Annotations.
 * 
 * @author Crystal Hansen
 * 05-30-2020
 */
@Entity						// This is a persistent class
@Table(name="customers")	// This class maps to the table named "customers".
@AccessType("field")		// This class uses field-based annotations.
public class Customer implements java.io.Serializable {

	@Transient 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int customerNumber;
	
	@Column(length=50)
	private String customerName;
	
	@Column(length=50)
	private String contactLastName;
	
	@Column(length=50)
	private String contactFirstName;
	
	@Column(length=50)
	private String phone;
	
	@Column(length=50)
	private String addressLine1;
	
	@Column(length=50, nullable=true)
	private String addressLine2;
	
	@Column(length=50)
	private String city;
	
	@Column(length=50, nullable=true)
	private String province;
	
	@Column(length=15, nullable=true)
	private String postalCode;
	
	@Column(length=50)
	private String country;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional=true )
	@JoinColumn(name="salesRepEmployeeNumber")
	private Employee salesRep;
	
	private BigDecimal creditLimit;
	@Column(length=50)
	private String username;
	@Column(length=50)
	private String password;

	public Customer() {

	}

	public Customer(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Customer(int customerNumber, String customerName,
			String contactLastName, String contactFirstName, String phone,
			String addressLine1, String addressLine2, String city,
			String province, String postalCode, String country, Employee salesRep,
			BigDecimal creditLimit) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRep = salesRep;
		this.creditLimit = creditLimit;
	}

	public Customer(int customerNumber, String customerName,
			String contactLastName, String contactFirstName, String phone,
			String addressLine1, String addressLine2, String city,
			String province, String postalCode, String country, String username,String password)
			 {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.password = password;
		this.username = username;
		
	}
	
	
	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(Employee salesRep) {
		this.salesRep = salesRep;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

}


