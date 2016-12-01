/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.BatallaCorta;
import Modelo.CharizardX;
import Modelo.CharizardY;
import Vista.VistaBatallaCorta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author arru
 */
public class ControladorBatallaCorta implements ActionListener{
    CharizardX charix;
    CharizardY chariy;
    VistaBatallaCorta vbc;
    ControladorDefMonito cdm;
    int contadorAtaques=1;
    BatallaCorta bt;
    JLabel[][] espaciosEnemigo;
    
    public ControladorBatallaCorta(){
        charix= new CharizardX();
        chariy= new CharizardY();
        bt= new BatallaCorta();
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
        String enlace1=ControladorDefMonito.ruta1;
        System.out.println(enlace1);
        String enlace2=ControladorDefMonito.ruta2;;
        System.out.println(enlace2);
        String nombreEnlace1=ControladorDefMonito.nombreRuta1;
        System.out.println(nombreEnlace1);
        String nombreEnlace2=ControladorDefMonito.nombreRuta2;
        System.out.println(nombreEnlace1);
        vbc.crearMonito(enlace1, espacioP);
        vbc.crearMonito(enlace2, espacioE);
        vbc.ponerNombre(nombreEnlace1, espacioNombreP);
        vbc.ponerNombre(nombreEnlace2, espacioNombreE);
        vbc.crearEspaciosJugador();
        vbc.crearEspaciosEnemigo();
        vbc.getCombatir().setEnabled(false);
        ArrayList<String> combiEnemigo= bt.obtenerAtaquesEnemigo();
        espaciosEnemigo=vbc.getEspaciosEnemigo();
        vbc.colocarAtaqueEnemigo(combiEnemigo, espaciosEnemigo);
        
        



        
        
        
    }
    public JButton[][] obtenerAtaquesJugador(){
        return vbc.getEspaciosJugador();
    }
    public void actionPerformed(ActionEvent e){
        contadorAtaques++;
        
        System.out.println(contadorAtaques);
        if (contadorAtaques<=7){
            
            
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
                vbc.getAtaqueEsp().setEnabled(false);
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
                int[] valoresJugador=bt.valorizarAtaquesJugador(combi);
                System.out.println("valores jugador");
                for(int i=0; i<7;i++){
                    System.out.println(valoresJugador[i]);
                }
                JLabel[][] combiEnemigo=vbc.getEspaciosEnemigo();
                int[] valoresEnemigo= bt.valorizarAtaquesEnemigo(combiEnemigo);
                System.out.println("valores enemigo");
                for(int i=0; i<7;i++){
                    System.out.println(valoresEnemigo[i]);
                }
                int[] resultanyus=bt.compararAtaques(valoresJugador, valoresEnemigo);
                System.out.println("resultados");
                for(int i=0; i<7;i++){
                    System.out.println(resultanyus[i]);
                }
                ArrayList<String> resultanyusFinal=bt.leerResultado(resultanyus);
                System.out.println("resultado");
                //for(int i=0;i<7;i++){
                    //System.out.println(resultanyusFinal.get(i));
                //}
                System.out.println(resultanyusFinal);
                int ataqueCharix=charix.getAtaque();
                int defensaCharix=charix.getDefensa();
                int hpCharix=charix.getHp();
                int ataqueChariy=chariy.getAtaque();
                int defensaChariy= chariy.getDefensa();
                int hpChariy=chariy.getHp();
                int[] daño= bt.calcularDaño(resultanyusFinal, hpCharix, ataqueCharix, defensaCharix, hpChariy, ataqueChariy, defensaChariy);
                for(int i=0; i<2; i++){
                   System.out.println(daño[i]);
                }
                int HPActualJ= bt.restarHPJugador(daño, hpCharix);
                int HPActualE= bt.restarHPEnemigo(daño, hpChariy);
                System.out.println("HP jugador antes de calculo daño");
                System.out.println(hpCharix);
                System.out.println("HP enemigo antes de calculo daño");
                System.out.println(hpChariy);
                charix.cambiarHP(HPActualJ);
                chariy.cambiarHP(HPActualE);
                int HPFinalJ= charix.getHp();
                int HPFinalE=chariy.getHp();
                System.out.println("HP jugador despues de calculo daño");
                System.out.println(HPFinalJ);
                System.out.println("HP enemigo despues de calculo daño");
                System.out.println(HPFinalE);
                JOptionPane.showMessageDialog(null, "Resultados:"+resultanyusFinal.get(0)+"|"+resultanyusFinal.get(1)+"|"+resultanyusFinal.get(2)+"|"+resultanyusFinal.get(3)+"|"+resultanyusFinal.get(4)+"|"+resultanyusFinal.get(5)+"|"+resultanyusFinal.get(6)+"|\n"+"Daño al jugador="+HPFinalJ+"\n"+"Daño al enemigo="+HPFinalE);
                vbc.dispose();
                

    
        }
        
        
        }
    }
}
