/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.ControladorSudoku;
import Vista.VistaMenuSudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Vista.VistaBibliotecaCentral;

/**
 *
 * @author Carlos
 */
public class ControladorMenuSudoku implements ActionListener{
    
    //Atributos
    private VistaMenuSudoku vms;
    private ControladorSudoku cs;
    public static String nivel;
    ControladorBibliotecaCentral cbc;

    
    //Constructor
    public ControladorMenuSudoku(){
        vms = new VistaMenuSudoku();
        vms.setVisible(true);
        vms.setLocationRelativeTo(null);
        vms.setListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int dificultad = 0;

        if (ae.getActionCommand() == "Facil"){
            try {
                this.nivel = ae.getActionCommand();
                cs = new ControladorSudoku();
            } catch (IOException ex) {
                Logger.getLogger(ControladorMenuSudoku.class.getName()).log(Level.SEVERE, null, ex);
            }
            cs.mostrarVista(true);
            vms.dispose();        
        }
        
        else if  (ae.getActionCommand() == "Medio"){
            try {
                this.nivel = ae.getActionCommand();
                cs = new ControladorSudoku();
            } catch (IOException ex) {
                Logger.getLogger(ControladorMenuSudoku.class.getName()).log(Level.SEVERE, null, ex);
            }
            cs.mostrarVista(true);
            vms.dispose();
        }
        
        else if (ae.getActionCommand() == "Dificil"){
            try {
                this.nivel = ae.getActionCommand();
                cs = new ControladorSudoku();
            } catch (IOException ex) {
                Logger.getLogger(ControladorMenuSudoku.class.getName()).log(Level.SEVERE, null, ex);
            }
            cs.mostrarVista(true);
            vms.dispose();
        }
        
        else if (ae.getSource() == this.vms.getbtnRegresar()){
            VistaBibliotecaCentral vbc = new VistaBibliotecaCentral();
            vms.dispose();
            
        }
    }
}
    
    
    

    
    
    
    
    
    
    
  