import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Random; // Importei Random para o caso de querer usar em Exemplos

public class App {

    // Constante para definir o número de execuções para cada teste
    private static final int NUMERO_EXECUCOES = 10;

    public static void main(String[] args) throws Exception {
        Exemplos exemplos = new Exemplos();

        // Usando um Map para organizar os conjuntos de grafos e seus nomes
        Map<String, ArrayList<Grafo>> conjuntosDeGrafos = new LinkedHashMap<>();
        conjuntosDeGrafos.put("20 Vértices (Denso)", exemplos.grafos20());
        conjuntosDeGrafos.put("40 Vértices (Denso)", exemplos.grafos40());
        conjuntosDeGrafos.put("80 Vértices (Denso)", exemplos.grafos80());
        conjuntosDeGrafos.put("160 Vértices (Denso)", exemplos.grafos160());

        // Executa os testes para cada conjunto de grafos
        for (Map.Entry<String, ArrayList<Grafo>> entry : conjuntosDeGrafos.entrySet()) {
            executarTestes(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Executa a bateria de testes para um conjunto específico de grafos.
     * @param nomeConjunto O nome do conjunto de grafos (ex: "Grafos com 20 Vértices").
     * @param grafos A lista de grafos a ser testada.
     */
    public static void executarTestes(String nomeConjunto, ArrayList<Grafo> grafos) {
        System.out.println("==============================================================");
        System.out.printf("INICIANDO TESTES PARA O CONJUNTO: %s\n", nomeConjunto);
        System.out.println("==============================================================\n");

        Guloso guloso = new Guloso();
        Welsh_Powell welshPowell = new Welsh_Powell();
        Dsatur dsatur = new Dsatur();

        int numeroGrafo = 1;
        for (Grafo grafo : grafos) {
            System.out.printf("--> Testando Grafo #%d (Vértices: %d, Arestas: %d)\n",
                    numeroGrafo,
                    grafo.getVertices().size(),
                    calcularNumeroArestas(grafo));

            // Teste para o Algoritmo Guloso
            rodarEExibirResultados("Guloso", guloso, grafo);

            // Teste para o Algoritmo Welsh-Powell
            rodarEExibirResultados("Welsh-Powell", welshPowell, grafo);

            // Teste para o Algoritmo DSatur
            rodarEExibirResultados("DSatur", dsatur, grafo);

            System.out.println(); // Linha em branco para separar os grafos
            numeroGrafo++;
        }
    }

    /**
     * Roda um algoritmo específico várias vezes em um grafo e exibe as médias.
     * @param nomeAlgo Nome do algoritmo para exibição.
     * @param algo Instância do algoritmo a ser testado (usando Object para generalizar).
     * @param grafo O grafo alvo do teste.
     */
    private static void rodarEExibirResultados(String nomeAlgo, Object algo, Grafo grafo) {
        ArrayList<Long> tempos = new ArrayList<>();
        ArrayList<Integer> cores = new ArrayList<>();

        for (int i = 0; i < NUMERO_EXECUCOES; i++) {
            grafo.zeraCores(); // ESSENCIAL: Reseta o grafo antes de cada execução

            long tempoInicio = System.nanoTime();
            int numCores = 0;

            // Identifica e executa o algoritmo correto
            if (algo instanceof Guloso) {
                numCores = ((Guloso) algo).guloso(grafo);
            } else if (algo instanceof Welsh_Powell) {
                numCores = ((Welsh_Powell) algo).WelshPowell(grafo);
            } else if (algo instanceof Dsatur) {
                numCores = ((Dsatur) algo).dsatur(grafo);
            }
            
            long tempoFim = System.nanoTime();

            tempos.add(tempoFim - tempoInicio);
            cores.add(numCores);
        }

        // --- ALTERAÇÃO AQUI ---
        
        // 1. Calcular a média de tempo em nanosegundos
        double mediaTempoNano = calcularMediaLong(tempos);
        // 2. Converter a média para milissegundos
        double mediaTempoMilli = mediaTempoNano / 1_000_000.0;

        double mediaCores = calcularMediaInt(cores);

        // 3. Atualizar o printf para exibir em milissegundos (ms) e com mais precisão decimal
        System.out.printf("     - %-15s | Média de Cores: %-5.1f | Tempo Médio: %.4f ms\n",
                nomeAlgo, mediaCores, mediaTempoMilli);
    }

    // --- Métodos de cálculo de média e utilitários ---

    public static double calcularMediaLong(ArrayList<Long> lista) {
        if (lista == null || lista.isEmpty()) return 0.0;
        long soma = 0;
        for (long valor : lista) {
            soma += valor;
        }
        return (double) soma / lista.size();
    }

    public static double calcularMediaInt(ArrayList<Integer> lista) {
        if (lista == null || lista.isEmpty()) return 0.0;
        int soma = 0;
        for (int valor : lista) {
            soma += valor;
        }
        return (double) soma / lista.size();
    }

    public static int calcularNumeroArestas(Grafo grafo) {
        int totalGraus = 0;
        for (Vertice v : grafo.getVertices()) {
            totalGraus += v.getGrau();
        }
        return totalGraus / 2; // Cada aresta é contada duas vezes na soma dos graus
    }
}