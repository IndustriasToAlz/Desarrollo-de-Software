/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: index.js
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */

/**
 * Función que inicializa nuestra pantalla
 * @return
 */
function carga() {
	$("#j_username").focus();
}

/**
 * Función que valida si los datos ingresados en la forma son correctos
 * @return true si los datos son correctos, false si hay datos requeridos nulos
 */
function validate() {
	user = $("#j_username");
	password = $("#j_password");
	if(user.val() == '') {
		alert("Ingresa el usuario");
		user.focus();
		return false;
	} else if(password.val() == '') {
		alert("Ingresa la contraseña");
		password.focus();
		return false;
	} else {
		return true;
	}
}

function showError(error) {
	alert(error);
	if(error == 'null' || error == "null" || error == null) {
		return;
	}
	limite = 0;
	while(error.length > limite) {
		for(var i = 0; i < 100; i++) {
			document.write(error.charAt(limite));
			limite++;
			if(limite >= error.length) {
				break;
			}
		}
		document.write("<br>");
	}
}
