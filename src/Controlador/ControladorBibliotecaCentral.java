/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ControladorLogin.dinero;
import Sudoku.Sudoku;
import Vista.VistaBibliotecaCentral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        vbc.setDineroLabel("Dinero: "+ dinero);
        
        
    }
            
            
    @Override
    public void actionPerformed(ActionEvent e) {
      //To change body of generated methods, choose Tools | Templates.
        if(vbc.getBtnAdivinaLaPalabra() == e.getSource()){
            controladorInicioMenu cim = new controladorInicioMenu();
            vbc.setVisible(false); 
          
        }
        
        if(vbc.getBtnSudoku() == e.getSource()){
            
            try {
                Sudoku sudoku = new Sudoku();
            } catch (IOException ex) {
                Logger.getLogger(ControladorBibliotecaCentral.class.getName()).log(Level.SEVERE, null, ex);
            }
         
          
        }
        if(vbc.getBtnGato() == e.getSource()){
          ControladorGato cg = new ControladorGato();
          vbc.dispose();
          
        }
        if(vbc.getBtnAhorcado() == e.getSource()){
            ControladorPrincipalAhorcado cpa=new ControladorPrincipalAhorcado();
            vbc.dispose();
          
          
        }
        if(vbc.getBtnRegresarAMP() == e.getSource()){
          ControladorMenuPrincipal cmp = new ControladorMenuPrincipal();
          vbc.dispose();
          
        }
      
      
         
    }
    
    
    
    
    
}
