/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.TableroSudoku;
import Vista.VistaMenuSudoku;
import Vista.VistaSudoku;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
class ControladorSudoku implements ActionListener{
    
    //Atributoa
    private TableroSudoku tablero = new TableroSudoku();
    private TableroSudoku solucionTablero;
    private JButton[][] tableroV;
    private VistaSudoku vs;
    private VistaMenuSudoku vms;
    private ControladorMenuSudoku cms;
    private Color colorA;
    private Color colorB;
    private boolean flag0 = true;
    private boolean flag1 = false;
    private int ultimaFila, ultimaColumna;
    private String bloqueados = "";

    
    
    
    //Constructor
    public ControladorSudoku() throws IOException{
        vs = new VistaSudoku();
        this.vs.deshabilitarBtnTerminar();
        this.tablero = new TableroSudoku();
        try{
            tablero.leerArchivo("C:\\Users\\Carlos\\Desktop\\PROYECTO-METODOS-master\\PROYECTO-METODOS-master\\src\\TablerosSudoku\\jugable" +cms.nivel+".txt");
        }
        catch(FileNotFoundException nf){
            System.out.println("no existe el archivo");
        }
        vs.setVisible(true);
        this.solucionTablero = new TableroSudoku();
        try{
            solucionTablero.leerSolucion("C:\\Users\\Carlos\\Documents\\Sudoku\\Dificultades\\solucion"+cms.nivel+".txt");
        }
        catch(FileNotFoundException nf){
            System.out.println("no existe el archivo");
        }
        
        this.vs.setListener(this);
        this.vs.setLocationRelativeTo(null);
        this.setTextoBotones();
        this.tablero.printTablero();
        this.solucionTablero.printSolucion();
        this.posicionBloqueados();
        this.bloquearBotones(bloqueados);

        

        //En este punto se le asignan los colores a los distintos tableros
       
        
        for(ArrayList<ArrayList<Integer>> color: this.tablero.listaPosicionesColores()){
            
            if(this.cms.nivel == "Facil"){
                this.colorA = new Color(255, 255, 0);
                this.colorB = new Color(240, 230, 140);
            }

            else if(this.cms.nivel == "Medio"){
                this.colorA = new Color(20, 250, 20);
                this.colorB = new Color(110, 255, 110);
            }

            else if(this.cms.nivel == "Dificil"){
                this.colorA = new Color(255, 53, 53);
                this.colorB = new Color(255, 120, 120);
            }
            
            if(this.tablero.listaPosicionesColores().indexOf(color) == 0){
                
                for (ArrayList<Integer> posicion : color){
                    this.vs.getTableroVista()[posicion.get(0)][posicion.get(1)].setBackground(colorA);
                    
                    for(JButton boton: this.vs.getBtnImpares()){
                        boton.setBackground(colorA);
                    }
                    
                    this.vs.getBtnTerminar().setBackground(colorA);
                    this.vs.getBtnRegresarNiveles().setBackground(colorA);
                }
            }
            
            else if(this.tablero.listaPosicionesColores().indexOf(color) == 1){
                for (ArrayList<Integer> posicion : color){
                    this.vs.getTableroVista()[posicion.get(0)][posicion.get(1)].setBackground(colorB);
                    
                    for(JButton boton: this.vs.getBtnPares()){
                        boton.setBackground(colorB);
                    }
                    
                    this.vs.getBtnVaciar().setBackground(colorB);
                }
            }
        }
    }
    
    //Metodos
    
    //Activa la visualizacion de la vista del tablero
    
    public void mostrarVista(boolean mV){
        this.vs.setVisible(mV);
        
    }
    
    /* Visualiza el valor de cada casilla en el tablero, desactivando aquellas 
    que tengan un valor distinto de 0
    */

