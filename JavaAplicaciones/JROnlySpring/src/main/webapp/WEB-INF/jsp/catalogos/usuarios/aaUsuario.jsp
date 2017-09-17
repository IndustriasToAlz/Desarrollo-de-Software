<!--
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: aaUsuario.jsp
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
-->
<%@ taglib prefix="form" uri="/WEB-INF/spring-form.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar ó Actualizar Usuario</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/formas.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jr.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/catalogos/usuarios.js"></script>
</head>
<body onload="cargaUsuario();">
<fieldset>
<legend>Ingrese los datos requeridos</legend>
<form:form action="doAAUsuario.jr" commandName="usuariosBean" onsubmit="return validaNulos();">
<form:hidden path="accion"/>
<center>
<table class="tablaAA">
<tr>
<td style="text-align: right;"><label>Usuario : </label></td>
<td><form:input path="usuario" class="required"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Password : </label></td>
<td><form:password path="password" class="required"/></td>
</tr>
<tr>
<td><input type="button" value="Cancelar" onclick="cancelar();"/>
<td><input type="submit" value="Aceptar"/></td>
</tr>
</table>
</center>
</form:form>
</fieldset>
</body>
</html>
