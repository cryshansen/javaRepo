package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.StudioManager;
import entity.Customer;
import entity.Studio;
import entity.StudioBooking;

public class StudioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	StudioManager studioManager= null;
	
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
	private void listStudioBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//studioId on form but 'id' parameter in links
		String id = request.getParameter("id");
		Studio studio = studioManager.getSingleStudio(Integer.parseInt(id));
		
		List<StudioBooking> theBookings = studioManager.getStudioBookings(Integer.parseInt(id));
//		for(StudioBooking c : theBookings) {
//			//System.out.println(c.getStudioBookingDate());
//		
//		}
		request.setAttribute("list", theBookings);
		request.setAttribute("studio", studio);
		dispatcher = request.getRequestDispatcher("/views/studio-booking.jsp");
		
		dispatcher.forward(request, response);
		
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
		
		List<Studio> theList = studioManager.listStudios();
//		for(Studio c : theList) {
//			System.out.println(c.getStudioName());
//		
//		}
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/views/studiolist.jsp");
		
		dispatcher.forward(request, response);
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
	

}
