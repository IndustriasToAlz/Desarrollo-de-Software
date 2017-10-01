'use strict'

for(var i=1; i<=10; i++){
    document.write('<p>' + i + '</p>');
}

for(var j=100; j>=1; j--){
    document.write('<div>' + j + '</div>');
}

for(var k=100; k>=1; k-= 2){
    // if(k==50){
    //     break;
    // }
    if(k <= 50 && k >= 20){
        continue; //dar un espacio ne el ciclo cuando se cumpla la condicion
    }

    if(k % 3 == 0){
        document.write('<div style="color: red;">' + k + '</div>');
    } else{
        document.write('<div>' + k + '</div>');
    }
}