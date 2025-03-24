<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Studio Booking</title>
  <link rel="StyleSheet" href="css/features.css" type="text/css" media="screen" />

  <script type="text/javascript" src="js/jquery/jquery-3.4.1.js"></script>
  <script type="text/javascript" src="js/includes.js"></script>
<!--   <script type="text/javascript" src="js/calendar_modal.js"></script>   -->   <!-- AngularJs File -->
    <script type="text/javascript" src="resources/js/angular_v1.6.0.js"></script>
    <script type="text/javascript" src="resources/js/ang_http_post_data.js"></script>
  
   <!-- Bootstrap Css -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">  
 <style>.no-color{background-color:#fff !important;}</style>
 <style>
/*  #modal_component{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vw;
    z-index: 9;
} */
#myModal{
	display: none;
    position: absolute;
    top: 18%;
    left: 0;
    width: 100%;
    height: 80vw;
    z-index: 9;
 
}

.modal{
	background-color: #fff;
	border: 2px solid #f5d5d5;
	padding: 10px;
	position:absolute;
	top:0;
	left:0;
	z:index:999;
	
}
.modal-content{
	align-items: center;
  justify-items: center;
}
.time_grid{width:100%;}
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto auto;
  grid-gap: 5px;
  background-color: #f5d5d5;
  padding: 10px;
  border-radius: 8px;
 /* adjusted */
}

.grid-container > div {
  background-color: #fff;
  text-align: center;
  padding: 20px 0;
  font-size: 15px;
}

.item1 {
  grid-column: 1 / 5;
  
  justify-column:left;
}
.item1 h2{
	justify-content:left;
	text-align:left;
	padding:5px;
}
.item13 .plus,
.item17 .plus,
.item21 .plus,
.item25 .plus,
.item29 .plus,
.item33 .plus,
.item9 .plus{
cursor: pointer;
  height: 30px;
  width: 30px;
  
  background-color: #f5d5d5;
  border-radius: 20%;
  display: inline-block;
}

