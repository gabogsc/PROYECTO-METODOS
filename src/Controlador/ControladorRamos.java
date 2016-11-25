/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaRamosCivil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gabriel
 */
public class ControladorRamos implements ActionListener{
    private VistaRamosCivil vr = new VistaRamosCivil();
   
    
    
    public ControladorRamos(){
 
        this.vr.setVisible(true);
        vr.agregarListener(this);
        
        
    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //To change body of generated methods, choose Tools | Templates.
        
        if(vr.getjButton1() == e.getSource()){
            ControladorTablero ct = new ControladorTablero(0);
            
        }
        if(vr.getjButton2() == e.getSource()){
            ControladorTablero ct = new ControladorTablero(1);
            
        }
        if(vr.getjButton3() == e.getSource()){
            ControladorTablero ct = new ControladorTablero(2);
            
        }
        
            
        
        
        
        
    }
    
}