    public void setTextoBotones(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (tablero.getTablero()[i][j].getCasilla() != 0){

                    this.vs.getTableroVista()[i][j].setText(this.tablero.getTablero()[i][j].getCasilla() +"");
                    this.vs.getTableroVista()[i][j].setEnabled(false);
                }
            }
        }
    }
    
    
    /* Crea una lista de todas las posiciones de las casillas del tablero que no
    son modificables por el usuario
    */
    
    public String posicionBloqueados(){

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (this.tablero.getTablero()[i][j].getCasilla() != 0){
                    
                    int bloqueado = (this.tablero.getTablero()[i][j].getColumna());
                    bloqueados = bloqueados.concat(Integer.toString(bloqueado));
                }
            }
        }
        
        return bloqueados;
    }
    
    /* Bloquea aquellos botones no modificables por el usuario
    */
    
    public void bloquearBotones(String bloqueados){
        char[] arregloBloqueados = bloqueados.toCharArray();
        int posBloqueados = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(Character.getNumericValue(arregloBloqueados[posBloqueados]) == j){
                    
                    this.vs.getTableroVista()[i][j].setEnabled(false);
                    if (posBloqueados < arregloBloqueados.length - 1){
                           posBloqueados++;
                    }
                }
            }
        }
    }
    
    public void verificarTablero(){
        int casillasVacias = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (this.tablero.getTablero()[i][j].getCasilla() == 0){
                    casillasVacias++;
                }
            }
        }
        System.out.println(casillasVacias);
        
        if (casillasVacias == 0){
            this.vs.hablitarBtnTerminar();
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(flag0){
            
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(ae.getSource() == this.vs.getTableroVista()[i][j]){
                        
                        vs.deshabilitarBtnTerminar();
                        System.out.println(i + "," + j);
                        System.out.println(this.tablero.getTablero()[i][j].getCasilla());
                        vs.activarBotonesTablero(false);
                        this.ultimaFila = i;
                        this.ultimaColumna = j;
                        
                        for(int valor: this.tablero.opcionesInvalidas(ultimaFila, ultimaColumna)){
                            switch (valor){
                                case 1:
                                    this.vs.DeshablitarBtn1();
                                    break;
                                case 2:
                                    this.vs.DeshablitarBtn2();
                                    break;
                                case 3:
                                    this.vs.DeshablitarBtn3();
                                    break;
                                case 4:
                                    this.vs.DeshablitarBtn4();
                                    break;
                                case 5:
                                    this.vs.DeshablitarBtn5();
                                    break;
                                case 6:
                                    this.vs.DeshablitarBtn6();
                                    break;
                                case 7:
                                    this.vs.DeshablitarBtn7();
                                    break;
                                case 8:
                                    this.vs.DeshablitarBtn8();
                                    break;
                                case 9:
                                    this.vs.DeshablitarBtn9(); 
                                    break;
                            }
                        }

                        flag0 = false;
                        flag1 = true;
                    } 
                }
            }
            
            if((JButton)ae.getSource() == this.vs.getBtnTerminar()){
                int errores = 0;
                for(int a = 0; a < 9; a++){
                    for(int b = 0; b < 9; b++){
                        if (this.tablero.getTablero()[a][b].getCasilla() != this.solucionTablero.getSolucion()[a][b].getCasilla()){
                            errores++;
                        }
                    }
                }

                if (errores != 0){
                    System.out.println("Perdio");
                    flag0 = false;
                }

                else{
                    System.out.println("Gano");
                    JOptionPane.showMessageDialog(null,"Sudoku Resuelto !!!");
                    flag0 = false;
                }
            }
            
            else if((JButton)ae.getSource() == this.vs.getBtnRegresarNiveles()){
                
                this.cms = new ControladorMenuSudoku();
                this.vs.setVisible(false);
            }
        }
        
        else if(flag1){
            
            if(ae.getSource() == this.vs.getBtnVaciar()){
                this.vs.getTableroVista()[ultimaFila][ultimaColumna].setText("");
                this.tablero.getTablero()[ultimaFila][ultimaColumna].setCasilla(0);
            }
            
            else{
                String numero = ((JButton)ae.getSource()).getText();
                this.vs.getTableroVista()[ultimaFila][ultimaColumna].setText(numero);
                this.tablero.getTablero()[ultimaFila][ultimaColumna].setCasilla(Integer.parseInt(numero));
            }
            
            this.vs.habilitarOpciones();
            this.vs.activarBotonesTablero(true);
            this.bloquearBotones(bloqueados);
            this.tablero.printTablero();
            this.verificarTablero();
            flag1 = false;
            flag0 = true;
        }
    }
}
    


