/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rruz
 */
public class CharizardX {
    String nombre="CharizardX";
    int hp= 8000;
    int ataque= 500;
    int defensa= 400;
    
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
    public void cambiarHP(int hpActual){
        this.hp=hpActual;
    }
    
    
}
