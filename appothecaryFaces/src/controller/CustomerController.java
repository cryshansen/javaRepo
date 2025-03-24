package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CustomerManager;
import entity.Customer;


public class CustomerController extends HttpServlet {
	
	
		
		private static final long serialVersionUID = 1L;
		
		RequestDispatcher dispatcher = null;
		CustomerManager customerManager = null;
		
		public CustomerController() {
			//create the customer manager 
			
			customerManager = new CustomerManager();
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String action = request.getParameter("action");
			
			if(action == null) {
				action = "LIST";
			}
			
			switch(action) {
				
				case "LIST":
					listCustomer(request, response);
					break;
					
				case "EDIT":
					getSingleCustomer(request, response);
					break;
					
				case "DELETE":
					deleteCustomer(request, response);
					break;
					
				default:
					listCustomer(request, response);
					break;
					
			}
			
		}

		private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id = request.getParameter("id");
			Customer cust = customerManager.getSingleCustomer(Integer.parseInt(id));
			if(customerManager.deleteCustomer(cust)==0) {
				request.setAttribute("NOTIFICATION", "Customer Deleted Successfully!");
			}
			
			listCustomer(request, response);
		}

		private void getSingleCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			String id = request.getParameter("id");
			
			Customer theCustomer = customerManager.getSingleCustomer(Integer.parseInt(id));
			
			request.setAttribute("customer", theCustomer);
			
			dispatcher = request.getRequestDispatcher("/views/customerreg.jsp");
			
			dispatcher.forward(request, response);
		}

		private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			List<Customer> theList = customerManager.listCustomers();
			for(Customer c : theList) {
				System.out.println(c.getCustomerName());
			
			}
			request.setAttribute("list", theList);
			
			dispatcher = request.getRequestDispatcher("/views/customerlist.jsp");
			
			dispatcher.forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id = request.getParameter("customerNumber");
			
			Customer customer = new Customer();
			customer.setCustomerName(request.getParameter("customerName"));
			customer.setContactFirstName(request.getParameter("contactFirstName"));
			customer.setContactLastName(request.getParameter("contactLastName"));
			customer.setPhone(request.getParameter("phone"));
			customer.setUsername(request.getParameter("username"));
			customer.setPassword(request.getParameter("password"));
			customer.setAddressLine1(request.getParameter("addressLine1"));
			customer.setAddressLine2(request.getParameter("addressLine2"));
			customer.setCity(request.getParameter("city"));
			customer.setProvince(request.getParameter("province"));
			customer.setCountry(request.getParameter("country"));
			customer.setPostalCode(request.getParameter("postalCode"));

			
			
			if(id.isEmpty() || id == null) {
				
				if(customerManager.registerCustomer(customer)==1) {
					request.setAttribute("NOTIFICATION", "Customer Saved Successfully!");
				}
			
			}else {
				
				customer.setCustomerNumber(Integer.parseInt(id));
				if(customerManager.updateCustomer(customer)==0) {
					request.setAttribute("NOTIFICATION", "Customer Updated Successfully!");
				}
				
			}
			
			listCustomer(request, response);
		}

	}
	
	
	
	


