/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Casilla;
import Modelo.Escenario;
import Modelo.Batalla;
import Modelo.CPU;
import Modelo.Personaje;
import Vista.VistaRamosCivil;
import Vista.VistaTablero;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;


/**
 *
 * @author Gabriel
 */
public class ControladorTablero implements ActionListener{
    private ControladorBatallaCorta bct;
    private Batalla bat;
    private CPU cpu;
    private Escenario esc = new Escenario();
    private VistaTablero vt = new VistaTablero();
    private boolean flagTurno = true;
    private boolean flagMover = false;
    private boolean flagAtacar = false;
    private boolean flagTurnoCPU;
    private int contadorMovimientos;
    ArrayList<Personaje> personajesOrdenadosU;
    ArrayList<Personaje> personajesOrdenadosCPU;
    Personaje jugador;
    
    

    
   
    
    
    public ControladorTablero(int tipoDeAsignatura){
        // TIPO DE ASIGNATURA QUE ELIGIO EL USUARIO
        bat=new Batalla();
        cpu = new CPU();
        
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
        
        //MUESTRA UNA LEYENDA CON DATOS RESPECTO A AL CASILLA SOBRE LA QUE SE POSA EL CURSOR
        
        for (int i = 0;i<25; i++){
            for(int j=0; j< 25; j++){
              
                String disponibilidad;
                String terreno;
                String altura;
                String rol;
                String puntosAtaqueLargo = "";
                String puntosAtaqueCorto = "";
                String traicion = "";
                String vida = "";
                String nombre = "";
                String defensa = "";
                
            //POSICION
                String coordenadas = "Posicion: " + (i+","+j) + "<br/>";
                
            //ALTURA
                altura = "Altura: " + this.esc.getMatrizEscenario()[i][j].getAltura() + "<br/>";
                
            //CAMINABLE
                if (this.esc.getMatrizEscenario()[i][j].isCaminable() == true){
                    disponibilidad = "Disponibilidad: Caminable" + "<br/>";
                }
                else{
                    disponibilidad = "Disponibilidad: No Caminable" + "<br/>";
                }
                
            //TIPO TERRENO
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
                
            //ROL, TRAICION, ATAQUE LARGO Y CORTO, VIDA Y DEFENSA
                if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() != ""){
                    rol = "Rol del personaje: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() + "<br/>";
                    traicion = "-Nivel de Traicion: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosTraicion() + " ptos";
                    puntosAtaqueLargo = "-Ataque Largo: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosAtaqueLargo() + " ptos" + "<br/>";
                    puntosAtaqueCorto = "-Ataque Corto: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosAtaqueCorto() + " ptos" + "<br/>";
                    vida = "-Vida: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosVidaActual() + " ptos" + "<br/>";
                    defensa = "-Defensa: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosDefensa() + " ptos" + "<br/>";
                }
                else{
                    rol = "" + "<br/>";
                }                               

                UIManager.put("ToolTip.background", new ColorUIResource(255, 247, 200)); 
                Border border = BorderFactory.createLineBorder(new Color(76,79,83)); 
                UIManager.put("ToolTip.border", border);
                ToolTipManager.sharedInstance().setDismissDelay(5000); // 15 second delay  
                this.vt.getMatrizVista()[i][j].setToolTipText("<html>"+ coordenadas + altura + disponibilidad + terreno + rol + "<br/>" + vida + defensa + puntosAtaqueLargo + puntosAtaqueCorto + traicion + ".<html>"); // Message to display
            }
        }
        
        for(Personaje personaje: this.esc.ordenarTurnosUsuario()){
            System.out.println(personaje.getPosX() + "," + personaje.getPosY());
        }
        personajesOrdenadosU = this.esc.ordenarTurnosUsuario();
        personajesOrdenadosCPU = this.esc.ordenarTurnosCPU();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //PRESIONAR BOTON REGRESAR
        if(e.getSource() == this.vt.getBtnRegresarVT()){
            vt.dispose();
            ControladorRamosCivil crc = new ControladorRamosCivil();
        }
        
        Personaje personaje = personajesOrdenadosU.get(0);
        Personaje personajeCPU = personajesOrdenadosCPU.get(0);
        int fila = personaje.getPosX();
        int columna = personaje.getPosY();
        int alturaInicial= this.esc.getMatrizEscenario()[fila][columna].getAltura();
        jugador = personaje;
        System.out.println("posicion " + fila + "," + columna);
        
        //EVENTOS RELACIONADOS A LA PULSACION DE UN BOTON
        
