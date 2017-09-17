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
public class Programa3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona hombre = new Persona("Carlos");
        Persona mujer = new Persona("Aledis");
        
        hombre.caminar();
        mujer.caminar();
    }
    
}
