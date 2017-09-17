<!--
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: welcome.jsp
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido al Sistema Web Java Revolutions construido solo con Spring</title>
<script type="text/javascript" language="JavaScript" src="<%= request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" language="JavaScript" src="<%= request.getContextPath() %>/js/jr.js"></script>
</head>
<body onload="loadImagen('<%= request.getContextPath() %>/images/Aporta.jpg');">
<table>
    <tr>
    <td style="font-weight: bold; size: 20px;">-> Home</td>
    </tr>
</table>
<table align="center">
<tr>
<td><img title="Bienvenido al Sistema Web Java Revolutions construido solo con Spring" 
         id="imageWelcome" name="imageWelcome" width="529px" height="409px"></td>
</tr>
</table>
</body>
</html>
