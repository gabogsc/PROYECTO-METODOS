/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Casilla;
import Modelo.Escenario;
import Modelo.Batalla;
import Modelo.Personaje;
import Vista.VistaRamosCivil;
import Vista.VistaTablero;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author Gabriel
 */
public class ControladorTablero implements ActionListener{
    private ControladorDefMonito cdm;
    private Escenario esc = new Escenario();
    private VistaTablero vt = new VistaTablero();
    private boolean flagTurno = true;
    private boolean flagMover = false;
    

    
   
    
    
    public ControladorTablero(int tipoDeAsignatura){
        // TIPO DE ASIGNATURA QUE ELIGIO EL USUARIO
        
        
        if(tipoDeAsignatura == 0){
            
            this.esc.GenerarTerrenoAreaPlanComun();
            this.esc.RevisarRios();
            this.esc.posicionarPjesCPU();
            this.esc.PosicionarPjesUsuario();

            
        }   
        else if(tipoDeAsignatura == 1){
            
            this.esc.GenerarTerrenoAreaDeEspecialidad();
            this.esc.RevisarRios();
            this.esc.posicionarPjesCPU();
            this.esc.PosicionarPjesUsuario();

        }
        else if(tipoDeAsignatura == 2){
        
            this.esc.GenerarTerrenoAreaDeEconomia();
            this.esc.RevisarRios();
            this.esc.posicionarPjesCPU();
            this.esc.PosicionarPjesUsuario();

        }
            
        
        this.vt.setVisible(true);
        vt.setTitle("Batalla");
        
        vt.agregarListener(this);
        
        //Al posar el raton sobre una de las casillas
        
        //Agregar nombre al personaje de la CPU en el tablero
        for (Personaje personaje: esc.getListaPersonajesCPU())
            this.vt.getMatrizVista()[personaje.getPosX()][personaje.getPosY()].setText(personaje.getRolPersonaje());
        
        
        // LOS TIPOS DE TERRENOS QUE SE GENERARAN CON SUS ALTURAS RESPECTIVAS
        for (int i = 0;i<25; i++){
            for(int j=0; j< 25; j++){
                
                

                // TIPO DE TERENO TIERRA
                if(this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno() == 0 ){
                    
                    // ALTURA "0" TIERRA
                       if(this.esc.getMatrizEscenario()[i][j].getAltura() == 0){
                        Color TonalidadTierra= new Color( 120, 66, 18 );
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadTierra);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("tierra");
                    }
                    // ALTURA "1" TIERRA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 1){
                        Color TonalidadTierra= new Color(147, 81, 22);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadTierra);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("tierra");
                    }
                    //ALTURA "2" TIERRA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 2){
                        Color TonalidadTierra= new Color( 202, 111, 30 );
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadTierra);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("tierra");
                    }
                    //ALTURA "3" TIERRA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 3){
                        Color TonalidadTierra= new Color( 230, 126, 34);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadTierra);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("tierra");
                    }
                    // ALTURA "4" TIERRA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 4){
                        Color TonalidadTierra= new Color( 245, 176, 65);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadTierra);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("tierra");
                    }   
                    // ALTURA "5" TIERRA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 5){
                        Color TonalidadTierra= new Color(250, 215, 160);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadTierra);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("tierra");
                    }      
                
                }
            
                
                // TIPO DE TERRENO BOSQUE
                else if(this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno() == 1 ){
                    
                    // ALTURA "0" BOSQUE
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 0){
                        Color TonalidadBosque= new Color( 0, 100, 0 );
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "1" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 1){
                        Color TonalidadBosque= new Color( 0, 115, 0 );
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "2" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 2){
                        Color TonalidadBosque= new Color( 0, 130, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "3" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 3){
                        Color TonalidadBosque= new Color( 0, 145, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "4" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 4){
                        Color TonalidadBosque= new Color( 0, 160, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "5" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 5){
                        Color TonalidadBosque= new Color( 0, 175, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "6" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 6){
                        Color TonalidadBosque= new Color( 0, 190, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "7" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 7){
                        Color TonalidadBosque= new Color( 0, 205, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "8" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 8){
                        Color TonalidadBosque= new Color( 0, 220, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "9" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 9){
                        Color TonalidadBosque= new Color( 0, 235, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "10" BOSQUE
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 10){
                        Color TonalidadBosque= new Color( 0, 250, 0);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadBosque);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                }
                
                
                // TIPO DE TERRENO MONTAÑA
                else if(this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno() == 2 ){
                    
                    // ALTURA "6" MONTAÑA
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 6){
                        Color TonalidadMontaña= new Color( 140, 140, 140);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadMontaña);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Montaña");
                    }
                    // ALTURA "7" MONTAÑA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 7){
                        Color TonalidadMontaña= new Color( 161, 161, 161);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadMontaña);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "8" MONTAÑA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 8){
                        Color TonalidadMontaña= new Color( 182, 182, 182);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadMontaña);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "9" MONTAÑA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 9){
                        Color TonalidadMontaña= new Color( 203, 203, 203);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadMontaña);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                    // ALTURA "10" MONTAÑA
                    else if(this.esc.getMatrizEscenario()[i][j].getAltura() == 10){
                        Color TonalidadMontaña= new Color( 224, 224,224);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadMontaña);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Bosque");
                    }
                }
                
                
                
                
                // TIPO DE TERRENO RIO
                else if(this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno() == 3 ){
                    // ALTURA "0" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 0){
                        Color TonalidadRio= new Color( 0, 0, 100);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "1" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 1){
                        Color TonalidadRio= new Color( 0, 0, 115);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "2" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 2){
                        Color TonalidadRio= new Color( 0, 0, 130);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "3" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 3){
                        Color TonalidadRio= new Color( 0, 0, 145);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "4" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 4){
                        Color TonalidadRio= new Color( 0, 0, 160);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "5" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 5){
                        Color TonalidadRio= new Color( 0, 0, 175);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "6" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 6){
                        Color TonalidadRio= new Color( 0, 0, 190);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "7" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 7){
                        Color TonalidadRio= new Color(0, 0, 205);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "8" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 8){
                        Color TonalidadRio= new Color(0, 0, 220);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "9" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 9){
                        Color TonalidadRio= new Color(0, 0, 235);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                     // ALTURA "10" RIO
                    if(this.esc.getMatrizEscenario()[i][j].getAltura() == 10){
                        Color TonalidadRio= new Color(0, 0, 250);
                        this.vt.getMatrizVista()[i][j].setBackground(TonalidadRio);
                        // PARA PROBAR COLORES
                        
                        //System.out.println("Rio");
                    }
                }
             
            }
        }
        

        
        

        // REPRESENTACION DE LOS PERSONAJES DE LA CPU EN EL TABLERO
        
        for (int i = 0;i<25; i++){
            for(int j=0; j< 25; j++){
                
            
                
                if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getBandoPersonaje() == "malo"){    
                    if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() == "Guerrero"){

                       this.vt.getMatrizVista()[i][j].setText("G");
                       this.vt.getMatrizVista()[i][j].setForeground(Color.red);

                    }

                    else if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() == "Arquero"){

                        this.vt.getMatrizVista()[i][j].setText("A");
                        this.vt.getMatrizVista()[i][j].setForeground(Color.red);

                    }
                }

            }
    
        }

        // REPRESENTACION DE LOS PERSONAJES DEL USUARIO EN EL TABLERO
        
        for (int i = 0;i<25; i++){
            for(int j=0; j< 25; j++){
                
            
                
                if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getBandoPersonaje() == "bueno"){    
                    if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() == "Guerrero"){

                       this.vt.getMatrizVista()[i][j].setText("G");
                       this.vt.getMatrizVista()[i][j].setForeground(Color.GREEN);

                    }

                    else if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() == "Arquero"){

                        this.vt.getMatrizVista()[i][j].setText("A");
                        this.vt.getMatrizVista()[i][j].setForeground(Color.GREEN);

                    }
                }

            }
    
        }
        
        //Mostrar datos por pantalla al usuario al posar el cursor sobre una de las casillas
        
        for (int i = 0;i<25; i++){
            for(int j=0; j< 25; j++){
              
                String disponibilidad = null;
                String terreno = null;
                String altura = null;
                String rol = null;
                
                //Definimos la coordenada en la que se posa el cursor
                String coordenadas = "Posicion: " + (i+","+j) + "<br/>";
                
                
                //Definimos la altura de la casilla
                altura = "Altura: " + this.esc.getMatrizEscenario()[i][j].getAltura() + "<br/>";
                
                
                //Ahora determinamos si la casilla en la que se posa el cursor es caminable
                if (this.esc.getMatrizEscenario()[i][j].isCaminable() == true){
                    disponibilidad = "Disponibilidad: Caminable" + "<br/>";
                }
                else{
                    disponibilidad = "Disponibilidad: No Caminable" + "<br/>";
                }
                
                
                //Ahora determinamos el tipo de terreno en el que se posa el cursor
                if(this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno()== 0){
                    terreno = "Tipo de terreno: Tierra" + "<br/>";
                }
                else if(this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno()== 1){
                    terreno = "Tipo de terreno: Bosque" + "<br/>";
                }
                else if(this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno()== 2){
                    terreno = "Tipo de terreno: Montaña" + "<br/>";
                }
                else{
                    terreno = "Tipo de terreno: Rio" + "<br/>";
                }
                
                
                //Determinamos el rol de personaje si existe en la casilla
                if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() != ""){
                    rol = "Rol del personaje: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje();
                }
                else{
                    rol = "";
                }

                this.vt.getMatrizVista()[i][j].setToolTipText("<html>"+ coordenadas + altura + disponibilidad + terreno + rol + ".<html>");
            }
        }
        
        for(Personaje personaje: this.esc.ordenarTurnosUsuario()){
            System.out.println(personaje.getPosX() + "," + personaje.getPosY());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(Personaje personaje: this.esc.ordenarTurnosUsuario()){
            int fila = personaje.getPosX();
            int columna = personaje.getPosY();

            if(flagTurno){

                if(e.getSource() == this.vt.getBtnRegresarVT()){

                }

                else if(e.getSource() == this.vt.getBtnMover()){
                    this.vt.getBtnMover().setEnabled(false);
                    for(ArrayList<Integer> posicion: this.esc.casillasEnRango(fila, columna)){
                        for (int i = 0;i<25; i++){
                            for(int j=0; j< 25; j++){
                                if((posicion.get(0)) != i && (posicion.get(1)) != j){
                                    this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setBackground(Color.ORANGE);
                                    flagTurno = false;
                                    flagMover = true;

                                }
                            }
                        }
                    }
                }

                else if (e.getSource() == vt.getAtaqueCorto()){
                    cdm= new ControladorDefMonito();
                }     
            }  

            else if(flagMover){
                for(ArrayList<Integer> posicion: this.esc.casillasEnRango(fila, columna)){
                    if(e.getSource() == this.vt.matrizVista[posicion.get(0)][posicion.get(1)]){
                        if(personaje.getBandoPersonaje() == "bueno"){
                            if(personaje.getRolPersonaje() == "Guerrero"){
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("G");
                            }

                            else{
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("A");

                            }

                            this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setForeground(Color.GREEN);
                            this.vt.matrizVista[fila][columna].setText("");
                            personaje.setPosX(fila);
                            personaje.setPosY(columna);
                            flagMover = false;
                            flagTurno = true;
                        }
                    }
                }
            }
        }  
    }
}

    
        



        
        
        
        
     

            
            
            
            
            
            
            
            
        
        
        
        
        
        
        
       
    
    
    
    
    
    
    
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
