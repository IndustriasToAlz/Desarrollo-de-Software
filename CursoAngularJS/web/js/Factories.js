'use strict';

angular.module('Factories_app',["LocalStorageModule"])
.factory('FactoryService',function(localStorageService){
    
    var factotyService = {};    
    
    factotyService.key = "angular-todolist";    
    
    if(localStorageService.get(factotyService.key)){
        factotyService.activities = localStorageService.get(factotyService.key);
    }else{
        factotyService.activities = [];
    }
    
    factotyService.add = function(newActv){
        factotyService.activities.push(newActv);
        factotyService.udateLocalStorage();
    };
    
    factotyService.udateLocalStorage = function(){
        localStorageService.set(factotyService.key,factotyService.activities);
    };
    
    factotyService.clean = function(){
        factotyService.activities = [];
        factotyService.udateLocalStorage();
        return factotyService.getAll();
    };
    
    factotyService.getAll = function(){
      return factotyService.activities;  
    };
    
    factotyService.removeItem = function(item){
        factotyService.activities = factotyService.activities.filter(function(activity){
            return activity !== item;
        });
        /*
            [{actividad: 'terminar el curso de angular', fecha: '14/10/2017' 15:40},{}] -> factotyService.activities;
            removeItem({actividad: 'terminar el curso de angular', fecha: '14/10/2017' 15:40})
         */
        factotyService.udateLocalStorage();
        return factotyService.getAll();
    };
    
    return factotyService;
})
.controller('factoriesController',function($scope,FactoryService){  
    
    $scope.todo = FactoryService.getAll();
    $scope.newActv = {};
    
    $scope.addActv = function(){
        FactoryService.add($scope.newActv);
    };
    
    $scope.removeActv = function(item){
        $scope.todo = FactoryService.removeItem(item);
    };
    
    $scope.clean = function(){
        $scope.todo = FactoryService.clean();
    };
});


