/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

//import otros.BD;
//import java.sql.Statement;

/**
 *
 * @author sebastian
 */
public class Registro {
    private String user;
    private String password;
    private String password2;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getUser() {
        return user;
    }
    
    public boolean registroCorrecto() {
        if (user.equals("") || password.equals(""))
            return false;
        else if (user.length() < 6 || user.length() >= 15)
            return false;
        else if (password.length() < 6 || password.length() >= 15)
            return false;
        else {
            if (password.equals(user)) {
                return false;
            }
            else {
                if (password.equals(password2)) {
                    //try {
                        //BD conexionBD = new BD();
                        //conexionBD.conectar();
                        //Statement stmt = conexionBD.crearConsulta();
                        //final String consulta = "insert into USUARIOS (USUARIO,PASSWORD,ES_HUMANO,JEFE_TERRENO) VALUES('"+this.user+"','"+this.password+"', true)";
                        //stmt.executeUpdate(consulta);
                        //return true;
                    //}
                    //catch(java.sql.SQLIntegrityConstraintViolationException e) {
                        //System.err.println("Usuario ya registrado");
                        //return false;
                    //}
                    //catch(java.sql.SQLException e) {
                        //System.err.println("BD no conectada");
                        //return false;
                    //}
                //}
                //else {
                    //return false;
                //}
                }
            }
        }
        return false;
    }
}            
        