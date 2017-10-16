'use strict';

angular.module("CustomDirective")
.controller("ReposController",function($scope,$http){
        $scope.repos = [];
        
        $http({
            //url: 'https://api.github.com/orgs/IndustriasToAlz/repos',
            url: 'https://api.github.com/users/twitter/repos',
            method: 'get'
        }).then(function(data){
            $scope.posts = data.data;
            for(var i = data.data.length - 1; i >= 0; i--){
              var repo = data.data[i];
              $scope.repos.push(repo.name);
            };
        }),function(error){
            console.log(error);
        };
        
        $scope.optionSelected = function(data){
            $scope.$apply(function(){
                $scope.main_repo = data;
            });
        };
    })
.controller("RepoController",function($scope,$http,$routeParams){
        $scope.repo = [];
        console.log($routeParams.name);
        $http({
            //url: 'https://api.github.com/orgs/IndustriasToAlz/repos',
            url: 'https://api.github.com/repos/twitter/' + $routeParams.name,
            method: 'get'
        }).then(function(data){
            $scope.repo = data.data;
            console.log($scope.repo);
        }),function(error){
            console.log(error);
        };
    });


