/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaTopicos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Ahorcado;
import java.util.ArrayList;

/**
 *
 * @author rruz
 */
public class ControladorTopicos implements ActionListener{
    ControladorAhorcado ca;
    VistaTopicos vt;
    int topicoElegido;
    static String ruta;
    Ahorcado ahorcado;
    ArrayList<String> palabrasContexto;
    
    
    //SE GENERA LA VISTA TOPICOS AHORCADO Y SE INSTANCIA EL MODELO AHORCADO.
    public void ControladorTopicos(){
        ahorcado= new Ahorcado();
        vt=new VistaTopicos();
        vt.setVisible(true);
        vt.agregarListener(this);
    }
    
    public void actionPerformed(ActionEvent eve){
        //SE SELECCIONA EL TOPICO ANIMALES.
        if (vt.getButtonAnimales()== eve.getSource()){
            this.vt.dispose();
            ControladorTopicos.ruta="src/Archivos/Animales.txt";
            ca = new ControladorAhorcado();
            ca.ControladorAhorcado();
            
            
        }
        //SE SELECCIONA TOPICO COSAS DEL HOGAR.
        else if (vt.getButtonCosasHogar()== eve.getSource()){
            this.vt.dispose();
            ControladorTopicos.ruta="src/Archivos/Cosas del hogar.txt";
            ca = new ControladorAhorcado();
            ca.ControladorAhorcado();
        }
    
    }
    public ArrayList<String> getPalabrasContexto(){
        return this.palabrasContexto;
        
    }
    
}
