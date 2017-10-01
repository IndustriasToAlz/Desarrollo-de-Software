'use strict'

document.getElementById("suma").addEventListener("click", suma);

function suma(){
    var op1 = document.getElementById("operando1").value;
    var op2 = document.getElementById("operando2").value;
    var resultado = Number(op1) + Number(op2); //este si deja sumar decimales pero no obliga a convertir las letras que se valla
    //var resultado = parseInt(op1) + parseInt(op2); //obliga a convertir a int pero no deja sumar decimales

    if(isNaN(resultado)){
        alert('Esa operacion no se puede realizar')
    } else{
        document.getElementById("resultado").value = resultado;
    }
}