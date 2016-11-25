/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class ModeloGato {

    private int[][] matriz=new int[3][3];
    private int desocupados;
    private Random rnd = new Random();
    
    
    public ModeloGato(){
        this.desocupados = 9;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.matriz[i][j]=0;
            }
        }
    }
    
    public void marcarTablero(int x,int i,int j){
        try{
            Thread.sleep(500);
        }catch(InterruptedException ie){
            System.out.println("Errror");
        }
        matriz[i][j]=x;
        this.desocupados--;
    }
    
    public int comprobarGanador(){
        if(matriz[0][0]==matriz[0][1] && matriz[0][0]==matriz[0][2]){
            return matriz[0][0];
        }
        if(matriz[1][0]==matriz[1][1] && matriz[1][0]==matriz[1][2]){
            return matriz[1][0];
        }
        if(matriz[2][0]==matriz[2][1] && matriz[2][0]==matriz[2][2]){
            return matriz[2][0];
        }
        if(matriz[0][0]==matriz[1][0] && matriz[0][0]==matriz[2][0]){
            return matriz[0][0];
        }
        if(matriz[0][1]==matriz[1][1] && matriz[0][1]==matriz[2][1]){
            return matriz[0][1];
        }
        if(matriz[0][2]==matriz[1][2] && matriz[0][2]==matriz[2][2]){
            return matriz[0][2];
        }
        if(matriz[0][0]==matriz[1][1] && matriz[0][0]==matriz[2][2]){
            return matriz[0][0];
        }
        if(matriz[0][2]==matriz[1][1] && matriz[0][2]==matriz[2][0]){
            return matriz[0][2];
        }
        return -1;
    }

    public int getDesocupados() {
        return desocupados;
    }

    public int getRnd() {
        
        return rnd.nextInt(3);
    }
    
    
}
