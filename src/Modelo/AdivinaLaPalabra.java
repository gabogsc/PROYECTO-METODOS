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
    int numero = rnd.nextInt(10);
    public String palabra;
    public String pista;
    private  int cantidad = 5 ;
    private controladorJuego cJ;
    
    public AdivinaLaPalabra(int cantidad){
        this.cantidad = cantidad;   
    }
    
    public void encontrarPalabra(){
         
    }
    public AdivinaLaPalabra(){
        palabras = new ArrayList<>();
        palabras.add("perro");
        palabras.add("gato");
        palabras.add("aire");
        palabras.add("juego");
        palabras.add("comida");
        palabras.add("nota");
        palabras.add("prueba");
        palabras.add("aprobar");
        palabras.add("killer");
        palabras.add("mu");
        palabra = palabras.get(numero);
    }
    
    public String encontrarHint(String palabra){
        if(this.palabra.equals("perro")){ 
            pista = "Animal domestico común.";
        }
        if(this.palabra.equals("gato")){
            pista = "Felino domestico común."; 
        }
        if(this.palabra.equals("aire")){
            pista = "Es necesario para la vida."; 
        }
        if(this.palabra.equals("juego")){
            pista = "Lo que esto es."; 
        }
        if(this.palabra.equals("comida")){
            pista = "Lo que una persona come."; 
        }
        if(this.palabra.equals("nota")){
            pista = "Despues de que revisan una prueba, te la entregan."; 
        }
        if(this.palabra.equals("prueba")){
            pista = "Posee una nota."; 
        }
        if(this.palabra.equals("aprobar")){
            pista = "Cuando se pasa un ramo."; 
        }
        if(this.palabra.equals("killer")){
            pista = "Lo que el Charlie es."; 
        }
        if(this.palabra.equals("mu")){
            pista = "Lo que el Arru dice."; 
        }
        return pista;
    }
    
          ///Método que compara palabras////
    public boolean verificar(String palabra){ 
        if(this.palabra.equals(palabra)){
            return true;
        }
        return false;
    }
    
    public String entregarHint(){
        return pista;
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
    

