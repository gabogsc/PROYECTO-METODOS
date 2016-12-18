/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ControladorLogin.carrera;
import static Controlador.ControladorLogin.dinero;
import static Controlador.ControladorLogin.nombrePP;
import static Controlador.ControladorLogin.nombrePS;
import static Controlador.ControladorLogin.pass;
import static Controlador.ControladorLogin.rolPP;
import static Controlador.ControladorLogin.rolPS;
import static Controlador.ControladorLogin.usuario;
import Vista.VistaMenuPrincipal;
import Vista.VistaRamosCivil;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ControladorMenuPrincipal implements ActionListener {
   private VistaMenuPrincipal vmp;
   private Usuario us;
   private ControladorBibliotecaCentral cbc;
   
   
   public ControladorMenuPrincipal() {
       this.vmp = new VistaMenuPrincipal();
       vmp.setVisible(true);
       vmp.agregarListener(this);
       
       this.vmp.setDinerolabel("Dinero: "+ dinero);
       
  
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        
        if(vmp.getBtnBiblioteca() == e.getSource()){
            ControladorBibliotecaCentral cbc = new ControladorBibliotecaCentral();
            Otros.registroUsuario.actividadUsuario("Usuario Ingresa a la BIBLIOTECA CENTRAL");
            vmp.dispose();
            
        }
        
        if(vmp.getBtnEao() == e.getSource()){
            ControladorEAO ceao = new ControladorEAO();
            Otros.registroUsuario.actividadUsuario("Usuario Ingresa a la EAO");
            
        }
        if(vmp.getBtnForoGriego() == e.getSource()){
            ControladorForoGriego cfg = new ControladorForoGriego();
            Otros.registroUsuario.actividadUsuario("Usuario INGRESA AL FORO GRIEGO");
            
        }
        if(vmp.getBtnInventario() == e.getSource()){
            ControladorInventario ci = new ControladorInventario();
            
        }
        if(vmp.getBtnRamos() == e.getSource()){
            ControladorRamosCivil cr = new ControladorRamosCivil();
            vmp.dispose();
            Otros.registroUsuario.actividadUsuario("Usuario INGRESA A SU MALLA CURRICULAR");
            
            
        }
        
        if(vmp.getBtnCerrarSesion() == e.getSource()){ 
            //Regresar a la Ventana del Login y guardar Dinero
            us = new Usuario();
           if(this.us.eliminarParaReemplazar(usuario, pass, nombrePP, rolPP, nombrePS, rolPS, carrera, dinero)) 
           if(this.us.registrar(usuario, pass, nombrePP, rolPP, nombrePS, rolPS, carrera, dinero)){;
            ControladorLogin cl = new ControladorLogin();
            vmp.dispose();
           }  
        }
        
        
        
    }
   
   
   
   
   
   
    
}
