package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.json.JSONArray;
import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;

import com.google.gson.Gson;

import bll.StudioManager;
import dao.BookingEventDao;
import dao.StudioDao;

import entity.BookingEvent;
import entity.Studio;

public class StudioBookingController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	StudioManager studioManager= null;
	
	public StudioBookingController() {
		studioManager = new StudioManager();
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setAttribute("us", theBookings);
//		request.setAttribute("studio", studio);
//		dispatcher = request.getRequestDispatcher("/views/studio-booking.jsp");
//		
//		dispatcher.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		
//		String line = null;
//		//user object properties
//		String id = null;
//		String pwd = null;
//        String username = null;
//        String cardholder_name= null;
//        String card_number= null;
//        String expire_date= null;
//        String ccv= null;
//        
//        //cart properties
//        String cartJSONString = null;
//		String studio = null;
//		String studios = null;
//		String fulldate = "";
//		String bgColor= "";
//		String start= "";
//		String end = "";
//		String avail="";
//		
//		String allday = "";
//		//List<BookingEvent> studioBList = new ArrayList<BookingEvent>();  //testing purpose
//		StudioDao studioDaoObj = new StudioDao();
//		
//		Studio studioObj = new Studio();
//		StringBuilder sb = new StringBuilder();
//		//make User user = new User();
//	    
//	    BufferedReader br = new BufferedReader(request.getReader());
//	    while ((line = br.readLine()) != null) {
//	        sb.append(line);
//	    }
//		
//		System.out.println(sb.toString());
//		try {
//			JSONObject json = new JSONObject(sb.toString());
//			//id=json.getString("id");
//			//assign user.setId(); etc
//			//pwd=json.getString("pwd");
//			
//           // username=json.getString("username");
//            
////	  		cardholder_name=json.getString("cardholder_name");
////	  		card_number=json.getString("card_number");
////	  		expire_date=json.getString("expire_date");
////			ccv=json.getString("ccv");
//			studios = json.getString("studios"); //use cart to validate the user signed in vs the card values!?
//			
//			//System.out.println("studios "+ studios.toString()); //trim outer bracket from jsonobject
//			if(studios.length() >4) {
//				//remove the [] brackets and reappend
//				studios = studios.substring(1,studios.length()-1);
//				
//			
//				try {
//					System.out.println("studios :::"+ studios.toString());
//				
//					JSONObject jsonCart = new JSONObject(studios);
//					
//					for(int i = 0; i<jsonCart.names().length(); i++){
//						BookingEvent studioBooking = new BookingEvent();
//						BookingEventDao bookeventDao = new BookingEventDao();
//						//studios2 = studios.substring(1,studios.length()-1);
//						String studioName = jsonCart.getString("studio");
//						
//						switch(studioName) {
//						
//								case "White Room":
//									//get studio by id ()  listStudioBookings(request, response);
//									 studioObj = studioManager.getSingleStudio(1);
//									
//									break;
//									
//								case "Apothecary":
//									studioObj =  studioManager.getSingleStudio(4);
//									break;
//								case "Make Believe Studio":
//									studioObj =  studioManager.getSingleStudio(3);
//									break;
//								//TODO: get studio by studioName; for studio id bc not passing it,
//								case "Furniture Design / Upholstery":
//									studioObj =   studioManager.getSingleStudio(5);
//									break;
//								default:
//									studioObj =  studioManager.getSingleStudio(1);
//									break;
//						}
//						
//						
//						
//						avail = jsonCart.getString("avail");						
//						allday = jsonCart.getString("allDay");						
//						bgColor = jsonCart.getString("bgColor");
//						
//						
//						
//						//for hours these are strings of time from 8 AM 08:00:00 - 21:00:00 in 2 hr blocks!!
//						String startVar = jsonCart.getString("start");
//						String endVar = jsonCart.getString("end");
//						// use same date for begin and end as the TODO: save to db removes the hours appended from 2 hr blocks!!
//						String fullDate = jsonCart.getString("fulldate");
//						
//						Date testDate = new SimpleDateFormat("yyyy-MM-dd").parse(fullDate);
//						String startS = "2020-07-23 17:00:00";
//				    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd H:mm:ss"); 
//				    	Date stime = new Timestamp((sdf.parse(startS)).getTime());
//				    	System.out.println(stime);
//				    	//SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd H:mm:ss"); 
//				    	Date startDate=stime;
//				    	System.out.println(startDate);
//				    	studioBooking.setBookingstart(startDate); 
//						
//						//new java upgrade old util.date to time 
//						Instant instant = testDate.toInstant() ;
//						ZoneId z = ZoneId.of( "US/Mountain" ) ;
//						ZonedDateTime zdt = instant.atZone( z ) ;
//						
//						Instant instant2 = zdt.toInstant() ;
//						//back into util.date
//						Date startDateSDF = java.util.Date.from ( instant2 ) ;
//						Date endDateSDF = java.util.Date.from ( instant2 ) ;
//						
//						String endS = "2020-07-23 19:00:00";  
//				    	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd H:mm:ss"); //INSERT INTO Table (`Table_date`) VALUES ('2015-04-12 16:50:35')
//				    	Date etime = new Timestamp((sdf.parse("2020-07-23 19:00:00.0")).getTime());
//				    	System.out.println(etime);
//				    	Date endDate=etime;
//				    	studioBooking.setBookingend(endDate);
//				    	
//						//studioBooking.setStudio();
//						studioBooking.setStudio(studioObj);
//						studioBooking.setBookingTitle(studioName);
//						//studioBooking.setBookingstart(startDateSDF);
//						//studioBooking.setBookingend(endDateSDF);
//						//sending the hours booked to time of day 2 hr blocks
//						studioBooking.setBookingHourStart(startVar.substring((startVar.indexOf("T")+1),startVar.length()-5));
//						studioBooking.setBookingHourEnd(endVar.substring((endVar.indexOf("T")+1),endVar.length()-5));
//						studioBooking.setBackgroundColor(bgColor);
//						
//						studioBooking.setEventStatus("Reserved");
//						studioBooking.setStudioNumberInAttendance(2);
//						//send to db
//						
//						// if(id.trim().isEmpty() || id == null) {
//							
//						if(bookeventDao.addBookingEvent(studioBooking)==1) {
//								request.setAttribute("NOTIFICATION", "Booked eventSaved Successfully!");
//								System.out.println("NOTIFICATION Booked eventSaved Successfully!");
//						
//						}else {
//							request.setAttribute("NOTIFICATION", "Booked event failed!");
//							
////							if(bookeventDao.updateBookingEvent(studioBooking)==1) {
////								request.setAttribute("NOTIFICATION", "Studio Updated Successfully!");
////							}
//							
//						}
//					//for testing purposes
//						//studioBList.add(i, studioBooking);
//					
//						}
//					
//						
//					
//
//				}catch(JSONException e) {
//					//e.printStackTrace();
//					System.out.println(e.getMessage());
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//					System.out.println(e1.getMessage());
//				}
//			}
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		 
//		System.out.println("studios ="+ studios.toString());
//		System.out.println("fulldate ="+ fulldate.toString());
//		System.out.println("bgColor; "+ bgColor.toString());
//		System.out.println("start = "+ start.toString());
//		System.out.println("end = "+ end.toString());
	}
	
}
