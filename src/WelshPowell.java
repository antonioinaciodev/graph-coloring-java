import java.util.ArrayList;
import java.util.List;

public class WelshPowell implements ColoringAlgorithm {

    @Override
    public String getName() {
        return "Welsh-Powell";
    }

    @Override
    public int execute(Graph graph) {
        List<Vertex> sortedVertices = new ArrayList<>(graph.getVertices());
        sortedVertices.sort((v1, v2) -> Integer.compare(v2.getDegree(), v1.getDegree()));
    
        int currentColor = 0;
        boolean allColored = false;

        while (!allColored) {
            allColored = true;
            for (Vertex v : sortedVertices) {
                if (v.getColor() == -1) {
                    boolean canColor = true;
                    for (int adj : v.getAdjacencies()) {
                        Vertex adjVertex = graph.getVertex(adj);
                        if (adjVertex != null && adjVertex.getColor() == currentColor) {
                            canColor = false;
                            break;
                        }
                    }
                    if (canColor) {
                        v.setColor(currentColor);
                    } else {
                        allColored = false;
                    }
                }
            }
            currentColor++;
            allColored = sortedVertices.stream().allMatch(v -> v.getColor() != -1);
        }
        
        return currentColor;
    }
}