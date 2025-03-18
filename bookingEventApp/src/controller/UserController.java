package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.io.*;
import org.apache.tomcat.util.json.JSONParser;
import org.richfaces.json.HTTP;
import org.richfaces.json.JSONException;

import org.richfaces.json.JSONObject;


public class UserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setAttribute("us", theBookings);
//		request.setAttribute("studio", studio);
//		dispatcher = request.getRequestDispatcher("/views/studio-booking.jsp");
//		
//		dispatcher.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String line = null;
		String id = null;
		String pwd = null;
		StringBuilder sb = new StringBuilder();
		//make User user = new User();
	    
	    BufferedReader br = new BufferedReader(request.getReader());
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
		
		System.out.println(sb.toString());
		try {
			JSONObject json = new JSONObject(sb.toString());
			id=json.getString("id");
			//assign user.setId(); etc
			pwd=json.getString("pwd");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//call the user and send back to front end
		System.out.println("id="+ id.toString());
		System.out.println("pwd ="+ pwd.toString());
	}
	
	
}
