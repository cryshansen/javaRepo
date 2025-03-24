package entity;

import javax.persistence.*;
import org.hibernate.annotations.AccessType;

/**
 * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "offices"
 * using Hibernate 3 Annotations.
 * 
 * @author Crystal Hansen
 * May 29 2020
 */
@Entity						// This is a persistent class
@Table(name="offices")		// This class maps to the table named "offices".
@AccessType("field")		// This class uses field-based annotations.
public class Office implements java.io.Serializable {

	
	@Transient	// Do NOT persist this property.
	private static final long serialVersionUID = 1L;

	/** Use the @Id annotation to indicate this field is the unique identifier */
	@Id
	@Column(length=10)
	private String officeCode;
	
	@Column(name="city",length=50)
	private String city;
	
	@Column(length=50)
	private String phone;
	
	@Column(length=50)
	private String addressLine1;
	
	@Column(length=50, nullable=true)
	private String addressLine2;
	
	@Column(length=50, nullable=true)
	private String province;
	
	@Column(length=50)
	private String country;
	
	@Column(length=15)
	private String postalCode;
	
	@Column(length=10)
	private String territory;

    public Office() {
    }

	
    public Office(String officeCode) {
        this.officeCode = officeCode;
    }
    
    public Office(String officeCode, String city, String phone, String addressLine1, String addressLine2, String province, String country, String postalCode, String territory) {
       this.officeCode = officeCode;
       this.city = city;
       this.phone = phone;
       this.addressLine1 = addressLine1;
       this.addressLine2 = addressLine2;
       this.province = province;
       this.country = country;
       this.postalCode = postalCode;
       this.territory = territory;
    }
   
    public String getOfficeCode() {
        return this.officeCode;
    }
    
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddressLine1() {
        return this.addressLine1;
    }
    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return this.addressLine2;
    }
    
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getTerritory() {
        return this.territory;
    }
    
    public void setTerritory(String territory) {
        this.territory = territory;
    }


}


