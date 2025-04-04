package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;

import bll.StudioManager;
import entity.Studio;
import entity.StudioBooking;

public class StudioCalendarController extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	StudioManager studioManager= null;
	
	public StudioCalendarController() {
		studioManager = new StudioManager();
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		System.out.println(action);
		switch(action) {
		
			case "LIST":
				listStudioBookings(request, response);
				break;
				
			case "BOOK":
				listStudioBookings(request, response);
				break;
			
			
			
			default:
				listStudioBookings(request, response);
				break;
			
		}
	
		
		
	
	}
	
	//show calendar studio view
	private void listStudioBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

//		String line = null;
//		String id = null;
//		String pwd = null;
		
		
		StringBuilder sb = new StringBuilder();
		//make User user = new User();
	    
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
//		
//		
//		//studioId on form but 'id' parameter in links
//		String studioid = request.getParameter("id");
		Studio studio = studioManager.getSingleStudio(Integer.parseInt("1"));
		
		List<StudioBooking> theBookings = studioManager.getStudioBookings(Integer.parseInt("1"));
		for(StudioBooking c : theBookings) {
			System.out.println(c.getStudioBookingDate());
		
		}
		request.setAttribute("list", theBookings);
		request.setAttribute("studio", studio);
		dispatcher = request.getRequestDispatcher("/views/studio-booking.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	
}
