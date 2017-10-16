'use strict';

var app = angular.module("MyFisrtApp",[]); //ngResourse es para consumir appis res como twiter instagram facebook etc
app.controller("FisrtController",["$scope",function(m){
    m.nombre = "Carlos";
    m.apellido = "Tobon";
    
    m.nuevoComentario = {};
    
    m.comentarios = [
        {
            comentario: "Buen Tutorial",
            username: "carlostoalz"
        },
        {
            comentario:"Malisimo Tutorial",
            username: "catobona"
        }
    ];
    m.agregarComentario =  function(){
        m.comentarios.push(m.nuevoComentario);
        m.nuevoComentario = {};
    };
}]);


