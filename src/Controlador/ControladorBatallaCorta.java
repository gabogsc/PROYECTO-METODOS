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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Modelo.Personaje;

/**
 *
 * @author arru
 */
public class ControladorBatallaCorta implements ActionListener{
    VistaBatallaCorta vbc;
    int contadorAtaques=1;
    BatallaCorta bt;
    JLabel[][] espaciosEnemigo;
    Personaje delJugador;
    int hpJugador;
    int ataqueJugador;
    int defensaJugador;
    String nombreJugador;
    String enlaceJugador;
    Personaje delEnemigo;
    int hpEnemigo;
    int ataqueEnemigo;
    int defensaEnemigo;
    String nombreEnemigo;
    String enlaceEnemigo;
    
    
    public ControladorBatallaCorta(Personaje jugador, Personaje enemigo){
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
        delJugador=jugador;
        hpJugador= jugador.getPuntosVidaTotal();
        ataqueJugador=jugador.getPuntosAtaqueCorto();
        defensaJugador=jugador.getPuntosDefensa();
        nombreJugador=jugador.getNombrePersonaje();
        enlaceJugador=jugador.getRuta();
        
        delEnemigo=enemigo;
        hpEnemigo=enemigo.getPuntosVidaTotal();
        ataqueEnemigo=enemigo.getPuntosAtaqueCorto();
        defensaEnemigo=enemigo.getPuntosDefensa();
        nombreEnemigo=enemigo.getNombrePersonaje();
        enlaceEnemigo=enemigo.getRuta();
        vbc.crearMonito(enlaceJugador, espacioP);
        vbc.crearMonito(enlaceEnemigo, espacioE);
        vbc.ponerNombre(nombreJugador, espacioNombreP);
        vbc.ponerNombre(nombreEnemigo, espacioNombreE);
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
                int[] daño= bt.calcularDaño(resultanyusFinal, hpJugador, ataqueJugador, defensaJugador, hpEnemigo, ataqueEnemigo, defensaEnemigo);
                for(int i=0; i<2; i++){
                   System.out.println(daño[i]);
                }
                int HPActualJ= bt.restarHPJugador(daño, hpJugador);
                int HPActualE= bt.restarHPEnemigo(daño, hpEnemigo);
                System.out.println("HP jugador antes de calculo daño");
                System.out.println(hpJugador);
                System.out.println("HP enemigo antes de calculo daño");
                System.out.println(hpEnemigo);
                delJugador.setPuntosVidaTotal(HPActualJ);
                delEnemigo.setPuntosVidaTotal(HPActualE);
                int HPFinalJ= delJugador.getPuntosVidaTotal();
                int HPFinalE=delEnemigo.getPuntosVidaTotal();
                System.out.println("HP jugador despues de calculo daño");
                System.out.println(HPFinalJ);
                System.out.println("HP enemigo despues de calculo daño");
                System.out.println(HPFinalE);
                JOptionPane.showMessageDialog(null, "Resultados:"+resultanyusFinal.get(0)+"|"+resultanyusFinal.get(1)+"|"+resultanyusFinal.get(2)+"|"+resultanyusFinal.get(3)+"|"+resultanyusFinal.get(4)+"|"+resultanyusFinal.get(5)+"|"+resultanyusFinal.get(6)+"|\n"+"Vida restante jugador="+HPFinalJ+"\n"+"Vida restante enemigo="+HPFinalE);
                vbc.dispose();
                

    
        }
        
        
        }
    }
}
