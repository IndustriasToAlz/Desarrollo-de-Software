'use strict';

daservaLoginApp.controller('loginController',function($scope,serviceLogin,$http,$window){
    $scope.login = {};
    $scope.title = "Ingresa Al Sistema";
    $scope.iniciarSesion = function(){
        
        var token = {
	    	login: $scope.login.login,
	    	password: $scope.login.password
	    };
	    
	var service = serviceLogin.login(token);
                
        service.then(function(response,status,headers,config){
            
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


