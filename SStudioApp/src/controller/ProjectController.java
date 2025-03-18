package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import dao.StudioBookingDao;
import entity.Project;
import entity.StudioBooking;
import dao.ProjectDao;


public class ProjectController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	StudioManager studioManager= null;
	private Gson gson = new Gson();
	private ProjectDao projDao = util.SpringFactory.getProjectDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
		
		case "LIST":
			listProjects(request, response);
			break;
		case "EDIT":
			getSingleProject(request, response);
			break;
			
		case "DELETE":
			deleteProject(request, response);
			break;
		default:
			listProjects(request, response);
			break;
		}
		
	}
	
	protected void listProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//studioId on form but 'id' parameter in links
				String id = request.getParameter("id");
				
				JSONArray ja = new JSONArray(); 
				System.out.println(ja);
			     List<Project> theProjects = projDao.getProjects();
			     
			     for(Project s : theProjects) {
						System.out.println(s.getProjectId());
						  JSONObject bklistObj =new JSONObject();
					        try {
					        	bklistObj.put("projectId", s.getProjectId());
					        	bklistObj.put("projectName",s.getProjectName());
					        	bklistObj.put("projectDescription",s.getProjectDescription());
					        	bklistObj.put("projectFee",s.getProjectFee());
					        	
					        	bklistObj.put("projectLength",s.getProjectLength());
					        	bklistObj.put("project_image",s.getProject_image());
					            ja.put(s.getProjectId(),bklistObj);

					        } catch (JSONException e) {
					            e.printStackTrace();
					        }
			     }
			     System.out.println(ja);

				 PrintWriter writer = response.getWriter();
			      
			        writer.println(ja);
			        writer.flush();
		
	}
	protected void getSingleProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void deleteProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String id = request.getParameter("id");
	}
	
}