        if(flagTurno){

        //PRESIONAR BOTON MOVER
        
            if(e.getSource() == this.vt.getBtnMover()){
                if(contadorMovimientos <= 3){
                    if(contadorMovimientos==3){
                        this.vt.getBtnMover().setEnabled(false);

                        for(ArrayList<Integer> posicion: this.esc.casillasFueraDeRango(fila, columna)){
                            for (int i = 0; i < 25; i++){
                                for(int j = 0; j < 25; j++){
                                    Border borde1;
                                    Border borde2;
                                    if((posicion.get(0)) != i && (posicion.get(1)) != j){

                                        borde1 = BorderFactory.createRaisedBevelBorder();
                                        borde2 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN);
                                        this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setBorder(BorderFactory.createCompoundBorder(borde2, borde1));
                                        flagTurno = false;
                                        flagMover = true;
                                    }
                                }
                            }
                        }
                    }
                    
                    else{
                        for(ArrayList<Integer> posicion: this.esc.casillasFueraDeRango(fila, columna)){
                            for (int i = 0;i<25; i++){
                                for(int j=0; j< 25; j++){
                                    Border borde1;
                                    Border borde2;
                                    if((posicion.get(0)) != i && (posicion.get(1)) != j){
                                        borde1 = BorderFactory.createRaisedBevelBorder();
                                        borde2 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN);
                                        this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setBorder(BorderFactory.createCompoundBorder(borde2, borde1));
                                        flagTurno = false;
                                        flagMover = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
        //PRESIONAR BOTON ATACAR
            
            else if(e.getSource() == this.vt.getBtnAtacar()){
                
                if(contadorMovimientos > 0){
                    this.vt.getBtnMover().setEnabled(false);
                }
                
                for(ArrayList<Integer> posicion: this.esc.casillasFueraDeRangoAtaque(fila, columna)){
                    for (int i = 0;i<25; i++){
                        for(int j=0; j< 25; j++){
                            Border borde1;
                            Border borde2;
                            if((posicion.get(0)) != i && (posicion.get(1)) != j){
                                borde1 = BorderFactory.createRaisedBevelBorder();
                                borde2 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setBorder(BorderFactory.createCompoundBorder(borde2, borde1));
                                flagTurno = false;
                                flagAtacar = true;
                            }
                        }
                    }
                }
            }
            
        //PRESIONAR BOTON TERMINAR
            
            else if(e.getSource() == this.vt.getBtnTerminar()){
                this.cpu.personajeMasCercano(personajeCPU, personajesOrdenadosU);
                personajesOrdenadosU.remove(0);
                personajesOrdenadosU.add(jugador);
                vt.getBtnTerminar().setEnabled(false);
                flagTurno = false;
                flagTurnoCPU = true;
            }   
        } 
        
        //EVENTOS RELACIONADOS AL MOVIMIENTO EL PERSONAJE
        
        else if(flagMover){
            
            for(ArrayList<Integer> posicion: this.esc.casillasFueraDeRango(fila, columna)){
                if(e.getSource() == this.vt.matrizVista[posicion.get(0)][posicion.get(1)]){
                    
            //ELIMINAMOS LOS BORDES    
            
                    for(ArrayList<Integer> mismaPosicion: this.esc.casillasFueraDeRango(fila, columna)){
                        this.vt.getMatrizVista()[mismaPosicion.get(0)][mismaPosicion.get(1)].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    }
                    
                    int alturaFinal = this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getAltura();
                //MOVIMIENTO INHABILITADO POR TIPO DE TERRENO RIO
                    if(this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getTipoDeTerreno()==3){
                        contadorMovimientos = contadorMovimientos;
                    }
                //MOVIMIENTO INHABILITADO POR DIFERENCIA DE ALTURAS Y PRESENCIA DE PERSONAJES
                    else{
                        if(alturaFinal-alturaInicial > 2 || alturaFinal-alturaInicial < (-2)){
                            contadorMovimientos = contadorMovimientos;
                        }
                        else{
                            if(this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].isCaminable() == false){
                                contadorMovimientos = contadorMovimientos;
                            }
                            else{
                                if(personaje.getBandoPersonaje().equals("bueno")){
                                    if(personaje.getRolPersonaje().equals("Guerrero")){
                                        this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("G");
                                        this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personaje);
                                    }

                                    else{
                                        this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("A");
                                        this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personaje);
                                    }

                                    this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setForeground(Color.GREEN);
                                    this.vt.matrizVista[fila][columna].setText("");
                                }
                                
                                this.esc.getMatrizEscenario()[fila][columna].setCaminable(true);
                                System.out.println("posicion despues de mover "+posicion.get(0)+","+posicion.get(1));
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(false);
                                personaje.setPosX(posicion.get(0));
                                personaje.setPosY(posicion.get(1));
                                flagMover = false;
                                flagTurno = true;
                                contadorMovimientos++;
                            }
                        }
                    }
                }
            }
        }
        
        //EVENTOS RELACIONADOS AL ATAQUE DEL PERSONAJE
        
        else if(flagAtacar){
            
            this.vt.getBtnAtacar().setEnabled(false);
            
            for(ArrayList<Integer> posicion: this.esc.casillasFueraDeRangoAtaque(fila, columna)){
                if(e.getSource() == this.vt.matrizVista[posicion.get(0)][posicion.get(1)]){
                    
            //ELIMINAMOS LOS BORDES
                    for(ArrayList<Integer> mismaPosicion: this.esc.casillasFueraDeRangoAtaque(fila, columna)){
                        this.vt.getMatrizVista()[mismaPosicion.get(0)][mismaPosicion.get(1)].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    }
                    
                    if(posicion.get(0)==fila&&(posicion.get(1)==columna+1||posicion.get(1)==columna+2||posicion.get(1)==columna-1||posicion.get(1)==columna-2)){
                        System.out.println("ATAQUE CORTO MUMU");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");
                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            bct=new ControladorBatallaCorta(personaje,enemigo);
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if(posicion.get(1)==columna&&(posicion.get(0)==fila+1||posicion.get(0)==fila+2||posicion.get(0)==fila-1||posicion.get(0)==fila-2)){
                        System.out.println("ATAQUE CORTO MUMU");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");
                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            bct=new ControladorBatallaCorta(personaje,enemigo);
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if(posicion.get(0)==fila+1&&(posicion.get(1)==columna-1||posicion.get(1)==columna+1)){
                        System.out.println("ATAQUE CORTO MUMU");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            bct=new ControladorBatallaCorta(personaje,enemigo);
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if(posicion.get(0)==fila-1&&(posicion.get(1)==columna-1||posicion.get(1)==columna+1)){
                        System.out.println("ATAQUE CORTO MUMU");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");
                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            bct=new ControladorBatallaCorta(personaje,enemigo);
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if(posicion.get(1)==columna&&(posicion.get(0)==fila+5||posicion.get(0)==fila+6||posicion.get(0)==fila+7||posicion.get(0)==fila+8||posicion.get(0)==fila-5||posicion.get(0)==fila-6||posicion.get(0)==fila-7||posicion.get(0)==fila-8)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;

                        }
                    }else if(posicion.get(0)==fila&&(posicion.get(1)==columna+5||posicion.get(1)==columna+6||posicion.get(1)==columna+7||posicion.get(1)==columna+8||posicion.get(1)==columna-5||posicion.get(1)==columna-6||posicion.get(1)==columna-7||posicion.get(1)==columna-8)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if ((posicion.get(0)==fila+5||posicion.get(0)==fila-5)&&(posicion.get(1)==columna+1||posicion.get(1)==columna+2||posicion.get(1)==columna+3||posicion.get(1)==columna-1||posicion.get(1)==columna-2||posicion.get(1)==columna-3)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if((posicion.get(0)==fila+6||posicion.get(0)==fila-6)&&(posicion.get(1)==columna+1||posicion.get(1)==columna+2||posicion.get(1)==columna-1||posicion.get(1)==columna-2)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if((posicion.get(0)==fila+7||posicion.get(0)==fila-7)&&(posicion.get(1)==columna+1||posicion.get(1)==columna-1)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if((posicion.get(0)==fila+4||posicion.get(0)==fila-4)&&(posicion.get(1)==columna+1||posicion.get(1)==columna+1||posicion.get(1)==columna+2||posicion.get(1)==columna+3||posicion.get(1)==columna+4||posicion.get(1)==columna-1||posicion.get(1)==columna-2||posicion.get(1)==columna-3||posicion.get(1)==columna-4)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if((posicion.get(0)==fila+3||posicion.get(0)==fila-3)&&(posicion.get(1)==columna+2||posicion.get(1)==columna+3||posicion.get(1)==columna+4||posicion.get(1)==columna+5||posicion.get(1)==columna-2||posicion.get(1)==columna-3||posicion.get(1)==columna-4||posicion.get(1)==columna-5)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if((posicion.get(0)==fila+2||posicion.get(0)==fila-2)&&(posicion.get(1)==columna+3||posicion.get(1)==columna+4||posicion.get(1)==columna+5||posicion.get(1)==columna+6||posicion.get(1)==columna-3||posicion.get(1)==columna-4||posicion.get(1)==columna-5||posicion.get(1)==columna-6)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }else if((posicion.get(0)==fila+1||posicion.get(0)==fila-1)&&(posicion.get(1)==columna+4||posicion.get(1)==columna+5||posicion.get(1)==columna+6||posicion.get(1)==columna+7||posicion.get(1)==columna-4||posicion.get(1)==columna-5||posicion.get(1)==columna-6||posicion.get(1)==columna-7)){
                        System.out.println("ATAQUE LARGO OINK");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");

                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            int probabilidadFallo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getProbabilidadDeFallo();
                            int resultado=bat.atacarLargo(probabilidadFallo, jugador, enemigo);
                            if(resultado==0){
                                JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                            }else{
                                int vidaEnemigo=enemigo.getPuntosVidaTotal();
                                JOptionPane.showMessageDialog(null,"DAÑOS AL PERSONAJE:"+vidaEnemigo);
                            }
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }                      
                }
            }
        }
        
        else if(flagTurnoCPU){
            
            contadorMovimientos=0;
            JOptionPane.showMessageDialog(null,"AUN NO HAGO NADA D: XD");
            vt.getBtnAtacar().setEnabled(true);
            vt.getBtnMover().setEnabled(true);
            vt.getBtnTerminar().setEnabled(true);
            flagTurnoCPU=false;
            flagTurno=true;
        }  
    }
}

    
        



        
        
        
        
     

            
            
            
            
            
            
            
            
        
        
        
        
        
        
        
       
    
    
    
    
    
    
    
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
