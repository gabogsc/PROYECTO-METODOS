/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ControladorRamosCivil.areaRamo;
import Vista.VistaSelecPjes;
import java.awt.event.ActionEvent;
import Modelo.Escenario;
import java.awt.event.ActionListener;

/**
 *
 * @author Gabriel
 */

public class ControladorSelecPjes implements ActionListener{
    private ControladorTablero ct;
    private VistaSelecPjes vsp;
    public static String personaje3;
    public static String personaje4;
    public static String personaje5;
    
    
    
            
    public ControladorSelecPjes() {
        
        vsp = new VistaSelecPjes();
        vsp.setVisible(true);
        
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //To change body of generated methods, choose Tools | Templates
        
        
        
        int aux=0;
        
        if(this.vsp.getBtnSelec() == ae.getSource()){
           
           /*for(int h=3; h<3;){
                if(this.vsp.getRadioBtnArru().isSelected() == true){
                    if(aux == 0){
                        personaje3 = "arru";
                    }
                    else if(aux == 1){
                        personaje4 = "arru";
                    }
                    else if(aux == 2){
                        personaje5 = "arru";
                    }

                    this.vsp.getRadioBtnArru().setEnabled(false);
                    aux++;
                    h++;
                }
                else if(this.vsp.getRadioBtnCharlie().isSelected() == true){
                    if(aux == 0){
                        personaje3 = "charlie";
                    }
                    else if(aux == 1){
                        personaje4 = "charlie";
                    }
                    else if(aux == 2){
                        personaje5 = "charlie";
                    }

                    this.vsp.getRadioBtnCharlie().setEnabled(false);
                    aux++;
                    h++;
                    


                }
                else if(this.vsp.getRadioBtnPoto().isSelected() == true){
                    if(aux == 0){
                        personaje3 = "poto";
                    }
                    else if(aux == 1){
                        personaje4 = "poto";
                    }
                    else if(aux == 2){
                        personaje5 = "poto";
                    }

                    this.vsp.getRadioBtnPoto().setEnabled(false);
                    aux++;
                    h++;
                    


                }
                else if(this.vsp.getRadioBtnULLOA().isSelected() == true){
                    if(aux == 0){
                        personaje3 = "ulloa";
                    }
                    else if(aux == 1){
                        personaje4 = "ulloa";
                    }
                    else if(aux == 2){
                        personaje5 = "ulloa";
                    }

                    this.vsp.getRadioBtnULLOA().setEnabled(false);
                    aux++;
                    h++;
                    


                }
                else if(this.vsp.getRadioBtnRusio().isSelected() == true){
                    if(aux == 0){
                        personaje3 = "rusio";
                    }
                    else if(aux == 1){
                        personaje4 = "rusio";
                    }
                    else if(aux == 2){
                        personaje5 = "rusio";
                    }

                    this.vsp.getRadioBtnRusio().setEnabled(false);
                    aux++;
                    h++;
                    
                }
        
            }

        }*/
    }
}
