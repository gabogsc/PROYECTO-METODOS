/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaMenuPrincipal;
import Vista.VistaRamosCivil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gabriel
 */
public class ControladorMenuPrincipal implements ActionListener {
   private VistaMenuPrincipal vmp;
   private ControladorBibliotecaCentral cbc;
   
   
   public ControladorMenuPrincipal() {
       this.vmp = new VistaMenuPrincipal();
       vmp.setVisible(true);
       vmp.agregarListener(this);
       
  
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        
        if(vmp.getBtnBiblioteca() == e.getSource()){
            ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
            vmp.dispose();
            
        }
        
        if(vmp.getBtnEao() == e.getSource()){
            ControladorEAO ceao = new ControladorEAO();
            
        }
        if(vmp.getBtnForoGriego() == e.getSource()){
            ControladorForoGriego cfg = new ControladorForoGriego();
            
        }
        if(vmp.getBtnInventario() == e.getSource()){
            ControladorInventario ci = new ControladorInventario();
            
        }
        if(vmp.getBtnRamos() == e.getSource()){
            ControladorRamos cr = new ControladorRamos();
            vmp.dispose();
            
            
        }
        
        if(vmp.getBtnCerrarSesion() == e.getSource()){ 
            //Regrear a la Ventana del Login
           ControladorLogin cl = new ControladorLogin();
           vmp.dispose();
           
        }
        
        
        
    }
   
   
   
   
   
   
    
}
