package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.json.JSONArray;
import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;

import com.google.gson.Gson;

import bll.StudioManager;
import entity.Customer;
import entity.Studio;
import entity.StudioBooking;

public class StudioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	StudioManager studioManager= null;
	private Gson gson = new Gson();
	public StudioController() {
		studioManager = new StudioManager();
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listStudio(request, response);
				break;
				
			case "EDIT":
				getSingleStudio(request, response);
				break;
				
			case "DELETE":
				deleteStudio(request, response);
				break;
				
			case "BOOK":
				listStudioBooking(request, response);
				break;
			
			case "PREV":
				listLastMonthAvailability( request, response);
				break;
			
			case "NEXT":
				listNextMonthAvailability( request, response);
				break;
			
			default:
				listStudio(request, response);
				break;
				
		}
		
	}

	private void deleteStudio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//studioId on form but 'id' parameter in links
		String id = request.getParameter("id");
		Studio studio = studioManager.getSingleStudio(Integer.parseInt(id));
		if(studioManager.deleteStudio(studio)==0) {
			request.setAttribute("NOTIFICATION", "Studio Deleted Successfully!");
		}
		
		listStudio(request, response);
	}

	private void getSingleStudio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//studioId on form but 'id' parameter in links
		String id = request.getParameter("id");
		
		Studio theStudio = studioManager.getSingleStudio(Integer.parseInt(id));
		
		request.setAttribute("studio", theStudio);
		
		dispatcher = request.getRequestDispatcher("/views/studio-form.jsp");
		
		dispatcher.forward(request, response);
	}
	
	//show calendar studio view
	private void listStudioBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException{
		
		//studioId on form but 'id' parameter in links
		String id = request.getParameter("id");
		
		JSONArray ja = new JSONArray(); 
		System.out.println(ja);
	     List<StudioBooking> theBookings = studioManager.getStudioBookings(Integer.parseInt(id));
	     
	     for(StudioBooking s : theBookings) {
				System.out.println(s.getStudio().getStudioId());
				  JSONObject bklistObj =new JSONObject();
			        try {
			        	bklistObj.put("studioId", s.getStudio().getStudioId());
			        	bklistObj.put("start",s.getStudioBookingDate());
			        	bklistObj.put("end",s.getStudioBookingDate());
			        	bklistObj.put("allDay",s.getStudioBookingHours());
			        	
			        	bklistObj.put("backgroundColor",s.getStudioNumberInAttendance());

			            ja.put(s.getStudio().getStudioId(),bklistObj);

			        } catch (JSONException e) {
			            e.printStackTrace();
			        }
	     }
	     System.out.println(ja);

		 PrintWriter writer = response.getWriter();
	      
	        writer.println(ja);
	        writer.flush();
						
				//		for(StudioBooking c : theBookings) {
				//			//System.out.println(c.getStudioBookingDate());
				//		
				//		}
				//		request.setAttribute("list", theBookings);
				//		request.setAttribute("studio", studio);
				//		dispatcher = request.getRequestDispatcher("/views/studio-booking.jsp");
				//		
				//		dispatcher.forward(request, response);
		
	}
	
	private void listLastMonthAvailability(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In last month!");
		//studioId on form but 'id' parameter in links
				String id = request.getParameter("id");
				Studio studio = studioManager.getSingleStudio(Integer.parseInt(id));
				
				List<StudioBooking> theBookings = studioManager.getStudioBookings(Integer.parseInt(id));
//				for(StudioBooking c : theBookings) {
//					//System.out.println(c.getStudioBookingDate());
//				
//				}
				request.setAttribute("list", theBookings);
				request.setAttribute("studio", studio);
		dispatcher = request.getRequestDispatcher("/views/studio-booking.jsp");
		
		dispatcher.forward(request, response);
		
	}
	private void listNextMonthAvailability(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//studioId on form but 'id' parameter in links
				String id = request.getParameter("id");
				Studio studio = studioManager.getSingleStudio(Integer.parseInt(id));
				
				List<StudioBooking> theBookings = studioManager.getStudioBookings(Integer.parseInt(id));
//				for(StudioBooking c : theBookings) {
//					//System.out.println(c.getStudioBookingDate());
//				
//				}
				request.setAttribute("list", theBookings);
				request.setAttribute("studio", studio);
		System.out.println("In Next Month!");
		dispatcher = request.getRequestDispatcher("/views/studio-booking.jsp");
		
		dispatcher.forward(request, response);
		
	}
	private void listStudio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fyi   JSONObject inp = (JSONObject) JSONValue.parse(request.getParameter("param1"));
		List<Studio> theList = studioManager.listStudios();
		
		//String element = gson.toJson( theList, new ArrayList<Studio>() {});
		//Create JSONArray from String:

		//JSONArray list = new JSONArray(element);
		
		JSONArray studioArray = new JSONArray();
		JSONArray ja = new JSONArray();  
		for(Studio c : theList) {
			System.out.println(c.getStudioName());
			  JSONObject obj =new JSONObject();
			  
		        try {
		        	obj.put("studioId",c.getStudioId());
		        	 obj.put("studioName",c.getStudioName());
		        	 obj.put("studioDescription",c.getStudioDescription());
		        	 obj.put("price",c.getStudioCharge());
		        	 obj.put("studioSizeSq",c.getStudioSizeSq());
		        	 obj.put("studioAvailability",c.getStudioAvailability());
		            obj.put("studioAccessories",c.getStudioAccessories());
		            ja.put(c.getStudioId(),obj);
		           // studioArray..put("studio",ja);
		        } catch (JSONException e) {
		            e.printStackTrace();
		        }
			  }
		
		
		 PrintWriter writer = response.getWriter();
	      
	        writer.println(ja);
	        writer.flush();
     
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action =  request.getParameter("action");
		switch(action) {
		
			case "NEXT":
				listNextMonthAvailability(request, response);
				break;
			case "PREV":
				listLastMonthAvailability(request, response);
				break;
			default:
				createStudio(request, response);
				break;
		}		
		
		
	}
	
	
	//save
	private void createStudio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//studioId on form but 'id' parameter in links
		String id = request.getParameter("studioId");
		Studio studio = new Studio();
		studio.setStudioName(request.getParameter("studioName"));
		
		studio.setStudioSizeSq(request.getParameter("studioSizeSq"));
		studio.setStudioDescription(request.getParameter("studioDescription"));
		studio.setStudioAvailability(request.getParameter("studioAvailability"));
		String charge = request.getParameter("studioCharge");
		if(charge==null) {
			studio.setStudioCharge(new BigDecimal(0.00));
		}else {
			BigDecimal bigDecimalCurrency=new BigDecimal(charge); 
			studio.setStudioCharge(bigDecimalCurrency);
		}
		
		studio.setStudioAccessories(request.getParameter("studioAccessories"));
		
		
		
		if(id.trim().isEmpty() || id == null) {
			
			if(studioManager.createStudio(studio)==1) {
				request.setAttribute("NOTIFICATION", "Studio Saved Successfully!");
			}
		
		}else {
			
			studio.setStudioId(Integer.parseInt(id));
			if(studioManager.updateStudio(studio)==0) {
				request.setAttribute("NOTIFICATION", "Studio Updated Successfully!");
			}
			
		}
	}
	
	
	// next month
	//function jsonParser(){
	
//	
//	JSONObject obj1 = new JSONObject(strAPI_TERMINAL);
//	 try {
//	  JSONArray result = obj1.getJSONArray("terminal");
//	for(int i=0;i<=result.length();i++)
//	 {
//	    String Id=result.getString("fmt_id");
//	      String terminalType=result.getString("terminal_type");
//	 }
//	 } catch (JSONException e) {
//	     e.printStackTrace();
//	}
	
	//}

}
