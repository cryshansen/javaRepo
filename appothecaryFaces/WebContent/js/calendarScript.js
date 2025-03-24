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
			templateUrl: "calendar.html"
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
        scope.getStartTime = "";
        scope.getDate = "";
        scope.getEndTime = "";
        scope.setSelectedDate = "";
        scope.end_time = "";
        scope.start_time = "";
        scope.event_date = "";
        scope.event_title = "";
        scope.event_color = "#ccc";
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
              $("#eventCreate").modal("show");
              calendar.fullCalendar('unselect'); 
            },
            dayClick: function(date, jsEvent, view) {
              scope.setSelectedDate = date.format("YYYY-MM-DD");
              scope.$apply();
            },
        
            eventClick: function(calEvent, jsEvent, view) {
              scope.getTitle = calEvent.title;
              scope.getDate = moment(calEvent.start).format("YYYY-MM-DD");
              scope.getStartTime = moment(calEvent.start).format("hh:mm:ss");
              if(calEvent.end!==null){
                scope.getEndTime = moment(calEvent.end).format("hh:mm:ss");  
              }else{
                scope.getEndTime = "--";
              }
              $("#eventDetails").modal("show");
              scope.$apply();
            },
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
        if (scope.event_title)
					{
					  var _eDate = moment(scope.setSelectedDate).format("YYYY-MM-DD");
					  var newEvent = {};
            newEvent.title = scope.event_title;
            if(scope.start_time===""){
              newEvent.start = _eDate;
              newEvent.end = _eDate;
              newEvent.allDay = true;
            }else{
              newEvent.start = _eDate+"T"+moment(scope.start_time).format("HH:MM:SS");
              newEvent.end = _eDate+"T"+moment(scope.end_time).format("HH:MM:SS");
              newEvent.allDay = false;
            }
            newEvent.backgroundColor = scope.event_color;
          	angular.element("#calendar").fullCalendar('renderEvent',newEvent);
  					$("#eventCreate").modal("hide");
  					scope.resetVariables();
					}
      };
      scope.resetVariables();
    }
  }
});