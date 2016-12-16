/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ControladorLogin.dinero;
import Vista.VistaGato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ModeloGato;
import javax.swing.JOptionPane;



/**
 *
 * @author Gabriel
 */
public class ControladorGato implements ActionListener{
    private VistaGato vg;
    private ModeloGato gato;

    public ControladorGato(){
        this.vg = new VistaGato();
        this.gato = new ModeloGato();
        vg.setVisible(true);
        vg.agregarListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0 ; i<3;i++){
            for(int j = 0 ; j<3;j++){
                if(this.vg.getMatriz()[i][j]==e.getSource()){
                    this.vg.getMatriz()[i][j].setEnabled(false);
                    this.vg.getMatriz()[i][j].setText("X");
                    this.vg.setColorJ(i,j);
                    this.gato.marcarTablero(1,i,j);
                    
                    // CUANDO EL JUGADOR GANA LA PARTIDA    
                    if(gato.comprobarGanador()==1){
                        
                        this.vg.setText("Gano el Jugador");
                         for (int r=0;r<3;r++){
                            for(int s=0;s<3;s++){
                                this.vg.getMatriz()[r][s].setEnabled(false);
                            }
                        }
                        JOptionPane.showMessageDialog(vg, "Felicidades has Ganado 1000 Monedas", "Ganaste", 1);
                        JOptionPane.showMessageDialog(vg, "Dinero Anterior: "+dinero, "Recompensa", 1);
                        dinero=dinero + 1000;
                        JOptionPane.showMessageDialog(vg, "Dinero Actual: "+ dinero, "Recompensa ", 1);
                        
                        
                       
                        //vg.dispose();
                        return;
                    }
                    // CuANDO EL JUGADOR EMPATA, SE ACABAN LAS POSICIONES
                    if (this.gato.getDesocupados() == 0) {
                        this.vg.setText("Empate");
                        for (int r=0;r<3;r++){
                            for(int s=0;s<3;s++){
                                this.vg.getMatriz()[r][s].setEnabled(false);
                            }
                        }
                        
 
                        //vg.dispose();
                        return;
                    }
                    // MENTE ARTIFICIAL DE LA CPU
                    int a,b,validador=0;
                    while(validador==0){
                        a=gato.getRnd();
                        b=gato.getRnd();
                        
                        if(this.vg.getMatriz()[a][b].isEnabled()){
                            validador=1;
                            this.vg.getMatriz()[a][b].setEnabled(false);
                            //Tiempo de espera(pendiente)
                            
                            this.vg.getMatriz()[a][b].setText("O");
                            this.vg.setColorM(a,b);
                            this.gato.marcarTablero(2,a,b);
                            this.vg.setText("Turno Jugador");
                        }
                    }
                    // CUANDO GANA LA CPU 
                    if(gato.comprobarGanador()==2){
                        this.vg.setText("Gano la CPU");
                         for (int r=0;r<3;r++){
                            for(int s=0;s<3;s++){
                                this.vg.getMatriz()[r][s].setEnabled(false);
                            }
                        } 
                        
                           
                        //vg.dispose();
                    }
                }
            }
        }
        
        if(this.vg.getBtnRegresarABC() == e.getSource()){
           this.vg.dispose();
           ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
           
        }
        
        
        
    }
    
}
