
package com.manosenelcodigo.modelos;


public class Clientes {
    private int cod_cliente;
    private String nom_cliente;
    private String ape_cliente;
    private String dir_cliente;
    private String telefono_cliente;
    private String email;

    public Clientes() {
    }

    public Clientes(String nom_cliente, String ape_cliente, String dir_cliente, String telefono_cliente, String email) {
        this.nom_cliente = nom_cliente;
        this.ape_cliente = ape_cliente;
        this.dir_cliente = dir_cliente;
        this.telefono_cliente = telefono_cliente;
        this.email = email;
    }

    public Clientes(int cod_cliente, String nom_cliente, String ape_cliente, String dir_cliente, String telefono_cliente, String email) {
        this.cod_cliente = cod_cliente;
        this.nom_cliente = nom_cliente;
        this.ape_cliente = ape_cliente;
        this.dir_cliente = dir_cliente;
        this.telefono_cliente = telefono_cliente;
        this.email = email;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getApe_cliente() {
        return ape_cliente;
    }

    public void setApe_cliente(String ape_cliente) {
        this.ape_cliente = ape_cliente;
    }

    public String getDir_cliente() {
        return dir_cliente;
    }

    public void setDir_cliente(String dir_cliente) {
        this.dir_cliente = dir_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
