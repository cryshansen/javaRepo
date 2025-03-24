/* 
 * Description - Angular Script for posting the data to the web-server!
 * Created By - Yatin Batra  
 * */
var app = angular.module("app", []);

app.controller("ctrl", ['$scope', '$http', function($scope, $http) {

	$scope.output_msg = null;
	
	// Use $.param jQuery function to serialize data from JSON 
	var form_data = $.param({
		id: $scope.login_id,
		pwd: $scope.login_pwd
	});

	var header_config = {
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
			}
	};

	$scope.validateCredentials = function() {
		//alert($scope.login_id);
		//alert($scope.login_pwd);
		var form_data = $.param({
			id: $scope.login_id,
			pwd: $scope.login_pwd
		});
		
		//alert(form_data);
		
		var dataObject = JSON.stringify({
            'id'  : $scope.login_id,
            'pwd': $scope.login_pwd
           
        });
		
		alert(dataObject);
		
		$http({
			method: 'POST',
			url: 'UserController',
			data: dataObject,
			
			config: header_config
		}).then(
				function(response) {
					$scope.output_msg = response.data.msg;
					angular.element(document.getElementById("msg")).css("color", "green");
					console.log("Status Code= " + response.status + ", Status Text= " + response.statusText);
				},
				function(response) {
					$scope.output_msg = "Service unavailable. Please try again.";
					angular.element(document.getElementById("msg")).css("color", "red");
					console.log("Status Code= " + response.status + ", Status Text= " + response.statusText);
				});
	};
}]);