<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container"  ng-controller="ParamsController">
   <div class="row">
        <div class="col">
			  <div ng-controller="ListStudiosCtrl as list">
			    <div ng-repeat="studio in list.studios | filter : paramValue">
			    <!-- <h1>Studio {{ studio.studioName }} </h1> -->
			    	<h1>Studio:  {{ studio.studioName }} </h1>
			    	<hr/>
			    	<!-- get description and all other options here this is a list only -->
			    </div>
			  </div>
		</div>
		<div class="row">
				<div ng-repeat="s in studiosList">
					<div class="col-xs-12 col-md-12 col-sm-12 col-lg-12">
						<div class="col2">{{s.start}}</div>
						<div class="col2">{{s.end}}</div>
						<div class="col2">{{s.allDay}}</div>
						<div class="col2">{{s.studioId}}</div>
						<div class="col2">{{studios.backgroundColor}}</div>
					</div>
				
				</div>
		</div>
	</div>
</div>
