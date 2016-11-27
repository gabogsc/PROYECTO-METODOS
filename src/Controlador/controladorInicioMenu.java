/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Vista.vistaInicioMenu;
import Vista.vistaJuego;

/**
 *
 * @author sebastian
 */
public class controladorInicioMenu implements ActionListener{
    
    vistaInicioMenu vInicioM;
    
    public controladorInicioMenu(){
        vInicioM = new vistaInicioMenu();
        vInicioM.ActionListener(this);
        vInicioM.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vInicioM.getJugar() == (JButton)ae.getSource()){
            controladorJuego vj = new controladorJuego();
            vInicioM.setVisible(false);
        }
        if(vInicioM.getSalir()== (JButton)ae.getSource()){
            vInicioM.dispose();
            ControladorBibliotecaCentral cbl = new ControladorBibliotecaCentral();
            vInicioM.setVisible(false);
    }
    
}
}
