
package Modelo;

import java.util.ArrayList;


public class CPU {
    


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
        
        System.out.println(distancias);
    }
    public void ataqueCPU(Personaje personaje, int x, int y){}
}