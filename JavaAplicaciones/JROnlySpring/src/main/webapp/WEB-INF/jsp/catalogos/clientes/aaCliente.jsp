<!--
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: aaCliente.jsp
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
<title>Agregar ó Actualizar Cliente</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/formas.css"/>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/calendario_dw-estilos.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/calendario_dw.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jr.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/catalogos/clientes.js"></script>
</head>
<body onload="cargaCliente();">
<fieldset>
<legend>Ingrese los datos requeridos</legend>
<form:form action="doAACliente.jr" commandName="clientesBean" onsubmit="return validaNulos();">
<form:hidden path="accion"/>
<center>
<table class="tablaAA">
<tr style="display:  none;">
<td><label>Id : </label></td>
<td><form:input path="id"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Nombre(s) : </label></td>
<td><form:input path="nombre" class="required"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Apellido Paterno : </label></td>
<td><form:input path="app" class="required"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Apellido Materno : </label></td>
<td><form:input path="apm" class="required"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Fecha de Nacimiento : </label></td>
<td><form:input path="fechaNacimientoStr" class="campofecha required" size="16" readonly="true"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Sexo : </label></td>
<td><form:select path="sexo" items="${listaSexos}" cssStyle="width: 140px;"/></td>
</tr>
<tr>
<td style="text-align: right;"><label>Usuario : </label></td>
<td><form:input path="usuario.usuario" class="required"/></td>
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
