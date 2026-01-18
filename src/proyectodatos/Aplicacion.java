

package proyectodatos;


import java.util.Random;


public class Aplicacion {
    private Lde lista;
    private Random random;

    public Aplicacion() {
        this.lista = new Lde();
        this.random = new Random();
    }

   
    public void ejecutarBenchmarking() {
        int[] cargas = { 1, 10, 100, 1000, 10000,100000,1000000}; 

        System.out.println("--- BENCHMARKING: MÉTODO DE INSERCIÓN ORDENADA ---");
        System.out.println("CANTIDAD (N) \t | \t TIEMPO PROMEDIO (ns)");

        for (int n : cargas) {
            correrPruebaInsercion(n);
        }
        
        System.out.println("--- FIN DE LAS PRUEBAS ---");
    }

    // --- LÓGICA DE LAS 30 REPETICIONES  ---
    private void correrPruebaInsercion(int n) {
        long sumaTiempos = 0;
        int repeticiones = 30; 

        for (int i = 0; i < repeticiones; i++) {
            
            sumaTiempos += testInsertar(n);
           
            lista.liberarMemoria();
            
            System.out.print("."); 
        }

        long promedio = sumaTiempos / repeticiones;

        System.out.println(); 
        System.out.println("DATOS: " + n + " \t -> \t " + promedio + " ns");
        System.out.println("-------------------------------------------------------");
    }

    
    private long testInsertar(int cantidad) {
        long inicio,fin;
        inicio= System.nanoTime(); 
        
        for (int i = 0; i < cantidad; i++) {
            // Generamos ID aleatorio y convertimos a String con ceros (ej. "00482")
            String id = String.format("%08d", random.nextInt(cantidad * 2));
            String nombre = "Producto " + i;
            
            // Medimos esto: Inserción en lugar apropiado 
            lista.insertar(new Producto(id, nombre)); 
        }
        
        fin = System.nanoTime(); // [cite: 10]
        return (fin - inicio);
    }

    public static void main(String[] args) {
       
        Aplicacion ap;
        ap= new Aplicacion();
        ap.ejecutarBenchmarking();
       /* int n=10000000;
        System.out.println("insercion solo al inicio:");
        System.out.println("cantidad de nodos:"+n);
        long tiempo= ap.testSoloInicio(n);
        System.out.println("Tiempo: " + tiempo + " ns");
        System.out.println("Tiempo: " + (tiempo / 1_000_000) + " ms");*/
    }
    
    public long testSoloInicio(int cantidad) {
        lista.liberarMemoria();
        Producto p;
        Nodo nuevoNodo;
        long inicio,fin;
        inicio= System.nanoTime();
        // 2. Bucle simple de inserción
        for (int i = 0; i < cantidad; i++) {
            // Creamos el producto
            p = new Producto("ANY-ID", "Producto " + i);

            // Creamos el Nodo aquí y lo mandamos directo a la cabecera
            nuevoNodo = new Nodo(p);
            lista.insInicio(nuevoNodo);
                 
        }
        
        fin = System.nanoTime();
        
        return (fin - inicio);
    }
}
