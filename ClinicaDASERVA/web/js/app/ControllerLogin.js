'use strict';

angular.module('AppDaservaLogin')
.controller('loginController',function($scope,$http,$window){
    $scope.login = {};
    $scope.title = "Ingresa Al Sistema";
    $scope.iniciarSesion = function(){
        $http({
            method: 'get',
            url: 'login.htm',
            params: {
                login: $scope.login.login,
                password: $scope.login.password 
            }
        }).then(function(response,status,headers,config){
            
            switch (response.data.resultado){
                case "SI": 
                    $window.location.href = "system.jsp#!/" + $scope.login.login;
                    break;
                case "NO CONTRASENA":
                    $('#error').text('Contraseña Errada');
                    $('#error').addClass('error');
                    break;
                case "NO USUARIO":
                    $('#error').text('Usuario Invalido');
                    $('#error').addClass('error');
                    break;
            }
        }),function(error){
            console.log(error);
        };
    };
});


