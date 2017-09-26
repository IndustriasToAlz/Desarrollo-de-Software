
package com.manosenelcodigo.modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Conectar {
    
    public DriverManagerDataSource conectar(){
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=prueba");
        dataSource.setUsername("carlostoalz");
        dataSource.setPassword("contigente3del9");
        
        return dataSource;
    }
}
