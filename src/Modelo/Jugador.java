/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Charlie
 */
public class Jugador {
    //Atributos
    private int dinero;
    private Personaje personaje;
    
    //Constructor con parametros
    public Jugador(int dinero, Personaje personaje){
        this.dinero = dinero;
        this.personaje = personaje;        
    }
    //Constructor sin parametros
    public Jugador(){
        this.dinero = 0;
        this.personaje = new Personaje();        
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    
    //Metodos
    public void efectuarMovimiento(Personaje personaje, Casilla casillaI, Casilla casillaF){}
    public void efectuarAtaque(Casilla atacante, Casilla atacado){}
    public void administrarInventario(){}
    public int seleccionarRolPP(){
        return 0;
    }
    public int seleccionarRolPS(){
        return 0;
    }
    public void validarCompañero(){}
    public void usarItem(){}
    public void agregarItem(){}
    public void eliminarItem(){}
    public String agregarCompañero(){
        String nombre = null;
        return nombre;
    }

    
    
    
}
