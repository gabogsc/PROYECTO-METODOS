/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import Vista.VistaLogin;
import Vista.vistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class ControladorLogin implements ActionListener {
    private Usuario us;
    private VistaLogin vl;
    
    
    
    public ControladorLogin(){
        this.vl = new VistaLogin();
        this.us = new Usuario();
        vl.setVisible(true);  
        vl.agregarListener(this);
      
    }    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        
        if(vl.getBtnIngresar()== (JButton)e.getSource()){
           if(this.us.validarInicio(this.us.ingresar(this.vl.getTxtUsuario().getText()),this.vl.getTxtContraseña().getText())){
               
              Otros.registroUsuario.actividadUsuario("Usuario se logea");
                    ControladorMenuPrincipal cmp = new ControladorMenuPrincipal();
                    vl.dispose();
        
           }
           
          
           
            
            
            
                    
                
              
        }
        if(vl.getBtnRegistrar() == (JButton)e.getSource()){
            ControladorRegistro cR = new ControladorRegistro();
            vl.setVisible(false);
            
       
        }
        
        if(vl.getBtnProbarCon()== (JButton)e.getSource()){
            this.us.conectar();
            
            
            
            
        }
    
    } 
}
        
        
        
        
        
        
        
          
        
           

    
    
      


    

        
        
        
        
        
        
        
          
        
           

    
    
      


    
