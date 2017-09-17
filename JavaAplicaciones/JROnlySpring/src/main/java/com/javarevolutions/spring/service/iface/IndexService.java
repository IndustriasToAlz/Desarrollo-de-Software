/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: IndexService.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.service.iface;

import java.util.List;

import com.javarevolutions.spring.dominio.IndexBean;

public interface IndexService {
    public boolean validaLogin(IndexBean obj) throws Exception;
    public boolean insertaUsuario(IndexBean obj) throws Exception;
    public boolean borraUsuario(IndexBean obj) throws Exception;
    public boolean actualizaUsuario(IndexBean obj) throws Exception;
    public List<IndexBean> consultaUsuarios() throws Exception;
    public IndexBean getUsuarioPorId(IndexBean obj) throws Exception;
}
