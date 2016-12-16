 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import static Controlador.ControladorRegistro.dinero;
import Vista.VistaAhorcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Ahorcado;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author arru
 */
public class ControladorAhorcado implements ActionListener {
    VistaAhorcado va;
    ControladorPrincipalAhorcado cp;
    ControladorTopicos ct;
    Ahorcado ahorcado;
    ArrayList<String> palabras;
    String palabrita;
    char[] palabraSeparada;
    int contadorErrores;
    int[] repetidas;
    int contadorPistas;
    

   
    
    
    public void ControladorAhorcado(){
        //SE INSTANCIA EL MODELO.
        ahorcado= new Ahorcado();
        //SE OBTIENE EL CONJUNTO DE PALABRAS DEL TOPICO ELEGIDO.
        palabras=ahorcado.leerArchivo(ControladorTopicos.ruta);
        //SE COMPRUEBA LA CANTIDAD DE REPETICIONES DE CADA LETRA
        repetidas= ahorcado.comprobarRepeticiones(palabras);
        //SE ESCOGE LA PALABRA DENTRO DEL CONJUNTO DE PALABRAS.
        palabrita = ahorcado.escogerPalabra(palabras);
        //SE OBTIENE EL LARGO DE LA PALABRA ESCOGIDA.
        int num= palabrita.length();
        //SE GENERA LA VISTA AHORCADO.
        va=new VistaAhorcado();
        va.setVisible(true);
        va.agregarListener(this);
        //SE GENERAN LOS ESPACIOS SEGUN EL LARGO DE LA PALABRA.
        va.crearEspacios(num);
        //SE COLOCA EN LA VISTA LA IMAGEN DEL AHORCADO.
        va.crearMonito("src/Imagenes/NOAhorcado.png");
        
    }
    public void actionPerformed(ActionEvent e){
        //EN CASO DE QUE EL USUSARIO INGRESE UNA LETRA.
        if (va.getButtoningresarLetra()== e.getSource()){
                //SE GUARDA LA LETRA INGRESADA EN MAYUSCULA.
                String letraIngresada=va.getLetra().toUpperCase();
                //SE GUARDA UN REGISTRO DE LAS LETRAS QUE YA HAN SIDO USADAS POR EL USUARIO.
                ArrayList<String> letrasGuardadas=ahorcado.getLetrasNoUsables();
                //SE REGISTRA LA LETRA INGRESADA.
                ahorcado.guardarLetra(letraIngresada);
                //SE VERIFICA QUE EL LARGO DEL STRING INGRESADO CORRESPONDA A UNA SOLA LETRA.
                if (ahorcado.verificarLargo(letraIngresada)== true){
                    //SE OBTIENE LA POSICION DE LA LETRA ING. DENTRO DE LA PALABRA.
                    ArrayList<Integer> posicion=ahorcado.verificarPosicion(letraIngresada, palabrita);
                    //SE OBTIENE EL VALOR ACTUAL DEL CONTADOR GANAR.
                    int contadorGanar= ahorcado.getContadorLetras();
                    //SI EL ARRAY POSICION ESTA VACIO, EL CONTADOR ERRORES AUMENTA 
                    //Y SE COLOCA EN LA VISTA LA IMAGEN CORRESPONDIENTE A LA CANT. DE ERRORES COMETIDOS
                    if (posicion.isEmpty()){
                        switch (contadorErrores) {
                            case 0:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSCuerpo.png");
                                this.va.devolverBlanco();
                                break;
                            case 1:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSBrazos.png");
                                this.va.devolverBlanco();
                                break;
                            case 2:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSBrazo.png");
                                this.va.devolverBlanco();
                                break;
                            case 3:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSPiernas.png");
                                this.va.devolverBlanco();
                                break;
                            case 4:
                                contadorErrores++;
                                this.va.crearMonito("src/Imagenes/AhorcadoSPIzquierda.png");
                                this.va.devolverBlanco();
                                break;
                            case 5:
                                //EN ESTE CASO EL USUARIO PERDIO Y ES DEVUELTO A EL MENU PRINCIPAL.
                                this.va.crearMonito("src/Imagenes/AhorcadoCompleto.png");
                                this.va.devolverBlanco();
                                JOptionPane.showMessageDialog(null, "Has perdido...");
                                this.va.dispose();
                                cp = new ControladorPrincipalAhorcado();
                                break;
                        }
                        
                    }else{
                        //SE REMUEVEN DEL ARRAY DE PALABRAS DEL TOPICO 
                        //TODAS LAS QUE NO CONTENGAN LA LETRA INGRESADA.
                        palabras=ahorcado.removerPalabra(palabras, letraIngresada);
                        //SE CALCULAN LAS LETRAS REPETIDAS NUEVAMENTE CON EL NUEVO CONJUNTO DE PALABRAS.
                        repetidas=ahorcado.comprobarRepeticiones(palabras);
                        //SE OBTIENEN LOS ESPACIOS DE LA VISTA.
                        JButton[][] espacitos=va.getEspacios();
                        //Y SE COLOCA LA LETRA ING. EN LAS POSICIONES QUE CORRESPONDA.
                        JButton[][] espaciosCambiados= ahorcado.colocarLetra(posicion, espacitos, letraIngresada);
                        //SE COLOCA LOS NUEVOS ESPACIOS EN LA VISTA.
                        this.va.cambiarPanelVacio(espaciosCambiados, posicion, letraIngresada,palabrita);
                        //Y SE COLOCA EN BLANCO EL TEXTFIELD PARA RECIBIR UNA NUEVA LETRA.
                        this.va.devolverBlanco();
                        //SE VERIFICA SI EL USUARIO GANO. EN CASO DE GANAR ES DEVUELTO A LAS VISTA MENU PRINCIPAL.
                        if(contadorGanar==palabrita.length()){
                            JOptionPane.showMessageDialog(null, "Has ganado, ¡Felicidades!");
                            JOptionPane.showMessageDialog(va, "Felicidades has Ganado 1500 Monedas", "Ganaste", 1);
                            JOptionPane.showMessageDialog(va, "Dinero Anterior: "+dinero, "Recompensa", 1);
                            dinero=dinero + 1000;
                            JOptionPane.showMessageDialog(va, "Dinero Actual: "+ dinero, "Recompensa ", 1);
                            this.va.dispose();
                            cp= new ControladorPrincipalAhorcado();
                        }else{
                            
                        }
                    }
                
            }
                
            else {
                //SE LE SOLICITA AL USUARIO INGRESAR SOLO UNA LETRA.
                JOptionPane.showMessageDialog(null, "¡Ingrese solamente una letra!");
            }
                
        }
        //EN CASO DE SELECCIONAR EL BOTON PISTA.
        if (va.getPista()== e.getSource()){
            //SE OCUPA UN CONTADOR PISTAS QUE ES LA CANTIDAD DE PISTAS SOLICITADAS.
            contadorPistas++;
            //EN CASO DE SER LA PRIMERA.
            if(contadorPistas==1){
                //SE OBTIENE LA LETRA MAS REPETIDA.
                String letra= ahorcado.obtenerMayorRepeticion(repetidas);
                JOptionPane.showMessageDialog(null, "Te recomiendo usar la letra: ("+letra+")");
            }else{
                //EN CASO DE SER LA QUINTA PISTA SOLICITADA
                if(contadorPistas==5){
                    //SE OBTIENE EL ARRAY QUE CONTIENE LAS LETRAS QUE YA FUERON USADAS.
                    ArrayList<String> letrasGuardadas= ahorcado.getLetrasNoUsables();
                    //SE CALCULA DE NUEVO LA CANTIDAD DE REPETICIONES DE CADA LETRA(SIN CONTAR LAS YA USADAS).
                    int[] repetidasNuevas= ahorcado.comprobarRepeticiones2(palabras, letrasGuardadas);
                    //SE OBTIENE LA LETRA MAS REPETIDA.
                    String letra= ahorcado.obtenerMayorRepeticion(repetidasNuevas);
                    //SE ENTREGA LA PISTA AL USUARIO, SE LE INFORMA QUE FUE SU ULTIMA PISTA 
                    //Y SE DESACTIVA EL BOTON PISTA.
                    JOptionPane.showMessageDialog(null, "Te recomiendo usar la letra: ("+letra+")");
                    JOptionPane.showMessageDialog(null, "Esa fue tu ultima pista...");
                    this.va.apagarBoton();
                }else{
                    //SE OBTIENE EL ARRAY QUE CONTIENE LAS LETRAS QUE YA FUERON USADAS.
                    ArrayList<String> letrasGuardadas= ahorcado.getLetrasNoUsables();
                    //SE CALCULA DE NUEVO LA CANTIDAD DE REPETICIONES DE CADA LETRA(SIN CONTAR LAS YA USADAS).
                    int[] repetidasNuevas= ahorcado.comprobarRepeticiones2(palabras, letrasGuardadas);
                    //SE OBTIENE LA LETRA MAS REPETIDA.
                    String letra= ahorcado.obtenerMayorRepeticion(repetidasNuevas);
                    //SE LE ENTREGA LA PISTA AL USUARIO.
                    JOptionPane.showMessageDialog(null, "Te recomiendo usar la letra: ("+letra+")");
                }
            }    
            
            
        }    
            
    }
    
    public String getPalabra(){
        return palabrita;
    }
    public int[] getRepetidas(){
        return repetidas;
    }
}
