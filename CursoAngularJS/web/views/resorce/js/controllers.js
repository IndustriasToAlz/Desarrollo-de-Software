'use strict';

angular.module("FinalApp")
.controller("MainController",function($scope,$http,$resource){
    var Post = $resource("http://jsonplaceholder.typicode.com/posts/:id", {id: "@id"});
    var User = $resource("http://jsonplaceholder.typicode.com/users/:id", {id: "@id"});
    
    $scope.posts = Post.query();
    $scope.users = User.query();
    //query() -> GET /posts -> Un arreglo de posts -> isArray: True
    
    $scope.removePost = function(post){
        Post.delete({id: post.id},function(data){
            console.log(data);
        });
        $scope.posts = $scope.posts.filter(function(element){
            return element.id !== post.id;
        });
    };
})
.controller("PostController",function($scope,$resource,$routeParams){
    //var Post = $resource("http://jsonplaceholder.typicode.com/posts/:id", {id: "@id"});
    $scope.post = $resource("http://jsonplaceholder.typicode.com/posts/:id", {id: "@id"}).get({id:$routeParams.id});
});