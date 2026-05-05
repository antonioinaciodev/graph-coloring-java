import java.util.*;

public class DSatur implements ColoringAlgorithm {

    @Override
    public String getName() {
        return "DSatur";
    }

    @Override
    public int execute(Graph graph) {
        List<Vertex> vertices = graph.getVertices();
        int n = vertices.size();
        int coloredCount = 0;
        int numColors = 0;

        while (coloredCount < n) {
            Vertex selected = null;
            int maxSaturation = -1;
            int maxDegree = -1;

            for (Vertex v : vertices) {
                if (v.getColor() == -1) {
                    int sat = countAdjacentColors(v, graph);
                    if (sat > maxSaturation || (sat == maxSaturation && v.getDegree() > maxDegree)) {
                        maxSaturation = sat;
                        maxDegree = v.getDegree();
                        selected = v;
                    }
                }
            }

            Set<Integer> adjColors = new HashSet<>();
            for (int adj : selected.getAdjacencies()) {
                Vertex vAdj = graph.getVertex(adj);
                if (vAdj != null && vAdj.getColor() != -1) {
                    adjColors.add(vAdj.getColor());
                }
            }

            int color = 0;
            while (adjColors.contains(color)) {
                color++;
            }
            
            selected.setColor(color);
            if (color + 1 > numColors) {
                numColors = color + 1;
            }
            coloredCount++;
        }

        return numColors;
    }

    private int countAdjacentColors(Vertex v, Graph graph) {
        Set<Integer> colors = new HashSet<>();
        for (int adj : v.getAdjacencies()) {
            Vertex vAdj = graph.getVertex(adj);
            if (vAdj != null && vAdj.getColor() != -1) {
                colors.add(vAdj.getColor());
            }
        }
        return colors.size();
    }
}