/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: GenericoBean.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.dominio;

import java.io.Serializable;

public class GenericoBean implements Serializable {
    private static final long serialVersionUID = -3046602426623981372L;
    private String mensaje;
    private Boolean status;
    private String accion;

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getAccion() {
        return accion;
    }
    public void setAccion(String accion) {
        this.accion = accion;
    }
}
