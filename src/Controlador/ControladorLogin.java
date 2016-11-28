/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
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
        
        if(vl.getBtnIngresar()== e.getSource()){
            //String usuario = this.vl.getTxtUsuario();
            //if(this.vl.getTxtUsuario().equals("gabriel")){
               // if(this.vl.getTxtContraseña().equals("gabriel")){
            
          
            
                    Otros.registroUsuario.actividadUsuario("Usuario se logea");
                    ControladorMenuPrincipal cmp = new ControladorMenuPrincipal();
                    vl.dispose();
                
                
              //  }else{ JOptionPane.showConfirmDialog(this.vl, "Constraseña Invalida", "error", HEIGHT);}
                    
                
           // }else{ JOptionPane.showConfirmDialog(this.vl, "Usuario Invalido", "error", HEIGHT);}

        }
        
       
    }
    
    
        
        
        
        
        
        
        
}          
        
           

    
    
      


    
