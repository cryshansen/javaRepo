package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/*
 * * This is the persistence POJO (Plain Ordinary Java Object) mapping to the database table "calendar Event"
 * using Hibernate 3 Annotations.
 * 
 * Studio Object Entity
 * @author Crystal Hansen
 *  June 23 2020
 * *
 * */

import org.hibernate.annotations.AccessType;

@Entity						// This is a persistent class
@Table(name="CalendarEvent")	// This class maps to the table named "employees".
@AccessType("field")		// This class uses field-based annotations.
public class CalendarEvent implements java.io.Serializable{
	
	@Transient 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )	
	private int calEventId;
	
	private String calEventTitle;
	
	private String bgColor;

	public int getCalEventId() {
		return calEventId;
	}

	public void setCalEventId(int calEventId) {
		this.calEventId = calEventId;
	}

	public String getCalEventTitle() {
		return calEventTitle;
	}

	public void setCalEventTitle(String calEventTitle) {
		this.calEventTitle = calEventTitle;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	public CalendarEvent() {
		super();
	}
	public CalendarEvent(int calEventId) {
		this.calEventId = calEventId;
	}
	

	public CalendarEvent(int calEventId, String calEventTitle, String bgColor) {
		super();
		this.calEventId = calEventId;
		this.calEventTitle = calEventTitle;
		this.bgColor = bgColor;
	}
	
	

}
