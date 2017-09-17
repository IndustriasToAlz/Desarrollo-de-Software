/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa5;

/**
 *
 * @author user
 */
public class Television {
    
    boolean estado = false;
    String marca = null;
    String tamaño = null;
    
    public Television(String marc, String tam){
        this.marca = marc;
        this.tamaño = tam;
    }
    
    public void encender(){
        if (estado == true) {
            System.out.println("La televsion ya esta encendida");
        }else{
            System.out.println("La television a encendido");
            this.estado = true;
        }
    }
    
    public void apagar(){
        if (estado == false) {
            System.out.println("La television ya esta apagada");
        }else{
            System.out.println("La television se ha apagado");
            this.estado = false;
        }
    }
    
    public void cambiar_canal(){
        if (estado == false) {
            System.out.println("Necesitas encender la television");
        }else{
            System.out.println("La television ha cambiado de canal");
        }
    }
            
}
