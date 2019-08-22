'use strict';
angular.module('AppDaservaIndex')
.factory("getCliente",function($resource,$http){
    return $resource(
        $http({
            method: 'get',
            url: 'getClient.htm'
        })
    );
});