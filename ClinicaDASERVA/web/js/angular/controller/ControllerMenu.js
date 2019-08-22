'use srict';

angular.module("AppDaservaSystem")
.controller('menuController',function($scope,$routeParams){
    $scope.usuario = $routeParams.login;
});

