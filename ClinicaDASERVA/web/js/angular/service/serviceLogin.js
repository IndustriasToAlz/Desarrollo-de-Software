'use strict';
daservaLoginApp.service("serviceLogin",function($resource,$http){
    
    this.login = function(token){
        var request =  $http({
            method: 'get',
            url: 'login.htm',
            params: token
        });
        return request;
    };
});