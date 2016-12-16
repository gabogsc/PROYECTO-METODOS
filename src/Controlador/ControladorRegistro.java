/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.ControladorLogin;
import java.awt.event.ActionEvent;
import Modelo.Registro;
import Modelo.Usuario;

import Vista.vistaRegistro;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class ControladorRegistro implements ActionListener {
    
    private Registro mR;
    private vistaRegistro vr;
    private Usuario us;
    public static int dinero;
    
    public ControladorRegistro(){
        this.vr = new vistaRegistro();
        this.verVista();
    }
    
    public void verVista (){
        this.mR = new Registro();
        this.vr = new vistaRegistro();
        this.us = new Usuario();
        this.vr.setVisible(true);
        this.vr.ActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vr.getRegistrar() == e.getSource()){
            
           
            String rolPP="", rolPS="", carrera="";
            dinero = 0;
            
        // Verificacion de que todos los campos esten Rellenados para poder Registrarte
        if((this.vr.getRadioArqueroPP().isSelected() == true || this.vr.getRadioGuerreroPP().isSelected() == true) && 
                (this.vr.getRadioArqueroPS().isSelected() == true || this.vr.getRadioGuerreroPS().isSelected() == true) && 
                    (this.vr.getRadioCivil().isSelected() == true || this.vr.getRadioEjecu().isSelected() == true) && 
                        (this.vr.getFieldUsuario().getText().equals("") == false) && (this.vr.getFieldPass().getText().equals("") == false) && 
                            (this.vr.getTextPP().getText().equals("") == false) && (this.vr.getTextPS().getText().equals("") == false) ){ 
            
                            // SI EL USUARIO SELECCIONA GUERRERO O ARQUERO PARA EL PERSONAJE PRINCIPAL
                            if(this.vr.getRadioArqueroPP().isSelected()==true)
                            {
                                rolPP= "Arquero";
                            }else if(this.vr.getRadioGuerreroPP().isSelected()==true){
                                rolPP= "Guerrero";
                            }

                            // SI EL USUARIO SELECCIONA GUERRERO O ARQUERO PARA EL PERSONAJE SECUNDARIO
                            if(this.vr.getRadioArqueroPS().isSelected()==true)
                            {
                                rolPS= "Arquero";
                            }else if(this.vr.getRadioGuerreroPS().isSelected()==true){
                                rolPS= "Guerrero";
                            }

                            // SI EL USUARIO SELECCIONA CARRERA CIVIL O CARRERA EJECUCION PARA EL PERSONAJE SECUNDARIO
                            if(this.vr.getRadioCivil().isSelected()==true)
                            {
                                carrera="Ing.Civil";
                            }else if(this.vr.getRadioEjecu().isSelected()==true){
                                carrera ="Ing.Ejecucion";
                            }

            
                
                            if(this.us.registrar(this.vr.getFieldUsuario().getText(), this.vr.getFieldPass().getText()
                                , this.vr.getTextPP().getText(), rolPP, this.vr.getTextPS().getText(), rolPS, carrera , dinero)){
                                
                                JOptionPane.showMessageDialog(null, "Jugador Registrado Exitosamente !!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                                this.vr.dispose();
                                ControladorLogin cl = new ControladorLogin();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "El Usuario ya es existente", "Error",JOptionPane.ERROR_MESSAGE);
                            }
                   
            
            
        }else{   
            JOptionPane.showMessageDialog(null, "Rellene todas los campos para Registrarse", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if (e.getSource() == vr.getBotonAtras()) {
            this.vr.dispose();
            ControladorLogin cl = new ControladorLogin();
        }
    
    
    
    
    
    
    }
    
}
