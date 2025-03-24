package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;



/**
 * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "customers"
 * using Hibernate 3 Annotations.
 * 
 * @author Crystal Hansen
 * 05-30-2020
 */
@Entity						// This is a persistent class
@Table(name="studiobooking")	// This class maps to the table named "customers".
@AccessType("field")		// This class uses field-based annotations.
public class StudioBooking implements java.io.Serializable{
	
	@Transient 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )	
	private int studioBookingId	;
	@Temporal(TemporalType.DATE)
	private Date studioBookingDate;
	
	private String studioBookingHours;
	
	private int studioNumberInAttendance;
	

	//must use key join column to make add work for studio bookings.
	 @ManyToOne
	 @JoinColumn(name="studioId")
	 private Studio studio;


	public int getStudioBookingId() {
		return studioBookingId;
	}


	public void setStudioBookingId(int studioBookingId) {
		this.studioBookingId = studioBookingId;
	}


	public Date getStudioBookingDate() {
		return studioBookingDate;
	}


	public void setStudioBookingDate(Date studioBookingDate) {
		this.studioBookingDate = studioBookingDate;
	}


	public String getStudioBookingHours() {
		return studioBookingHours;
	}


	public void setStudioBookingHours(String studioBookingHours) {
		this.studioBookingHours = studioBookingHours;
	}


	public int getStudioNumberInAttendance() {
		return studioNumberInAttendance;
	}


	public void setStudioNumberInAttendance(int studioNumberInAttendance) {
		this.studioNumberInAttendance = studioNumberInAttendance;
	}


	public Studio getStudio() {
		return studio;
	}


	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public StudioBooking() {
		super();
		
	}
	
	public StudioBooking(int studioBookingId) {
		super();
		this.studioBookingId = studioBookingId;
	}
	
	public StudioBooking(int studioBookingId, Date studioBookingDate, String studioBookingHours,
			int studioNumberInAttendance, Studio studio) {
		super();
		this.studioBookingId = studioBookingId;
		this.studioBookingDate = studioBookingDate;
		this.studioBookingHours = studioBookingHours;
		this.studioNumberInAttendance = studioNumberInAttendance;
		this.studio = studio;
	}


	
	
	
}
