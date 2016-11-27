/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.controladorJuego;

/**
 *
 * @author sebastian
 */
public class AdivinaLaPalabra {
    public String palabra = "comida";
    private  int cantidad = 6 ;
    
    private controladorJuego cJ;
    
    public AdivinaLaPalabra(int cantidad){
        this.cantidad = cantidad;
    }
    ///Método que compara palabras////

    public AdivinaLaPalabra() {
        
    }
    
    public boolean verificar(String palabra){ 
        if(this.palabra.equals(palabra)){
            return true;
        }
        return false;
       }
    
    public int disminuirCantidad(){
           this.cantidad = this.cantidad - 1 ;  
           System.out.println(this.cantidad);
           return this.cantidad;
       
   }
        
    
      public int getCantidad() {
        return cantidad;
    }

}
    