.item13 .plus:before,
.item17 .plus:before,
.item21 .plus:before,
.item25 .plus:before,
.item29 .plus:before,
.item33 .plus:before,
.item9 .plus:before{content:"+"; color:#fff; font-weight:bold;}

.grid-container .taken{

	background-color:#yellow !important;

}
.modal{

display:none;
}
</style>			
<style type="text/less">
			body { font-family:Arial; font-size:14px; }
			body>span, body>h1 { float:left; width:100%; margin:0; padding:0; margin-bottom:10px; }
			
			span { color:#888888;
                >b { color:black; }
            }
            
            .vertical-centre (@height) { height:@height; line-height:@height !important; display:inline-block; vertical-align:middle; }
            .border-box { box-sizing:border-box; -moz-box-sizing:border-box; }

            @border-colour:#CCC;
            calendar { float:left; display:block; .border-box; background:white; width:300px; border:solid 1px @border-colour; margin-bottom:10px;
                @secondary-colour:#2875C7;
                @spacing:10px;
                
                @icon-width:40px;
                @header-height:40px;
                
                >div.header { float:left; width:100%; background:@secondary-colour; height:@header-height; color:white;
                    >* { .vertical-centre(@header-height); }
                    >i { float:left; width:@icon-width; font-size:1.125em; font-weight:bold; position:relative; .border-box; padding:0 @spacing; cursor:pointer; }
                    >i.fa-angle-left { text-align:left; }
                    >i.fa-angle-right { text-align:right; margin-left:@icon-width*-1; }
                    >span { float:left; width:100%; font-weight:bold; text-transform:uppercase; .border-box; padding-left:@icon-width+@spacing; margin-left:@icon-width*-1; text-align:center; padding-right:@icon-width; color:inherit; }
                }
                >div.week { float:left; width:100%; border-top:solid 1px @border-colour;
                    &:first-child { border-top:none; }
                    >span.day { float:left; width:100%/7; .border-box; border-left:solid 1px @border-colour; font-size:0.75em; text-align:center; .vertical-centre(30px); background:white; cursor:pointer; color:black;
                        &:first-child { border-left:none; }
                        &.today { background:#E3F2FF; }
                        &.different-month { color:#C0C0C0; }
                        &.selected { background:@secondary-colour; color:white; }
                    }
                    &.names>span { color:@secondary-colour; font-weight:bold; }
                }
            }
        </style>
		
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.min.js"></script>
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.5/less.min.js"></script>
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.7.0/underscore-min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.3/moment.min.js"></script>
          <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.1.1/fullcalendar.min.css" />
   		 <script src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.1.1/fullcalendar.min.js"></script>
		<script type="text/javascript">
			var app = angular.module("calendarApp", []);

            app.controller("calendarDemo", function($scope, $http,$rootScope) {
                //todays date
            	$scope.day = moment();
                $scope.availHours = {start: "",
	                        end: "",
	                        price: '$90.00'
                        };
               $scope.studioId = $scope.id;
               console.log("studioId" + $scope.studioId);
            	//To get the hour/minute/second as numbers, use moment().hour(); / moment().minute(); / moment().second();
                //getmonth for day
                
                /* //for ajax calls
                $scope.myData = {};
            	$scope.myData.doClick = function(item, event) {

                var responsePromise = $http.get("/json-test-data.jsp");

                responsePromise.success(function(data, status, headers, config) {
                    $scope.myData.fromServer = data.title;
                });
                responsePromise.error(function(data, status, headers, config) {
                    alert("AJAX failed!");
                }); */
           // }
                //
                
                
                
            });
            
            
           
			
            app.directive("calendar", function() {
                return {
                    restrict: "E",
                    templateUrl: "templates/calendar.html",
                    scope: {
                        selected: "=",
                        availHours: "=",
                        studioId: "="
                        
                    },
                    link: function(scope) {
                    	
                        scope.selected = _removeTime(scope.selected || moment());
                        scope.month = scope.selected.clone();
                        
                        var start = scope.selected.clone();
                        start.date(1);
                        _removeTime(start.day(0));

                        _buildMonth(scope, start, scope.month);

                        scope.select = function(day) {
                        	
                            scope.selected = day.date; 
                            console.log('selected day.date '+ scope.selected);
                           // console.log($scope.root);
                            //here to call ajax
                            //call popup
                           availHours = _getModelWindow(scope,scope.selected);
                         //____________   added this _____________________//
                           var modalcalendarInstance = $modal.open({
                        	      templateUrl: 'calModalContent.html',
                        	      controller: calendarInstance,
                        	      resolve: {
                        	        items: function () {
                        	          return $scope.items;
                        	        }
                        	      }
                        	    });

                        	    modalcalendarInstance.result.then(function () {
                        	      return;
                        	    }, function () {
                        	      console.log('Modal dismissed at: ' + new Date());
                        	    });
                        	  //____________   added this _____________________//
                            
                        };

                        scope.next = function() {
                        	// //get ajax call only if same as todays date month/year call _loadBookings
                            var next = scope.month.clone();
                            _removeTime(next.month(next.month()+1).date(1));
                            scope.month.month(scope.month.month()+1);
                            _buildMonth(scope, next, scope.month);
                            //get ajax call of bookings
                        };

                        scope.previous = function() {
                        	// //get ajax call only if same as todays date month/year call _loadBookings
                            var previous = scope.month.clone();
                            _removeTime(previous.month(previous.month()-1).date(1));
                            scope.month.month(scope.month.month()-1);
                            _buildMonth(scope, previous, scope.month);
                           
                            
                        };
                        
                    }
                };
		
                function _removeTime(date) {
                    return date.day(0).hour(0).minute(0).second(0).millisecond(0);
                }

                function _buildMonth(scope, start, month) {
                    scope.weeks = [];
                    var done = false, date = start.clone(), monthIndex = date.month(), count = 0;
                    while (!done) {
                        scope.weeks.push({ days: _buildWeek(date.clone(), month) });
                        date.add(1, "w");
                        done = count++ > 2 && monthIndex !== date.month();
                        monthIndex = date.month();
                    }
                }

                function _buildWeek(date, month) {
                    var days = [];
                    for (var i = 0; i < 7; i++) {
                        days.push({
                            name: date.format("dd").substring(0, 1),
                            number: date.date(),
                            isCurrentMonth: date.month() === month.month(),
                            isToday: date.isSame(new Date(), "day"),
                            date: date
                        });
                        date = date.clone();
                        date.add(1, "d");
                    }
                    return days;
                }
                //call ajax for time slots
                function _loadBookings(date){
	                //call ajax to get bookings for date availability
	                console.log("loadBookings" + date);
                }

                
                function _addTime(timevalue){
                	//create shopping cart of items.
                	
                	console.log(timevalue);
                	
                	
                }
                
                function _getModelWindow(scope,buttonDate){
                	console.log(scope);// css button with <time> tag and text value; get innerhtml
                	//[Log] <button class="active_dates" onclick="getModelWindow(this);">1</button> (includes.js, line 129)
                	var mhoursAvail = [];
                	var availHours = [];
                	const dateclickOnly = buttonDate.format('YYYY.MM.DD');
                	
                	_loadBookings(dateclickOnly);
                	const currentTime = moment().format('HH:mm:ss'); // 20:39:52
    				const dateWithCurrentTime =  moment(dateclickOnly+' '+currentTime,'YYYY.MM.DD HH:mm:ss').format('MM.DD.YYYY HH:mm:ss');
    				console.log(currentTime);
                	console.log(dateclickOnly);
                	console.log(dateWithCurrentTime); 
                	                     // Results will go here
                	  // Get current hour of the day

                	// Loop from current hour number to 23
                	for(var i = 8; i < 22; i+=2){
                	  if(i >= 12){
                		  if(i===12){ mhoursAvail.push((i) + ":00");}
                		  	i+1;
                		  	mhoursAvail .push((i+1) + ":00");  // Put loop counter into array with "00" next to it
                	  		
                		  
                	  	}else{
                	  		mhoursAvail .push(i + ":00");  // Put loop counter into array with "00" next to it
                    	  	
                	  	}
                	}
                	
                	console.log(mhoursAvail.length);
                	for(var i=0;i < (mhoursAvail.length-1); i++){
                		if((i+1)>7){
                			console.log(i);
                		}else{
                			
                			availHours.push({
                                start: mhoursAvail[i],
                                end: mhoursAvail[i+1],
                                price: '$90.00'
                            });
                			if(availHours[i].start != "12:00")
                			console.log(availHours[i].start + " - " + availHours[i].end  + " - " + availHours[i].price);
                		}
                		
                	}
                	
                	
                	
                	
                	//scope.hoursAvail = hoursAvail;
                	//moment(date+' '+time,'DD/MM/YYYY HH:mm').format('MM.DD.YYYY');
                	// Get the modal
                	var modal = document.getElementById("myModal");
                	//var parent_modal = document.getElementById("modal_component");
                	var page_section = document.getElementsByClassName("page_block")[0];
                	// Get the button that opens the modal
                	//var btn = document.getElementById(dateWithCurrentTime);
                	//var hours = document.getElementById("hours");
                	
                	// Get the <span> element that closes the modal
                	var span = document.getElementsByClassName("close")[0];
                	var btn2 = document.getElementsByClassName("return_cal")[0];
                	// When the user clicks the button, open the modal 
                	//btn.onclick = function() {
                	  modal.style.display = "block";
                	  //parent_modal.style.display="block"; 
                	//}
                	 
                	// When the user clicks on <span> (x), close the modal
                	span.onclick = function() {
                	  modal.style.display = "none";
                	  //parent_modal.style.display="none"; 
                	  page_section.style.display="block";
                	}
                	btn2.onclick =function() {
                	  modal.style.display = "none";
                	  //parent_modal.style.display="none"; 
                	  page_section.style.display="block";
                	}
                	// When the user clicks anywhere outside of the modal, close it
                	window.onclick = function(event) {
                	  if (event.target == modal) {
                	    modal.style.display = "none";
                	    //parent_modal.style.display="none"; 
                	    page_section.style.display="block";
                	  }
                	}
                	return availHours; 
                }
                
                
                
                
            });
            
            
            
		</script>


</head>
<body>

	<div class = "container">
		
		<h1>Studio Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<a href = "${pageContext.request.contextPath}/StudioController?action=LIST">Studio List</a>
		</p>
			<div>
				<c:set var="studio" value="${studio}" />
				<p>${studio.studioName}</p>
					<p>${studio.studioDescription}</p>
					<div class="grid-container no-color">
					<div>${studio.studioSizeSq} square ft</div>
					<div>
					
					<c:choose>
					  <c:when test="${studio.studioAvailability}==1}">
					    Available
					  </c:when>
					  <c:when test="${studio.studioAvailability}==0}">
					    Not Available
					  </c:when>
					</c:choose>
					
					</div>
					<div>${studio.studioAccessories}</div>
					<div>$${studio.studioCharge}</div>
					</div>

			
			<%-- <c:forEach items="${list}" var="studiobooking">	
			
	        	<c:out value="${studiobooking.studioBookingId}"/>
				<c:out value="${studiobooking.studioBookingDate}" />
				<c:out value="${studiobooking.studioBookingHours}"/>
				<c:out value="${studiobooking.studioNumberInAttendance}"/>
					
				</c:forEach> --%>
			</div>
		
		<!--     -->
		<main class="body_flow">
				<div class="page_flow">
					<div class="content">
						<section class="page_block">
							<div ng-app="calendarApp">
								<div ng-controller="calendarDemo">
						        	<calendar selected="day"></calendar>
					        		<br style="clear:all;"/>
									<label>Selected date: <b>{{day.format('dddd, MMMM Do YYYY')}}</b></label>
									<%-- <%@ include file="component/modal.html" %>   --%>
								</div>
								 
							</div>
						</section>						
					</div>
				</div>
			
		</main> 
<!-- 
<script type="text/javascript">
var angularApp = angular.app('demo', []);

angularApp.controller('bookingViewModel', ['$scope', function ($scope) {
    var selectedDate = this;
    console.log(selectedDate);
	//$scope.selected = selected;
	__getModelWindow(selectedDate);
}]);

</script> -->

		

</body>
</html>