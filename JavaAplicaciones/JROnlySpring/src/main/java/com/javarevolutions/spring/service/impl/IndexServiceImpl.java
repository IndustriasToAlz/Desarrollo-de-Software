/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: IndexServiceImpl.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javarevolutions.spring.dao.iface.IndexDAO;
import com.javarevolutions.spring.dominio.IndexBean;
import com.javarevolutions.spring.entity.Index;
import com.javarevolutions.spring.service.iface.IndexService;
import com.javarevolutions.spring.util.BaseUtil;

public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexDAO indexDAO;

    public boolean validaLogin(IndexBean obj) throws Exception {
        Index entity = new Index();
        BaseUtil.copyProperties(entity, obj);
        boolean status = indexDAO.validaLogin(entity);
        if(!status) {
            obj.setMensaje("Usuario o Contraseña Inválidos");
        }
        return status;
    }
    public boolean insertaUsuario(IndexBean obj) throws Exception {
        Index entity = new Index();
        BaseUtil.copyProperties(entity, obj);
        return indexDAO.insertaUsuario(entity);
    }
    public boolean borraUsuario(IndexBean obj) throws Exception {
        Index entity = new Index();
        BaseUtil.copyProperties(entity, obj);
        return indexDAO.borraUsuario(entity);
    }
    public boolean actualizaUsuario(IndexBean obj) throws Exception {
        Index entity = new Index();
        BaseUtil.copyProperties(entity, obj);
        return indexDAO.actualizaUsuario(entity);
    }
    public List<IndexBean> consultaUsuarios() throws Exception {
        List<IndexBean> lista = new ArrayList<IndexBean>();
        List<Index> entities = indexDAO.consultaUsuarios();
        for(Index entity: entities) {
            IndexBean bean = new IndexBean();
            BaseUtil.copyProperties(bean, entity);
            lista.add(bean);
        }
        return lista;
    }
    public IndexBean getUsuarioPorId(IndexBean obj) throws Exception {
        Index entity = new Index();
        BaseUtil.copyProperties(entity, obj);
        entity = indexDAO.getUsuarioPorId(entity);
        BaseUtil.copyProperties(obj, entity);
        return  obj;
    }
}
