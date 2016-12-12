package Modelo;


import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;




public class TableroSudoku {
    
    //Atributos
    public CasillaSudoku[][] tablero = new CasillaSudoku[9][9];
    public CasillaSudoku[][] solucionTablero = new CasillaSudoku[9][9];

    //Metodos
    
    /*Este metodo se encarga de cargar en la memoria el archivo que contiene los datos del tablero
    que seran mostrados por pantalla, mediente un proceso de adquisicion del fichero, lectura a bajo nivel,
    y transformacion a alto nivel
    
    */
    public void leerArchivo(String ruta) throws FileNotFoundException, IOException{

        String archivo = "";

        //Adquiscion del archivo
        File adquisicion = new File(ruta);
        
        if(adquisicion.exists()){    //Verificacmos que la ruta especificada existe
  
        //Carga del archivo en la memoria
            FileReader archivoBN = new FileReader(adquisicion);
 
        //Transformacion del fichero a lenguaje de alto nivel 
            BufferedReader archivoAN = new BufferedReader(archivoBN);

        //Transformamos el archivo a una sola linea string con todos los datos
            String linea = archivoAN.readLine();

            while (linea != null){
                
                linea.replaceAll("\n", "");
                archivo = archivo.concat(linea);

                linea = archivoAN.readLine();  
            }
            
            char[] listaNumeros = archivo.toCharArray();
            int aux = 0;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    tablero[i][j].setCasilla(Character.getNumericValue(listaNumeros[aux]));
                    aux++;
                }
            }
        }
        
        else{
            System.out.println("Ruta inexistente");
        }
    }
    
    
    
    public void leerSolucion(String ruta) throws FileNotFoundException, IOException{
        
        String archivo = "";

        //Adquiscion del archivo
        File adquisicion = new File(ruta);
        
        if(adquisicion.exists()){    //Verificacmos que la ruta especificada existe
  
        //Carga del archivo en la memoria
            FileReader archivoBN = new FileReader(adquisicion);
 
        //Transformacion del fichero a lenguaje de alto nivel 
            BufferedReader archivoAN = new BufferedReader(archivoBN);

        //Transformamos el archivo a una sola linea string con todos los datos
            String linea = archivoAN.readLine();

            while (linea != null){
                
                linea.replaceAll("\n", "");
                archivo = archivo.concat(linea);

                linea = archivoAN.readLine();  
            }
            
            char[] listaNumeros = archivo.toCharArray();
            int aux = 0;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    solucionTablero[i][j].setCasilla(Character.getNumericValue(listaNumeros[aux]));
                    aux++;
                }
            }
        }
        
        else{
            System.out.println("Ruta inexistente");
        }
    }
    
    public void printTablero(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(tablero[i][j].getCasilla());
                System.out.print(" ");

            }
            System.out.println("");
       }
   
    }
    
    public void printSolucion(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(solucionTablero[i][j].getCasilla());
                System.out.print(" ");

            }
            System.out.println("");
        }
    }

    public CasillaSudoku[][] getTablero() {
        return tablero;
    }
        
    public CasillaSudoku[][] getSolucion(){
        return solucionTablero;
    }

    
    //Metodo encargado de devolver la distribucion de colores en las casillas del tablero

    public ArrayList<ArrayList<ArrayList<Integer>>> listaPosicionesColores(){

        ArrayList<ArrayList<ArrayList<Integer>>> coloresAB = new ArrayList<>();
        ArrayList<ArrayList<Integer>> colorA = new ArrayList<>();
        ArrayList<ArrayList<Integer>> colorB = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                ArrayList<Integer> posicion = new ArrayList<>();
                posicion.add(i);
                posicion.add(j);

                if(i < 3 ||(i >= 6 && i < 9)){
                    if(j < 3){
                        colorA.add(posicion);
                    }
                    else if(j >= 3 && j < 6){

                        colorB.add(posicion);
                    }
                    else if(j >= 6 && j < 9){
                        colorA.add(posicion);
                    }
                }

                else if(i >= 3 && i < 6){
                    if(j < 3){
                        colorB.add(posicion);
                    }
                    else if(j >= 3 && j < 6){

                        colorA.add(posicion);
                    }
                    else if(j >= 6 && j < 9){
                        colorB.add(posicion);
                    }
                }   
            }
        }

        coloresAB.add(colorA);
        coloresAB.add(colorB);
        System.out.println(coloresAB);

        return coloresAB;
    }


    /*Metodo encargado de retornar una lista con todos los valores que no se le pueden
    asigar a una casilla que se ubica en la fila "ultimaFila" y la columna
    "ultimaColumna".
    */

    public ArrayList<Integer> opcionesInvalidas(int ultimaFila, int ultimaColumna){

        ArrayList<Integer> opcionesInvalidas = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (i == ultimaFila){
                    opcionesInvalidas.add(tablero[i][j].getCasilla());
                }

                if (j == ultimaColumna){
                    opcionesInvalidas.add(tablero[i][j].getCasilla());
                }
            }
        }

        System.out.println(opcionesInvalidas);
        return opcionesInvalidas;
    }

     /* Crea una lista de todas las posiciones de las casillas del tablero que no
    son modificables por el usuario
    */

    public ArrayList<ArrayList<Integer>> posicionCasillasBloqueadas(){

        ArrayList<ArrayList<Integer>> casillasBloqueadas = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                ArrayList<Integer> posicionCasilla = new ArrayList<>();
                posicionCasilla.add(i);
                posicionCasilla.add(j);

                if (tablero[i][j].getCasilla() != 0){
                    casillasBloqueadas.add(posicionCasilla);
                }
            }
        }

        return casillasBloqueadas;
    }

    //Constructor
    public TableroSudoku(){  
        int posNumero = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                tablero[i][j] = new CasillaSudoku(0, i, j);
                solucionTablero[i][j] = new CasillaSudoku(0, i, j);
            }
        }
    }
}
        
        

                    

    
    
            
                
    
        
            
        
    

    
    
        


            
               
        
                
                
                
                
                
            
    
    
    



