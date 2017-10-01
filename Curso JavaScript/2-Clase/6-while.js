'use strict'

var nombre = '';

while(nombre != 'Miguel'){
    nombre = prompt('Dime Tu Nombre', 'Miguel');
}

alert('Bienvenido!! ' + nombre);

do {
    nombre = prompt('Dime Tu Nombre', 'Miguel');
} while (nombre != 'Miguel');
alert('Bienvenido 2!! ' + nombre);