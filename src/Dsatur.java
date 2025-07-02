import java.util.*;

public class Dsatur {
    public Dsatur() {}

    public int dsatur(Grafo grafo) {
        ArrayList<Vertice> vertices = grafo.getVertices();
        int n = vertices.size();


        // Saturação de cada vértice (quantidade de cores diferentes nos adjacentes)
        Map<Vertice, Integer> saturacao = new HashMap<>();
        for (Vertice v : vertices) {
            saturacao.put(v, 0);
        }

        int coloridos = 0;
        int numCores = 0;

        while (coloridos < n) {
            // Seleciona o vértice não colorido de maior saturação (ou maior grau em caso de empate)
            Vertice escolhido = null;
            int maxSaturacao = -1;
            int maxGrau = -1;

            for (Vertice v : vertices) {
                if (v.getCor() == -1) {
                    int sat = contarCoresAdjacentes(v, grafo);
                    if (sat > maxSaturacao || (sat == maxSaturacao && v.getGrau() > maxGrau)) {
                        maxSaturacao = sat;
                        maxGrau = v.getGrau();
                        escolhido = v;
                    }
                }
            }

            // Encontra a menor cor possível para o vértice escolhido
            Set<Integer> coresAdj = new HashSet<>();
            for (int adj : escolhido.getAdjacencia()) {
                Vertice vAdj = grafo.getVertice(adj);
                if (vAdj != null && vAdj.getCor() != -1) {
                    coresAdj.add(vAdj.getCor());
                }
            }

            int cor = 0;
            while (coresAdj.contains(cor)) {
                cor++;
            }
            escolhido.setCor(cor);
            if (cor + 1 > numCores) numCores = cor + 1;
            coloridos++;
        }

        return numCores;
    }

    // Conta o número de cores diferentes nos adjacentes de um vértice
    private int contarCoresAdjacentes(Vertice v, Grafo grafo) {
        Set<Integer> cores = new HashSet<>();
        for (int adj : v.getAdjacencia()) {
            Vertice vAdj = grafo.getVertice(adj);
            if (vAdj != null && vAdj.getCor() != -1) {
                cores.add(vAdj.getCor());
            }
        }
        return cores.size();

    }
}