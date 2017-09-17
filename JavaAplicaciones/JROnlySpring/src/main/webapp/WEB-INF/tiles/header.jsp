<!--
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: header.jsp
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
-->
<table height="80px" border="0" align="center">
<tr>
    <td>
        <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
        <input type="hidden" name="cmd" value="_s-xclick"/>
        <input type="hidden" name="hosted_button_id" value="BDBWXVDZJULMG"/>
        <input type="image" src="https://www.paypalobjects.com/es_XC/MX/i/btn/btn_donateCC_LG.gif" border="0" name="submit" alt="PayPal, la forma más segura y rápida de pagar en línea."/>
        <img alt="" border="0" src="https://www.paypalobjects.com/es_XC/i/scr/pixel.gif" width="1" height="1"/>
        </form>
    </td>
    <td>
        <img alt="Ayudar a Otros es bueno" border="0" src="<%= request.getContextPath() %>/images/izquierda1.gif"/>
    </td>
    <td>
        <div style="border: 0; height: 100px; overflow: hidden; width: 248px;">
        <iframe align="middle" allowtransparency="true" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" src="http://www.youtube.com/subscribe_widget?p=JavaRevolutions" style="left: -1px; position: relative; top: -1px;" width="250px">
        </iframe>
        </div>
    </td>
</tr>
</table>