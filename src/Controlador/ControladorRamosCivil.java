/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaRamosCivil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Gabriel
 */
public class ControladorRamosCivil implements ActionListener{
    private VistaRamosCivil vr = new VistaRamosCivil();
    public static int areaRamo;
   
    
    
    public ControladorRamosCivil(){
 
        this.vr.setVisible(true);
        vr.agregarListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //To change body of generated methods, choose Tools | Templates.
        
        for(JButton ramo: this.vr.areaPlanComun()){
            
            if(ae.getSource() == ramo){
                ControladorSelecPjes csp = new ControladorSelecPjes();
                vr.dispose();
                areaRamo = 0;
                
                Otros.registroUsuario.actividadUsuario("Usuario INGRESO A LA BATALLA CALCULO");
            }
        }
        
        for(JButton ramo: this.vr.areaEspecialidad()){
            
            if(ae.getSource() == ramo){
                ControladorSelecPjes csp = new ControladorSelecPjes();
                vr.dispose();
                areaRamo = 1;
            }
        }
        
        for(JButton ramo: this.vr.areaEconomia()){
            
            if(ae.getSource() == ramo){
                ControladorSelecPjes csp = new ControladorSelecPjes();
                vr.dispose();
                areaRamo = 2;
            }
        }
        
            
        
        
        
        
    }
    
}

