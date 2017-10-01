'use strict'

document.addEventListener('DOMContentLoaded',inicializacion);

function inicializacion(){

    document.getElementById('cambiaClase').addEventListener('click',cambiaEstilosClase);

    document.getElementById('cambiarLi').addEventListener('click',cambiaEstilosLi);
}

function cambiaEstilosClase(){
   console.log(document.getElementsByClassName('item'));
   console.log(document.getElementsByClassName('item').length);

   for(var i = 0; i < document.getElementsByClassName('item').length; i++){
       console.log('Item: ', document.getElementsByClassName('item').item(i));
       document.getElementsByClassName('item').item(i).style.color = '#399'
   }
}

function cambiaEstilosLi(){
    console.log(document.getElementsByTagName('li'));
    
    for(var i = 0; i < document.getElementsByTagName('li').length; i++){
        console.log('Item: ',document.getElementsByTagName('li').item(i));
        document.getElementsByTagName('li').item(i).classList.add('itemgrande');
    }
}