/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rruz
 */
public class CharizardY {
    String nombre="CharizardY";
    int hp= 8000;
    int ataque= 700;
    int defensa= 300;
    
    public String getNombre(){
        return nombre;
    }
    public int getHp(){
        return hp;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getDefensa(){
        return defensa;
    }
    public void cambiarHP(int HPActual){
        this.hp=HPActual;
    }
    
}
