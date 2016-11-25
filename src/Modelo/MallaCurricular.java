
package Modelo;


public class MallaCurricular {
    private int carreraAselec;
    private Asignatura asignatura;

    public MallaCurricular(int carreraAselec, Asignatura asignatura) {
        this.carreraAselec = carreraAselec;
        this.asignatura = asignatura;
    }

    public int getCarreraAselec() {
        return carreraAselec;
    }

    public void setCarreraAselec(int carreraAselec) {
        this.carreraAselec = carreraAselec;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    
}
