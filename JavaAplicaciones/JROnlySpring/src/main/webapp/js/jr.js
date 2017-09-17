/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: jr.js
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
**/
var cInt = 1;
var rowSel;
var doClick = false;

function getRowSel() {
	return rowSel;
}

function setRowSel(rowSelect) {
	rowSel = rowSelect;
}

function estiloTabla(id_tabla) {
    var estyle_tabla = document.getElementById(id_tabla);
    var rows = estyle_tabla.tBodies[0].rows;
    for(var i = cInt; i < rows.length; i++) {
        row = rows[i];
        row.bgColor = "#F2F2F2";
        row.onmouseover = function() {
            if(doClick == false) {
                this.bgColor = 'FFDC75';
            }
            this.style.cursor = 'pointer';
        };
        row.onmouseout = function() {
            setEstyleNull(rows);
        };
        row.onclick = function() {
            setRowSel(this);
            this.bgColor = 'FFDC75';
            applyEstyle(rows, this);
            doClick = true;
        };
        row.ondblclick = function() {
        	consultaData();
        };
    }
}

function applyEstyle(rows, aux) {
    for(var i = cInt; i < rows.length; i++) {
        row = rows[i];
        if(row != aux) {
            row.bgColor = "#F2F2F2";
        }
    }
}

function setEstyleNull(rows) {
    if(doClick == false) {
        for(var i = cInt; i < rows.length; i++) {
            row = rows[i];
            row.bgColor = "#F2F2F2";
        }
    }
}

function abrirVentana(urlPagina, widthAncho, heightAlto) {
	titulo = "";
	ancho = widthAncho;
	alto = heightAlto;
	left = 100;
	top = 100;
	var response = null;
	if(navigator.appName == "Netscape") {
		if(window.showModalDialog) {
			response = window.showModalDialog(urlPagina, "Dialogo Web",
			"dialogWidth:"+ancho+"px;dialogHeight:"+alto+"px");
		} else {
			response = window.open(urlPagina, titulo, 'width='+ancho+',height='+
			alto+',top='+top+',left='+left+',toolbar=no,location=no,directories=no,scrollbars=yes,status=no,menubar=no,resizable=no');
			response.moveTo(100, 100);
			response.resizeTo(ancho, alto);
		}
	} else if(navigator.appName == "Microsoft Internet Explorer") {
		if(window.showModalDialog) {
			response = window.showModalDialog(urlPagina, "Dialogo Web",
			"dialogWidth:"+ancho+"px;dialogHeight:"+alto+"px");
		} else {
			response = window.open(urlPagina, titulo, "toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1,width="+
			ancho+",height="+alto+",left="+left+",top="+top);
		}
	} else {
		if(window.showModalDialog) {
			response = window.showModalDialog(urlPagina, "Dialogo Web",
			"dialogWidth:"+ancho+"px;dialogHeight:"+alto+"px");
		} else {
			response = window.open(urlPagina, titulo, "toolbar=1,scrollbars=1,location=1,statusbar=1,menubar=1,resizable=1,width="+ancho+",height="+alto+",left="+left+",top="+top);
		}
	}
	if(response == "success") {
		window.location.reload();
	}
}

function validaBorrado(idForm, idField, numCell, action) {
	if(getRowSel() != null) {
		if(confirm("¿Esta seguro que desea borrar el registro seleccionado?")) {
			value_id = getRowSel().cells[numCell];
			document.getElementById(idField).value = value_id.innerHTML;
			document.forms[idForm].action = action;
			document.forms[idForm].submit();
		}
	} else {
		alert("Selecciona un registro");
	}
}

function actualizaData(urlPagina, idField, numCell, widthAncho, heightAlto) {
	if(getRowSel() != null) {
		value_id = getRowSel().cells[numCell];
		nuevo(urlPagina+"?"+idField+"="+value_id.innerHTML+"&accion=actualizar", widthAncho, heightAlto);
	} else {
		alert("Selecciona un registro");
	}
}

function nuevo(urlPagina, widthAncho, heightAlto) {
	abrirVentana(urlPagina, widthAncho, heightAlto);
}

function carga(idTabla) {
	estiloTabla(idTabla);
}

function validaNulos() {
	var cmps = document.getElementsByTagName("input");
	for(var i = 0; i < cmps.length; i++) {
		cmp = cmps[i];
		if(cmp.type == "text" || cmp.type == "password") {
			if(cmp.className.indexOf("required") != -1) {
				valor = cmp.value.trim();
				if(valor == "" || valor.lenth <= 0) {
					alert("Ingresa el valor del campo requerido");
					cmp.focus();
					return false;
				}
			}
		}
	}
	return true;
}

String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, "");
};

function success() {
	window.returnValue = "success";
	window.close();
}

function cancelar() {
	window.close();
}

function loadForma(idTabla) {
	carga(idTabla);
}

function loadImagen(rutaSRC) {
	var image = document.getElementById("imageWelcome");
	image.src = rutaSRC;
}
