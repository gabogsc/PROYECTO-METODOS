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
import Controlador.ControladorLogin;
import static Controlador.ControladorLogin.nombrePP;
import static Controlador.ControladorLogin.nombrePS;
import static Controlador.ControladorLogin.rolPP;
import static Controlador.ControladorLogin.rolPS;
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
    private ControladorLogin cl;
    private Escenario esc = new Escenario();
    private VistaTablero vt = new VistaTablero();
    private boolean flagTurno = true;
    private boolean flagMover = false;
    private boolean flagAtacar = false;
    private boolean flagTurnoCPU;
    private boolean flagMoverCPU=false;
    private boolean flagAtacarCPU=false;
    private int contadorMovimientos;
    ArrayList<Personaje> personajesOrdenadosU;
    ArrayList<Personaje> personajesOrdenadosCPU;
    Personaje jugador;
    Personaje personCPU;
    int filaActual = 0;
    int columnaActual = 0;
    int filaAnterior = 0;
    int columnaAnterior = 0;
    
    
    
    

    
   
    
    
    public ControladorTablero(int tipoDeAsignatura){
        // TIPO DE ASIGNATURA QUE ELIGIO EL USUARIO
        bat=new Batalla();
        cpu = new CPU();
        this.vt.getBtnVerificarTerminar().setEnabled(false);
        this.vt.getBtnCancelarTerminar().setEnabled(false);
        this.vt.getBtnCancelarAtacar().setEnabled(false);
        this.vt.getBtnCancelarMover().setEnabled(false);

        
        if(tipoDeAsignatura == 0){
            
            this.esc.GenerarTerrenoAreaPlanComun();
            this.esc.RevisarRios();
            this.esc.posicionarPjesCPU();
            this.esc.PosicionarPjesUsuario(nombrePP,rolPP,nombrePS,rolPS);

            
        }   
        else if(tipoDeAsignatura == 1){
            
            this.esc.GenerarTerrenoAreaDeEspecialidad();
            this.esc.RevisarRios();
            this.esc.posicionarPjesCPU();
            this.esc.PosicionarPjesUsuario(nombrePP,rolPP,nombrePS,rolPS);

        }
        else if(tipoDeAsignatura == 2){
        
            this.esc.GenerarTerrenoAreaDeEconomia();
            this.esc.RevisarRios();
            this.esc.posicionarPjesCPU();
            this.esc.PosicionarPjesUsuario(nombrePP,rolPP,nombrePS,rolPS);

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
                
            
                
                if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getBandoPersonaje().equals("malo")){    
                    if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje().equals("Guerrero")){

                       this.vt.getMatrizVista()[i][j].setText("G");
                       this.vt.getMatrizVista()[i][j].setForeground(Color.red);

                    }

                    else if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje().equals("Arquero")){

                        this.vt.getMatrizVista()[i][j].setText("A");
                        this.vt.getMatrizVista()[i][j].setForeground(Color.red);

                    }
                }

            }
    
        }

        // REPRESENTACION DE LOS PERSONAJES DEL USUARIO EN EL TABLERO
        
        for (int i = 0;i<25; i++){
            for(int j=0; j< 25; j++){
                
                System.out.println(this.esc.getMatrizEscenario()[i][j].getPersonaje().getNombrePersonaje());
                System.out.println(this.esc.getMatrizEscenario()[i][j].getPersonaje().getBandoPersonaje());
                System.out.println(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje());
                System.out.println(this.esc.getMatrizEscenario()[i][j].getPersonaje().getTipoPersonaje());
                if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getBandoPersonaje().equals("bueno")){    
                    if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje().equals("Guerrero")){

                       this.vt.getMatrizVista()[i][j].setText("G");
                       this.vt.getMatrizVista()[i][j].setForeground(Color.GREEN);

                    }

                    else if(this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje().equals("Arquero")){

                        this.vt.getMatrizVista()[i][j].setText("A");
                        this.vt.getMatrizVista()[i][j].setForeground(Color.GREEN);

                    }
                }
            }
        }
        
        for(Personaje personaje: this.esc.ordenarTurnosUsuario()){
            System.out.println(personaje.getPosX() + "," + personaje.getPosY());
        }
    
    personajesOrdenadosU = this.esc.ordenarTurnosUsuario();
    personajesOrdenadosCPU = this.esc.ordenarTurnosCPU();
    
    this.mostrarLeyenda();
    }    
    
    
    //MUESTRA UNA LEYENDA CON DATOS RESPECTO A AL CASILLA SOBRE LA QUE SE POSA EL CURSOR
        
    public void mostrarLeyenda(){
        
        for (int i = 0; i < 25; i++){
            for(int j = 0; j< 25; j++){
              
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
                if(this.esc.getMatrizEscenario()[i][j].isCaminable() == false && this.esc.getMatrizEscenario()[i][j].getTipoDeTerreno() != 3){
                    
                    rol = "Rol del personaje: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje() + "<br/>";
                    nombre = "Nombre: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getNombrePersonaje() + "<br/>";
                    traicion = "-Nivel de Traicion: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosTraicion() + " ptos";
                    puntosAtaqueLargo = "-Ataque Largo: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosAtaqueLargo() + " ptos" + "<br/>";
                    puntosAtaqueCorto = "-Ataque Corto: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosAtaqueCorto() + " ptos" + "<br/>";
                    vida = "-Vida: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosVidaTotal() + " ptos" + "<br/>";
                    defensa = "-Defensa: " + this.esc.getMatrizEscenario()[i][j].getPersonaje().getPuntosDefensa() + " ptos" + "<br/>";
                }
                else{
                    rol = "" + "<br/>";
                }                               

                UIManager.put("ToolTip.background", new ColorUIResource(255, 247, 200)); 
                Border border = BorderFactory.createLineBorder(new Color(76,79,83)); 
                UIManager.put("ToolTip.border", border);
                ToolTipManager.sharedInstance().setDismissDelay(5000); // 15 second delay  
                this.vt.getMatrizVista()[i][j].setToolTipText("<html>"+ coordenadas + altura + disponibilidad + terreno + nombre + rol + "<br/>" + vida + defensa + puntosAtaqueLargo + puntosAtaqueCorto + traicion + ".<html>"); // Message to display
                //System.out.println("El ROL DEL PJE En " + i + "," + j  + "es"+ this.esc.getMatrizEscenario()[i][j].getPersonaje().getRolPersonaje());
            } 
        }
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.mostrarLeyenda();
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
        personCPU = personajeCPU;
        System.out.println("posicion " + fila + "," + columna);
        
        //EVENTOS RELACIONADOS A LA PULSACION DE UN BOTON
        
        if(flagTurno){

        //PRESIONAR BOTON MOVER
        
            if(e.getSource() == this.vt.getBtnMover()){
                
                this.vt.getBtnCancelarMover().setEnabled(true);
                this.vt.getBtnMover().setEnabled(false);
                
                if(contadorMovimientos <= 3){
                    if(contadorMovimientos == 3){
                        this.vt.getBtnMover().setEnabled(false);


                        for(ArrayList<Integer> posicion: this.esc.casillasEnRango(fila, columna)){
                            for (int i = 0; i < 25; i++){
                                for(int j = 0; j < 25; j++){
                                    Border borde1;
                                    Border borde2;
                                    if((posicion.get(0)) != i && (posicion.get(1)) != j && this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getTipoDeTerreno() != 3
                                            && this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].isCaminable() == true){

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
                        for(ArrayList<Integer> posicion: this.esc.casillasEnRango(fila, columna)){
                            for (int i = 0;i<25; i++){
                                for(int j=0; j< 25; j++){
                                    Border borde1;
                                    Border borde2;
                                    if((posicion.get(0)) != i && (posicion.get(1)) != j && this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getTipoDeTerreno() != 3
                                            && this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].isCaminable() == true){
                                        
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
                this.vt.getBtnCancelarAtacar().setEnabled(true);
                this.vt.getBtnAtacar().setEnabled(false);
                if(contadorMovimientos > 0){
                    this.vt.getBtnMover().setEnabled(false);
                }
                
                for(ArrayList<Integer> posicion: this.esc.casillasEnRangoAtaque(fila, columna)){
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
                
                
                
                this.vt.getBtnVerificarTerminar().setEnabled(true);
                this.vt.getBtnCancelarTerminar().setEnabled(true);
                this.vt.getBtnTerminar().setEnabled(false);
                
                
                flagTurnoCPU = true;
                flagTurno = false;
                
            }   
        } 
        
        //EVENTOS RELACIONADOS AL MOVIMIENTO EL PERSONAJE
        
        else if(flagMover){
            System.out.println("El rol actual es:" + this.esc.getMatrizEscenario()[fila][columna].getPersonaje().getRolPersonaje());
            
            for(ArrayList<Integer> posicion: this.esc.casillasEnRango(fila, columna)){
                if(e.getSource() == this.vt.matrizVista[posicion.get(0)][posicion.get(1)] && this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getTipoDeTerreno() != 3
                        && this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].isCaminable() == true){
                    
                    this.vt.getBtnMover().setEnabled(true);
                    this.vt.getBtnCancelarMover().setEnabled(false);
                    
                    
            //ELIMINAMOS LOS BORDES    
            
                    for(ArrayList<Integer> mismaPosicion: this.esc.casillasEnRango(fila, columna)){
                        this.vt.getMatrizVista()[mismaPosicion.get(0)][mismaPosicion.get(1)].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    }
                    
                    int alturaFinal = this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getAltura();
                //MOVIMIENTO INHABILITADO POR TIPO DE TERRENO RIO
                    if(this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getTipoDeTerreno()==3){
                        contadorMovimientos = contadorMovimientos;
                    }
                //MOVIMIENTO INHABILITADO POR DIFERENCIA DE ALTURAS Y PRESENCIA DE PERSONAJES
                    else{
                        if(alturaFinal - alturaInicial > 2 || alturaFinal - alturaInicial < (-2)){
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
                                        this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(jugador);
                                        
                                    }

                                    else if(personaje.getRolPersonaje().equals("Arquero")){
                                        this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("A");
                                        this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(jugador);
                                    }

                                    this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setForeground(Color.GREEN);
                                    this.vt.matrizVista[fila][columna].setText("");
                                }
                                
                                esc.getMatrizEscenario()[fila][columna].setCaminable(true);
                                System.out.println("posicion despues de mover "+posicion.get(0)+","+posicion.get(1));
                                esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(false);
                                personaje.setPosX(posicion.get(0));
                                personaje.setPosY(posicion.get(1));
                                esc.moverAtributos(jugador, posicion.get(0), posicion.get(1));
                                
                                this.mostrarLeyenda();
                                
                                flagMover = false;
                                flagTurno = true;
                                        
                                contadorMovimientos++;
                            }
                        }
                    }
                }
                
                else if(e.getSource() == this.vt.getBtnCancelarMover()){
                    
                    this.vt.getBtnCancelarMover().setEnabled(false);
                    this.vt.getBtnMover().setEnabled(true);
                    
                    //ELIMINAMOS LOS BORDES    
            
                    for(ArrayList<Integer> mismaPosicion: this.esc.casillasEnRango(fila, columna)){
                        this.vt.getMatrizVista()[mismaPosicion.get(0)][mismaPosicion.get(1)].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    }
                    
                    flagMover = false;
                    flagTurno = true;
                }
            }
            
            
        }
        
        //EVENTOS RELACIONADOS AL ATAQUE DEL PERSONAJE
        
        else if(flagAtacar){
            
            for(ArrayList<Integer> posicion: this.esc.casillasEnRangoAtaque(fila, columna)){
                if(e.getSource() == this.vt.matrizVista[posicion.get(0)][posicion.get(1)]  && this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].getPersonaje().getRolPersonaje() != ""){
                    
                    this.vt.getBtnCancelarAtacar().setEnabled(false);
                    
            //ELIMINAMOS LOS BORDES
                    for(ArrayList<Integer> mismaPosicion: this.esc.casillasEnRangoAtaque(fila, columna)){
                        this.vt.getMatrizVista()[mismaPosicion.get(0)][mismaPosicion.get(1)].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    }
                    
            
            //CASOS ATAQUE A CORTA DISTANCIA
                    if(posicion.get(0) == fila && (posicion.get(1) == columna+1||posicion.get(1) == columna+2||posicion.get(1)==columna-1||posicion.get(1)==columna-2)){
                        System.out.println("ATAQUE CORTO MUMU");
                        if(this.vt.matrizVista[posicion.get(0)][posicion.get(1)].getText().equals("")){
                            System.out.println("NO HAY PERSONAJE");
                        }else{
                            Personaje enemigo=this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].obtenerPersonaje();
                            bct=new ControladorBatallaCorta(personaje,enemigo);
                            vt.getBtnAtacar().setEnabled(false);
                            if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            
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
                            vt.getBtnAtacar().setEnabled(false);
                            if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
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
                            vt.getBtnAtacar().setEnabled(false);
                            if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
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
                            vt.getBtnAtacar().setEnabled(false);
                            if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            
                            
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            vt.getBtnAtacar().setEnabled(false);
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
                                JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                                if(enemigo.getPuntosVidaTotal()<=0){
                                System.out.println("personaje mmuerto");
                                Personaje personajeAux=new Personaje();
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setPersonaje(personajeAux);
                                this.vt.matrizVista[posicion.get(0)][posicion.get(1)].setText("");
                                this.esc.getMatrizEscenario()[posicion.get(0)][posicion.get(1)].setCaminable(true);
                                int xCPU=enemigo.getPosX();
                                int yCPU=enemigo.getPosY();
                                for(int i=0;i<personajesOrdenadosCPU.size();i++){
                                    if(personajesOrdenadosCPU.get(i).getPosX()==xCPU &&personajesOrdenadosCPU.get(i).getPosY()==yCPU){
                                        personajesOrdenadosCPU.remove(i);
                                        System.out.println("se removio personaje");
                                        break;
                                    }else{
                                        
                                    }
                                }
                            }else{
                                
                            }
                            }
                            vt.getBtnAtacar().setEnabled(false);
                            flagAtacar=false;
                            flagTurno=true;
                        }
                    }                      
                }
                
                else if(e.getSource() == this.vt.getBtnCancelarAtacar()){
                    
                    this.vt.getBtnCancelarAtacar().setEnabled(false);
                    this.vt.getBtnAtacar().setEnabled(true);
                    
                    //ELIMINAMOS LOS BORDES
                    for(ArrayList<Integer> mismaPosicion: this.esc.casillasEnRangoAtaque(fila, columna)){
                        this.vt.getMatrizVista()[mismaPosicion.get(0)][mismaPosicion.get(1)].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    }
                    
                    flagAtacar = false;
                    flagTurno = true;
                }
            }
        }
        
        else if(flagTurnoCPU){
            
            System.out.println("turno de:"+personajeCPU.getPosX()+","+personajeCPU.getPosY());
            if(e.getSource() == this.vt.getBtnVerificarTerminar()){
                
                this.vt.getBtnCancelarTerminar().setEnabled(false);
                this.vt.getBtnVerificarTerminar().setEnabled(false);
                this.vt.getBtnTerminar().setEnabled(true);
                
                personajesOrdenadosU.remove(0);
                personajesOrdenadosU.add(jugador);
                contadorMovimientos=0;
                JOptionPane.showMessageDialog(null,"Turno Computadora");
                vt.getBtnAtacar().setEnabled(true);
                vt.getBtnMover().setEnabled(true);
                
                flagMoverCPU = true;
                flagTurnoCPU = false;
                vt.getBtnTerminar().doClick();
                
            }
            
            else if(e.getSource() == this.vt.getBtnCancelarTerminar()){
                
                this.vt.getBtnCancelarTerminar().setEnabled(false);
                this.vt.getBtnVerificarTerminar().setEnabled(false);
                this.vt.getBtnTerminar().setEnabled(true);
                flagTurnoCPU = false;
                flagTurno = true;
            } 
        }
        
        else if(flagMoverCPU){
                Personaje PersonajeUsuarioMasCerca = this.cpu.personajeMasCercano(personajeCPU, personajesOrdenadosU);
                
                
            for(int a = 0; a < 4; a++){
                //try{
                  //  Thread.sleep(500);
                //}catch(InterruptedException ie){
                  //  System.out.println("Errror");
                    //
                //}   
                System.out.println("nyus");
                if( (personajeCPU.getPosX()+1 != PersonajeUsuarioMasCerca.getPosX() || personajeCPU.getPosX()-1 != PersonajeUsuarioMasCerca.getPosX()  ) && personajeCPU.getPosX() < PersonajeUsuarioMasCerca.getPosX() ){
                       
            
                    if(this.esc.getMatrizEscenario()[personajeCPU.getPosX()+1][personajeCPU.getPosY()].getTipoDeTerreno() != 3 && this.esc.getMatrizEscenario()[personajeCPU.getPosX()+1][personajeCPU.getPosY()].isCaminable() == true){
            
                        // SETEO POSICION X + 1
                            
                       // System.out.println(this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()].getTipoDeTerreno());
                        
                        if (this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("G")){
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosX(personajeCPU.getPosX()+1);
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("G");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());
                        }
                        
                        else if(this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("A")){
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosX(personajeCPU.getPosX()+1); 
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("A");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());
   
                        }
                        
                        
                    }    

                }
        
                else if( (personajeCPU.getPosX()+1 != PersonajeUsuarioMasCerca.getPosX() || personajeCPU.getPosX()-1 != PersonajeUsuarioMasCerca.getPosX()  ) && personajeCPU.getPosX() > PersonajeUsuarioMasCerca.getPosX() ){
                    
                    if(this.esc.getMatrizEscenario()[personajeCPU.getPosX()-1][personajeCPU.getPosY()].getTipoDeTerreno() != 3 && this.esc.getMatrizEscenario()[personajeCPU.getPosX()-1][personajeCPU.getPosY()].isCaminable() == true){
                        // SETEO POSICION X -1
                        System.out.println(this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()].getTipoDeTerreno());
                        
                        
                        if (this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("G")){
                        
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosX(personajeCPU.getPosX()-1);
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("G");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());
                     
                        }
                        else if(this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("A")){
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosX(personajeCPU.getPosX()-1);
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("A");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());
                    
                        }
                    
                    }    

                }
                
                else if( (personajeCPU.getPosY()+1 != PersonajeUsuarioMasCerca.getPosY() || personajeCPU.getPosY()-1 != PersonajeUsuarioMasCerca.getPosY()  ) && personajeCPU.getPosY() < PersonajeUsuarioMasCerca.getPosY() ){
                    
                    if(this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()+1].getTipoDeTerreno() != 3 && this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()+1].isCaminable() == true){
                        // SETEO POSICION Y + 1
                        System.out.println(this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()].getTipoDeTerreno());
                        
                        
                        if (this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("G")){
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosY(personajeCPU.getPosY()+1);
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("G");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());
                        }
                        else if(this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("A")){
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosY(personajeCPU.getPosY()+1);
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("A");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());
                            
                        }
                    }

                }
                else if( (personajeCPU.getPosY()+1 != PersonajeUsuarioMasCerca.getPosY() || personajeCPU.getPosY()-1 != PersonajeUsuarioMasCerca.getPosY()  ) && personajeCPU.getPosY() > PersonajeUsuarioMasCerca.getPosY() ){
                    
                    if(this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()-1].getTipoDeTerreno() != 3 && this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()-1].isCaminable() == true){
                        // SETEO POSICION Y - 1
                        System.out.println(this.esc.getMatrizEscenario()[personajeCPU.getPosX()][personajeCPU.getPosY()].getTipoDeTerreno());
                        
                        
                        
                        
                        if (this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("G")){
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosY(personajeCPU.getPosY()-1);
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("G");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());

                        }
                        else if(this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].getText().equals("A")){
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText(null);
                            personajeCPU.setPosY(personajeCPU.getPosY()-1);
                            this.vt.matrizVista[personajeCPU.getPosX()][personajeCPU.getPosY()].setText("A");
                            this.vt.getMatrizVista()[personajeCPU.getPosX()][personajeCPU.getPosY()].setForeground(Color.red);
                            esc.moverAtributos(personajeCPU, personajeCPU.getPosX(), personajeCPU.getPosY());
                            System.out.println("nueva pos");
                            System.out.println(personajeCPU.getPosX()+","+personaje.getPosY());
                        }
                    
                    
                    }

                }else{

                    //PASAR
                    System.out.println("TURNO CPU OBLIGADO A PASAR");

                }

                System.out.println("COORDENADAS SETEADAS PERSONAJE");
                System.out.println(personajeCPU.getPosX()+","+personajeCPU.getPosY());    


            }
            
            flagMoverCPU=false;
            flagAtacarCPU=true;
            vt.getBtnTerminar().doClick();
           
        }
        
        else if(flagAtacarCPU){
            int x=personajeCPU.getPosX();
            int y=personajeCPU.getPosY();
            Personaje personajeUsuarioMasCerca = this.cpu.personajeMasCercano(personajeCPU, personajesOrdenadosU);
            int posX=personajeUsuarioMasCerca.getPosX();
            int posY=personajeUsuarioMasCerca.getPosY();
            if(posY==y && (posX==x+1||posX==x+2||posX==x-1||posX==x-2)){
                Personaje personajeUs=esc.getMatrizEscenario()[posX][posY].getPersonaje();
                bct=new ControladorBatallaCorta(personajeUs,personajeCPU);
            }else if(posX==x && (posY==y+1||posY==y+2||posY==y-1||posY==y-2)){
                Personaje personajeUs=esc.getMatrizEscenario()[posX][posY].getPersonaje();
                bct=new ControladorBatallaCorta(personajeUs,personajeCPU);
            }else if(posX==x && (posY==y+5||posY==y-5||posY==y+6||posY==y-6||posY==y+7||posY==y-7||posY==y+8||posY==y-8)){
                Personaje personajeUs=this.esc.getMatrizEscenario()[posX][posY].obtenerPersonaje();
                int probabilidadFallo=this.esc.getMatrizEscenario()[posX][posY].getProbabilidadDeFallo();
                int resultado=bat.atacarLargo(probabilidadFallo, personajeCPU, personajeUs);
                if(resultado==0){
                    JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                }else{
                    int vidaEnemigo=personajeUs.getPuntosVidaTotal();
                    JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                }
            }else if(posY==y && (posX==x+5||posX==x-5||posX==x+6||posX==x-6||posX==x+7||posX==x-7||posX==x+8||posX==x-8)){
                Personaje personajeUs=this.esc.getMatrizEscenario()[posX][posY].obtenerPersonaje();
                int probabilidadFallo=this.esc.getMatrizEscenario()[posX][posY].getProbabilidadDeFallo();
                int resultado=bat.atacarLargo(probabilidadFallo, personajeCPU, personajeUs);
                if(resultado==0){
                    JOptionPane.showMessageDialog(null,"EL ATAQUE FALLO :c");
                }else{
                    int vidaEnemigo=personajeUs.getPuntosVidaTotal();
                    JOptionPane.showMessageDialog(null,"VIDA RESTANTE:"+vidaEnemigo);
                }
            }
            personajesOrdenadosCPU.remove(0);
            personajesOrdenadosCPU.add(personCPU);
            flagAtacarCPU=false;
            flagTurno=true;
            //vt.getBtnTerminar().doClick();
            
        }
        
    }  
}


    
        



        
        
        
        
     

            
            
            
            
            
            
            
            
        
        
        
        
        
        
        
       
    
    
    
    
    
    
    
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
