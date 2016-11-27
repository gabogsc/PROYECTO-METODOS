/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Random;
import Controlador.ControladorPrincipalAhorcado;
import Controlador.ControladorAhorcado;
import Controlador.ControladorTopicos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;




/**
 *
 * @author arru
 */
public class Ahorcado {
    ControladorPrincipalAhorcado cp;
    ControladorAhorcado ca;
    ControladorTopicos ct;
    BufferedReader br;
    String linea;
    int contadorLetras;
    ArrayList<String> letrasNoUsables;
    ArrayList<String> abecedario;
    
    
    

    
   

    /** 
     */
    //ESCOGE LA PALABRA ENTRE EL CONJUNTO DEL TOPICO AL AZAZR.
    public String escogerPalabra (ArrayList<String> palabras){
        letrasNoUsables=new ArrayList();
        int numeroRandom;
        numeroRandom = new Random().nextInt(palabras.size());
        String palabraEscogida = palabras.get(numeroRandom);
        return palabraEscogida;
        }
    //SE CALCULAN LA CANTIDAD DE REPETICIONES DE CADA LETRA DENTR DEL CONJUNTO DE PALABRAS.
    public int[] comprobarRepeticiones(ArrayList<String> palabras){
        //SE GENERA UN ARREGLO DE ENTEROS EN EL QUE SE RETORNARA EL RESULTADO.
        int[] repeticiones= new int[26];
        //SE RECORRE EL CONJUNTO DE PALABRAS UNA PALABRA A LA VEZ.
        for(int i=0; i<palabras.size(); i++){
            String palabra= palabras.get(i);
            String[] letrasPalabra= palabras.get(i).split("");
            //SE RECORRE CADA LETRA DE CADA PALABRA DEL CONJUNTO Y SE CUENTAN LAS REPETICIONES.
            for(int j=0;j<palabra.length(); j++){
                if(letrasPalabra[j].equals("A")){
                    repeticiones[0]++;
                }
                else if (letrasPalabra[j].equals("B")){
                    repeticiones[1]++;
                }
                else if (letrasPalabra[j].equals("C")){
                    repeticiones[2]++;
                }
                else if (letrasPalabra[j].equals("D")){
                    repeticiones[3]++;
                }
                else if (letrasPalabra[j].equals("E")){
                    repeticiones[4]++;
                }
                else if (letrasPalabra[j].equals("F")){
                    repeticiones[5]++;
                }
                else if (letrasPalabra[j].equals("G")){
                    repeticiones[6]++;
                }
                else if (letrasPalabra[j].equals("H")){
                    repeticiones[7]++;
                   
                }
                else if (letrasPalabra[j].equals("I")){
                    repeticiones[8]++;
                }
                else if (letrasPalabra[j].equals("J")){
                    repeticiones[9]++;
                }
                else if (letrasPalabra[j].equals("K")){
                    repeticiones[10]++;
                    
                }
                else if (letrasPalabra[j].equals("L")){
                    repeticiones[11]++;
                }
                else if (letrasPalabra[j].equals("M")){
                    repeticiones[12]++;
                }
                else if (letrasPalabra[j].equals("N")){
                    repeticiones[13]++;
                }
                else if (letrasPalabra[j].equals("O")){
                    repeticiones[14]++;
                }
                else if (letrasPalabra[j].equals("P")){
                    repeticiones[15]++;
                }
                else if (letrasPalabra[j].equals("Q")){
                    repeticiones[16]++;
                }
                else if (letrasPalabra[j].equals("R")){
                    repeticiones[17]++;
                }
                else if (letrasPalabra[j].equals("S")){
                    repeticiones[18]++;
                }
                else if (letrasPalabra[j].equals("T")){
                    repeticiones[19]++;
                }
                else if (letrasPalabra[j].equals("U")){
                    repeticiones[20]++;
                }
                else if (letrasPalabra[j].equals("V")){
                    repeticiones[21]++;
                }
                else if (letrasPalabra[j].equals("W")){
                    repeticiones[22]++;
                    
                }
                else if (letrasPalabra[j].equals("X")){
                    repeticiones[23]++;
                }
                else if (letrasPalabra[j].equals("Y")){
                    repeticiones[24]++;
                }
                else if (letrasPalabra[j].equals("Z")){
                    repeticiones[25]++;
                }else{
                    
                }
                
            }
            
        }
        return repeticiones;
    }
    //SE VERIFICA EL LARGO DEL STRING INGRESADO.
    public boolean verificarLargo(String largo){
        if(largo.length()==1){
            return true;
        }
        else {
            return false;
        
        }
    }
    //SE LEE EL ARCHIVO QUE CONTIENE LAS PALABRAS.
    public ArrayList<String> leerArchivo (String ruta){
        ArrayList<String> palabras;
        palabras = new ArrayList<>();
        try{
            br = new BufferedReader(new FileReader(ruta));
            while ((linea = br.readLine()) != null)   {
                palabras.add(linea);
            }
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return palabras;
    }    
    //SE VERIFICA LA POSICION DE CADA LETRA INGRESADA DENTRO DE LA PALABRA.
    public ArrayList<Integer> verificarPosicion(String letra,String palabra){
        ArrayList<Integer> posiciones;
        posiciones = new ArrayList<>();
        //SE GENERAN CHAR CON LA LETRA Y LA PALABRA PARA LUEGO COMPARARLAS Y OBTENER LA POSICION.
        char[] caracteres= palabra.toCharArray();
        char[] letrita= letra.toCharArray();
        for(int i=0;i<palabra.length();i++){
            if (letrita[0]==caracteres[i]){
                posiciones.add(i);
                //SE AUMENTA EL CONTADOR GANAR
                contadorLetras++;
            }else{
                
            }
           
        }
        return posiciones;
    }
    //SE COLOCA LA LETRA INGRESADA (EN CASO DE SER CORRECTA) EN LA POSICION CORRESPONDIENTE.
    public JButton[][] colocarLetra(ArrayList<Integer> enteros,JButton[][] espacitos,String letra){
        for (int i=0; i<enteros.size(); i++){
            int num=enteros.get(i);
            espacitos[0][num].setText(letra);
        }
        return espacitos;
        
    }
    //SE OBTIENE LA LETRA MAS REPETIDA.
    public String obtenerMayorRepeticion(int[] enteritos){
        abecedario = new ArrayList();
        int maximo =0;
        int posicionMaximo=0;
        String abcd= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] abecedarium= abcd.split("");
        for(int k=0; k<abcd.length(); k++){
            String abcd1=abecedarium[k];
            abecedario.add(abcd1);
        }
        for(int i=0; i<enteritos.length; i++){
            if(maximo<enteritos[i]){
                maximo=enteritos[i];
            }else{
            }
        }
        for (int j=0; j<enteritos.length; j++){
            if (maximo== enteritos[j]){
                posicionMaximo=j;
            }else{
            } 
        }
        return abecedario.get(posicionMaximo);
    }
    //REMUEVE LAS PALABRAS QUE NO CONTENGAN LA LETRA CORRECTA INGRESADA.
    public ArrayList<String> removerPalabra(ArrayList<String> palabras, String letra){
        int sizePalabras = palabras.size();
        String[] palabrita= new String[sizePalabras];
        for (int i=0; i<sizePalabras;i++){
           palabrita[i]=palabras.get(i);
        }
        palabras=new ArrayList();
        for(int j=0; j<palabrita.length;j++){
            if (palabrita[j].contains(letra)){
                palabras.add(palabrita[j]);
            }else{
                
            }
        }
        
        return palabras;
    }
    //REGISTRA LA LETRA INGRESADA.
    public void guardarLetra(String letra){
        letrasNoUsables.add(letra);
    }
    //retorna 
    public int getContadorLetras(){
        return this.contadorLetras;
    }
    //RETORNA EL REGISTRO DELETRAS YA USADAS.
    public ArrayList<String> getLetrasNoUsables(){
        return letrasNoUsables;
    }
    //OBTIENE LA CANTIDAD DE REPETICIONES DE LAS LETRAS SIN TOMAR EN CUENTA LAS YA USADAS.
    public int[] comprobarRepeticiones2(ArrayList<String> palabras,ArrayList<String> letrasNoUsables){
        //SE GENERA UN ARREGLO DE ENTEROS EN EL QUE SE RETORNARA EL RESULTADO.
        int[] repeticiones= new int[26];
        //SE RECORRE EL CONJUNTO DE PALABRAS UNA PALABRA A LA VEZ.
        for(int i=0; i<palabras.size(); i++){
            String palabra= palabras.get(i);
            String[] letrasPalabra= palabras.get(i).split("");
            //SE RECORRE CADA LETRA DE CADA PALABRA DEL CONJUNTO Y SE CUENTAN LAS REPETICIONES.
            for(int j=0;j<palabra.length(); j++){
                if(letrasPalabra[j].equals("A")){
                    if (letrasNoUsables.contains("A")){
                        repeticiones[0]=0;
                    }else{
                        repeticiones[0]++;
                    }
                }
                else if (letrasPalabra[j].equals("B")){
                    if (letrasNoUsables.contains("B")){
                        repeticiones[1]=0;
                    }else{
                        repeticiones[1]++;
                    } 
                }
                else if (letrasPalabra[j].equals("C")){
                    if (letrasNoUsables.contains("C")){
                        repeticiones[2]=0;
                    }else{
                        repeticiones[2]++;
                    }
                }
                else if (letrasPalabra[j].equals("D")){
                    if (letrasNoUsables.contains("D")){
                        repeticiones[3]=0;
                    }else{
                        repeticiones[3]++;
                    }
                }
                else if (letrasPalabra[j].equals("E")){
                    if (letrasNoUsables.contains("E")){
                        repeticiones[4]=0;
                    }else{
                        repeticiones[4]++;
                    }
                }
                else if (letrasPalabra[j].equals("F")){
                    if (letrasNoUsables.contains("F")){
                        repeticiones[5]=0;
                    }else{
                        repeticiones[5]++;
                    }
                }
                else if (letrasPalabra[j].equals("G")){
                    if (letrasNoUsables.contains("G")){
                        repeticiones[6]=0;
                    }else{
                        repeticiones[6]++;
                    }
                }
                else if (letrasPalabra[j].equals("H")){
                    if (letrasNoUsables.contains("H")){
                        repeticiones[7]=0;
                    }else{
                        repeticiones[7]++;
                    }
                   
                }
                else if (letrasPalabra[j].equals("I")){
                    if (letrasNoUsables.contains("I")){
                        repeticiones[8]=0;
                    }else{
                        repeticiones[8]++;
                    }
                }
                else if (letrasPalabra[j].equals("J")){
                    if (letrasNoUsables.contains("J")){
                        repeticiones[9]=0;
                    }else{
                        repeticiones[9]++;
                    }
                }
                else if (letrasPalabra[j].equals("K")){
                    if (letrasNoUsables.contains("K")){
                        repeticiones[10]=0;
                    }else{
                        repeticiones[10]++;
                    }
                    
                }
                else if (letrasPalabra[j].equals("L")){
                    if (letrasNoUsables.contains("L")){
                        repeticiones[11]=0;
                    }else{
                        repeticiones[11]++;
                    }
                }
                else if (letrasPalabra[j].equals("M")){
                    if (letrasNoUsables.contains("M")){
                        repeticiones[12]=0;
                    }else{
                        repeticiones[12]++;
                    }
                }
                else if (letrasPalabra[j].equals("N")){
                    if (letrasNoUsables.contains("N")){
                        repeticiones[13]=0;
                    }else{
                        repeticiones[13]++;
                    }
                }
                else if (letrasPalabra[j].equals("O")){
                    if (letrasNoUsables.contains("O")){
                        repeticiones[14]=0;
                    }else{
                        repeticiones[14]++;
                    }
                }
                else if (letrasPalabra[j].equals("P")){
                    if (letrasNoUsables.contains("P")){
                        repeticiones[15]=0;
                    }else{
                        repeticiones[15]++;
                    }
                }
                else if (letrasPalabra[j].equals("Q")){
                    if (letrasNoUsables.contains("Q")){
                        repeticiones[16]=0;
                    }else{
                        repeticiones[16]++;
                    }
                }
                else if (letrasPalabra[j].equals("R")){
                    if (letrasNoUsables.contains("R")){
                        repeticiones[17]=0;
                    }else{
                        repeticiones[17]++;
                    }
                }
                else if (letrasPalabra[j].equals("S")){
                    if (letrasNoUsables.contains("S")){
                        repeticiones[18]=0;
                    }else{
                        repeticiones[18]++;
                    }
                }
                else if (letrasPalabra[j].equals("T")){
                    if (letrasNoUsables.contains("T")){
                        repeticiones[19]=0;
                    }else{
                        repeticiones[19]++;
                    }
                }
                else if (letrasPalabra[j].equals("U")){
                    if (letrasNoUsables.contains("U")){
                        repeticiones[20]=0;
                    }else{
                        repeticiones[20]++;
                    }
                }
                else if (letrasPalabra[j].equals("V")){
                    if (letrasNoUsables.contains("V")){
                        repeticiones[21]=0;
                    }else{
                        repeticiones[21]++;
                    }
                }
                else if (letrasPalabra[j].equals("W")){
                    if (letrasNoUsables.contains("W")){
                        repeticiones[22]=0;
                    }else{
                        repeticiones[22]++;
                    }
                    
                }
                else if (letrasPalabra[j].equals("X")){
                    if (letrasNoUsables.contains("X")){
                        repeticiones[23]=0;
                    }else{
                        repeticiones[23]++;
                    }
                }
                else if (letrasPalabra[j].equals("Y")){
                    if (letrasNoUsables.contains("Y")){
                        repeticiones[24]=0;
                    }else{
                        repeticiones[24]++;
                    }
                }
                else if (letrasPalabra[j].equals("Z")){
                    if (letrasNoUsables.contains("Z")){
                        repeticiones[25]=0;
                    }else{
                        repeticiones[25]++;
                    }
                }else{
                    
                }
                
                
            }
        }return repeticiones;
    }
}   
    
        
    
        
    

    
        // TODO code application logic here
    

    
    
    
    
    

    

