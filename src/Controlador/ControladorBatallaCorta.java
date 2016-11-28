/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.BatallaCorta;
import Vista.VistaBatallaCorta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author arru
 */
public class ControladorBatallaCorta implements ActionListener{
    VistaBatallaCorta vbc;
    ControladorDefMonito cdm;
    int contadorAtaques=1;
    BatallaCorta bt;
    
    public ControladorBatallaCorta(){
        bt= new BatallaCorta();
        cdm= new ControladorDefMonito();
        vbc=new VistaBatallaCorta();
        vbc.setVisible(true);
        vbc.agregarListener(this);
        JLabel espacioP=vbc.getMonitoPersonaje();
        System.out.println("label del personaje");
        System.out.println(espacioP);
        JLabel espacioE=vbc.getMonitoEnemigo();
        System.out.println("label del enemigo");
        System.out.println(espacioE);
        JLabel espacioNombreP=vbc.getNombrePersonaje();
        System.out.println(espacioNombreP);
        JLabel espacioNombreE=vbc.getNombreEnemigo();
        System.out.println(espacioNombreE);
        String enlace1=cdm.getRuta1();
        System.out.println(enlace1);
        String enlace2=cdm.getRuta2();
        System.out.println(enlace2);
        String nombreEnlace1=cdm.getNombreRuta1();
        System.out.println(nombreEnlace1);
        String nombreEnlace2=cdm.getNombreRuta2();
        System.out.println(nombreEnlace1);
        vbc.crearMonito(enlace1, espacioP);
        vbc.crearMonito(enlace2, espacioE);
        vbc.ponerNombre(nombreEnlace1, espacioNombreP);
        vbc.ponerNombre(nombreEnlace2, espacioNombreE);
        vbc.crearEspaciosJugador();
        vbc.crearEspaciosEnemigo();



        
        
        
    }
    public JButton[][] obtenerAtaquesJugador(){
        return vbc.getEspaciosJugador();
    }
    public void actionPerformed(ActionEvent e){
        contadorAtaques++;
        System.out.println(contadorAtaques);
        if (contadorAtaques<=7){
            
            vbc.getCombatir().setEnabled(false);
            if (vbc.getAtaqueAlto()==e.getSource()){
            //contadorAtaques++;
            System.out.println("Has seleccionado ataque alto");
            JButton[][] espaciosJug=vbc.getEspaciosJugador();
            for(int i=0; i<7;i++){
                if (espaciosJug[0][i].getText().equals("")){
                    espaciosJug[0][i].setText("ATK.A.");
                    break;
                    }else{
                    
                    }
                }
                //contadorAtaques++;
            
            }
            
            else if(vbc.getAtaqueMedio()==e.getSource()){
                //contadorAtaques++;
                System.out.println("Has seleccionado ataque medio");
                JButton[][] espaciosJug=vbc.getEspaciosJugador();
                for(int i=0; i<7;i++){
                    if (espaciosJug[0][i].getText().equals("")){
                        espaciosJug[0][i].setText("ATK.M.");
                        break;
                    }else{
                    
                    }
                }
                //contadorAtaques++;
            
            }
            else if(vbc.getAtaqueBajo()==e.getSource()){
                //contadorAtaques++;
                System.out.println("Has seleccionado ataque bajo");
                JButton[][] espaciosJug=vbc.getEspaciosJugador();
                for(int i=0; i<7;i++){
                    if (espaciosJug[0][i].getText().equals("")){
                        espaciosJug[0][i].setText("ATK.B.");
                        break;
                    }else{
                    
                    }
                }
                //contadorAtaques++;
            
            }
            else if(vbc.getAtaqueEsp()==e.getSource()){
                //contadorAtaques++;
                System.out.println("Has seleccionado ataque especial");
                JButton[][] espaciosJug=vbc.getEspaciosJugador();
                for(int i=0; i<7;i++){
                    if (espaciosJug[0][i].getText().equals("")){
                        espaciosJug[0][i].setText("ATK.ESP.");
                        break;
                    }else{
                    
                    }
                }
                //contadorAtaques++;
            }
            
            
        }else{
            
            if (vbc.getAtaqueAlto()==e.getSource()){
            //contadorAtaques++;
            System.out.println("Has seleccionado ataque alto");
            JButton[][] espaciosJug=vbc.getEspaciosJugador();
            for(int i=0; i<7;i++){
                if (espaciosJug[0][i].getText().equals("")){
                    espaciosJug[0][i].setText("ATK.A.");
                    break;
                    }else{
                    
                    }
                }
                //contadorAtaques++;
            
            }
            
            else if(vbc.getAtaqueMedio()==e.getSource()){
                //contadorAtaques++;
                System.out.println("Has seleccionado ataque medio");
                JButton[][] espaciosJug=vbc.getEspaciosJugador();
                for(int i=0; i<7;i++){
                    if (espaciosJug[0][i].getText().equals("")){
                        espaciosJug[0][i].setText("ATK.M.");
                        break;
                    }else{
                    
                    }
                }
                //contadorAtaques++;
            
            }
            else if(vbc.getAtaqueBajo()==e.getSource()){
                //contadorAtaques++;
                System.out.println("Has seleccionado ataque bajo");
                JButton[][] espaciosJug=vbc.getEspaciosJugador();
                for(int i=0; i<7;i++){
                    if (espaciosJug[0][i].getText().equals("")){
                        espaciosJug[0][i].setText("ATK.B.");
                        break;
                    }else{
                    
                    }
                }
                //contadorAtaques++;
            
            }
            else if(vbc.getAtaqueEsp()==e.getSource()){
                //contadorAtaques++;
                System.out.println("Has seleccionado ataque especial");
                JButton[][] espaciosJug=vbc.getEspaciosJugador();
                for(int i=0; i<7;i++){
                    if (espaciosJug[0][i].getText().equals("")){
                        espaciosJug[0][i].setText("ATK.ESP.");
                        break;
                    }else{
                    
                    }
                }
            }
            vbc.getAtaqueAlto().setEnabled(false);
            vbc.getAtaqueMedio().setEnabled(false);
            vbc.getAtaqueBajo().setEnabled(false);
            vbc.getAtaqueEsp().setEnabled(false);
            vbc.getCombatir().setEnabled(true);
            if(vbc.getCombatir()==e.getSource()){
                System.out.println("Has seleccionado combatir");
                JButton[][] combi=vbc.getEspaciosJugador();
                int[] valores=bt.valorizarAtaques(combi);
                for(int i=0; i<7;i++){
                    System.out.println(valores[i]);
                }
                
                

    
        }
        
        
        }
    }
}
