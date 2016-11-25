
package Modelo;


public class Item {
    //ATRIBUTOS
    private int posicionEnInventario;
    

    //CONSTRUCTORES
    public Item(int posicionEnInventario) {
        this.posicionEnInventario = posicionEnInventario;
    }

    public int getPosicionEnInventario() {
        return posicionEnInventario;
    }

    public void setPosicionEnInventario(int posicionEnInventario) {
        this.posicionEnInventario = posicionEnInventario;
    }
    
    //METODOS
    public String infoItem(){
        return "";
    }
}
