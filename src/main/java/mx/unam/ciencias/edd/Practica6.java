package mx.unam.ciencias.edd;

import java.util.Random;

/**
 * Práctica 6: Gráficas.
 */
public class Practica6 {

    /* Cadena para que usen las lambdas. */
    private static String cadena = "";

    public static void main(String[] args) {
        /*
         *    b─────d
         *   ╱│╲    │╲
         *  ╱ │ ╲   │ ╲
         * a  │  ╲  │  f
         *  ╲ │   ╲ │ ╱
         *   ╲│    ╲│╱
         *    c─────e
         */
        Grafica<String> grafica = new Grafica<String>();

        
        grafica.agrega("a");
        grafica.agrega("b");
        grafica.agrega("c");
        grafica.agrega("d");
        grafica.agrega("e");
        grafica.agrega("f");

        grafica.conecta("a", "b");
        grafica.conecta("a", "c");
        grafica.conecta("b", "c");
        grafica.conecta("b", "d");
        grafica.conecta("b", "e");
        grafica.conecta("c", "e");
        grafica.conecta("d", "e");
        grafica.conecta("d", "f");
        grafica.conecta("e", "f");
        

        /* 
        grafica.agrega("1");
        grafica.agrega("2");
        grafica.agrega("3");
        grafica.agrega("4");
        grafica.agrega("5");
        grafica.agrega("6");
        grafica.agrega("7");
        grafica.agrega("8");
        grafica.agrega("9");
        grafica.agrega("10");


        grafica.conecta("1", "2");
        grafica.conecta("1", "4");
        grafica.conecta("2", "3");
        grafica.conecta("2", "5");
        grafica.conecta("2", "7");
        grafica.conecta("2", "8");
        grafica.conecta("3", "4");
        grafica.conecta("3", "9");
        grafica.conecta("3", "10");
        grafica.conecta("5", "6");
        grafica.conecta("5", "8");
        grafica.conecta("5", "7");
        grafica.conecta("8", "7");
*/
        

        System.out.println(grafica);

        String elementos_cola = "";

        String cola[]; 


        String aux[]; 


        
        //BFS 
        grafica.paraCadaVertice(v -> grafica.setColor(v, Color.ROJO));
        Cola<VerticeGrafica<String>> c = new Cola<VerticeGrafica<String>>();
        VerticeGrafica<String> vertice = grafica.vertice("e");
        grafica.setColor(vertice, Color.NEGRO);
        c.mete(vertice);

        System.out.println();
        System.out.println("BFS");
        System.out.println("Se empieza el recorrido con: " + vertice.toString());

        String s = " ";
        System.out.println("Los elementos de la cola hasta el momento son: " + vertice.toString());

        System.out.println();

        while (!c.esVacia()) {
            vertice = c.saca();
            elementos_cola = "";
            cadena += vertice.toString() + " ";

            System.out.println("Se saca el elemento: " + vertice.toString());
            for (VerticeGrafica<String> vecino : vertice.vecinos()) {
                if (vecino.getColor() == Color.ROJO) {
                    grafica.setColor(vecino, Color.NEGRO);
                    c.mete(vecino);
                    System.out.println("Se agrega el elemento: " + vecino.toString());
                    elementos_cola += vecino.toString() + " ";
                }
            }

            s += elementos_cola; 

            s = s.replace(vertice.toString(), "");

            aux = s.split(" ");

            System.out.print("Los elementos de la cola hasta el momento son: ");

            for(int k = aux.length-1; k >= 0; k--){
                System.out.print(aux[k] + " ");
            }

            System.out.println();
            System.out.println();
        }


        System.out.println("El resultado es: " + cadena);
        System.out.println();
        


        /* BFS de la clase 
        cadena = "BFS: ";
        System.out.println("BFS");
        grafica.bfs("8", v -> cadena += v.get() + ", ");
        //System.out.println(cadena);
*/

        
        //DFS 
        grafica.paraCadaVertice(v -> grafica.setColor(v, Color.ROJO));
        Pila<VerticeGrafica<String>> p = new Pila<VerticeGrafica<String>>();
        vertice = grafica.vertice("e");
        grafica.setColor(vertice, Color.NEGRO);
        p.mete(vertice);

        System.out.println();
        System.out.println("DFS");
        System.out.println("Se empieza el recorrido con: " + vertice.toString());

        s = " ";
        System.out.println("Los elementos de la pila hasta el momento son: " + vertice.toString());

        System.out.println();

        String elementos_pila = "";

        cadena = "";

        while (!p.esVacia()) {
            elementos_pila = "";
            vertice = p.saca();
            cadena += vertice.get() + " ";
            System.out.println("Se saca el elemento: " + vertice.toString());
            for (VerticeGrafica<String> vecino : vertice.vecinos()) {
                if (vecino.getColor() == Color.ROJO) {
                    grafica.setColor(vecino, Color.NEGRO);
                    p.mete(vecino);
                    System.out.println("Se agrega el elemento: " + vecino.toString());
                    elementos_pila += vecino.toString() + " ";
                }
            }

            s += elementos_pila; 

            s = s.replace(vertice.toString(), "");

            aux = s.split(" ");

            System.out.print("Los elementos de la pila hasta el momento son: ");

            for(int k = 0; k < aux.length; k++){ 
                System.out.print(aux[k] + " ");
            }

            System.out.println();
            System.out.println();
        }
        System.out.println("El resultado es: " + cadena);
        System.out.println();
        
        /* 
        System.out.println();
        System.out.println();

        System.out.println("DFS");
        cadena = "DFS: ";
        grafica.dfs("1", v -> cadena += v.get() + ", ");
        //System.out.println(cadena);
        */
        
    }
}
