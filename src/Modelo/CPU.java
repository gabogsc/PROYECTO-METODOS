
package Modelo;

import java.util.ArrayList;

import Modelo.Usuario;
import Modelo.Personaje;
import java.util.*;
import Modelo.Escenario;
import java.util.stream.Collectors;

public class CPU {

    public CPU() {
    
   
   
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
            System.out.println("posicion Uusario" + personajeUsuario.getPosX() + "," + personajeUsuario.getPosY());
            distancia = Math.sqrt(Math.pow(filaCPU - filaUsuario, 2) + Math.pow(columnaCPU - columnaUsuario, 2));
            distancias.add(distancia);
            distanciasOrdenadas.add(distancia);
        }
        
    /*LA DISTANCIA MINIMA ENTRE LA CPU QUE ESTA EN TURNO, Y TODOS LOS PERSONAJES 
    ENEMIGO
    */
        Collections.sort(distanciasOrdenadas);
        System.out.println("");
        double min = distanciasOrdenadas.get(0);
        System.out.println(distancias);
        System.out.println(distanciasOrdenadas);
    //ENCONTRAMOS AL PERSONAJE QUE PERTENECE LA DISTANCIA MENOR
        pjeMasCercano = personajesUsuario.get(distancias.indexOf(min));
        System.out.println("Posicion lista personajes" + distancias.indexOf(min));
        System.out.println("Posicion CPU: " + personajeCPU.getPosX() + "," + personajeCPU.getPosY());
        System.out.println("Posicion Usuario: " + pjeMasCercano.getPosX() + "," + pjeMasCercano.getPosY());
        return pjeMasCercano;
    }
    
    
    
    public void ataqueCPU(Personaje personaje, int x, int y){}
}