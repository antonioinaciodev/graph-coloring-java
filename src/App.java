import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Exemplos ex = new Exemplos();
        Guloso GL = new Guloso();
        Welsh_Powell WP = new Welsh_Powell();
        Dsatur DS = new Dsatur();

        ArrayList<Long> temp_GL = new ArrayList<Long>();
        ArrayList<Long> temp_WP = new ArrayList<Long>();
        ArrayList<Long> temp_DS = new ArrayList<Long>();

        for (Grafo grafo : ex.grafos20()) {
            long temp_ini = System.nanoTime();
            int num_cores = GL.guloso(grafo);
            long temp_fim = System.nanoTime();
            temp_GL.add(temp_fim-temp_ini);
        }

        System.err.println(calcularMedia(temp_GL));
        
    }
     public static double calcularMedia(ArrayList<Long> tempos) {
        long soma = 0;
        for (long t : tempos) {
            soma += t;
        }
        return (double) soma / tempos.size();
    }
}
