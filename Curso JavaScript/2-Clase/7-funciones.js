'use strict'

//declarar funcion
function colorear(){
    document.bgColor = '#339999'
}

//colorear();


//parametros
function colorearColor(color){
    document.bgColor = color;
}

colorearColor('#326412');

//valores de retorno
function pideNumero(){
    var numero;
    do {
       numero = prompt('Dame un numero ', '');
       numero = Number(numero);

       if (numero > 1000){
            return 'kk';
       }

    } while (isNaN(numero));
        return numero;
}

var miNUmero = pideNumero();

console.log(miNUmero);