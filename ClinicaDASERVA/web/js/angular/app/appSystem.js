'use srict';

var daservaSystemApp = angular.module("AppDaservaSystem",["lumx","ngRoute","ngResource"])
.config(function($routeProvider){
    $routeProvider
        .when("/:login",{
            controller: "menuController"
        })
        .when("/menu/Consulta&ActualizaCliente.html",{
           controller: "clientesController",
           templateUrl: "views/html/Consulta&ActualizaCliente.html" 
        })
        .when("/menu/Consulta&ActualizaDoctor.html",{
           controller: "doctorController",
           templateUrl: "views/html/Consulta&ActualizaDoctor.html" 
        })
        .when("/menu/angendaSystem.html",{
           controller: "agendaController",
           templateUrl: "views/html/agendaSystem.html" 
        })
        .otherwise("/");
});