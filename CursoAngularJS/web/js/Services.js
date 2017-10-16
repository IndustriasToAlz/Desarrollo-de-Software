'use strict';

angular.module('Services_app',["LocalStorageModule"])
.service('Service',function(localStorageService){
    
    this.key = "angular-todolist";    
    
    if(localStorageService.get(this.key)){
        this.activities = localStorageService.get(this.key);
    }else{
        this.activities = [];
    }
    
    this.add = function(newActv){
        this.activities.push(newActv);
        this.udateLocalStorage();
    };
    
    this.udateLocalStorage = function(){
        localStorageService.set(this.key,this.activities);
    };
    
    this.clean = function(){
        this.activities = [];
        this.udateLocalStorage();
        return this.getAll();
    };
    
    this.getAll = function(){
      return this.activities;  
    };
    
    this.removeItem = function(item){
        this.activities = this.activities.filter(function(activity){
            return activity !== item;
        });
        /*
            [{actividad: 'terminar el curso de angular', fecha: '14/10/2017' 15:40},{}] -> factotyService.activities;
            removeItem({actividad: 'terminar el curso de angular', fecha: '14/10/2017' 15:40})
         */
        this.udateLocalStorage();
        return this.getAll();
    };
})
.controller('ServicesController',function($scope,Service){
    $scope.todo = Service.getAll();
    $scope.newActv = {};
    
    $scope.addActv = function(){
        Service.add($scope.newActv);
    };
    
    $scope.removeActv = function(item){
        $scope.todo = Service.removeItem(item);
    };
    
    $scope.clean = function(){
        $scope.todo = Service.clean();
    };    
});

