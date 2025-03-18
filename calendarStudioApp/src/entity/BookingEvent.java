package entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

/*
* * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "calendar bookingEvent table"
* using Hibernate 3 Annotations.
* 
* Studio Object Entity
* @author Crystal Hansen
*  June 17 2020
* *
* */

@Entity						// This is a persistent class
@Table(name="bookingEvent")	// This class maps to the table named "employees".
@AccessType("field")		// This class uses field-based annotations.
public class BookingEvent implements java.io.Serializable{

	@Transient 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int bookingId ;
//
//	@Temporal(TemporalType.DATE)
//	@Column(nullable=true)
//	private Date bookingstart;
//
//	@Temporal(TemporalType.DATE)
//	@Column(nullable=true)
//	private Date bookingend;
//	
//	@Column(length=10, nullable=false)
//	private String bookingHourStart;
//	@Column(length=10, nullable=false)
//	private String bookingHourEnd;
	
	@Column(length=10,nullable=false)
	private String   bookingTitle;
//	
//	@Column(length=10, nullable=true)
//	private String   backgroundColor;
//
//	@Column(length=10, nullable=false)
//	private String eventStatus;
//	
//	//private String eventStatus;
//	@Column(length=5,nullable=false)
//	private String allDay;
//
//	@Column(nullable=true)
//	private int studioNumberInAttendance;
//	
//	//must use key join column to make add work for studio bookings.
//	@ManyToOne
//	@JoinColumn(name="studioId")
//	private Studio studio;


	public BookingEvent() {
		super();
		// TODO Auto-generated constructor stub
	}  
	  
	public BookingEvent(int bookingId) {
		super();
		// TODO Auto-generated constructor stub
		this.bookingId=bookingId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

//	public Date getBookingstart() {
//		return bookingstart;
//	}

//	public void setBookingstart(Date bookingstart) {
//		this.bookingstart = bookingstart;
//	}
//
//	public Date getBookingend() {
//		return bookingend;
//	}
//
//	public void setBookingend(Date endDate) {
//		this.bookingend = endDate;
//	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

//	public String getBackgroundColor() {
//		return backgroundColor;
//	}
//
//	public void setBackgroundColor(String backgroundColor) {
//		this.backgroundColor = backgroundColor;
//	}
//	
//	public String getAllDay() {
//		return allDay;
//	}
//
//	public void setAllDay(String allDay) {
//		this.allDay = allDay;
//	}

//	public String getBookingHourStart() {
//		return bookingHourStart;
//	}
//
//	public void setBookingHourStart(String bookingHourStart) {
//		this.bookingHourStart = bookingHourStart;
//	}
//
//	public String getBookingHourEnd() {
//		return bookingHourEnd;
//	}
//
//	public void setBookingHourEnd(String bookingHourEnd) {
//		this.bookingHourEnd = bookingHourEnd;
//	}

//	public String getEventStatus() {
//		return eventStatus;
//	}
//
//	public void setEventStatus(String eventStatus) {
//		this.eventStatus = eventStatus;
//	}
//
//	public int getStudioNumberInAttendance() {
//		return studioNumberInAttendance;
//	}
//
//	public void setStudioNumberInAttendance(int studioNumberInAttendance) {
//		this.studioNumberInAttendance = studioNumberInAttendance;
//	}
//
//	public Studio getStudio() {
//		return studio;
//	}

//	public void setStudio(Studio studio) {
//		this.studio = studio;
//	}  
	
	public BookingEvent(int bookingId
//			, Date bookingstart, Date bookingend, String bookingHourStart,
//			String bookingHourEnd
			, String bookingTitle
//			, String backgroundColor
//			, String eventStatus, String allDay,
//			int studioNumberInAttendance, Studio studio
			) {
		super();
		this.bookingId = bookingId;
//		this.bookingstart = bookingstart;
//		this.bookingend = bookingend;
//		this.bookingHourStart = bookingHourStart;
//		this.bookingHourEnd = bookingHourEnd;
		this.bookingTitle = bookingTitle;
//		this.backgroundColor = backgroundColor;
//		this.eventStatus = eventStatus;
//		this.allDay = allDay;
//		this.studioNumberInAttendance = studioNumberInAttendance;
//		this.studio = studio;
	}

	
	
	

}
