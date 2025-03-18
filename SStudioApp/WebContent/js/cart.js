 
angular.module('shoppingCart', [ 'ngRoute' ])
.factory('messages', function(){
	  var messages = {};
	
	  messages.list = [];
	  messages.add = function(message){
		    messages.list.push({
		    		id: messages.list.length, 
		    		text: message
		    	});
		  };
	  return messages;
})
.factory('studios', function(){
	  var studios = {};
	
	  studios.list = [];
	  studios.add = function(studio){
		  studios.list.push({
			  	id:studio.list.length,
			  	studioId:studio.studioId,
				studioDescription: studio.studioDescription,
				studioAvailability:studio.studioAvailability,
				price:studio.price,
				studioName:studio.studioName,
				studioSizeSq:studio.studioSizeSq,
				studioAccessories:studio.studioAccessories
			  });
		  };
})	
.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    .when('/', {
		templateUrl: 'index.html',
		//controller: 'cartController'
	})
	.when('/cart', {
		templateUrl: 'cart.html',
		controller: 'cartController'
	})
	.when('/booking/:studioId', {  ///routeURL1/:userId  
	
		

		templateUrl: 'studio-booking.jsp',
		controller: 'studioBookingController'
	})
	.when('/checkout',{
		templateUrl: 'checkout.html',
		controller: 'checkoutController'
	})
	.when('/pay',{
		templateUrl: 'pay.html',
		controller: 'payController'
	})
    .otherwise({
        redirectTo: '/cart'
    });
    
}]).controller('cartController', function ($scope, $http,messages){
	  var self = this;

	  //self.messages = messages.list;
	 
     console.log("cartController");
    // self.messages.add("White has such an interesting finish. Conceptuals are the best in this spot. Currently consisting of head cage shots and bench light workshops.");
     //self.messages.add();
     var message="White Room";
     messages.add(message);

     message="Apothecary";
     messages.add(message);
    
     message="Make Believe Studio";
     messages.add(message);
     
     message="Furniture Design / Upholstery";
     messages.add(message);
     
     var cart =[ {studioId:1,
    	 			studioDescription:"White has such an interesting finish. Conceptuals are the best in this spot. Currently consisting of head cage shots and bench light workshops.",
    	 			studioAvailability:1,
    	 			price:"$90.00",
    	 			studioName:"White Room",
    	 			studioSizeSq:"200",
    	 			studioAccessories:"two strobes"
    	 		},
    	 		{studioId:3,
    	 			studioDescription:"This studio is a collection to say the least. Everything Ive adored and held onto is in this very room. Its a clever room with hidden compartments and rabbit heads. Time is of the essence and lets make cake. ",
    	 			studioAvailability:1,
    	 			price:"$90.00",
    	 			studioName:"Make Believe Studio",
    	 			studioSizeSq:"120",
    	 			studioAccessories:"1 strobe"
    	 		},
    	 		{studioId:4,"studioDescription":"Ocean healing spa, a working space to collaborate with artists and designers creating sculptured soap, lotions and luxury products from the earth.",
	 				studioAvailability:1,
	 				price:"$50.00",
	 				studioName:"Apothecary",
	 				studioSizeSq:"70",
	 				studioAccessories:"soap supplies"
    	 		},
    	 		{studioId:5,
					studioDescription:"I learned some upholstery skills. Ive used them when I see something I adore bringing new life to. Utilitarian Furniture designs and DIY awesomeness. ",
					studioAvailability:0,
					price:"$75.00",
					studioName:"Furniture Design / Upholstery",
					studioSizeSq:"100",
					studioAccessories:"tools for upholstery and building components"
				}
    	 	];
     
     //self.messages = cart.list;
     
     $scope.studio_name = cart[0].studioName;
		
		$scope.bookingCart = cart ;
		console.log($scope.bookingCart);
		
	var	user={ 
	  		username:"Randy Pond",
	  		pwd: "EBFNLL5m3$",
	  		card:{
	  			cardholder_name :"Randy Pond Photography",
	  			card_number :"5454676776763389",
	  			expire_date : '08/26',
				ccv : '338'
			},
			carttotal:''
	  		
	  	};
		//console.log(cart);
		var i;
		var cost=0;
		for(i=0;i<$scope.bookingCart.length;i++){

			var int = parseInt($scope.bookingCart[i].price.substring(1,$scope.bookingCart[i].price.length-3)) ;
			cost = int + cost;
			
		}
		$scope.total = cost;
		
		//$scope.cart[0].user.carttotal = cost;
		//$scope.studio_name = $scope.cart[1].studio;
		// console.log("dont mess with cart."+ cart);
     
     
})
.controller('checkoutController', function($scope, $http,messages) {
	console.log("checkoutController");
	 var self = this;

	  self.messages = messages.list;
	  
	  console.log(messages);
})
.controller('payController', function($scope,messages) {
	console.log("payController");
	$scope.user = "Me!";
	var self = this;

	  self.messages = messages.list;
	  
	  console.log(messages);
	
})
.controller('ListCtrl', function (messages){

		  var self = this;

		  self.messages = messages.list;
		
})
.controller('PostCtrl', function (messages){
  var self = this;

  self.addMessage = function(message){
    messages.add(message);
  };
})
.controller('studioBookingController', [function() {
	console.log("studioBookingController");
}]);