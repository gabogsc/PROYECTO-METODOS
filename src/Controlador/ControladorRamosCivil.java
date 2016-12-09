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
public class ControladorRamosCivil implements ActionListener{
    private VistaRamosCivil vr = new VistaRamosCivil();
   
    
    
    public ControladorRamosCivil(){
 
        this.vr.setVisible(true);
        vr.agregarListener(this);
        
        
    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //To change body of generated methods, choose Tools | Templates.
        
        if(vr.getBtnCalculoI()== e.getSource()){
            ControladorTablero ct = new ControladorTablero(0);
            vr.dispose();
            
        }
        
        if(vr.getBtnMetodosDeProgramacion() == e.getSource()){
            ControladorTablero ct = new ControladorTablero(1);
            vr.dispose();
        }
        
        if(vr.getBtnFundaEconomia() == e.getSource()){
            ControladorTablero ct = new ControladorTablero(2);
            vr.dispose();
        }
        
            
        
        
        
        
    }
    
}
