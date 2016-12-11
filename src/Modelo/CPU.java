
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
    public void movimientoCPU(Personaje personajeCPU, ArrayList<Personaje> personajesUsuario){
        
        ArrayList<Double> distancias = new ArrayList<>();
        double filaCPU = personajeCPU.getPosX();
        double columnaCPU = personajeCPU.getPosY();
        
        for(Personaje personajeUsuario: personajesUsuario){
            double filaUsuario = personajeUsuario.getPosX();
            double columnaUsuario = personajeUsuario.getPosY();
            double distancia;
            
            distancia = Math.sqrt(Math.pow(filaCPU + filaUsuario, 2) + Math.pow(columnaCPU + columnaUsuario, 2));
            distancias.add(distancia);
        }
        
        Collections.sort(distancias);
        
        for(double h: distancias ){
            System.out.println(h);
            
        }
        
        double min = distancias.get(0);
       
    }
    public void ataqueCPU(Personaje personaje, int x, int y){}
}