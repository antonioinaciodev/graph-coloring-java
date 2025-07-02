import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo();
        int[] aresta = new int[2];
        
        for(int i=1;i<10;i++){

            aresta[0] = i;
            aresta[1] = i+1;
            grafo.addAresta(aresta);
            System.err.print(aresta[0]);
            System.err.print(',');
            System.err.println(aresta[1]);
        }

        for(int i=10;i>2;i--){
            aresta[0] = i;
            aresta[1] = i-2;
            grafo.addAresta(aresta);
            System.err.print(aresta[0]);
            System.err.print(',');
            System.err.println(aresta[1]);

        }

        Welsh_Powell WP = new Welsh_Powell();
        Dsatur DS = new Dsatur();
        int numCores_WP = WP.WelshPowell(grafo);
        int numCores_DS = DS.dsatur(grafo);

        System.err.println(numCores_WP);
        System.err.println(numCores_DS);
        
    }
}
