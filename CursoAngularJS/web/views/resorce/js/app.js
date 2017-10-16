'use strict';

angular.module("FinalApp",["lumx","ngRoute","ngResource"])
.config(function($routeProvider){
    $routeProvider
        .when("/",{
            controller: "MainController",
            templateUrl: "templates/home.html"
        })
        .when("/post/:id",{
           contrller: "PostController",
           templateUrl: "templates/post.html" 
        });
});