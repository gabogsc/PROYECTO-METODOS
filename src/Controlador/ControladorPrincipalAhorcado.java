/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaPrincipalAhorcado;
import Modelo.Ahorcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author arru
 */
public class ControladorPrincipalAhorcado implements ActionListener {
    ControladorBibliotecaCentral cbc;
    VistaPrincipalAhorcado vp;
    Ahorcado ahorcado;
    ControladorAhorcado ca;
    ControladorPrincipalAhorcado cp;
    ControladorTopicos ct;
    
    /**
     *
     */
    //SE GENERA LA VISTA MENU PRINCIPAL AHORCADO, SE HACE VISIBLE 
    //Y SE LE AGREGA EL ACTION LISTENER
    public ControladorPrincipalAhorcado(){
        vp=new VistaPrincipalAhorcado();
        vp.setVisible(true);
        vp.agregarListener(this);
    }
        
           
           
    public void actionPerformed(ActionEvent ev){
        //EN CASO DE SELECCIONAR JUGAR, SE CIERRA LA VENTANA MENU PRINCIPAL 
        //Y SE INICIA EL CONTROLADOR TOPICOS
        if(vp.getButtonJugar() == ev.getSource()){
            this.vp.dispose();
            ct = new ControladorTopicos();
            ct.ControladorTopicos();
            
            
        }
        //EN CASO DE SELECCIONAR SALIR, SE CIERRA LA VENTANA MENU PRINCIPAL 
        //Y SE REGRESA A LA BIBLIOTECA CENTRAL
        else if(vp.getButtonSalir()==ev.getSource()){
            this.vp.dispose();
            cbc= new ControladorBibliotecaCentral();
        }
    }
}
       
        
       
    
        
    
    
   
    
        
    
        
        
         
        
    
    
    
    
    
            
    

