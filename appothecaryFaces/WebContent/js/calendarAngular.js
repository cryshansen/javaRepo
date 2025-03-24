angular.module('calendarApp', ['ui.calendar', 'ui.bootstrap']);
var ModalDemoCtrl = function ($scope, $modal, $timeout) {

  $scope.items = ['item1', 'item2', 'item3'];

  // Open primary modal button
  $scope.open = function () {

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
  };

};


//// Controller for primary modal
var calendarInstance = function ($scope, $modal, $modalInstance, items) {

  $scope.items = items;
  $scope.selected = {
    item: $scope.items[0]
  };

  $scope.ok = function () {
    $modalInstance.close($scope.selected.item);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
  
  $scope.open = function() {
    $scope.openModal();
  };
  
  // Open modal from modal
  $scope.openModal = function (eventObj) {
    console.log('Opening modal...');
      var modalInstance = $modal.open({
        templateUrl: 'bookingInstance.html',
        controller: bookingInstanceControler,
        backdrop: false,
        resolve: {
          event: function () {
            return eventObj;
          }
        }
      });
    
    // Scope apply here to make modal show up
    $scope.$apply(function() {
      modalInstance.result.then(
        function (event) {
          console.log('Modal closed at: ' + new Date());
          console.log(event);
          $scope.events.push(event);
        }, 
        function () {
          console.log('Modal dismissed at: ' + new Date());
        }
      );
    });
    
  };
  
  var date = new Date();var d = date.getDate();var m = date.getMonth();var y = date.getFullYear();
  $scope.events= [ 
        {type:'party',id: 999,title: 'Repeating Event 2',start: new Date(y, m, d - 3, 16, 0),allDay: false},
        {type:'party',id: 999,title: 'Repeating Event 2',start: new Date(y, m, d + 4, 16, 0),allDay: false},
        {type:'party',title: 'Meeting 2',start: new Date(y, m, d, 10, 30),allDay: false}
  ];
  
  $scope.eventSources = [$scope.events];
  
  $scope.uiConfig = {
    calendar: {
      dayClick: function(event) {console.log('Day clicking'); $scope.openModal(event) }
    }
  };

  $scope.addEvent = function() {
    console.log('Adding event');
      $scope.events.push({type:'party',id: 34,title: 'Added with button',start: new Date(y, m, d + 1, 12, 0),allDay: false});  
  };
  
    
};

// Controller for modal created from other modal
var bookingInstanceControler = function ($scope, $modalInstance, event) {
	console.log($scope);
  $scope.bookings = [];
  $scope.cart = [];
  var date = new Date(event);
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();
  $scope.selected = d +" " + m + " " +y;
  $scope.ok = function () {
    
	  $modalInstance.close({type:'party',id: 999,title: 'Added from modal',start: new Date(y, m, d, 16, 0),allDay: false});
  };
  $scope.addTime= function(value){
	  //add time to shopping cart update cart button count label
	  console.log(value + " " + event);//event is date selected
	  console.log('Adding event');
	  $scope.bookings.push({bookid: value, bookStudio: 1, event: event , cost: '$90.00'});
      //$scope.events.push({type:'party',id: 34,title: 'Added with button',start: new Date(y, m, d + 1, 12, 0),allDay: false});  
	  var i;
	  for (i = 0;i< $scope.bookings.length; i++){
		  console.log($scope.bookings[i].bookid + " "+ $scope.bookings[i].bookStudio + " " + $scope.bookings[i].event + " " +$scope.bookings[i].cost);
	  }
  
  }
  $scope.addCart = function(){
	  //add bookings to cart
	  $scope.cartBtn = $scope.bookings.length;
	  console.log($scope.cartBtn);
	  var i;
	  for (i = 0;i<$scope.bookings.length; i++){
		 console.log($scope.bookings[i].bookid + " "+ $scope.bookings[i].bookStudio + " " + $scope.bookings[i].event + " " +$scope.bookings[i].cost);
	  }
	  
  }
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
  
  
};