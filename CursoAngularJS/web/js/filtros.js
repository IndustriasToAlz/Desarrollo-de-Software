'use strict';

angular.module('Filtros',[])
.filter("removeHtml",function(){
    return function(texto){
        return String(texto).replace(/<[^>]+>/gm,'');
    };
})
.controller('filtrosController',function($scope){
    $scope.mi_html = "<p>Hola mundo</p>";
    
    $scope.mi_html2 = {};
    $scope.mi_html2.title = "Hola";
    $scope.mi_html2.body = "Hola Mundo";
    
    $scope.costo = 2;
});
