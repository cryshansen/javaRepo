package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.json.JSONArray;
import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;

import bll.StudioManager;
import dao.BookingEventDao;
import dao.StudioBookingDao;
import dao.StudioDao;
import entity.BookingEvent;
import entity.Studio;


public class BookingEventController extends HttpServlet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	//StudioManager studioManager = null;
	BookingEventDao bookingEventDao;

	private String line;
	
	
	public BookingEventController() {
		//studioManager = new StudioManager();
		bookingEventDao =  util.SpringFactory.getBookEventDao();
		
	}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String action = request.getParameter("action");
			
			if(action == null) {
				action = "LIST";
			}
			System.out.println(action);
			switch(action) {
			
				case "LIST":
					listBookingEventss(request, response);
					break;
					
				case "BOOK":
					listBookingEventss(request, response);
					break;

				default:
					listBookingEventss(request, response);
					break;
			}
	
	}
		
		//show calendar studio view
		private void listBookingEventss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			List<BookingEvent> theEvents = bookingEventDao.getBookingEvents();

			
			JSONArray ja = new JSONArray(); 
		    // List<StudioBooking> theBookings = studioManager.getStudioBookings(Integer.parseInt("1"));
//		     
		     for(BookingEvent s : theEvents) {
					System.out.println("EventId: " + s.getBookingId() + " " 
								//+ s.getStudio().getStudioId() 
								+" :: " + s.getBookingTitle());
					  JSONObject bklistObj =new JSONObject();
				        try {
				        	bklistObj.put("id", s.getBookingId());
				        	bklistObj.put("title", s.getBookingTitle());
				        	//bklistObj.put("studioId", s.getStudio().getStudioId());
				        	//bklistObj.put("start",s.getBookingstart());
//				        	bklistObj.put("end",s.getBookingend());
//				        	bklistObj.put("starthour",s.getBookingHourStart());
//				        	bklistObj.put("endhour",s.getBookingHourEnd());
//				        	bklistObj.put("allDay","false");
//				        	bklistObj.put("status", true);
				        	//bklistObj.put("backgroundColor",s.getBackgroundColor());
				        	//bklistObj.put("attendance",s.getStudioNumberInAttendance());

				            ja.put(s.getBookingId(),bklistObj);

				        } catch (JSONException e) {
				            e.printStackTrace();
				        }
		     }
			
			
		     System.out.println(ja);

			 PrintWriter writer = response.getWriter();
		      
		        writer.println(ja);
		        writer.flush();
			
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			action = "BOOK";
		}
		//System.out.println(action);
		switch(action) {
		
			case "LIST":
				listBookingEventss(request, response);
				break;
				
			case "BOOK":
			
				addBookingEvent2(request, response);
				break;

			default:
			
				addBookingEvent2(request, response);
			
				break;
		}
		

	}
	protected void addBookingEvent2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		//make User user = new User();
	    
	    BufferedReader br = new BufferedReader(request.getReader());
	    	while((line = br.readLine()) != null) {
	    		sb.append(line);
	    		
	    	}
	    if(sb.toString().trim() != "null") {
	    		//System.out.println(sb.toString());
	    		
	    		JSONObject json;
	    		JSONArray jsnA;
	    		int studioId= 0;
	    		
	    		String fulldate = "";
	    		String bgColor= "";
	    		String start= "";
	    		String end = "";
	    		String avail="";
	    		String price = "";
	    		String studioName = "";
	    		String selected = "";
	    		List<BookingEvent> theEvents = new ArrayList();
	    		String allday = "";
	    		int counter=0;
				try {
					json = new JSONObject(sb.toString());
					jsnA= new JSONArray(json.getString("studios"));
					
					for(int i=0; i< jsnA.length();i++) {
						JSONObject studio = jsnA.getJSONObject(i);
						BookingEvent studioBooking = new BookingEvent();
						
						Iterator keys =studio.keys(); //2 studio objects
					
						while(keys.hasNext()) {
							Object innerKey = keys.next(); //get keys in those objects
							//studios  objects keys
							JSONObject studioValues = (JSONObject) studio.get(innerKey.toString());
							System.out.println("Values:: "+studioValues.get("studioName").toString());
							allday = studioValues.getString("allDay");
							bgColor=studioValues.getString("bgColor");
							price=studioValues.getString("price");
							studioName=studioValues.getString("studioName");
							StudioDao studioDao = util.SpringFactory.getStudioDao();
//							String studioName = jsnA.getString("studio");
//							
							switch(studioName) {
							
									case "White Room":
										//get studio by id ()  listStudioBookings(request, response);
										studioId = 1;
										
										break;
										
									case "Apothecary":
										studioId = 4;
										break;
									case "Make Believe Studio":
										studioId = 3;
										break;
									//TODO: get studio by studioName; for studio id bc not passing it,
									case "Furniture Design / Upholstery":
										studioId = 5;
										break;
									default:
										studioId = 1;
										break;
							}

							Studio studioObj = studioDao.getStudioByStudioId(studioId);
							//System.out.println(studioObj.toString());
							start=studioValues.getString("start");
							end=studioValues.getString("end");
							
							selected=studioValues.getString("selected");
							avail=studioValues.getString("avail");
							fulldate=studioValues.getString("fulldate");
							//studioBooking.setStudio(studioObj);
							//studioBooking.setStudio(StudioManager.getSingleStudio(studioId));
							
							studioBooking.setBookingTitle(studioName);
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
							Date stime = null;
							try {
								 stime = new Timestamp((sdf.parse(fulldate)).getTime());
								//System.out.println(stime);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//Date eTime = new Timestamp((sdf.parse(end)).getTime());
//							studioBooking.setBookingstart(stime);
//							studioBooking.setBookingend(stime);
//							//sending the hours booked to time of day 2 hr blocks
//							studioBooking.setBookingHourStart(start.substring((start.indexOf(" ")+1),start.length()));
//							studioBooking.setBookingHourEnd(end.substring((end.indexOf(" ")+1),end.length()));
							//studioBooking.setBackgroundColor(bgColor);
							//studioBooking.setAllDay(allday);
							
							//studioBooking.setEventStatus("Reserved");
							//studioBooking.setStudioNumberInAttendance(2);
							theEvents.add(studioBooking);							
					
					}
				}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
	    	
				}
				
				//System.out.println(theEvents.toString());
				//for each event
				for(BookingEvent s: theEvents) {
//					System.out.println(s.getBookingstart().toString() +"  :: BookingEnd " 
//										+s.getBookingend() +"  :: Title " 
//										+ s.getBookingTitle()+"  :: allDay " 
//										+s.getAllDay() +"  ::  background " 
//										+s.getBackgroundColor() + "  ::  hoursEnd " 
//										+s.getBookingHourEnd() +"  :: hoursStart  " 
//										+ s.getBookingHourStart()+"  :: eventStatus ::  " 
//										+ s.getEventStatus() +"  :: attendance ::  "
//										+ s.getStudioNumberInAttendance() +"  :: studioName ::  "
//										+ s.getStudio().getStudioName());
					
					

					BookingEventDao bookeventDao =  new BookingEventDao();
					bookeventDao.addBookingEvent(s);
//					System.out.println("Before Add Booking Event -----------  ");
//					if(bookeventDao.addBookingEvent(s)==1) {
//						System.out.println("add Booking Event -----------  ");
//							request.setAttribute("NOTIFICATION", "Booked eventSaved Successfully!");
//							System.out.println("NOTIFICATION Booked eventSaved Successfully!");
//					
//					}else {
//						request.setAttribute("NOTIFICATION", "Booked event failed!");
//						System.out.println("in error Booking Event Failed-----------  ");
//	//					if(bookeventDao.updateBookingEvent(studioBooking)==1) {
//							request.setAttribute("NOTIFICATION", "Studio Updated Successfully!");
//						}
				}

	    	}//if not null condition

	}
	
	
	protected JSONArray buildBookingEventsList(){
		//List<BookingEvent> eventLS = new ArrayList<BookingEvent>();
		
		JSONArray ja = new JSONArray();
		JSONObject bklistObj =new JSONObject();
        try {
        	bklistObj.put("eventId",2);
        	bklistObj.put("start","2020-06-03 14:00:00");
        	bklistObj.put("end","2020-06-03 16:00:00");
        	bklistObj.put("starthour","2020-06-03 14:00:00");
        	bklistObj.put("endhour","2020-06-03 16:00:00");
        	bklistObj.put("allDay","false");
        	
        	bklistObj.put("backgroundColor","#ff8c82");
        	bklistObj.put("attendance",3);
        	bklistObj.put("studioId", 1);
            ja.put(1,bklistObj);

        } catch (JSONException e) {
            e.printStackTrace();
        }
		
        return ja;
//	(3, '2020-07-16 19:00:00', '2020-07-16 21:00:00', '', '', 'White Room', '#ff8c82', 'Reserved', 3, 1),
//	(4, '2020-06-04 01:00:00', '2020-06-04 03:00:00', '', '', 'White Room', '#ff8c82', 'Reserved', 3, 1),
//	(5, '2020-07-23 23:00:00', '2020-07-24 01:00:00', '', '', 'White Room', '#ff8c82', 'Reserved', 3, 1),
//	(6, '2020-07-23 06:00:00', '2020-07-23 06:00:00', '', '', 'White Room', '#ff8c82', 'Reserved', 3, 1),
//	(7, '2020-07-23 06:00:00', '2020-07-23 06:00:00', '17:00:00', '19:00:00', 'White Room', '#ff8c82', 'Reserved', 3, 1);
	}
	protected void someUserFunction(JSONObject jsonObj) {
		
		
		
		
//		String line = null;
//		String id = null;
//		String pwd = null;
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
//			id=json.getString("id");
//			//assign user.setId(); etc
//			pwd=json.getString("pwd");
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//call the user and send back to front end
//		System.out.println("id="+ id.toString());
//		System.out.println("pwd ="+ pwd.toString());
		
		
		
		//id=json.getString("id");
		//assign user.setId(); etc
		//pwd=json.getString("pwd");
		
       // username=json.getString("username");
        
//  		cardholder_name=json.getString("cardholder_name");
//  		card_number=json.getString("card_number");
//  		expire_date=json.getString("expire_date");
//		ccv=json.getString("ccv");

		
		
		
	}

}
