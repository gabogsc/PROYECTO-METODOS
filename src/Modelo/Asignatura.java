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
public class Asignatura {
    private Escenario escenario;
    private int tipoAsignatura;
    private int nivelAsignatura;

    public Asignatura(Escenario escenario, int tipoAsignatura, int nivelAsignatura) {
        this.escenario = escenario;
        this.tipoAsignatura = tipoAsignatura;
        this.nivelAsignatura = nivelAsignatura;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    public int getTipoAsignatura() {
        return tipoAsignatura;
    }

    public void setTipoAsignatura(int tipoAsignatura) {
        this.tipoAsignatura = tipoAsignatura;
    }

    public int getNivelAsignatura() {
        return nivelAsignatura;
    }

    public void setNivelAsignatura(int nivelAsignatura) {
        this.nivelAsignatura = nivelAsignatura;
    }
    
}
