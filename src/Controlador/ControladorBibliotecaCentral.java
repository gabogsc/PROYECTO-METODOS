/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBibliotecaCentral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gabriel
 */
public class ControladorBibliotecaCentral implements ActionListener{
    private VistaBibliotecaCentral vbc;
    
    public ControladorBibliotecaCentral(){
        this.vbc = new VistaBibliotecaCentral();
        vbc.setVisible(true);
        vbc.agregarListener(this);
        
        
    }
            
            
    @Override
    public void actionPerformed(ActionEvent e) {
      //To change body of generated methods, choose Tools | Templates.
        if(vbc.getBtnAdivinaLaPalabra() == e.getSource()){
          
          
        }
        if(vbc.getBtnPicApix() == e.getSource()){
          
          
        }
        if(vbc.getBtnSudoku() == e.getSource()){
          
          
        }
        if(vbc.getBtnGato() == e.getSource()){
          ControladorGato cg = new ControladorGato();
          vbc.setVisible(false);
          
        }
        if(vbc.getBtnAhorcado() == e.getSource()){
          
          
        }
        if(vbc.getBtnRegresarAMP() == e.getSource()){
          ControladorMenuPrincipal cmp = new ControladorMenuPrincipal();
          vbc.dispose();
          
        }
      
      
         
    }
    
    
    
    
    
}
