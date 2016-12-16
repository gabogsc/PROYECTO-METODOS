/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Usuario {
    private String nombreUsuario;
    private String contraseñaUsuario;
    
    public Connection con;
    public Statement state;
    public ResultSet res;

    public Usuario(String nombreUsuario, String contraseñaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }
    public Usuario() {
        this.nombreUsuario = "";
        this.contraseñaUsuario = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos?zeroDateTimeBehavior=convertToNull","root","");
            //JOptionPane.showMessageDialog(null, "Conectado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        
        
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

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getState() {
        return state;
    }

    public void setState(Statement state) {
        this.state = state;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }
    
    
    
    
    
    //METODOS
    public boolean guardarPartida(){return false;}
    public boolean cargarPartida(){return false;}
    
    public Connection conectar()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos?zeroDateTimeBehavior=convertToNull","root","");
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return con;
    }
    
    
    public boolean registrar(String user, String pass, String per1, String rol1,
                        String per2, String rol2, String carrera, int dinero){
        
        try {
            String query = "INSERT INTO JUGADOR VALUES ('"+user+"','"+pass+"','"+per1+"',"
                    + "'"+rol1+"','"+per2+"','"+rol2+"','"+carrera+"',"+dinero+")";
            
            state = con.createStatement();
            
            
        int saber =  state.executeUpdate(query);
            
          if(saber > 0)
          {
              return true;
          }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
            

public String[] ingresar(String user){
   
    String[] x = new String[8];
    
        try {
            String query = "SELECT * FROM JUGADOR WHERE USUARIO = '"+user+"'";
            
            state = con.createStatement();
            
            res= state.executeQuery(query);
            
            
            while(res.next()){
                
               x[0]=res.getString("USUARIO");
               x[1]=res.getString("PASS");
               x[2]=res.getString("PERSONAJE1");
               x[3]=res.getString("ROL1");
               x[4]=res.getString("PERSONAJE2");
               x[5]=res.getString("ROL2");
               x[6]=res.getString("CARRERA");
               x[7]=res.getInt("DINERO")+"";
                
            }
            if(x[0]!= null || x[0]!="")
            {
                return x;
                
            }
            else {
                return null;
            }
            
            
             }
            catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
 }

public boolean validarInicio(String[] aux, String pss)
{
    if (aux[0] == null || aux[0]=="")
    {
        JOptionPane.showMessageDialog(null, "El Usuario No existe");
        return false;
        
    }else if (aux[1].equals(pss))
    {
        JOptionPane.showMessageDialog(null, "Ingreso Exitoso");
        return true;
        
    }else{
        JOptionPane.showMessageDialog(null, "La contraseña esta Erronea");
        return false;
    }
        
        
    
    
}



public Personaje PersonajePrincipal(String nombrePP, String rolPP){
    
  Personaje PP = new Personaje(); 
  
  PP.setNombrePersonaje(nombrePP);
  PP.setTipoPersonaje("alumno");
  PP.setRolPersonaje(rolPP);
  PP.setBandoPersonaje("bueno");
  PP.setPuntosAtaqueCorto(5000);
  PP.setPuntosAtaqueLargo(5000);
  PP.setPuntosDefensa(5000);
  PP.setPuntosVelocidad(5000);
  PP.setPuntosVidaTotal(5000);
  
  return PP; 

}


public Personaje PersonajeSecundario(String nombrePS, String rolPS){
    
   Personaje PS = new Personaje(); 
  
  PS.setNombrePersonaje(nombrePS);
  PS.setTipoPersonaje("alumno");
  PS.setRolPersonaje(rolPS);
  PS.setBandoPersonaje("bueno");
  PS.setPuntosAtaqueCorto(5000);
  PS.setPuntosAtaqueLargo(5000);
  PS.setPuntosDefensa(5000);
  PS.setPuntosVelocidad(5000);
  PS.setPuntosVidaTotal(5000);
  
  return PS;
}










}
