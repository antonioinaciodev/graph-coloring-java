public class Guloso {

    public Guloso(){}

    // Algoritmo guloso para coloração de grafos
    public int guloso(Grafo grafo) {
        int numCores = 0;
        // Inicializa todos os vértices como não coloridos
        for (Vertice v : grafo.getVertices()) {
            v.setCor(-1);
        }

        for (Vertice v : grafo.getVertices()) {
            boolean[] coresUsadas = new boolean[grafo.getVertices().size()];
            // Marca as cores usadas pelos adjacentes
            for (int adj : v.getAdjacencia()) {
                Vertice vAdj = grafo.getVertice(adj);
                if (vAdj != null && vAdj.getCor() != -1) {
                    coresUsadas[vAdj.getCor()] = true;
                }
            }
            // Encontra a menor cor disponível
            int cor;
            for (cor = 0; cor < coresUsadas.length; cor++) {
                if (!coresUsadas[cor]) break;
            }
            v.setCor(cor);
            if (cor + 1 > numCores) numCores = cor + 1;
        }
        return numCores;
    }
}

