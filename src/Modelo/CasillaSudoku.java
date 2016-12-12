/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JToggleButton;

/**
 *
 * @author Carlos
 */
public class CasillaSudoku{
    //Atributos
    private int valorCasilla;
    private int posicionColumna;
    private int posicionFila;

    
    //Constructor
    public CasillaSudoku(int valor, int fila, int columna){
        this.valorCasilla = valor;
        this.posicionColumna = columna;
        this.posicionFila = fila;
    }    
    //Metodos
    public int getCasilla(){
        return this.valorCasilla;
    }
    public int getColumna(){
        return this.posicionColumna;
    }
    public int getFila(){
        return this.posicionFila;
    }
    public void setCasilla(int numero){
        this.valorCasilla = numero;
        
    }
     
        
        
}