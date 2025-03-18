<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
	.block {
	    position: absolute;
	    background: #fff;
	    /* padding: 20px; */
	    width: 320px;
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
	<div class ="flex-container" ng-controller="studioStaticGalleryController"  id="gallery" data-toggle="modal" data-target="#exampleModal">
	
	<!-- https://benholland.me/javascript/2012/02/20/how-to-build-a-site-that-works-like-pinterest.html  masonry style layout-->
	<!-- https://www.erikjo.com/work  -->
							    					    
	    <!-- Create multiple versions of this with different content -->
	    <div class="block" ngClass="block">									    	
	    	<img class="w-100" src="images/studio3/576/129A9167.JPG"  alt="{{studioName}}">								    	
	    </div>	
	    <div class="block" ngClass="block">	
			<img class="w-100" src="images/studio3/576/129A9166.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9204.JPG"  alt="{{studioName}}">
			</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9200.JPG"  alt="{{studioName}}">
			</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9189.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9176.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9163.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9203.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9161.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9202.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9192.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9187.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9191.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9184.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9190.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"> <img class="w-100" src="images/studio3/576/129A9194.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9180.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block"><img class="w-100" src="images/studio3/576/129A9181.JPG"  alt="{{studioName}}">
		</div>	
	    <div class="block" ngClass="block">	<img class="w-100" src="images/studio3/576/129A9168.JPG"  alt="{{studioName}}">
	    </div>
			<div class="block" ngClass="block">	<img class="w-100" src="images/studio3/576/129A9196.JPG"  alt="{{studioName}}">
	    </div>
	    
	</div>	
	<!-- Modal -->
<!-- 
This part is straight out of Bootstrap docs. Just a carousel inside a modal.

https://css-tricks.com/creating-a-modal-image-gallery-with-bootstrap-components/
-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div id="carouselExample" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExample" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExample" data-slide-to="1"></li>
            <li data-target="#carouselExample" data-slide-to="2"></li>
            <li data-target="#carouselExample" data-slide-to="3"></li>
            <li data-target="#carouselExample" data-slide-to="4"></li>
            <li data-target="#carouselExample" data-slide-to="5"></li>
          </ol>
          <div class="carousel-inner">
            
           
           		<div class="carousel-item active" ngClass="carousel-item">									    	
	    			<img class="d-block w-100" src="images/studio3/576/129A9167.JPG"  alt="{{studioName}}">								    	
	    		</div>	
			    <div class="carousel-item" ngClass="carousel-item">	
					<img class="d-block w-100" src="images/studio3/576/129A9166.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9204.JPG"  alt="{{studioName}}">
					</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9200.JPG"  alt="{{studioName}}">
					</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9189.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9176.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9163.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9203.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="d-block w-100" src="images/studio3/576/129A9161.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="d-block w-100" src="images/studio3/576/129A9202.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="d-block w-100" src="images/studio3/576/129A9192.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="w-100" src="images/studio3/576/129A9187.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="d-block w-100" src="images/studio3/576/129A9191.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="d-block w-100" src="images/studio3/576/129A9184.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="d-block w-100" src="images/studio3/576/129A9190.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"> <img class="d-block w-100" src="images/studio3/576/129A9194.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9180.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item"><img class="d-block w-100" src="images/studio3/576/129A9181.JPG"  alt="{{studioName}}">
				</div>	
			    <div class="carousel-item" ngClass="carousel-item">	<img class="d-block w-100" src="images/studio3/576/129A9168.JPG"  alt="{{studioName}}">
			    </div>
				<div class="carousel-item" ngClass="carousel-item">	<img class="d-block w-100" src="images/studio3/576/129A9196.JPG"  alt="{{studioName}}">
			    </div>
          
          
          </div>
          <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExample" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>