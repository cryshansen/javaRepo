<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
	.block {
	    position: absolute;
	    background: #fff;
	    /* padding: 20px; */
	    width: 300px;
	    border: 1px solid #ddd;
		/* float: left !important; */
		
    -webkit-transition: all 1s ease-in-out;
    -moz-transition: all 1s ease-in-out;
    -o-transition: all 1s ease-in-out;
    -ms-transition: all 1s ease-in-out;
    transition: all 1s ease-in-out; 
}

.vertical-center {
  min-height: 100%;
  min-height: 100vh;
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  
  
  
  -webkit-box-align: center;
  -webkit-align-items: center;
  -moz-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  width: 100%;
  -webkit-box-pack: center;
  -moz-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
}
.flex-container {
  display: flex;
  flex-flow: row wrap;
  justify-content: flex-start;
}

</style>

	<div class = "flex-container" id="gallery" ng-controller="studioGalleryController">
			    
	    <!-- Create multiple versions of this with different content -->
	    <div class="block" ngClass="block" *ngFor="s in studioImages">
	     	<ngui-in-view>									    	
	    		<img *ngIf class="w-100" ng-src="{{s.imgUrl}}" alt="{{studioName}}"> 
	    	 <ngui-in-view>
	    								    	
	    </div>	
</div>

