<!--
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: clientes.jsp
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
-->
<%@ taglib prefix="form" uri="/WEB-INF/spring-form.tld"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cátalogo de Clientes</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jr.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/catalogos/clientes.js"></script>
</head>
<body onload="loadForma('tablaCatalogoClientes');">
<form:form commandName="clientesBean">
<form:hidden path="id"/>
<div align="center" style="width: 100%; height: 450px;">
<table style="width: 98%">
<tr>
    <td style="font-weight: bold; size: 20px;" align="right" colspan="4">-> Cátalogo de Clientes</td>
</tr>
<tr>
<td>
    <table style="width: 100%;">
        <tr>
        <td align="left">
        <a href="#" title="Nuevo Registro" onclick="nuevo('showCliente.jr?accion=nuevo', 850, 350);">
        <img src="<%= request.getContextPath() %>/images/new.gif" alt="Nuevo Registro" title="Nuevo Registro" border="0"/>
        <font color="blue">Nuevo</font>
        </a>&nbsp;
        <a href="#" title="Actualizar Registro" onclick="actualizaData('showCliente.jr', 'id', 0, 850, 350);">
        <img src="<%= request.getContextPath() %>/images/update.gif" alt="Actualizar Registro" title="Actualizar Registro" border="0"/>
        <font color="blue">Actualizar</font>
        </a>&nbsp;
        <a href="#" title="Borrar Registro" onclick="validaBorrado('clientesBean', 'id', 0, 'borraCliente.jr');">
        <img src="<%= request.getContextPath() %>/images/delete.png" alt="Borrar Registro" title="Borrar Registro" border="0"/>
        <font color="blue">Borrar</font>
        </a>
        </td></tr>
        <tr><td width="100%" height="2px" bgcolor="Silver"></td></tr>
    </table>
    <table id="tablaCatalogoClientes" style="width: 100%">
        <tr>
        <th style="display: none;">id</th>
        <th>Nombre</th>
        <th>Fecha de Nacimiento</th>
        <th>Sexo</th>
        </tr>
        <c:forEach var="objCliente" items="${listaClientes}" varStatus="status">
        <tr>
        <td style="display: none;">${objCliente.id}</td>
        <td>${objCliente.nombre} ${objCliente.app} ${objCliente.apm}</td>
        <td>${objCliente.fecha_nacimiento}</td>
        <td>${objCliente.sexo}</td>
        </tr>
        </c:forEach>
    </table>
</td></tr>
</table>
</div>
</form:form>
</body>
</html>
