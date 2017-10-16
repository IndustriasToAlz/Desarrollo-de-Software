'use strict';

angular.module('hide&show_app',[])
.controller('hide&show_controller',function($scope,$http){
    $scope.posts = [];
    $scope.loading = true;
    
    $http({
            method: 'get', 
            url: 'http://jsonplaceholder.typicode.com/posts'
        }).then(function (response) {
            $scope.posts = response.data;
            $scope.loading = false;
        },function (error){
            console.log(error, 'can not get data.');
            $scope.loading = false;
        });
});


