
package Modelo;

import java.util.Objects;


public class Casilla {
    //Atributos
    private int probabilidadDeFallo;
    private int altura;
    private Personaje personaje;
    private int coordenadaX;
    private int coordenadaY;
    private boolean caminable;
    private int tipoDeTerreno;
    
    
    //Metodos
    
    
      
    
    //Constructor con parametros
    public Casilla(int coordenadaX , int coordenadaY,int tipoDeTerreno, int altura,int probabilidadDeFallo, Personaje personaje, boolean caminable) {
        
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.tipoDeTerreno = tipoDeTerreno;
        this.altura = altura;
       
        this.personaje = new Personaje();
        
        this.caminable = caminable;
        
        this.probabilidadDeFallo = probabilidadDeFallo;
    }
    
    //Constructor sin parametros
    public Casilla() {
        this.coordenadaX = 0;
        this.coordenadaY = 0;
        this.altura = 0;
        this.probabilidadDeFallo = 0;
        
        this.personaje = new Personaje();
        
        this.caminable = false;
        this.tipoDeTerreno = 0;
    }
    
    // METODOS 
        // COORDENADAS EN LAS CASILLAS
    public int getCoordenadaX() {
        return this.coordenadaX;
    }

    
    
    public int getCoordenadaY() {
        return this.coordenadaY;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

   
    
    public int getAltura() {
        return this.altura;
    }
     
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public Personaje obtenerPersonaje(){
        return this.personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
   
    
    
    
    
    
    
// WEAS QUE SE VEN DESPUES
    public int getProbabilidadDeFallo() {
        return probabilidadDeFallo;
    }

    public void setProbabilidadDeFallo(int probabilidadDeFallo) {
        this.probabilidadDeFallo = probabilidadDeFallo;
    }

   

    public Personaje getPersonaje() {
        return personaje;
    }

    //public void setPersonaje(Personaje personaje) {
        //this.personaje = personaje;
    //}

   
    public boolean isCaminable() {
        return caminable;
    }

    public void setCaminable(boolean caminable) {
        this.caminable = caminable;
    }

    public int getTipoDeTerreno() {
        return this.tipoDeTerreno;
    }

    public void setTipoDeTerreno(int tipoDeTerreno) {
        this.tipoDeTerreno = tipoDeTerreno;
    }

    @Override
    public String toString() {
        return "Casilla{" + "probabilidadDeFallo=" + probabilidadDeFallo + ", altura=" + altura + ", personaje=" + personaje + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", caminable=" + caminable + ", tipoDeTerreno=" + tipoDeTerreno + '}';
    }

    
    
}
