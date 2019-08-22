'use srict';

var daservaLoginApp = angular.module("AppDaservaLogin",["lumx","ngRoute","ngResource"])
.config(function($routeProvider){
    $routeProvider
        .when("/",{
            controller: "loginController",
            templateUrl: "views/html/login.html" 
        });
});