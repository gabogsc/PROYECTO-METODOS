/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.controladorJuego;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sebastian
 */
public class AdivinaLaPalabra {
    Random rnd = new Random();
    ArrayList<String> palabras;
    public String palabra = "comida";
    public String pista = "Lo que una persona come";
    private  int cantidad = 6 ;
    
    private controladorJuego cJ;
    
    public AdivinaLaPalabra(int cantidad){
        this.cantidad = cantidad;   
    }
    ///Método que compara palabras////
    
    public void encontrarPalabra(){
        Random numeroAzar;
        //Ayuda ARRUUU          this.palabra = palabras[numeroAzar];
    }
    public AdivinaLaPalabra(String palabra){
        palabras = new ArrayList<>();
        palabras.add("perro");
        palabras.add("aire");
        palabras.add("juego");
        palabras.add("comida");
        palabras.add("nota");
        palabras.add("prueba");
    }
    
    public AdivinaLaPalabra(){
        if(this.palabra.equals("perro")){ 
            pista = "Animal domestico común";
        }
        if(this.palabra.equals("aire")){
            pista = "Es necesario para la vida"; 
        }
        if(this.palabra.equals("juego")){
            pista = "Lo que esto es"; 
        }
        if(this.palabra.equals("comida")){
            pista = "Lo que una persona come"; 
        }
        if(this.palabra.equals("nota")){
            pista = "Despues de que revisan una prueba, te lo entregan"; 
        }
        if(this.palabra.equals("prueba")){
            pista = "Posee una nota"; 
        }
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
    

