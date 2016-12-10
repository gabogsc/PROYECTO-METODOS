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
        if(this.vr.getBoton() == e.getSource()){
            
           
            String rolPP="", rolPS="", carrera="";
            int dinero = 500;
            
            if(this.vr.getRadioArqueroPP().isSelected()==true)
            {
                rolPP="Arquero";
            }else if(this.vr.getRadioGuerreroPP().isSelected()==true){
                rolPP="Guerrero";
            }
            
            
            if(this.vr.getRadioArqueroPS().isSelected()==true)
            {
                rolPS="Arquero";
            }else if(this.vr.getRadioGuerreroPS().isSelected()==true){
                rolPS="Guerrero";
            }
            
            if(this.vr.getRadioCivil().isSelected()==true)
            {
                carrera="Ing. Civil";
            }else if(this.vr.getRadioEjecu().isSelected()==true){
                carrera ="Ing. Ejecucion";
            }
            
            if(this.us.registrar(this.vr.getFieldUsuario().getText(), this.vr.getFieldPass().getText()
                    , this.vr.getTextPP().getText(), rolPP, this.vr.getTextPS().getText(), rolPS, carrera , dinero))
             {
                 JOptionPane.showMessageDialog(null, "Jugador Registrado Exitosamente !!!");
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "El usuario ya existe, no se pudo registrar.");
             }
            
           
            
        }
        else if (e.getSource() == vr.getBotonAtras()) {
            this.vr.dispose();
            ControladorLogin cl = new ControladorLogin();
        }
    
    
    
    
    
    
    }
    
}
