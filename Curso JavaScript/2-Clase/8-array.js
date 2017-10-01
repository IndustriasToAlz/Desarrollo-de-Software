'use strict'

var numeros = [3,5,2,10,'x',40];

numeros.push(1000); //sirve para agregarle pososciones al array

function sumatorio(vector){
    var sum = 0;
    // for(var i = 0; i < vector.length; i++){
    //     sum +=  vector[i];
    // }

    for(var i in vector){
        if(typeof(vector[i]) == 'number'){
            sum +=  vector[i];
        }
    }
    
    return sum;
}

console.log(sumatorio(numeros));
