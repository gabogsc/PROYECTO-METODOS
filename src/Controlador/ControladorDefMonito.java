/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaDefMonito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author arru
 */
public class ControladorDefMonito implements ActionListener {
    VistaDefMonito vdm;
    static String ruta1;
    static String nombreRuta1;
    static String ruta2;
    static String nombreRuta2;
    ControladorBatallaCorta cbc;
    
    public ControladorDefMonito(){
        vdm= new VistaDefMonito();
        vdm.setVisible(true);
        vdm.agregarListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(vdm.getCharizards()==e.getSource()){
            System.out.println("Se selecciono charizards");
            vdm.dispose();
            this.ruta1="src/Imagenes/Charizard X.jpg";
            this.nombreRuta1="Charizard X";
            this.ruta2="src/Imagenes/Charizard Y.jpg";
            this.nombreRuta2="Charizard Y";
            cbc= new ControladorBatallaCorta();
            
            
            
        }
        else if(vdm.getDragonBall()==e.getSource()){
            System.out.println("Se selecciono dragon ball");
        }
    }
    public String getRuta1(){
        return ruta1;
    }
    public String getRuta2(){
        return ruta2;
    }
    public String getNombreRuta1(){
        return nombreRuta1;
    }
    public String getNombreRuta2(){
        return nombreRuta2;
    }
}
