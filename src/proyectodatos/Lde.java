package proyectodatos;

public class Lde {

    private Nodo cab;

    public Lde() {
        this.cab = null;
    }

    
    // INSERTAR CON COMPARETO (String)
    
    public void insertar(Producto p) {
        Nodo nuevo,actual;
        nuevo= new Nodo(p);
        // CASO 1: Lista vacía
        if (cab == null) {
            cab = nuevo;
        }else{
            // CASO 2: El nuevo es MENOR que el primero (Va al inicio)
            // Usamos compareTo: si da negativo (< 0), 'p' es menor que 'cab'
            if (p.getId().compareTo(cab.getDato().getId()) < 0) {
                insInicio(nuevo);
            } else {
                // CASO 3: Buscar posición
                actual = cab;

                // Avanzamos mientras haya siguiente...
                // Y el siguiente sea MENOR que el nuestro (compareTo < 0)
                while (actual.getSig() != null
                        && actual.getSig().getDato().getId().compareTo
                            (p.getId()) < 0) {
                    actual = actual.getSig();
                }
                // Insertamos después de 'actual'
                insInter(nuevo, actual);
            }
        } 
    }

  
    public void insInicio(Nodo p) {
        if (p != null) {
            p.setSig(cab);
            if (cab != null) {
                cab.setAnt(p);
            }
            cab = p;
            p.setAnt(null);
        }
    }

    public void insInter(Nodo p, Nodo q) { // p: nuevo, q: anterior
        if (p != null && q != null) {
            p.setSig(q.getSig());
            q.setSig(p);
            if (p.getSig() != null) {
                p.getSig().setAnt(p);
            }
            p.setAnt(q);
        }
    }


   
    public void eliminarInter(Nodo p){
        if(p!=null){
            p.getAnt().setSig(p.getSig());
            if (p.getSig()!=null) {
                p.getSig().setAnt(p.getAnt());
                
            }
            p.setSig(null);
            p.setAnt(null);
        }
    }
    
    public void eliminarInicio(){
        Nodo p;
        if (cab!=null) {
            p=cab;
            cab=p.getSig();
            if (cab!=null) {
                cab.setAnt(null);
            }
            p.setSig(null);
            
        }
    }
   
    public void liberarMemoria() {
        Nodo actual,sig;
        actual = cab;
        while (actual != null) {
            sig = actual.getSig();
            actual.setSig(null);
            actual.setAnt(null);
            actual = sig;
        }
        cab = null;
    }
     
    
    
}
