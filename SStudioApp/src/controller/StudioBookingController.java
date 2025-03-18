package controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;


public class StudioBookingController extends HttpServlet  {

	
	
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
        String username = null;
        String cardholder_name= null;
        String card_number= null;
        String expire_date= null;
        String ccv= null;
		
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
			
            username=json.getString("username");
            
	  		cardholder_name=json.getString("cardholder_name");
	  		card_number=json.getString("card_number");
	  		expire_date=json.getString("expire_date");
			ccv=json.getString("ccv");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//call the user and send back to front end
		System.out.println("id="+ id.toString());
		System.out.println("pwd ="+ pwd.toString());
		
		
		System.out.println("card holder ="+ cardholder_name.toString());
		System.out.println("card_number ="+ card_number.toString());
		
		
		
		System.out.println("expire_date="+ expire_date.toString());
		System.out.println("ccv ="+ ccv.toString());
	}
	
}
