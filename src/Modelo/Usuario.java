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
            System.out.println("hola ");
            state = con.createStatement();
            System.out.println("wenaaa");
            
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
            

}
