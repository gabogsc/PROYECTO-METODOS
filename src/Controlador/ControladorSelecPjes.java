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
import javax.swing.JButton;

/**
 *
 * @author Gabriel
 */

public class ControladorSelecPjes implements ActionListener{
    
    private ControladorTablero ct;
    private VistaSelecPjes vsp;
    private boolean flagPersonajes = true;
    private boolean flagAccion = false;
    public static String personaje3;
    public static String personaje4;
    public static String personaje5;
    private JButton personajeSeleccionado;
    private int aux = 0;
    private int acompañantes = 0;
    
    
    
            
    public ControladorSelecPjes(){
        
        
        vsp = new VistaSelecPjes();
        vsp.setVisible(true);
        vsp.AgregarActionListener(this);
        vsp.getBtnSelec().setEnabled(false);
        vsp.getBtnDeshacer().setEnabled(false);
        vsp.getBtnVaciar().setEnabled(false);
        vsp.getBtnTerminarSeleccion().setEnabled(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //To change body of generated methods, choose Tools | Templates
        
        
        
        
    //ACCIONES RELACIONADAS CON LA SELECCION DE UN PERSONAJE
        if(flagPersonajes) {
            

            System.out.println(acompañantes);
            if(ae.getSource() == this.vsp.getBtnCharlie()){
                if(aux == 0){
                    personaje3 = "charlie";
                }
                else if(aux == 1){
                    personaje4 = "charlie";
                }
                else if(aux == 2){
                    personaje5 = "charlie";
                }
            }
            
            else if(ae.getSource() == this.vsp.getBtnArru()){
                if(aux == 0){
                    personaje3 = "arru";
                }
                else if(aux == 1){
                    personaje4 = "arru";
                }
                else if(aux == 2){
                    personaje5 = "arru";
                }
            }
            
            else if(ae.getSource() == this.vsp.getBtnPoto()){
                if(aux == 0){
                    personaje3 = "poto";
                }
                else if(aux == 1){
                    personaje4 = "poto";
                }
                else if(aux == 2){
                    personaje5 = "poto";
                }   
            }
            
            else if(ae.getSource() == this.vsp.getBtnRusio()){
                if(aux == 0){
                    personaje3 = "rusio";
                }
                else if(aux == 1){
                    personaje4 = "rusio";
                }
                else if(aux == 2){
                    personaje5 = "rusio";
                }
            }
            
            else if(ae.getSource() == this.vsp.getBtnULLOA()){
                if(aux == 0){
                    personaje3 = "ulloa";
                }
                else if(aux == 1){
                    personaje4 = "ulloa";
                }
                else if(aux == 2){
                    personaje5 = "ulloa";
                }
            }
            
            this.personajeSeleccionado = (JButton) ae.getSource();  //PERSONAJE SELECCIONADO
            
            if(acompañantes <= 2){
                this.vsp.getBtnSelec().setEnabled(true);
            }
            this.vsp.getBtnVaciar().setEnabled(true);
            this.vsp.getBtnDeshacer().setEnabled(true);
            
            if(acompañantes == 2){
                this.vsp.getBtnTerminarSeleccion().setEnabled(true);
            }
            
            flagPersonajes = false; //ESTA WEA ES
            flagAccion = true;

        }
        
        
    //ACCIONES RELACIONADAS CON UN PERSONAJE SELECCIONADO    
        else if(flagAccion){
          
        //AÑADIR UN PERSONAJE A LA BATALLA    
            if(ae.getSource() == this.vsp.getBtnSelec()){
                
                personajeSeleccionado.setEnabled(false);
                acompañantes++;
                aux++;
                
            }
        
        //DESHACER LA SELECCION DE PERSONAJE
            else if(ae.getSource() == this.vsp.getBtnDeshacer()){
                
            }
            
        //VACIAR LA SELECCION DE PERSONAJES    
            else if(ae.getSource() == this.vsp.getBtnVaciar()){
                
                aux = 0;
                acompañantes = 0;
                personaje3 = "";
                personaje4 = "";
                personaje5 = "";
                this.vsp.getBtnArru().setEnabled(true);
                this.vsp.getBtnCharlie().setEnabled(true);
                this.vsp.getBtnPoto().setEnabled(true);
                this.vsp.getBtnULLOA().setEnabled(true);
                this.vsp.getBtnRusio().setEnabled(true);
                
            }
            
        //TERMINAR CON LA SELECCION DE PERSONAJES
            else if(ae.getSource() == this.vsp.getBtnTerminarSeleccion()){
                
                ControladorTablero ct = new ControladorTablero(areaRamo);
                this.vsp.dispose();
            }
            
            this.vsp.getBtnDeshacer().setEnabled(false);
            this.vsp.getBtnVaciar().setEnabled(true);
            this.vsp.getBtnSelec().setEnabled(false);
            flagAccion = false;
            flagPersonajes = true;

        }
    }
}
