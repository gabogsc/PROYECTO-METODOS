
package Modelo;

import java.util.ArrayList;
import java.util.Random;
import Modelo.Personaje;
import java.util.Collections;


public class Escenario {
    // Atributos y creacion de una matriz para el Escenario
    private Casilla[][] matrizEscenario = new Casilla[25][25];
    //Declaramos un atributo de tipo ArrayList el cual contendra elementos del tipo Personaje
    private ArrayList<Personaje> listaPersonajesCPU = new ArrayList<>();
    private ArrayList<Personaje> listaPersonajesUsuario = new ArrayList<>();
    // Referencia de clase personaje para el constructor
    private Personaje personaje;
    
    

    public Escenario() {
    
        //Constructor para Hacer que cada elemento en la matriz sea una casilla 
         
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                matrizEscenario[i][j] = new Casilla(i,j,0,0,0,personaje,true);
                
               
            }
        }
    } 
    
    
    
    public Casilla[][] getMatrizEscenario(){
    return this.matrizEscenario;
    }
    
    
    public void GenerarTerrenoAreaPlanComun(){
        //Charlie pasao a pene
        Random rnd = new Random();
        int tipoDeTerreno;
        int alturaTierra;
        //solo me interesa la altura en rio
        int alturaBYR;
        // Para Manejar las proporcionalidades de terreno (TipoTierra = 469 ), (TipoRIo = 156 )
        int cTierra =0;
        int cRio= 0;
        // MAXIMO DE TERRENOS POSIBLES
        int maxTierra = 469;
        int maxRio = 156;
     
        
        
        
        for(int i= 0; i<25; i++){
            for(int j = 0; j<25; j++){
                
                
                int contador = 0;
                
                do{
                    
                    tipoDeTerreno = (int) Math.round(rnd.nextGaussian()* 1 + 0 );
                    alturaTierra =(int) Math.round(rnd.nextGaussian()* 1 + 5);
                    alturaBYR = (int) Math.round(rnd.nextGaussian()* 1 + 6);
                   
                    
                    if(tipoDeTerreno==1 || tipoDeTerreno == 0){
                        if(alturaTierra <= 5 && alturaTierra >= 0 && alturaBYR>=0 && alturaBYR<=10 ){
                        
                            contador++;
                        }
                    }
                    

                }while (contador == 0);   

                // Tipo de terreno Tierra
                if (tipoDeTerreno == 0 && cTierra < maxTierra){
                    
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno);
                    matrizEscenario[i][j].setAltura(alturaTierra);
                    matrizEscenario[i][j].setCaminable(true);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0);    
                    cTierra++;
                    //System.out.println("TIERRA");
                    //System.out.println(alturaTierra);
                    
                } 
               
                // Tipo de terreno Rio
                else if (tipoDeTerreno == 1 && cRio < maxRio){
                    
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno + 2);
                    matrizEscenario[i][j].setAltura(alturaBYR);
                    matrizEscenario[i][j].setCaminable(false);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0);
                    cRio++;
                    //System.out.println("RIO");
                    //System.out.println(alturaBYR);
                    
                }else{
                    j--;
                } 
            }
        }
        
        System.out.println(cRio);
        System.out.println(cTierra);
    }

    
    
    
    
    
    
    
    public void GenerarTerrenoAreaDeEconomia(){
        Random rnd = new Random();
        int tipoDeTerreno;
        int alturaTierra;
        //SOlo me interesa la altura en rio
        int alturaBYR;
        int alturaMontaña;
        // Para Manejar las proporcionalidades de terreno (TipoTierra = 357 ), (TipoRIo = 179 ),(TipoMontaña = 89 )
        int cTierra =0;
        int cRio= 0;
        int cMontaña=0;
        // Maximo de terrenos posibles
        int maxMontaña = 89;
        int maxTierra = 357;
        int maxRio = 179;
        
        
        
        
        
        
        for(int i= 0; i<25; i++){
            for(int j = 0; j<25; j++){
                
                
                int contador = 0;
                
                do{
                    
                    tipoDeTerreno = (int) Math.round(rnd.nextGaussian()* 1 + 1);
                    alturaTierra =(int) Math.round(rnd.nextGaussian()* 1 + 5);
                    alturaBYR = (int) Math.round(rnd.nextGaussian()* 1 + 6);
                    alturaMontaña = (int) Math.round(rnd.nextGaussian()* 1 + 8);
                    
                    if(tipoDeTerreno==0 || tipoDeTerreno == 1 || tipoDeTerreno == 2){ 
                       if((alturaTierra <= 5 && alturaTierra >= 0 && alturaBYR>=0 && alturaBYR<=10 && alturaMontaña>=6 && alturaMontaña<= 10)){
                        
                            contador++;
                        } 
                      
                    }
                    

                }while (contador == 0);   

                
                // Tipo de terreno Tierra
                if (tipoDeTerreno == 0 && maxTierra > cTierra){
                    
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno);
                    matrizEscenario[i][j].setAltura(alturaTierra);
                    matrizEscenario[i][j].setCaminable(true);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0);    
                    cTierra++;
                    //System.out.println("TIERRA");
                    //System.out.println(alturaTierra);
                    
                } 
               
                else if(tipoDeTerreno == 1 && maxMontaña > cMontaña){
                // Tipo de terreno Montaña 
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno+1);
                    matrizEscenario[i][j].setAltura(alturaMontaña);
                    matrizEscenario[i][j].setCaminable(true);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0);
                    cMontaña++;
                    //System.out.println("MONTAÑA");
                    //System.out.println(alturaMontaña);
                    
                } 
                
                // Tipo de terreno Rio
                else if(tipoDeTerreno == 2 && maxRio > cRio){
                    
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno+1);
                    matrizEscenario[i][j].setAltura(alturaBYR);
                    matrizEscenario[i][j].setCaminable(false);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0);
                    cRio++;
                    //System.out.println("RIO");
                    //System.out.println(alturaBYR);
                    
                    
                }else{
                    j--;
                } 
            }
        }
        System.out.println(cTierra);
        System.out.println(cMontaña);
        System.out.println(cRio);
    }
    
    
    public void GenerarTerrenoAreaDeEspecialidad(){
        Random rnd = new Random();
        int tipoDeTerreno;
        int alturaTierra;
        int alturaBYR;
        int alturaMontaña;
        // Para Manejar las proporcionalidades de terreno (TipoTierra = 250 ), (TipoRIo = 125 ),(TipoMontaña = 62  ),(TipoBosque = 188 )
        int cTierra =0;
        int cRio= 0;
        int cMontaña = 0;
        int cBosque = 0;
        // MAximo de terrenos posibles
        int maxTierra = 250;
        int maxRio = 125;
        int maxMontaña = 62;
        int maxBosque = 188;
        
        
        
        for(int i= 0; i<25; i++){
            for(int j = 0; j<25; j++){
                
                
                int contador = 0;
                
                do{
                    
                    tipoDeTerreno = (int) Math.round(rnd.nextGaussian()* 1 + 2);
                    alturaTierra =(int) Math.round(rnd.nextGaussian()* 1 + 5);
                    alturaBYR = (int) Math.round(rnd.nextGaussian()* 1 + 6);
                    alturaMontaña = (int) Math.round(rnd.nextGaussian()* 1 + 8);
                    
                    if(tipoDeTerreno <=3 && tipoDeTerreno >=0){
                        if(alturaTierra <= 5 && alturaTierra >= 0 && alturaBYR>=0 && alturaBYR<=10){ 
                            if(alturaMontaña>=6 && alturaMontaña<= 10){
                        
                                contador++;
                      
                            }
                        }
                    }   

                }while (contador == 0);   
 
                
                // Tipo de terreno Tierra
                if (tipoDeTerreno == 0 && maxTierra > cTierra){
                    
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno);
                    matrizEscenario[i][j].setAltura(alturaTierra);
                    matrizEscenario[i][j].setCaminable(true);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0); 
                    //System.out.println("TIERRA");
                    //System.out.println(alturaTierra);
                    cTierra++;
                } 
                // Tipo de terreno Bosque
                else if (tipoDeTerreno == 1 && maxBosque > cBosque){
                    
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno);
                    matrizEscenario[i][j].setAltura(alturaBYR);
                    matrizEscenario[i][j].setCaminable(true);
                    matrizEscenario[i][j].setProbabilidadDeFallo(20);
                    cBosque++;
                    //System.out.println("BOSQUE");
                    //System.out.println(alturaBYR);
                } 
                else if (tipoDeTerreno == 2 && maxMontaña > cMontaña){
                // Tipo de terreno Montaña 
                matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno);
                    matrizEscenario[i][j].setAltura(alturaMontaña);
                    matrizEscenario[i][j].setCaminable(true);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0);
                    cMontaña++;
                    //System.out.println("MONTAÑA");
                    //System.out.println(alturaMontaña);
                } 
                // Tipo de terreno Rio
                else if (tipoDeTerreno == 3 && maxRio > cRio){
                    
                    matrizEscenario[i][j].setTipoDeTerreno(tipoDeTerreno);
                    matrizEscenario[i][j].setAltura(alturaBYR);
                    matrizEscenario[i][j].setCaminable(false);
                    matrizEscenario[i][j].setProbabilidadDeFallo(0);
                    cRio++;
                    //System.out.println("RIO");
                    //System.out.println(alturaBYR);
                }else{
                    j--;
                } 
            }
        }
        System.out.println(cTierra);
        System.out.println(cBosque);
        System.out.println(cMontaña);
        System.out.println(cRio);
        
    }
    
 
    
    
    
    
    public void RevisarRios(){
        Random rndAux = new Random();
        int riofaltante = 0;
        int tierraDemas = 0;
        
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                
                int contadorRio = 0;
                if(matrizEscenario[i][j].getTipoDeTerreno() == 3){
                   
                    
                    try{
                            if( 3 == matrizEscenario[i][j+1].getTipoDeTerreno()){
                                contadorRio++;
                            
                            }
                        
                        }catch(ArrayIndexOutOfBoundsException a){}
                        
                        
                    
                    try{    
                            if( 3 == matrizEscenario[i+1][j].getTipoDeTerreno()){
                                contadorRio++;
                            
                            }
                        
                        }catch(ArrayIndexOutOfBoundsException a){}
                        
                    
                    try{    
                            if(3 == matrizEscenario[i-1][j].getTipoDeTerreno()){
                                contadorRio++;
                            
                            }    
                            
                        }catch(ArrayIndexOutOfBoundsException a){}
          
                    try{
                            if(3 == matrizEscenario[i][j-1].getTipoDeTerreno()){
                                contadorRio++;
                            
                            }
                        
                        }catch(ArrayIndexOutOfBoundsException a){}

                    if(contadorRio == 0){
                        
                        riofaltante--;
                        matrizEscenario[i][j].setTipoDeTerreno(0);
                        matrizEscenario[i][j].setAltura(rndAux.nextInt(6));
                        tierraDemas++;
                 
                    }
                   
                }
               
            
                    
                    
              
                if(matrizEscenario[i][j].getTipoDeTerreno() == 0 && tierraDemas != 0){
                    
                    try{
                            if(3 == matrizEscenario[i][j+1].getTipoDeTerreno() ){
                                contadorRio++;
                                System.out.println(contadorRio);
                            }
                        
                        }catch(ArrayIndexOutOfBoundsException a){}
                    
                    try{    
                            if( 3 == matrizEscenario[i+1][j].getTipoDeTerreno()){
                                contadorRio++;
                            }
                        
                        }catch(ArrayIndexOutOfBoundsException a){}
                    
                    try{   
                            if(3 == matrizEscenario[i-1][j].getTipoDeTerreno()){
                                contadorRio++;
                            
                            }
                        
                        }catch(ArrayIndexOutOfBoundsException a){}
                    
                    try{    
                            if(3 == matrizEscenario[i][j-1].getTipoDeTerreno()){
                                contadorRio++;
                            }
                        
                        }catch(ArrayIndexOutOfBoundsException a){}

                    
                
                    if(contadorRio > 0){
                        
                        matrizEscenario[i][j].setTipoDeTerreno(3);
                        matrizEscenario[i][j].setAltura(rndAux.nextInt(11));
                        riofaltante++;
 
                        tierraDemas--;
                        
                    }    
                }
            } 
        }   
    }
    
    
    
    
    
    
    
    
    
    /*Metodo encargado de deshabilitar como caminable aquellas casillas
    en las que exista un personaje de la cpu
    */
    public void posicionarPjesCPU(){

       for(int nPjesCPU=0; nPjesCPU < 5;){
            
            
            Random numero = new Random();
            int posX = (numero.nextInt(25));
            int posY = (numero.nextInt(11) + 14);
            int tipoDeRol = (numero.nextInt(2));
            
            int aumentadorDeVelocidad = 50;
            
            if(matrizEscenario[posX][posY].getTipoDeTerreno()== 3){
                
                
                System.out.println("NO SE PUSO PERSONAJE");
            }

            else {
                if(tipoDeRol == 0){
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setTipoPersonaje("alumno");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setRolPersonaje("Guerrero");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setBandoPersonaje("malo");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueCorto(100);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueLargo(20);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosVelocidad(25+aumentadorDeVelocidad);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosDefensa(50);
                    
                    
                    aumentadorDeVelocidad =+ 100;
                    
                    
                    
                    
                    
                    System.out.println("SI SE PUSO");
                }
                else if(tipoDeRol == 1){
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setTipoPersonaje("alumno");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setRolPersonaje("Arquero");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setBandoPersonaje("malo");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueCorto(20);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueLargo(100);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosVelocidad(50+aumentadorDeVelocidad);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosDefensa(20);
                    
                    aumentadorDeVelocidad =+ 100;
                     
                    
                    System.out.println("SISE PUSO ");
                
                }

                
                matrizEscenario[posX][posY].setCaminable(false);
                listaPersonajesCPU.add(matrizEscenario[posX][posY].obtenerPersonaje());
                
                
                nPjesCPU++;
                System.out.println(nPjesCPU);
                
                
            }
            
            
            
           
        }
    }
    
 
    public ArrayList<Personaje> getListaPersonajesCPU(){
        return this.listaPersonajesCPU;
    }
    
    public ArrayList<Personaje> getListaPersonajesUsuario(){
        return this.listaPersonajesCPU;
    }
    
    
    
    
    
    
    
    public void PosicionarPjesUsuario(){
        
        

        int aumentadorDeVelocidad = 50;
        
       for(int nPjesUsuario=0; nPjesUsuario < 5;){
            
            
            Random numero = new Random();
            int posX = (numero.nextInt(25));
            int posY = (numero.nextInt(13));
            int tipoDeRol = (numero.nextInt(2));
            
            
            
            if(matrizEscenario[posX][posY].getTipoDeTerreno()== 3){
                
                
                System.out.println("NO SE PUSO PERSONAJE");
            }

            else {
                if(tipoDeRol == 0){
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setRolPersonaje("Guerrero");
                   
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setBandoPersonaje("bueno");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setTipoPersonaje("alumno");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueCorto(100);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueLargo(20);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosVelocidad(25+aumentadorDeVelocidad);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosDefensa(50);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPosX(posX);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPosY(posY);
                    
                    aumentadorDeVelocidad =+ 100;
                    
                    System.out.println("SI SE PUSO");
                }
                else if(tipoDeRol == 1){
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setRolPersonaje("Arquero");
                    // TIPO DE BANDO == malo , significa que es del equipo de la CPU
                    // TIPO DE BANDO == bueno, significa que es del equipo del usuario
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setBandoPersonaje("bueno");
                    
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setTipoPersonaje("alumno");
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueCorto(20);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosAtaqueLargo(100);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosVelocidad(50+aumentadorDeVelocidad);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPuntosDefensa(20);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPosX(posX);
                    
                    this.matrizEscenario[posX][posY].obtenerPersonaje().setPosY(posY);
                    
                    aumentadorDeVelocidad =+ 100;
                    
                    System.out.println("SISE PUSO ");
                    
                
                }

                
                matrizEscenario[posX][posY].setCaminable(false);
                listaPersonajesUsuario.add(matrizEscenario[posX][posY].obtenerPersonaje());
                
                
                nPjesUsuario++;
                System.out.println(nPjesUsuario);
                
  
            }
        }
    }

    public ArrayList<Personaje> ordenarTurnosUsuario(){
        
        ArrayList<Personaje> listaTurnosUsuario = new ArrayList<>() ;
        ArrayList<Personaje> listaTurnosCPU = new ArrayList<>();
        int[] lista= new int[1000];
        
        
        // CREAR LISTA DESDE EL 1 AL 1000
        for (int a = 0; a < lista.length; a++) {
            lista[a] = a + 1;
        }  
        
        //RECORRER LA LISTA DE NUMEROS E IR COMPARANDOLOS CON EL ATRIBUTO PUNTOS DE VELOCIDAD E IR ORDENANDOLOS
        for(int numero: lista){ 
            for(Personaje personaje: listaPersonajesUsuario){
                
                if(personaje.getPuntosVelocidad() == numero){
                    listaTurnosUsuario.add(personaje);
                    
                }
            }
        }
        //LA LISTA DE TURNOS USUARIO ESTAN ORDENADOS DE MAYOR A MENOR Y CON EL METODO SIGUIENTE LO DEJAREMOS DE MAYOR A MENOR
        Collections.reverse(listaTurnosUsuario);
        
         for(Personaje personaje: listaTurnosUsuario){
            
            System.out.println(personaje);
        }
        
        return listaTurnosUsuario;
    }
        
        
        
    public ArrayList<Personaje> ordenarTurnosCPU(){
        
        ArrayList<Personaje> listaTurnosCPU = new ArrayList<>();
        int[] lista= new int[1000];
        
        //RECORRER LA LISTA DE NUMEROS E IR COMPARANDOLOS CON EL ATRIBUTO PUNTOS DE VELOCIDAD E IR ORDENANDOLOS
        for(int numero: lista){ 
            for(Personaje personaje: listaPersonajesCPU ){

                if(personaje.getPuntosVelocidad() == numero){
                    
                    listaTurnosCPU.add(personaje);
                }
            }
        }
        //LA LISTA DE TURNOS DE CPU ESTAN ORDENADOS DE MAYOR A MENOR Y CON EL METODO SIGUIENTE LO DEJAREMOS DE MAYOR A MENOR
        Collections.reverse(listaTurnosCPU);

    
        for(Personaje personaje: listaTurnosCPU){
            System.out.println(personaje);
            
        }
        
        return listaTurnosCPU;
        
    }
    
    /*En este metodo creamos un ArrayList de ArrayList de enteros de aquellas casillas
    no adyacentes
    */
    
    public ArrayList<ArrayList<Integer>> casillasFueraRango(int fila, int columna){
        System.out.println(fila + "," + columna);
        
        ArrayList<ArrayList<Integer>> posicionesDeshabilitadas = new ArrayList<>();
        for(int i = 0; i < 25; i++){
            for( int j = 0; j < 25; j++){
                ArrayList<Integer> posicion = new ArrayList<>();
                if((fila==i || fila==(i+2) || fila==(i-2) || fila==(i+1) || fila==(i-1)) && (columna==j || columna==(j+2) || columna==(j-2) || columna==(j+1) || columna==(j-1))){
                    posicion.add(i);
                    posicion.add(j);
                    posicionesDeshabilitadas.add(posicion);
                    System.out.println(posicion);
                }
            }
        }
        System.out.println(posicionesDeshabilitadas);
        return posicionesDeshabilitadas;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public void eliminarPersonaje(){}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
