package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.StudioManager;
import entity.Studio;

public class StudioListingController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	StudioManager studioManager= null;
	
	public StudioListingController() {
		studioManager = new StudioManager();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
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
		
dispatcher = request.getRequestDispatcher("/views/studiolist.jsp");
		
		dispatcher.forward(request, response);
		
	}
}
