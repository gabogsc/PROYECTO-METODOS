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
        //this.ALP 
        vj.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.vj.setHint("Salacadula Chachicomula Bibidi Babidi Buu");
        if(ALP.getCantidad() > 0){
            if(vj.getAceptar()== (JButton)ae.getSource()){
                System.out.println("Acepteichon");
                Component frame = null;
                if(ALP.verificar((vj.getIngresar()))){
                    vj.dispose();
                    System.out.println("Correcto");
                    JOptionPane.showMessageDialog(frame, "Acertaste, usted ha ganado!."); 
                    JOptionPane.showMessageDialog(vj, "Felicidades has Ganado 100 Monedas", "Ganaste", 1);
                    JOptionPane.showMessageDialog(vj, "Dinero Anterior: "+dinero, "Recompensa", 1);
                    dinero=dinero + 100;
                    JOptionPane.showMessageDialog(vj, "Dinero Actual: "+ dinero, "Recompensa ", 1);
                    controladorInicioMenu cInicioM = new controladorInicioMenu();
                }
                else{
                    System.out.println("Incorrecto");
                    JOptionPane.showMessageDialog(frame, "Incorrecto.");
                    int contador = ALP.disminuirCantidad();
                    vj.setContador(contador);
                }
            if (ALP.getCantidad() == 0){
                vj.dispose();
                System.out.println("Perdeichon");
                JOptionPane.showMessageDialog(frame, "Usted ha perdido.");
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
