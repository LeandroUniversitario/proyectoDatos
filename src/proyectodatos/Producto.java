

package proyectodatos;


public class Producto {
    private String id;       // DNI o Código (Para ordenar)
    private String datos; // Nombre, Descripción (Relleno)

    public Producto(String id, String datos) {
        this.id = id;
        this.datos = datos;
    }

    public String getId(){ 
        return id; }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public void mostrar(){
        System.out.println("ID: "+id + " "+ datos);
    }
   
}
