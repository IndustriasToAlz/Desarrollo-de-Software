/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa3;

/**
 *
 * @author user
 */
public class Persona {
    
    String Nombre;
    int Edad;
    String Nacionalidad;
    
    public Persona(String nom){
        this.Nombre = nom;
    }
    
    public void caminar(){
        System.out.println("La persona " + Nombre + " esta caminado");
    }
    
    public void enamorarse(){
        System.out.println("La persona esta enamorandose");
    }
    
    public void morir(){
        System.out.println("La persona murio");
    }
}
