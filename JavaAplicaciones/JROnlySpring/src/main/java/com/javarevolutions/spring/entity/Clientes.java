/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: Clientes.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.entity;

import java.io.Serializable;
import java.sql.Date;

public class Clientes implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 2286378858501851031L;
    private Integer id;
    private String nombre;
    private String app;
    private String apm;
    private Date fecha_nacimiento;
    private String sexo;
    private Index usuario;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApp() {
        return app;
    }
    public void setApp(String app) {
        this.app = app;
    }
    public String getApm() {
        return apm;
    }
    public void setApm(String apm) {
        this.apm = apm;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Index getUsuario() {
        return usuario;
    }
    public void setUsuario(Index usuario) {
        this.usuario = usuario;
    }
}
