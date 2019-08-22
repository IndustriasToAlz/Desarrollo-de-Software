
package com.daserva.dao;

import com.daserva.conexion.ConexionDB;
import com.daserva.sql.IconsultasSQL;
import com.daserva.dto.DoctorDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class doctorDAO {
    
    public ArrayList<DoctorDTO> getDoctorDatos(String rut) throws SQLException{
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        DoctorDTO doctor = new DoctorDTO();
        ArrayList<DoctorDTO> ADoctor = new ArrayList<DoctorDTO>();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;
        
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.GET_DOCTOR);
            callableStatement.setString("rut",rut);
            resulSet = callableStatement.executeQuery();

            while(resulSet.next()){

                doctor.setCodigo(resulSet.getInt("CODIGO"));
                doctor.setRut(resulSet.getString("RUT"));
                doctor.setPrimerNombre(resulSet.getString("PRIMER_NOMBRE"));
                doctor.setSegundoNombre(resulSet.getString("SEGUNDO_NOMBRE"));
                doctor.setPrimerApellido(resulSet.getString("PRIMER_APELLIDO"));
                doctor.setSegundoApellido(resulSet.getString("SEGUNDO_APELLIDO"));
                doctor.setDireccionResidencia(resulSet.getString("DIRECCION_RESIDENCIA"));
                doctor.setComuna(resulSet.getString("COMUNA"));
                doctor.setTelefonoParticular(resulSet.getString("TELEFONO_PARTICULAR"));
                doctor.setTelefonoTrabajo(resulSet.getString("TELEFONO_TRABAJO"));
                doctor.setTelefonoMovil(resulSet.getString("TELEFONO_MOVIL"));
                doctor.setEmail(resulSet.getString("EMAIL"));
                doctor.setFechaNacimiento(resulSet.getString("FECHA_NACIMIENTO"));
                doctor.setFechaCreacion(resulSet.getDate("FECHA_CREACION"));

                ADoctor.add(doctor);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        return ADoctor;
    }
    
    public ArrayList<DoctorDTO> getDoctoresListaDatos() throws SQLException{
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        DoctorDTO doctor = new DoctorDTO();
        ArrayList<DoctorDTO> ADoctor = new ArrayList<DoctorDTO>();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;
        
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.GET_DOCTORES_LISTA);
            resulSet = callableStatement.executeQuery();

            while(resulSet.next()){

                doctor.setCodigo(resulSet.getInt("CODIGO"));
                doctor.setRut(resulSet.getString("RUT"));
                doctor.setPrimerNombre(resulSet.getString("PRIMER_NOMBRE"));
                doctor.setSegundoNombre(resulSet.getString("SEGUNDO_NOMBRE"));
                doctor.setPrimerApellido(resulSet.getString("PRIMER_APELLIDO"));
                doctor.setSegundoApellido(resulSet.getString("SEGUNDO_APELLIDO"));
                doctor.setDireccionResidencia(resulSet.getString("DIRECCION_RESIDENCIA"));
                doctor.setComuna(resulSet.getString("COMUNA"));
                doctor.setTelefonoParticular(resulSet.getString("TELEFONO_PARTICULAR"));
                doctor.setTelefonoTrabajo(resulSet.getString("TELEFONO_TRABAJO"));
                doctor.setTelefonoMovil(resulSet.getString("TELEFONO_MOVIL"));
                doctor.setEmail(resulSet.getString("EMAIL"));
                doctor.setFechaNacimiento(resulSet.getString("FECHA_NACIMIENTO"));
                doctor.setFechaCreacion(resulSet.getDate("FECHA_CREACION"));

                ADoctor.add(doctor);
                
                doctor = new DoctorDTO();
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        return ADoctor;
    }
    
    public ArrayList CRUDoctor(int accion,DoctorDTO doctor) throws SQLException{
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        ArrayList resultado = new ArrayList<>();
        CallableStatement callableStatement = null;
        int filas;
        
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.CRU_DOCTOR);
            callableStatement.setInt("accion", accion);
            callableStatement.setString("rut",doctor.getRut());
            callableStatement.setString("primer_nombre", doctor.getPrimerNombre());
            callableStatement.setString("segundo_nombre",doctor.getSegundoNombre());
            callableStatement.setString("primer_apellido",doctor.getPrimerApellido());
            callableStatement.setString("segundo_apellido",doctor.getSegundoApellido());
            callableStatement.setString("direccion_residencia",doctor.getDireccionResidencia());
            callableStatement.setString("comuna",doctor.getComuna());
            callableStatement.setString("tel_particular",doctor.getTelefonoParticular());
            callableStatement.setString("tel_trabajo",doctor.getTelefonoTrabajo());
            callableStatement.setString("tel_movil",doctor.getTelefonoMovil());
            callableStatement.setString("email",doctor.getEmail());
            callableStatement.setString("fecha_nacimiento",doctor.getFechaNacimiento());
            filas = callableStatement.executeUpdate();
            
            if (filas > 0) {
                if (accion == 1) {
                    resultado.add("Ok Doctor creado correctamente");
                }else{
                    resultado.add("Ok Doctor actualizado correctamente");
                }
            } else{
                if (accion == 1) {
                    resultado.add("Fail Doctor no se pudo crear");
                }else{
                    resultado.add("Fail Doctor no se pudo actualizar");
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            resultado.add(e.getMessage());
        }

        return resultado;
    }
    
    
}
