var app = angular.module('angularRouting', ['ngRoute']);
//Handle $routeChangeError 
app.run(['$rootScope', '$location', 
   function($rootScope, $location) {
     $rootScope.$on('$routeChangeError', function(event, next, previous, error) {
        if(error == 'AUTH_REQUIRED') {
            $rootScope.message = 'Sorry, you must log in to access that page';
            $location.path('/');
        } //AUTH_REQUIRED
     }); // $routeChangeError
   }
]);
app.config(['$routeProvider', 
	  function($routeProvider, $routeParams){
	    $routeProvider
	      .when('/', {
	        templateUrl: 'main.html'
	      })
	      .when('/artfolio',{
	    	  templateUrl: 'artfolio.html',
		        controller:'artfolioController'
	      })
	      .when('/about', {
	        template: '<h1>This is about</h1>'
	      })
	      .when('/projects',{
	    	  templateUrl: 'projects.html',
		        controller:'projectsController'
	      })
	      .when('/creds', {
	        
	        	templateUrl: 'creds.html',
		        controller:'credsController'
	      })
	      .when('/listing', {
	    	  templateUrl: 'listing.jsp',
	        controller:'listingController'
	      })
	      .when('/booking/:id', {
	        templateUrl: 'booking.jsp',
	        controller: 'ParamsController'
	      })
	      .when('/auth', {
	        template: '<h1>Success</h1>',
	        resolve: {
	          currentAuth: function(AuthService) {
	            return AuthService.authenticate();
	          }
	        }
	      })
	      .otherwise({
	        redirectTo: '/'
	      })
	  }
	]);
app.controller('ParamsController', 
		  function ParamsController($scope, $http,$routeParams,studios) {
		    $scope.paramValue = $routeParams.id;
		    var url = 'StudioController?action=BOOK&id='+$scope.paramValue;
		    
		    $http({

		    	method: 'GET',

		    	url: url

		    	}).then(function success(response) {
		    		
		    	$scope.myWelcome = angular.fromJson(response.data);
		    	console.log($scope.myWelcome);
		    	
		    	var studiobookLS = $scope.myWelcome;
		    	var studiosList = [];
		    	var studiosBookins = {};
		    	for(var i=1; i < studiobookLS.length;i++){
		    		if(studiobookLS[i] != null){
		    		console.log(studiobookLS[i]);
		    		studiosBookins.allDay = studiobookLS[i].allDay;
		    		studiosBookins.start = studiobookLS[i].start;
		    		studiosBookins.end = studiobookLS[i].end;
		    		studiosBookins.backgroundColor = studiobookLS[i].backgroundColor;
		    		studiosBookins.studioId = studiobookLS[i].studioId;
		    		studiosList.push(studiosBookins);
		    		}
		    	}
		    	//assigning scope to contain studios
		    	$scope.studios  = studios;
		    	//passing studio cart variable forward
		    	studios = studios;
		    	console.log(studiosList);
		    	$scope.studiosList =studiosList;
		    	console.log($scope.studios ); 
		    	
		    	
		    	
		    	$scope.statusval = response.status;

		    	$scope.statustext = response.statusText;

		    	$scope.headers = response.headers();

		    	}, function error(response) {

		    	});
		    
		    
});
app.controller('listingController',function ($scope,$http,studios) {
		  console.log('listingController');
		  $http({
				
				method: 'GET',
		
				url: 'StudioController?action=LIST'
		
				}).then(function success(response) {
		
		
				var studiosLS2=angular.fromJson(response.data);
				$scope.studios = [];
				for(var i=1; i < studiosLS2.length;i++){
					 var studio ={};
					 if(studiosLS2[i] != null){
						 //JSON.stringify(studiosLS2);
						 studio.studioId = studiosLS2[i].studioId;
						 studio.studioName = studiosLS2[i].studioName;
						 studio.studioDescription = studiosLS2[i].studioDescription;
						 studio.price = studiosLS2[i].price;
						 studio.studioSizeSq = studiosLS2[i].studioSizeSq;
						 studio.studioAvailability = studiosLS2[i].studioAvailability;
						 studio.studioAccessories = studiosLS2[i].studioAccessories;
						 $scope.studios.push(studio);
						 if(studios.length < studiosLS2.length){
							 studios.add(studio); 
						}
						 
					 }
				}
				
				//studioCart = $scope.studios;
				//$scope.studioCart = $scope.studios;
				$scope.statusval = response.status;
		
				$scope.statustext = response.statusText;
		
				$scope.headers = response.headers();
		
				}, function error(response) {
		
				});
		  
		  
});
app.controller('projectsController',function($scope,$http){
	console.log('projectsController');
	$http({
		
		method: 'GET',

		url: 'ProjectController?action=LIST'

		}).then(function success(response) {


		var projectLS2=angular.fromJson(response.data);
		$scope.myWelcome = projectLS2;
		$scope.projects = [];
		for(var i=1; i < projectLS2.length;i++){
			 var project ={};
			 if(projectLS2[i] != null){
				project.projectId =  projectLS2[i].projectId ;
				project.projectName=  projectLS2[i].projectName ;
				project.projectDescription	=  projectLS2[i].projectDescription ;
				project.projectFee=  projectLS2[i].projectFee ;
				project.projectLength=  projectLS2[i].projectLength ;
			
				project.project_image	= 'images/' + projectLS2[i].project_image ;
				console.log(project.project_image);
				$scope.projects.push(project);
			}
		}
		
		
		$scope.statustext = response.statusText;
		
		$scope.headers = response.headers();

		}, function error(response) {

		
	});
	
});
app.controller('credsController',function($scope){
	console.log('credsController');
});
app.controller('artfolioController',function ($scope) {
	  console.log('artfolioController');
});
app.controller('ListCtrl', function (messages){

	  var self = this;

	  self.messages = messages.list;
	
})
app.controller('ListStudiosCtrl', function (studios){

	  var self = this;

	  self.studios = studios.list;
	
})
.controller('PostCtrl', function (messages){
	var self = this;

	self.addMessage = function(message){
	messages.add(message);
	};
})


app.factory('messages', function(){
	  var messages = {};
	
	  messages.list = [];
	  messages.add = function(message){
		    messages.list.push({
		    		id: messages.list.length, 
		    		text: message
		    	});
		  };
	  return messages;
});

app.factory('studios',function(){
	var studios = [];
	
	studios.list=[];
	
	studios.add = function(studio){
		//studios.push({studioId:studio.studioId,studioName:studio.studioName,studioDescription:studio.studioDescription});
		studios.list.push({id:studio.studioId,studioName:studio.studioName});
		//		studioName : studio.studioName,
//		studioDescription : studio.studioDescription,
//	 	price : studio.price,
//	 	studioSizeSq : studio.studioSizeSq,
//	 	studioAvailability : studio.studioAvailability,
//	 	studioAccessories : studio.studioAccessories
	};

	return studios;
});
//Authentication Service 
app.factory('AuthService', function($q) {
  return {
    authenticate: function() {
      // Your authenication logic
      return $q.reject('AUTH_REQUIRED');
    }
  }
});