'use strict';

angular.module("ToDoList",["LocalStorageModule"])
.controller("ToDoController",function($scope,localStorageService){
    
    if(localStorageService.get("angular-todolist")){
        $scope.todo = localStorageService.get("angular-todolist");
    }else{
        $scope.todo = [];
    }
  
    /*
      {
           descripcion: 'Terminar el curso Angular',
           fecha: '14-10-2017 11:09'
      }  
    */
    $scope.$watchCollection('todo',function(){
        localStorageService.set("angular-todolist",$scope.todo);
    });
    
    $scope.addActv = function(){
        $scope.todo.push($scope.newActv);
        $scope.newActv = {};
    };
    
    $scope.clean = function(){
        $scope.todo = [];
    };
});

