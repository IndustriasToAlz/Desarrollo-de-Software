'use strict';

angular.module('adwapp',[])
.controller('adwcontroller',function($scope){
    $scope.nombre = 'Carlos';
    setTimeout(function(){
        $scope.$apply(function(){
            $scope.nombre = 'Carlos Andres';
        });
    },2000);
    
    $(function(){
        $("#mi-boton").click(function(){
            $scope.$apply(function(){
                $scope.nombre = 'Tobon Alzate';
            });
        });
    });
});


