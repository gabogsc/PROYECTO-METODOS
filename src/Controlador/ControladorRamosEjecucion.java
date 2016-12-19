/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vista.VistaRamosCivil;
import Vista.VistaRamosEjecucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author Gabriel
 */
public class ControladorRamosEjecucion implements ActionListener{
    private VistaRamosEjecucion vre = new VistaRamosEjecucion();
    private static int areaRamo;
    
    
    public ControladorRamosEjecucion(){
 
        this.vre.setVisible(true);
        vre.agregarListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        for(JButton ramo: this.vre.areaPlanComun()){
            
            if(ae.getSource() == ramo){
                
                vre.dispose();
                Otros.registroUsuario.actividadUsuario("Usuario INGRESO A LA BATALLA CALCULO");
                areaRamo = 0;
            }
        }
        
        for(JButton ramo: this.vre.areaEspecialidad()){
            
            if(ae.getSource() == ramo){
                
                vre.dispose();
                areaRamo = 1;
            }
        }
        
        for(JButton ramo: this.vre.areaEconomia()){
            
            if(ae.getSource() == ramo){
                
                vre.dispose();
                areaRamo = 2;
            }
        }
    }
}
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    
    
  
    
    
    
    
    
    
    
    
    

