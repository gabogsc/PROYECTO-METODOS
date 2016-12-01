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
import javax.swing.JLabel;

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
    int[] dañoProducido;
    /**
    // * @param args the command line arguments
     */
    //public static void main(String[] args) {
      //  ControladorDefMonito cdm=new ControladorDefMonito();
        
        // TODO code application logic here
    //}
    public int[] valorizarAtaquesJugador(JButton[][] combinacion){
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
        for(int i=0; i<7;i++){
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
                else{
                    ataquesEnemigoCod.add("ATK.B.");
                }
                
            
            }else{
                int rd=new Random().nextInt(11);
                if(rd<=11 && rd>=8){
                    ataquesEnemigoCod.add("ATK.A.");
                }
                else if(rd<8 && rd>=4){
                    ataquesEnemigoCod.add("ATK.M.");
                }
                else{
                    ataquesEnemigoCod.add("ATK.B.");
                }
            }
            
        }
        return ataquesEnemigoCod;
    }
    public int[] valorizarAtaquesEnemigo(JLabel[][] combinacion){
        valorAtaquesEnemigo= new int[7];
        for(int i=0;i<7;i++){
            if (combinacion[0][i].getText().equals("ATK.A.")){
                valorAtaquesEnemigo[i]=8;
            }
            else if(combinacion[0][i].getText().equals("ATK.M.")){
                valorAtaquesEnemigo[i]=4;
            }
            else if(combinacion[0][i].getText().equals("ATK.B.")){
                valorAtaquesEnemigo[i]=1;
            }
            else if(combinacion[0][i].getText().equals("ATK.ESP.")){
                valorAtaquesEnemigo[i]=20;
            }else{
                
            }
        }
        
        return valorAtaquesEnemigo;
    }
    public int[] compararAtaques(int[] valJugador, int[] valEnemigo){
        int[] resultados=new int[7];
        for(int i=0; i<7;i++){
            int resultado=valJugador[i]-valEnemigo[i];
            resultados[i]=resultado;
        }
        return resultados;
    }
    public ArrayList<String> leerResultado(int[] result){
        ArrayList<String> resultadoFinal= new ArrayList();
        for(int i=0; i<7; i++){
            int resultadoActual=result[i];
            if(resultadoActual==(-3)){
                resultadoFinal.add("Gana Enemigo");
            }
            else if(resultadoActual==3){
                resultadoFinal.add("Gana Jugador");
            }
            else if(resultadoActual==(-7)){
                resultadoFinal.add("Gana Jugador");
            }
            else if(resultadoActual==7){
                resultadoFinal.add("Gana Enemigo");
            }
            else if(resultadoActual==4){
                resultadoFinal.add("Gana Jugador");
            }
            else if(resultadoActual==(-4)){
                resultadoFinal.add("Gana Enemigo");
            }else if(resultadoActual==19){
                resultadoFinal.add("Gana Jugador");
            }else if(resultadoActual==16){
                resultadoFinal.add("Gana Jugador");
            }
            else if(resultadoActual==12){
                resultadoFinal.add("Gana Jugador");
            }else if(resultadoActual==(-19)){
                resultadoFinal.add("Gana Enemigo");
            }else if(resultadoActual==(-16)){
                resultadoFinal.add("Gana Enemigo");
            }else if(resultadoActual==(-12)){
                resultadoFinal.add("Gana Enemigo");
            }else if(resultadoActual==0){
                resultadoFinal.add("Empate");
            }else{
                
            }
           
        }
        return resultadoFinal;
    }
    public int[] calcularDaño(ArrayList<String> resultado ,int hpJugador, int ataqueJugador, int defensaJugador, int hpEnemigo, int ataqueEnemigo, int defensaEnemigo){
        dañoProducido= new int[2];
        for(int i=0; i<7;i++){
            String elemento= resultado.get(i);
            if(elemento.equals("Gana Jugador")){
                int dañoEnemigo= defensaEnemigo - ataqueJugador;
                dañoProducido[1]=dañoProducido[1]+dañoEnemigo;
            }
            if(elemento.equals("Gana Enemigo")){
                int dañoJugador= defensaJugador-ataqueEnemigo;
                dañoProducido[0]=dañoProducido[0]+dañoJugador;
            }
        }
        return dañoProducido;
    } 
    public int restarHPJugador(int[] daño,int HPJugador){
        HPJugador= HPJugador + daño[0];
        return HPJugador;
    }
    public int restarHPEnemigo(int[]daño, int HPEnemigo){
        HPEnemigo= HPEnemigo + daño[1];
        return HPEnemigo;
    }
}
    
    

