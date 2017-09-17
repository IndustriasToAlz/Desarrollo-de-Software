/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: ClientesServiceImpl.java
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

import com.javarevolutions.spring.dao.iface.ClientesDAO;
import com.javarevolutions.spring.dominio.ClientesBean;
import com.javarevolutions.spring.entity.Clientes;
import com.javarevolutions.spring.service.iface.ClientesService;
import com.javarevolutions.spring.util.BaseUtil;

public class ClientesServiceImpl implements ClientesService {
    @Autowired
    private ClientesDAO clientesDAO;

    public boolean insertaCliente(ClientesBean obj) throws Exception {
        Clientes entity = new Clientes();
        BaseUtil.copyProperties(entity, obj);
        return clientesDAO.insertaCliente(entity);
    }
    public boolean borraCliente(ClientesBean obj) throws Exception {
        Clientes entity = new Clientes();
        BaseUtil.copyProperties(entity, obj);
        return clientesDAO.borraCliente(entity);
    }
    public boolean actualizaCliente(ClientesBean obj) throws Exception {
        Clientes entity = new Clientes();
        BaseUtil.copyProperties(entity, obj);
        return clientesDAO.actualizaCliente(entity);
    }
    public List<ClientesBean> consultaClientes() throws Exception {
        List<ClientesBean> lista = new ArrayList<ClientesBean>();
        List<Clientes> entities = clientesDAO.consultaClientes();
        for(Clientes entity: entities) {
            ClientesBean bean = new ClientesBean();
            BaseUtil.copyProperties(bean, entity);
            lista.add(bean);
        }
        return lista;
    }
    public ClientesBean getClientePorId(ClientesBean obj) throws Exception {
        Clientes entity = new Clientes();
        BaseUtil.copyProperties(entity, obj);
        entity = clientesDAO.getClientePorId(entity);
        BaseUtil.copyProperties(obj, entity);
        return  obj;
    }
}
