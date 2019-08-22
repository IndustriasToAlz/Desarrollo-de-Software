
package com.daserva.dao;

import com.daserva.conexion.ConexionDB;
import com.daserva.sql.IconsultasSQL;
import com.daserva.dto.CitaDTO;
import com.daserva.dto.DisponibilidadCitaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class agendaDAO {
    
    public ArrayList<DisponibilidadCitaDTO> getDisponibilidadDatos(int cod_cliente, int cod_doctor, String fecha) throws SQLException{
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        DisponibilidadCitaDTO cita = new DisponibilidadCitaDTO();
        ArrayList<DisponibilidadCitaDTO> ACita = new ArrayList<DisponibilidadCitaDTO>();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;
        
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.GET_DISPONIBILIDAD_AGENDA);
            callableStatement.setInt("cod_cliente",cod_cliente);
            callableStatement.setInt("cod_doctor",cod_doctor);
            callableStatement.setString("fecha",fecha);
            resulSet = callableStatement.executeQuery();
            
            while(resulSet.next()){

                cita.setHora(resulSet.getString("HORA"));
                cita.setCodigoCliente(resulSet.getInt("COD_CLIENTE"));
                cita.setCodigoDoctor(resulSet.getInt("COD_DOCTOR"));
                cita.setAsignada(resulSet.getInt("ASIGNADA"));

                ACita.add(cita);
                
                cita = new DisponibilidadCitaDTO();
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        return ACita;
    }   
    
    
    public ArrayList CRUDcita(int accion, CitaDTO cita) throws SQLException{
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        ArrayList resultado = new ArrayList<>();
        CallableStatement callableStatement = null;
        int filas;
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.CRUD_CITA);
            callableStatement.setInt("cod_cliente", cita.getCodigoCliente());
            callableStatement.setInt("cod_doctor", cita.getCodigoDoctor());
            callableStatement.setString("fecha", cita.getFecha());
            callableStatement.setString("hora", cita.getHora());
            callableStatement.setInt("accion", accion);
            
            filas = callableStatement.executeUpdate();
            
            if (filas > 0) {
                if (accion == 1) {
                    resultado.add("Ok cita creada correctamente");
                }else{
                    resultado.add("Ok cita eliminada correctamente");
                }
            } else{
                if (accion == 1) {
                    resultado.add("Fail cita no se pudo crear");
                }else{
                    resultado.add("Fail cita no se pudo eliminar");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            resultado.add(e.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList validarAgendamiento(int cod_cliente, int cod_doctor, String fecha) throws SQLException{
        
        ArrayList resultado = new ArrayList<>();
        ConexionDB cone = new ConexionDB();
        Connection con = cone.obtener();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.VALIDAR_AGENDAMIENTO);
            callableStatement.setInt("cod_cliente", cod_cliente);
            callableStatement.setInt("cod_doctor", cod_doctor);
            callableStatement.setString("fecha", fecha);
            
            resulSet = callableStatement.executeQuery();
            
            while(resulSet.next()){
                resultado.add(resulSet.getString("NOMBRE"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return resultado;
    }
}
