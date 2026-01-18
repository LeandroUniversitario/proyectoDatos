

package proyectodatos;


public class Nodo {
    private Producto dato; // <--- CAMBIO IMPORTANTE
    private Nodo sig;
    private Nodo ant;

    public Nodo(Producto dato) {
        this.dato = dato;
        this.sig = null;
    }

    public Producto getDato() {
        return dato;
    }

    public void setDato(Producto dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
    public void mostrar(){
        dato.mostrar();
    }
}
