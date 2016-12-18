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

public boolean eliminarParaReemplazar(String user){
        
        try {
            String query = "DELETE FROM JUGADOR WHERE USUARIO = '"+user+"'";
                    //+ ",'"+pass+"','"+per1+"',"
                    //+ "'"+rol1+"','"+per2+"','"+rol2+"','"+carrera+"',"+dinero+")";
            
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



public String getUser(String[] tablaBD){
   String user= tablaBD[0]; 
    
return user;}

public String getPass(String[] tablaBD){
    
    String pass= tablaBD[1];
    
return pass;}

// Obtener Nombre Personaje principal para despues nombrar a un personaje y posicionarlo en el tablero
public String getNombrePP(String[] tablaBD){
    
    String nombrePP= tablaBD[2];

return nombrePP;}
// Obtener Rol Personaje principal para despues nombrar a un personaje y posicionarlo en el tablero
public String getRolPP(String[] tablaBD){
    
    String rolPP= tablaBD[3];
    
return rolPP;}
// Obtener Nombre Personaje secundario para despues nombrar a un personaje y posicionarlo en el tablero
public String getNombrePS(String[] tablaBD){
    
    String nombrePS= tablaBD[4];
    
return nombrePS;}
// Obtener rol Personaje scundario para despues nombrar a un personaje y posicionarlo en el tablero
public String getRolPS(String[] tablaBD){
    
    String rolPS= tablaBD[5];
    
return rolPS;}

// Obtener Carrera del usuario para saber que malla corresponde abrir

public String getCarreraUsuario(String[] tablaBD){
    
    String carreraU= tablaBD[6];

return carreraU;}

public int getDineroUsuario(String[] tablaBD){
    
    int dinero= Integer.parseInt(tablaBD[7]);
return dinero;}







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




}
