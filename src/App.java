import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Exemplos ex = new Exemplos();
        Guloso GL = new Guloso();
        Welsh_Powell WP = new Welsh_Powell();
        Dsatur DS = new Dsatur();

        ArrayList<Long> TemposGulosos = new ArrayList<Long>();
        ArrayList<Long> TemposWelshPowell = new ArrayList<Long>();
        ArrayList<Long> TemposDsatur = new ArrayList<Long>();


        ArrayList<Grafo> listaGrafos = ex.grafos10();

        for (Grafo grafo : listaGrafos) {
            long temp_ini = System.nanoTime();
            int num_cores = WP.WelshPowell(grafo);
            long temp_fim = System.nanoTime();
            TemposWelshPowell.add(temp_fim-temp_ini);
        }
        System.err.println(calcularMedia(TemposWelshPowell) + " nanosegundos");
        
    }

    public static double calcularMedia(ArrayList<Long> tempos) {
        long soma = 0;
        for (long t : tempos) {
            soma += t;
        }
        return (double) soma / tempos.size();
    }
}
