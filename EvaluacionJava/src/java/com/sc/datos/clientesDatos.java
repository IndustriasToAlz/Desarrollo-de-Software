
package com.sc.datos;

import com.sc.conexion.ConexionDB;
import com.sc.interfaces.IconsultasSQL;
import com.sc.modelos.ThomCliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class clientesDatos {
    
    public ArrayList<ThomCliente> getCliente(String cedula) throws SQLException{
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        ThomCliente cliente = new ThomCliente();
        ArrayList<ThomCliente> clientes = new ArrayList<ThomCliente>();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.GET_CLIENTE);
            callableStatement.setString("cedula", cedula);
            resulSet = callableStatement.executeQuery();

            while(resulSet.next()){

                cliente.setDsnombre(resulSet.getString("dsnombre"));
                cliente.setDsdireccion(resulSet.getString("dsdireccion"));
                cliente.setDsmail(resulSet.getString("dsmail"));
                cliente.setCdusuario(resulSet.getString("cdusuario"));
                cliente.setSnactivo(resulSet.getString("snactivo"));
                cliente.setCdtelefono(resulSet.getString("cdtelefono"));
                cliente.setDscontacto(resulSet.getString("dscontacto"));
                cliente.setDslogo(resulSet.getString("dslogo"));

                clientes.add(cliente);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return clientes;
    }
    
     public ArrayList<ThomCliente> getClientes() throws SQLException{
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        ThomCliente cliente = new ThomCliente();
        ArrayList<ThomCliente> clientes = new ArrayList<ThomCliente>();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.GET_CLIENTES);
            resulSet = callableStatement.executeQuery();

            while(resulSet.next()){

                cliente.setDsnombre(resulSet.getString("dsnombre"));
                cliente.setDsdireccion(resulSet.getString("dsdireccion"));
                cliente.setDsmail(resulSet.getString("dsmail"));
                cliente.setCdusuario(resulSet.getString("cdusuario"));
                cliente.setSnactivo(resulSet.getString("snactivo"));
                cliente.setCdtelefono(resulSet.getString("cdtelefono"));
                cliente.setDscontacto(resulSet.getString("dscontacto"));
                cliente.setDslogo(resulSet.getString("dslogo"));

                clientes.add(cliente);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return clientes;
    }
     
     public ArrayList cruCliente(ThomCliente cliente, int accion) throws SQLException{
         ArrayList resultado = new ArrayList<>();
         
        ConexionDB cone = new ConexionDB();
        Connection con = cone.obtener();
        CallableStatement callableStatement = null;
        int filas;
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.CRU_CLIENTES);
            callableStatement.setInt("accion", accion);
            callableStatement.setString("cdcliente",cliente.getCdcliente());
            callableStatement.setString("dsnombre", cliente.getDsnombre());
            callableStatement.setString("dsdireccion",cliente.getDsdireccion());
            callableStatement.setString("dsmail",cliente.getDsmail());
            callableStatement.setString("cdusuario",cliente.getCdusuario());
            callableStatement.setString("snactivo",cliente.getSnactivo());
            callableStatement.setString("cdtelefono",cliente.getCdtelefono());
            callableStatement.setString("dscontacto",cliente.getDscontacto());
            callableStatement.setString("dslogo",cliente.getDslogo());
            filas = callableStatement.executeUpdate();
            
            if (filas > 0) {
                if (accion == 0) {
                    resultado.add("Ok cliente creado correctamente");
                }else{
                    resultado.add("Ok cliente actualizado correctamente");
                }
            } else{
                if (accion == 0) {
                    resultado.add("Fail cliente no se pudo crear");
                }else{
                    resultado.add("Fail cliente no se pudo actualizar");
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            resultado.add(e.getMessage());
        }
         
        return resultado;
     }
}
