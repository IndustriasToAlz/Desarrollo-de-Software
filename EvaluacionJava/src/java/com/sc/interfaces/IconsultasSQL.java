
package com.sc.interfaces;


public interface IconsultasSQL {
    
    public static String GET_CLIENTE = "EXECUTE [dbo].[Proc_Get_Cliente] ?";
    public static String GET_CLIENTES = "EXECUTE [dbo].[Proc_Get_Clientes]";
    public static String CRU_CLIENTES = "EXECUTE [dbo].[Proc_CRU_Cliente] ?,?,?,?,?,?,?,?,?,?";
}
