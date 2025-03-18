
var app = angular.module('mainApp', []);

//define a service named myService
app.service('myService', function () {
    this.message = '';
    this.setMessage = function (newMessage) {
        this.message = newMessage;
        return this.message;
    };
});

//define factory  named 'myFactory'
app.factory('myFactory', function () {
    var obj = {};
    obj.message = '';
    obj.setMessage = function (newMessage) {
        obj.message = newMessage;
    };
    return obj;
});

//Defining a provider 'configurable'
app.provider('configurable', function () {
    var returnMessage = '';
    this.setMessage = function (newMessage) {
        returnMessage = newMessage;
    };
    this.$get = function () {
        return {
            message: returnMessage
        };
    };
});

//configuring provider
app.config(function (configurableProvider) {
    configurableProvider.setMessage("Hello, I'm From Provider");
});

//defining controller
app.controller('myController', function ($scope, myService, myFactory, configurable) {
    $scope.serviceMsg = myService.setMessage("Hello, I'm From Service");

    myFactory.setMessage("Hello, I'm From Factory ");
    $scope.factoryMsg = myFactory.message;

    $scope.providerMsg= configurable.message;
});