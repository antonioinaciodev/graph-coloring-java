public class Greedy implements ColoringAlgorithm {

    @Override
    public String getName() {
        return "Greedy";
    }

    @Override
    public int execute(Graph graph) {
        int numColors = 0;
        
        for (Vertex v : graph.getVertices()) {
            v.setColor(-1);
        }

        for (Vertex v : graph.getVertices()) {
            boolean[] usedColors = new boolean[graph.getVertices().size()];
            
            for (int adj : v.getAdjacencies()) {
                Vertex vAdj = graph.getVertex(adj);
                if (vAdj != null && vAdj.getColor() != -1) {
                    usedColors[vAdj.getColor()] = true;
                }
            }
            
            int color;
            for (color = 0; color < usedColors.length; color++) {
                if (!usedColors[color]) break;
            }
            
            v.setColor(color);
            if (color + 1 > numColors) {
                numColors = color + 1;
            }
        }
        return numColors;
    }
}