import java.util.ArrayList;

public class Welsh_Powell{

    public Welsh_Powell(){}
    
    public int WelshPowell(Grafo grafo){
        ArrayList<Vertice> vertOrdenados = grafo.getVertices();
        // Ordena em ordem decrescente de grau
        vertOrdenados.sort((v1, v2) -> Integer.compare(v2.getGrau(), v1.getGrau()));
    
        int corAtual = 0;
        boolean todosColoridos = false;

        while (!todosColoridos) {
            todosColoridos = true;
            for (Vertice v : vertOrdenados) {
                if (v.getCor() == -1) {
                    // Verifica se algum adjacente já tem a cor atual
                    boolean podeColorir = true;
                    for (int adj : v.getAdjacencia()) {
                        Vertice adjVertice = grafo.getVertice(adj);
                        if (adjVertice != null && adjVertice.getCor() == corAtual) {
                            podeColorir = false;
                            break;
                        }
                    }
                    if (podeColorir) {
                        v.setCor(corAtual);
                    } else {
                        todosColoridos = false;
                    }
                }
            }
            corAtual++;
            // Verifica se todos estão coloridos
            todosColoridos = vertOrdenados.stream().allMatch(v -> v.getCor() != -1);
        }

        
        return corAtual;
    }

}