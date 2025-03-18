package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.json.JSONArray;
import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;

import dao.CalendarEventDao;
import entity.BookingEvent;
import entity.CalendarEvent;

public class CalendarEventController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			action = "LIST";
		}
		System.out.println(action);
		switch(action) {
		
			case "LIST":
				listCalendarBookedEvents(request, response);
				break;
				
			case "BOOK":
				listCalendarBookedEvents(request, response);
				break;

			default:
				listCalendarBookedEvents(request, response);
				break;
		}
		
		
		
		
	
		
	}
	//show calendar studio view
	private void listCalendarBookedEvents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CalendarEventDao calDao = new CalendarEventDao();
		
		List<CalendarEvent> theList = calDao.getCalendarEvent();
		
		JSONArray ja = new JSONArray(); 
		for(CalendarEvent e : theList) {
			 JSONObject bklistObj =new JSONObject();
		        try {
		        	
		        	bklistObj.put("id",e.getCalEventId() );
		        	bklistObj.put("title", e.getCalEventTitle() );
		        	bklistObj.put("start","2020-06-22 06:00:00");
		        	bklistObj.put("end","2020-06-22 06:00:00");
		        	bklistObj.put("starthour","13:00:00");
		        	bklistObj.put("endhour","13:00:00");
		        	bklistObj.put("allDay","false");
		        	bklistObj.put("status", true);
		        	bklistObj.put("backgroundColor",e.getBgColor());
		        	bklistObj.put("attendance",2);
		        	
		        }catch( Exception ex){
		        	ex.getStackTrace();
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
				listCalendarEvents(request, response);
				break;
				
			case "BOOK":
			
				addCalendarEvent(request, response);
				break;

			default:
			
				addCalendarEvent(request, response);
			
				break;
		}
		

	}
	
	protected void listCalendarEvents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}
	
	
	protected void addCalendarEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		//make User user = new User();
	    String line;
	    BufferedReader br = new BufferedReader(request.getReader());
	    	while((line = br.readLine()) != null) {
	    		sb.append(line);
	    		
	    	}
	    if(sb.toString().trim() != "null") {
	    	JSONObject json;
    		JSONArray jsnA;
    		//int studioId= 0;
    		
    		String fulldate = "";
    		String bgColor= "";
    		String start= "";
    		String end = "";
    		String avail="";
    		String price = "";
    		String studioName = "";
    		String selected = "";
    		String allday = "";
    		List<CalendarEvent> theEvents = new ArrayList();
    		try {
				json = new JSONObject(sb.toString());
				jsnA= new JSONArray(json.getString("studios"));
				
				for(int i=0; i< jsnA.length();i++) {
					JSONObject studio = jsnA.getJSONObject(i);
					CalendarEvent studioBooking = new CalendarEvent();
					CalendarEventDao studioEventDao = new CalendarEventDao();
					
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
						start=studioValues.getString("start");
						end=studioValues.getString("end");
						selected=studioValues.getString("selected");
						avail=studioValues.getString("avail");
						fulldate=studioValues.getString("fulldate");
						
						
						
						studioBooking.setCalEventTitle(studioName);
						studioBooking.setBgColor(bgColor);
						//theEvents.add(studioBooking);
						studioEventDao.addCalendarEvent(studioBooking);
						
					}
				}
    		} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
    	
			}
    		
    		
	    }
	}

}
