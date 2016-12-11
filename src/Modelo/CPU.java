
package Modelo;

import java.util.ArrayList;

import Modelo.Escenario;
import Modelo.Personaje;
import java.util.*;
import Modelo.Escenario;
import java.util.stream.Collectors;

public class CPU {
    private Escenario es;
    public CPU() {
    
        es=new Escenario();
   
    }

    // METODOS
    public Personaje personajeMasCercano(Personaje personajeCPU, ArrayList<Personaje> personajesUsuario){
        
        ArrayList<Double> distancias = new ArrayList<>();
        ArrayList<Double> distanciasOrdenadas = new ArrayList<>();
        Personaje pjeMasCercano = new Personaje();
        double filaCPU = personajeCPU.getPosX();
        double columnaCPU = personajeCPU.getPosY();
        
        for(Personaje personajeUsuario: personajesUsuario){
            double filaUsuario = personajeUsuario.getPosX();
            double columnaUsuario = personajeUsuario.getPosY();
            double distancia;
            //System.out.println("posicion Uusario" + personajeUsuario.getPosX() + "," + personajeUsuario.getPosY());
            distancia = Math.sqrt(Math.pow(filaCPU - filaUsuario, 2) + Math.pow(columnaCPU - columnaUsuario, 2));
            distancias.add(distancia);
            distanciasOrdenadas.add(distancia);
        }
        
    /*LA DISTANCIA MINIMA ENTRE LA CPU QUE ESTA EN TURNO, Y TODOS LOS PERSONAJES 
    ENEMIGO
    */
        Collections.sort(distanciasOrdenadas);
        
        double min = distanciasOrdenadas.get(0);
        //System.out.println(distancias);
        //System.out.println(distanciasOrdenadas);
    //ENCONTRAMOS AL PERSONAJE QUE PERTENECE LA DISTANCIA MENOR
        pjeMasCercano = personajesUsuario.get(distancias.indexOf(min));
        //System.out.println("Posicion lista personajes" + distancias.indexOf(min));
        System.out.println("Posicion CPU: " + personajeCPU.getPosX() + "," + personajeCPU.getPosY());
        System.out.println("Posicion Usuario: " + pjeMasCercano.getPosX() + "," + pjeMasCercano.getPosY());
        return pjeMasCercano;
    }
    
    
    
    
    
    
    
    
   public void MovimientoCPU(Personaje PersonajeUsuarioMasCerca, Personaje personajeCPU ){
       
    
       
       
       
       
        if( (personajeCPU.getPosX()+1 != PersonajeUsuarioMasCerca.getPosX() ||
                
                personajeCPU.getPosX()-1 != PersonajeUsuarioMasCerca.getPosX()  ) && 
                
			personajeCPU.getPosX() < PersonajeUsuarioMasCerca.getPosX() ){
                       
            
                        if(this.es.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()].getTipoDeTerreno() != 3){
            
                            // SETEO POSICION X + 1
                            
                            System.out.println(this.es.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()].getTipoDeTerreno());
                            personajeCPU.setPosX(personajeCPU.getPosX()+1);
                        
                        }    

        }
        
        else if( (personajeCPU.getPosX()+1 != PersonajeUsuarioMasCerca.getPosX() ||
                
                    personajeCPU.getPosX()-1 != PersonajeUsuarioMasCerca.getPosX()  ) && 
                
			personajeCPU.getPosX() > PersonajeUsuarioMasCerca.getPosX() ){
                        // SETEO POSICION X -1
                            personajeCPU.setPosX(personajeCPU.getPosX()-1);


        }
        else if( (personajeCPU.getPosY()+1 != PersonajeUsuarioMasCerca.getPosY() ||
                
                    personajeCPU.getPosY()-1 != PersonajeUsuarioMasCerca.getPosY()  ) && 
                
			personajeCPU.getPosY() < PersonajeUsuarioMasCerca.getPosY() ){
                        // SETEO POSICION Y + 1
                            personajeCPU.setPosY(personajeCPU.getPosY()+1);


        }
        else if( (personajeCPU.getPosY()+1 != PersonajeUsuarioMasCerca.getPosY() ||
                
                    personajeCPU.getPosY()-1 != PersonajeUsuarioMasCerca.getPosY()  ) && 
                
			personajeCPU.getPosY() > PersonajeUsuarioMasCerca.getPosY() ){
                        // SETEO POSICION Y - 1
                        personajeCPU.setPosY(personajeCPU.getPosY()-1);


        }else{
            
                // ATACAR 
        
        
        }
       
       System.out.println("COORDENADAS SETEADAS PERSONAJE");
       System.out.println(personajeCPU.getPosX()+","+personajeCPU.getPosY());    
       
    
   }

    
       
       
     
        
        
     
   
   
    
    public void ataqueCPU(Personaje personaje, int x, int y){}
}