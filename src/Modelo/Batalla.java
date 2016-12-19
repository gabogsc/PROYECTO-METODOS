/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;
import Modelo.Escenario;
import Modelo.Casilla;

public class Batalla {
    //Atributos
    private ArrayList<String> personajesVivos;
    private ArrayList<String> personajesMuertos;
    Personaje delJugador;
    int hpJugador;
    int ataqueJugador;
    int defensaJugador;
    Personaje delEnemigo;
    int hpEnemigo;
    int ataqueEnemigo;
    int defensaEnemigo;

    

    public Batalla(ArrayList<String> personajesVivos, ArrayList<String> personajesMuertos) {
        this.personajesVivos = personajesVivos;
        this.personajesMuertos = personajesMuertos;
    }
     public Batalla() {
        this.personajesVivos = new ArrayList();
        this.personajesMuertos = new ArrayList();
    }
     
    //Metodos
 
    public void setTablero(Escenario escenario){
        
    }
    public int atacarLargo(int num, Personaje jugador, Personaje enemigo){
        int hpJugador=jugador.getPuntosVidaTotal();
        System.out.println("vida jugador");
        System.out.println(hpJugador);
        int ataqueJugador=jugador.getPuntosAtaqueLargo();
        System.out.println("ataque jugador");
        System.out.println(ataqueJugador);
        int hpEnemigo=enemigo.getPuntosVidaTotal();
        System.out.println("vida enemigo");
        System.out.println(hpEnemigo);
        int defensaEnemigo=enemigo.getPuntosDefensa();
        System.out.println("defensa enemigo");
        System.out.println(defensaEnemigo);
        int dañoRealizado;
        if(num==0){
            int daño=defensaEnemigo-ataqueJugador;
            System.out.println("daño realizado");
            System.out.println(daño);
            dañoRealizado=hpEnemigo + daño;
            System.out.println("resultado ataque");
            System.out.println(dañoRealizado);
            enemigo.setPuntosVidaTotal(dañoRealizado);
            int vidaActual=enemigo.getPuntosVidaTotal();
            System.out.println("vida enemigo despues");
            System.out.println(vidaActual);
        }else{
            Random rand=new Random();
            int probabilidad=rand.nextInt(99);
            if ((probabilidad<=25)&&(20<probabilidad)||(probabilidad<=45)&&(probabilidad>40)||(probabilidad<=65)&&(probabilidad>60)||(probabilidad<=85)&&(probabilidad>80)){
                dañoRealizado=0;
            }else{
               int daño=defensaEnemigo-ataqueJugador;
                System.out.println("daño realizado");
                System.out.println(daño);
                dañoRealizado=hpEnemigo + daño;
                System.out.println("resultado ataque");
                System.out.println(dañoRealizado);
                enemigo.setPuntosVidaTotal(dañoRealizado);
                int vidaActual=enemigo.getPuntosVidaTotal();
                System.out.println("vida enemigo despues");
                System.out.println(vidaActual); 
                }
            }return dañoRealizado;
        
        }
    
    
}


   





    



    
