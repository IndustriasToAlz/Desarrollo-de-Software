<!--
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: menu.jsp
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
-->
<%
String context = request.getContextPath();
%>
<script type="text/javascript">
YAHOO.util.Event.onDOMReady(function () {
	var clickSubmenu = function () {
            nuevo('<%= context %>/templates/donaAporta.jsp', 600, 450);
	    opcion = this.id;
            if(opcion == "home") {
	    	window.location.replace("<%= context %>/home.jr");
	    	return;
	    }
	    if(opcion == "salir") {
	    	window.location.replace("<%= context %>/redirect.jsp");
	    	return;
	    }
	    if(opcion == "clientes" || opcion == "clientes1") {
	    	window.location.replace("<%= context %>/catalogos/clientes/consultaClientes.jr");
	    	return;
	    }
	    if(opcion == "usuarios" || opcion == "usuarios1") {
	    	window.location.replace("<%= context %>/catalogos/usuarios/consultaUsuarios.jr");
	    	return;
	    }
	};
	var aItemData = null;
	aItemData = [
        {
	   	text: "Home", onclick: {fn: clickSubmenu}, id: "home"
	},
	{
	    text: "Cátalogo de Clientes y Usuarios",
	    submenu: {
	        id: "catalogos",
	        itemdata: [
	            {text: "Clientes", onclick: {fn: clickSubmenu}, id: "clientes"},
	            {text: "Usuarios", onclick: {fn: clickSubmenu}, id: "usuarios"}
	        ]
	    }
	},
        {
	    text: "Cátalogo de Clientes",
	    submenu: {
	        id: "catalogos1",
	        itemdata: [
	            {text: "Clientes", onclick: {fn: clickSubmenu}, id: "clientes1"}
	        ]
	    }
	},
        {
	    text: "Cátalogo de Usuarios",
	    submenu: {
	        id: "catalogos2",
	        itemdata: [
	            {text: "Usuarios", onclick: {fn: clickSubmenu}, id: "usuarios1"}
	        ]
	    }
	},
	{
	   	text: "Salir", onclick: {fn: clickSubmenu}, id: "salir"
	}];
	var oMenuBar = new YAHOO.widget.MenuBar("mymenubar", {
	    lazyload: true,
	    itemdata: aItemData
	});
	oMenuBar.render(document.getElementById("menu_jr"));
});
</script>
<div id="menu_jr">
</div>
