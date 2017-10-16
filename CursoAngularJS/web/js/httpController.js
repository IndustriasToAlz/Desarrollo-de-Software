'use strict';

angular.module("MySecondApp",[])
    .controller("httpController",function($scope,$http){
        $scope.posts = [];
        $scope.newPost = {};
        
        $http({
            method: 'get', 
            url: 'http://jsonplaceholder.typicode.com/posts'
        }).then(function (response) {
            $scope.posts = response.data;
        },function (error){
            console.log(error, 'can not get data.');
        });
        
        $scope.addPost = function(){
            $http({
                method: 'post',
                url: 'http://jsonplaceholder.typicode.com/posts',
                data: {
                    tittle: $scope.newPost.title,
                    body: $scope.newPost.body,
                    userId: 1
                }
            }).then(function(response,status,headers,config){
                $scope.posts.push($scope.newPost);
                $scope.addPost() = {};
            },function(error,status,headers,config){
                //console.log(error);
            });
        };
    });