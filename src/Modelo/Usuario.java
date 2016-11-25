/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gabriel
 */
public class Usuario {
    private String nombreUsuario;
    private String contraseñaUsuario;
    

    public Usuario(String nombreUsuario, String contraseñaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }
    public Usuario() {
        this.nombreUsuario = "";
        this.contraseñaUsuario = "";
        
    }
   
    

    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }
    
    
    
    
    
    //METODOS
    public boolean guardarPartida(){return false;}
    public boolean cargarPartida(){return false;}
    
 
}
