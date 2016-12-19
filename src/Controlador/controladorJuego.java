/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ControladorLogin.dinero;
import java.awt.Component;
import Modelo.AdivinaLaPalabra;
import Vista.vistaJuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class controladorJuego implements ActionListener{
    private vistaJuego vj;
    private AdivinaLaPalabra ALP;
    
   
            
    public controladorJuego(){
        this.ALP = new AdivinaLaPalabra();   
        this.vj = new vistaJuego();
        this.vj.ActionListener(this);
        String palabra = ALP.palabra;
        String encontrarHint = ALP.encontrarHint(palabra);
        this.vj.setHint(encontrarHint);
        vj.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ALP.getCantidad() > 0){
            if(vj.getAceptar()== (JButton)ae.getSource()){
                System.out.println("Acepteichon");
                Component frame = null;
                if(ALP.verificar((vj.getIngresar()))){
                    System.out.println("Correcto");
                    JOptionPane.showMessageDialog(frame, "Acertaste, usted ha ganado!."); 
                    JOptionPane.showMessageDialog(vj, "Felicidades has Ganado 500 Monedas", "Ganaste", 1);
                    System.out.println("Gano 500 Monedas");
                    JOptionPane.showMessageDialog(vj, "Dinero Anterior: "+dinero, "Recompensa", 1);
                    dinero=dinero + 500;
                    JOptionPane.showMessageDialog(vj, "Dinero Actual: "+ dinero, "Recompensa ", 1);
                    vj.dispose();
                    controladorInicioMenu cInicioM = new controladorInicioMenu();
                }
                else{
                    System.out.println("Incorrecto");
                    JOptionPane.showMessageDialog(frame, "Incorrecto.");
                    int contador = ALP.disminuirCantidad();
                    vj.setContador(contador);
                }
            if (ALP.getCantidad() == 0){
                System.out.println("Perdeichon");
                JOptionPane.showMessageDialog(frame, "Usted ha perdido.");
                vj.dispose();
                controladorInicioMenu cInicioM = new controladorInicioMenu();
            }
                if(vj.getAtras()== (JButton)ae.getSource()){
                    vj.dispose();
                    controladorInicioMenu cInicioM = new controladorInicioMenu();
                    vj.setVisible(false);
                }
       
        
       
            }
        }
        
        if(vj.getAtras()== (JButton)ae.getSource()){
            vj.dispose();
            controladorInicioMenu cInicioM = new controladorInicioMenu();
            vj.setVisible(false);
        }
    }
}
