/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: ClientesDAOImpl.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.javarevolutions.spring.dao.iface.ClientesDAO;
import com.javarevolutions.spring.entity.Clientes;
import com.javarevolutions.spring.entity.Index;

public class ClientesDAOImpl extends PersistenceDAO implements ClientesDAO {
    @Override
    @Transactional
    public boolean agregar(Object obj) throws Exception {
        Clientes entity = (Clientes)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into "+getEsquema()+".clientes(nombre, app, apm, fecha_nacimiento, sexo, usuario) values(?,?,?,?,?,?)");
        Object[] args = {entity.getNombre(), entity.getApp(), entity.getApm(), entity.getFecha_nacimiento(), 
        entity.getSexo(), entity.getUsuario().getUsuario()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean borrar(Object obj) throws Exception {
        Clientes entity = (Clientes)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from "+getEsquema()+".clientes where id = ?");
        Object[] args = {entity.getId()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean actualizar(Object obj) throws Exception {
        Clientes entity = (Clientes)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("update "+getEsquema()+".clientes set nombre = ?, app = ?, apm = ?, fecha_nacimiento = ?, sexo = ?, usuario = ? where id = ?");
        Object[] args = {entity.getNombre(), entity.getApp(), entity.getApm(), entity.getFecha_nacimiento(), 
        entity.getSexo(), entity.getUsuario().getUsuario(), entity.getId()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    public List<?> obtenerLista() throws Exception {
        List<Clientes> lista = new ArrayList<Clientes>();
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".clientes");
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString());
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size(); i++) {
                Map<String, Object> mapa = rows.get(i);
                Clientes entity = new Clientes();
                entity.setId((Integer)mapa.get("id"));
                entity.setNombre(""+mapa.get("nombre"));
                entity.setApp(""+mapa.get("app"));
                entity.setApm(""+mapa.get("apm"));
                entity.setFecha_nacimiento((Date)mapa.get("fecha_nacimiento"));
                entity.setSexo(""+mapa.get("sexo"));
                Index usuario = new Index();
                usuario.setUsuario(""+mapa.get("usuario"));
                entity.setUsuario(usuario);
                lista.add(entity);
            }
        }
        return lista;
    }
    @Override
    public Object obtenerObjetoPorId(Object entity) throws Exception {
        Clientes obj = (Clientes)entity;
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".clientes where id = ?");
        Object[] args = {obj.getId()};
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString(), args);
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size();) {
                Map<String, Object> mapa = rows.get(i);
                obj.setNombre(""+mapa.get("nombre"));
                obj.setApp(""+mapa.get("app"));
                obj.setApm(""+mapa.get("apm"));
                obj.setFecha_nacimiento((Date)mapa.get("fecha_nacimiento"));
                obj.setSexo(""+mapa.get("sexo"));
                Index usuario = new Index();
                usuario.setUsuario(""+mapa.get("usuario"));
                obj.setUsuario(usuario);
                return obj;
            }
        }
        return obj;
    }
    public boolean insertaCliente(Clientes entity) throws Exception {
        return agregar(entity);
    }
    public boolean borraCliente(Clientes entity) throws Exception {
        return borrar(entity);
    }
    public boolean actualizaCliente(Clientes entity) throws Exception {
        return actualizar(entity);
    }
    @SuppressWarnings("unchecked")
    public List<Clientes> consultaClientes() throws Exception {
        return (List<Clientes>)obtenerLista();
    }
    public Clientes getClientePorId(Clientes entity) throws Exception {
        return (Clientes)obtenerObjetoPorId(entity);
    }
}
