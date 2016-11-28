/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.ControladorBatallaCorta;
import Controlador.ControladorDefMonito;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author arru
 */
public class BatallaCorta {
    ControladorBatallaCorta cbc;
    ControladorDefMonito cdm;
    ArrayList<Integer> ataquesJugador;
    ArrayList<Integer> ataquesEnemigo;
    ArrayList<String> ataquesEnemigoCod;
    int[] valorAtaquesJugador;
    int[] valorAtaquesEnemigo;
    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        //ControladorDefMonito cdm=new ControladorDefMonito();
        
        // TODO code application logic here
    //}
    public int[] valorizarAtaques(JButton[][] combinacion){
        valorAtaquesJugador= new int[7];
        for(int i=0;i<7;i++){
            if (combinacion[0][i].getText().equals("ATK.A.")){
                valorAtaquesJugador[i]=8;
            }
            else if(combinacion[0][i].getText().equals("ATK.M.")){
                valorAtaquesJugador[i]=4;
            }
            else if(combinacion[0][i].getText().equals("ATK.B.")){
                valorAtaquesJugador[i]=1;
            }
            else if(combinacion[0][i].getText().equals("ATK.ESP.")){
                valorAtaquesJugador[i]=20;
            }else{
                
            }
        }
        
        return valorAtaquesJugador;
    }
    public ArrayList<String> obtenerAtaquesEnemigo(){
        ataquesEnemigoCod=new ArrayList();
        int contadorAtaqueEsp=0;
        for(int i=0; i<1;i++){
            if(contadorAtaqueEsp==0){
                int rd=new Random().nextInt(20);
                if(rd<=20 && rd>=12){
                    ataquesEnemigoCod.add("ATK.ESP.");
                    contadorAtaqueEsp++;
                }
                else if(rd<12 && rd>=8){
                    ataquesEnemigoCod.add("ATK.A.");
                }
                else if(rd<8 && rd>=4){
                    ataquesEnemigoCod.add("ATK.M.");
                }
                
            
            }
            
        }
        return ataquesEnemigoCod;
    }
    
}
