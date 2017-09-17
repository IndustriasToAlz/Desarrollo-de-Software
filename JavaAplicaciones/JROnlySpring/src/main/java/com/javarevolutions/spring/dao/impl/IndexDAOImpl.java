/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: IndexDAOImpl.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.javarevolutions.spring.dao.iface.IndexDAO;
import com.javarevolutions.spring.entity.Index;

public class IndexDAOImpl extends PersistenceDAO implements IndexDAO {
    public boolean validaLogin(Index entity) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from "+getEsquema()+".login where usuario = ? and password = ?");
        Object[] args = {entity.getUsuario(), entity.getPassword()};
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql.toString(), args);
        if(rows.size() > 0) {
            return true;
        }
        return false;
    }
    @Override
    @Transactional
    public boolean agregar(Object obj) throws Exception {
        Index entity = (Index)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into "+getEsquema()+".login(usuario, password) values(?,?)");
        Object[] args = {entity.getUsuario(), entity.getPassword()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean borrar(Object obj) throws Exception {
        Index entity = (Index)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from "+getEsquema()+".login where usuario = ?");
        Object[] args = {entity.getUsuario()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean actualizar(Object obj) throws Exception {
        Index entity = (Index)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("update "+getEsquema()+".login set password = ? where usuario = ?");
        Object[] args = {entity.getPassword(), entity.getUsuario()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    public List<?> obtenerLista() throws Exception {
        List<Index> lista = new ArrayList<Index>();
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".login");
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString());
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size(); i++) {
                Map<String, Object> mapa = rows.get(i);
                Index entity = new Index();
                entity.setUsuario(""+mapa.get("usuario"));
                entity.setPassword(""+mapa.get("password"));
                lista.add(entity);
            }
        }
        return lista;
    }
    @Override
    public Object obtenerObjetoPorId(Object entity) throws Exception {
        Index obj = (Index)entity;
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".login where usuario = ?");
        Object[] args = {obj.getUsuario()};
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString(), args);
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size();) {
                Map<String, Object> mapa = rows.get(i);
                obj.setUsuario(""+mapa.get("usuario"));
                obj.setPassword(""+mapa.get("password"));
                return obj;
            }
        }
        return obj;
    }
    public boolean insertaUsuario(Index entity) throws Exception {
        return agregar(entity);
    }
    public boolean borraUsuario(Index entity) throws Exception {
        return borrar(entity);
    }
    public boolean actualizaUsuario(Index entity) throws Exception {
        return actualizar(entity);
    }
    @SuppressWarnings("unchecked")
    public List<Index> consultaUsuarios() throws Exception {
        return (List<Index>)obtenerLista();
    }
    public Index getUsuarioPorId(Index entity) throws Exception {
        return (Index)obtenerObjetoPorId(entity);
    }
}
