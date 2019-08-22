
package com.daserva.sql;


public interface IconsultasSQL {
    
    public static String VALIDAR_LOGIN = "EXECUTE seguridad.Proc_Validar_login ?,?";
    
    public static String GET_CLIENTE = "EXECUTE clientes.Proc_Get_Cliente ?";
    
    public static String CRU_CLIENTE = "EXECUTE clientes.Proc_CRU_Cliente ?,?,?,?,?,?,?,?,?,?,?,?,?";
    
    public static String GET_DOCTOR = "EXECUTE clinica.Proc_Get_Doctor ?";
    
    public static String CRU_DOCTOR = "EXECUTE clinica.Proc_CRU_DOCTOR ?,?,?,?,?,?,?,?,?,?,?,?,?";
    
    public static String GET_DOCTORES_LISTA = "EXECUTE clinica.Proc_Get_Doctores_Lista";
    
    public static String GET_DISPONIBILIDAD_AGENDA = "EXECUTE agenda.Proc_Consultar_Disponibilidad ?,?,?";
    
    public static String CRUD_CITA = "EXECUTE agenda.Proc_CRUD_Cita ?,?,?,?,?";
    
    public static String VALIDAR_AGENDAMIENTO = "EXECUTE agenda.Proc_Validar_Agendamiento ?,?,?";
    
}
