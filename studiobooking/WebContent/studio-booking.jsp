<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class = "container" ng-controller="ParamsController">
		
		<h1>Studio {{paramValue}}</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<a href = "${pageContext.request.contextPath}/StudioController?action=LIST">Studio List</a>
		</p>
			
			<div ng-repeat="s in studioBDates"> 
				<p>{{s.studioId}}</p> 
				<p>{{s.allDay}}</p>
				<p>{{s.backgroundColor}}</p>	
				<div class="grid-container no-color">
					<div>${s.start}</div>
					<div >{{s.end}}</div>
					
				<div>						
			</div>
		
		<!--     -->
		<main class="body_flow">
				<div class="page_flow">
					<div class="content">
						<section class="page_block">
							<%-- <div ng-app="calendarApp">
								<div ng-controller="calendarDemo">
						        	<calendar selected="day"></calendar>
					        		<br style="clear:all;"/>
									<label>Selected date: <b>{{day.format('dddd, MMMM Do YYYY')}}</b></label>
									<%@ include file="component/modal.html" %>  
								</div>
								 
							</div> --%>
						</section>						
					</div>
				</div>
			
		</main> 

	</div>	
