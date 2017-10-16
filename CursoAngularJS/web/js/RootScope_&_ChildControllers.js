'use strict';

angular.module('RootScope_&_Child_app',[])
.run(function($rootScope){
    $rootScope.nombre = "Carlos Andres";
})
.controller('RootScopeController',function($scope){
    $scope.nombre = "Tobon Alzate";
    setTimeout(function(){
        $scope.$apply(function(){
            $scope.nombre = ":3";
        });
    },1000);
})
.controller('ChildController',function($scope){
    
})
;

