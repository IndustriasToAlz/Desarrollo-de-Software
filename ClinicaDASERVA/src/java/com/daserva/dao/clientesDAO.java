
package com.daserva.dao;

import com.daserva.conexion.ConexionDB;
import com.daserva.sql.IconsultasSQL;
import com.daserva.dto.ClienteDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class clientesDAO {
    
    public ArrayList<ClienteDTO> getClienteDatos(String rut) throws SQLException{
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        ClienteDTO cliente = new ClienteDTO();
        ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;
        
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.GET_CLIENTE);
            callableStatement.setString("rut",rut);
            resulSet = callableStatement.executeQuery();

            while(resulSet.next()){

                cliente.setCodigo(resulSet.getInt("CODIGO"));
                cliente.setRut(resulSet.getString("RUT"));
                cliente.setPrimerNombre(resulSet.getString("PRIMER_NOMBRE"));
                cliente.setSegundoNombre(resulSet.getString("SEGUNDO_NOMBRE"));
                cliente.setPrimerApellido(resulSet.getString("PRIMER_APELLIDO"));
                cliente.setSegundoApellido(resulSet.getString("SEGUNDO_APELLIDO"));
                cliente.setDireccionResidencia(resulSet.getString("DIRECCION_RESIDENCIA"));
                cliente.setComuna(resulSet.getString("COMUNA"));
                cliente.setTelefonoParticular(resulSet.getString("TELEFONO_PARTICULAR"));
                cliente.setTelefonoTrabajo(resulSet.getString("TELEFONO_TRABAJO"));
                cliente.setTelefonoMovil(resulSet.getString("TELEFONO_MOVIL"));
                cliente.setEmail(resulSet.getString("EMAIL"));
                cliente.setFechaNacimiento(resulSet.getString("FECHA_NACIMIENTO"));
                cliente.setFechaCreacion(resulSet.getDate("FECHA_CREACION"));

                clientes.add(cliente);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        return clientes;
    }
    
    public ArrayList CRUCliente(int accion,ClienteDTO cliente) throws SQLException{
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        ArrayList resultado = new ArrayList<>();
        CallableStatement callableStatement = null;
        int filas;
        
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.CRU_CLIENTE);
            callableStatement.setInt("accion", accion);
            callableStatement.setString("rut",cliente.getRut());
            callableStatement.setString("primer_nombre", cliente.getPrimerNombre());
            callableStatement.setString("segundo_nombre",cliente.getSegundoNombre());
            callableStatement.setString("primer_apellido",cliente.getPrimerApellido());
            callableStatement.setString("segundo_apellido",cliente.getSegundoApellido());
            callableStatement.setString("direccion_residencia",cliente.getDireccionResidencia());
            callableStatement.setString("comuna",cliente.getComuna());
            callableStatement.setString("tel_particular",cliente.getTelefonoParticular());
            callableStatement.setString("tel_trabajo",cliente.getTelefonoTrabajo());
            callableStatement.setString("tel_movil",cliente.getTelefonoMovil());
            callableStatement.setString("email",cliente.getEmail());
            callableStatement.setString("fecha_nacimiento",cliente.getFechaNacimiento());
            filas = callableStatement.executeUpdate();
            
            if (filas > 0) {
                if (accion == 1) {
                    resultado.add("Ok cliente creado correctamente");
                }else{
                    resultado.add("Ok cliente actualizado correctamente");
                }
            } else{
                if (accion == 1) {
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
