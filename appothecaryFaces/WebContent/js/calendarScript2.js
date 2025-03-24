//https://embed.plnkr.co/plunk/sY7V3S fullcalendar example angular google
var calendarApp = angular.module("calendarApp", ['ui.bootstrap','ui.router'])
.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider.state('signin', {
    url: "/signin",
    views: {
		'mainContainer': {
			templateUrl: "signin.html"

		}
	},
  }).state('signUp', {
    url: "/signUp",
    views: {
		'mainContainer': {
			templateUrl: "signUp.html"
		}
	}
  }).state('calendar', {
    url: "/calendar",
    views: {
		'mainContainer': {
			templateUrl: "calendarSampleCalendar.html"
		}
	}
  })
  

})
.controller("maincontroller",function($scope,$state,$rootScope){
  this.isSignup = false;
  
  $scope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams, options){ 
    // console.log("Success : ",event, toState, toParams, fromState, fromParams, options)
  })
  
  $scope.$on('$stateChangeError', function(event, toState, toParams, fromState, fromParams, options){ 
    // console.log("Error : ",toState)
  });
  
  $scope.$on('$stateChangeSuccess', function(event, current) {
    // console.log(event, current)
  });
  $state.go("signin");
}).directive("calendarShow", function() {
  return { 
    restrict: 'A',
    link: function (scope, oElement, attrs) {
      scope.resetVariables = function(){
        scope.edit = true;
        scope.getTitle = '';
        scope.getStudioTitle='';
        scope.getStartTime = "";
        scope.getHoursSelected ="";
        scope.getDate = "";
        scope.getEndTime = "";
        scope.setSelectedDate = "";
        scope.end_time = "";
        scope.start_time = "";
        scope.event_date = "";
        scope.event_title = "";
        scope.event_color = "#ccc";
        scope.cart = [];
        scope.cartItem = {};
        scope.hoursCanBook= [{
        	start: '08:00 AM',
            end:'10:00 AM',
            price: '$90.00',
            avail: 'N',
            selected:''
        	
        },{
        	start: '10:00 AM',
            end:'12:00 AM',
            price: '$90.00',
            avail: 'Y',
            selected:''
        },{
        	start: '13:00 PM',
            end:'15:00 PM',
            price: '$90.00',
            avail: 'Y',
             selected:''
        },{
        	start: '15:00 PM',
            end:'17:00 PM',
            price: '$90.00',
            avail: 'Y',
            selected:''
        },{
        	start: '17:00 PM',
            end:'19:00 PM',
            price: '$90.00',
            avail: 'Y',
            selected:''
        },{
        	start: '19:00 PM',
            end:'21:00 PM',
            price: '$90.00',
            avail: 'Y',
            selected:''
        }]
        
      }
    
    
      
      scope.init = function() {
    	  var date = new Date();
          var d = date.getDate();
          var m = date.getMonth();
          var y = date.getFullYear();
          
          var calendar = $('#calendar').fullCalendar({
            header: {
              left: 'prev,next',
              center: 'title',
              right: 'month,agendaDay'
            },
            editable:false,
            selectable: true,
            selectHelper: true,
            select: function(start, end, allDay) {
            	//get the id of the modal
              $("#bookingCreate").modal("show");
              calendar.fullCalendar('unselect'); 
            },
            dayClick: function(date, jsEvent, view) {
              scope.setSelectedDate = date.format("YYYY-MM-DD");
              scope.$apply();
            },
            
            //editing an event via eventonClick
            eventClick: function(calEvent, jsEvent, view) {
              scope.getTitle = calEvent.title;
              scope.getStudioTitle = calEvent.title;
              scope.getDate = moment(calEvent.start).format("YYYY-MM-DD");
              
              //convert it back to hour minutes am/pm and compare to huorsAvail hour.start and select that box
              const numb12 = moment(calEvent.start, ["h:mm A"]).format("HH:mm");
              if(numb12 > '12:00'){
            	  //append PM to
            	  console.log(numb12 + " PM");
            	  scope.getHourSelected = numb12 + " PM";
              }else{
            	  //append AM
            	  console.log(numb12 + " AM");
            	  scope.getHourSelected = numb12 + " AM";
              }

              
              console.log("gethour selected "+scope.getHourSelected +" cal start"+ calEvent.start);
              scope.hoursCanBook.forEach(function(hour) {
            	  
              	console.log("hr selected "+hour.selected);
                if (hour.start == scope.getHourSelected) {
                	hour.selected = true;

                }else{hour.selected =false;}
                //otherwise clear select boxes
              });
             
              //call edit modal
              $("#eventDetails").modal("show");
              scope.$apply();
            },
            
            hoursCanBook: [{
            	start: '08:00 AM',
                end:'10:00 AM',
                price: '$90.00',
                avail: 'N',
                selected:''
            	
            },{
            	start: '10:00 AM',
                end:'12:00 AM',
                price: '$90.00',
                avail: 'Y',
                selected:''
            },{
            	start: '13:00 PM',
                end:'15:00 PM',
                price: '$90.00',
                avail: 'Y',
                 selected:''
            },{
            	start: '15:00 PM',
                end:'17:00 PM',
                price: '$90.00',
                avail: 'Y',
                selected:''
            },{
            	start: '17:00 PM',
                end:'19:00 PM',
                price: '$90.00',
                avail: 'Y',
                selected:''
            },{
            	start: '19:00 PM',
                end:'21:00 PM',
                price: '$90.00',
                avail: 'Y',
                selected:''
            }],
            events: [{
              title: 'All Day Event',
              start: new Date(y, m, 1),
              backgroundColor: '#ccc'
            }, {
              title: 'Long Event',
              start: new Date(y, m, d - 5),
              end: new Date(y, m, d - 2),
              backgroundColor: 'green'
            }, {
              id: 999,
              title: 'Repeating Event',
              start: new Date(y, m, d - 3, 16, 0),
              allDay: false,
              backgroundColor: 'black',
              textColor: "#fff"
            }, {
              id: 999,
              title: 'Repeating Event',
              start: new Date(y, m, d + 4, 16, 0),
              allDay: false
            }, {
              title: 'Meeting',
              start: new Date(y, m, d, 10, 30),
              allDay: false
            }, {
              title: 'Lunch',
              start: new Date(y, m, d, 12, 0),
              end: new Date(y, m, d, 14, 0),
              allDay: false,
              textColor: "yellow"
            }, {
              title: 'Birthday Party',
              start: new Date(y, m, d + 1, 19, 0),
              end: new Date(y, m, d + 1, 22, 30),
              allDay: false
            }, {
              title: 'Click for Google',
              start: new Date(y, m, 28),
              end: new Date(y, m, 29)
            }]
          });
          }();
      
      scope.addNewEvent = function(){
        console.log(angular.element("#calendar"))
       console.log("selected Date" + scope.setSelectedDate);
        if (scope.event_title){
			var _eDate = moment(scope.setSelectedDate).format("YYYY-MM-DD");
			console.log("date selected "+_eDate);
			
			//create multiple events here based on 2 hour minimum booking hoursAvail.
			// at same time, make it added to a shopping cart so as to pay in advance for the bookings. 
			var newBookings = [];
//			var newEvent = {};					  
//            newEvent.title = scope.event_title;
            
            var checkedHour = '';
            scope.hoursCanBook.forEach(function(hour) {
            	
            	console.log("hr selected"+hour.selected);
              if (hour.selected) {
            	  var newEvent = {};					  
                  newEvent.title = scope.event_title;
            	 
                  var hourStart =  hour.start.substring(0, hour.start.length-3);
            	 hourStart = hourStart+":00";
            	 var hourEnd = hour.end.substring(0, hour.end.length-3);
            	 hourEnd = hourEnd+":00";
            	  newEvent.start = moment(_eDate+' '+hourStart,'YYYY-MM-DD HH:mm:ss').format('YYYY-MM-DD HH:mm:ss');
                  newEvent.end = moment(_eDate+' '+ hourEnd, 'YYYY-MM-DD HH:mm:ss').format('YYYY-MM-DD HH:mm:ss');
                  
                  console.log("AssignedDate:" + newEvent.end + " ," + newEvent.start );
                  newEvent.allDay = false;
                  newEvent.backgroundColor = scope.event_color;
                  newBookings.push(newEvent);
            	  scope.cart.push(newEvent);
                if(checkedHour != ''){
                	checkedHour += " , ";
                }
                checkedHour += hour.start;
              }
            });
            console.log(checkedHour);
            
//            newEvent.backgroundColor = scope.event_color;
            newBookings.forEach(function (newEvent){
            	angular.element("#calendar").fullCalendar('renderEvent',newEvent);
  				$("#bookingCreate").modal("hide");
  				
  				//show shopping cart?
  				
  				scope.resetVariables();
            });
		 }
      };
      scope.resetVariables();
    }
  }
});