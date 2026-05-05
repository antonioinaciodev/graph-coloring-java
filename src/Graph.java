import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<Vertex> vertices = new ArrayList<>();

    public void addVertex(int id) {
        vertices.add(new Vertex(id));
    }

    public void addEdge(int source, int destination) {
        Vertex v1 = getVertex(source);
        Vertex v2 = getVertex(destination);

        if (v1 == null) {
            addVertex(source);
            v1 = getVertex(source);
        }
        if (v2 == null) {
            addVertex(destination);
            v2 = getVertex(destination);
        }

        if (v1 != null && v2 != null) {
            v1.addAdjacency(destination);
            v2.addAdjacency(source);
        }
    }

    public Vertex getVertex(int id) {
        for (Vertex v : vertices) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void resetColors() {
        for (Vertex vertex : this.getVertices()) {
            vertex.setColor(-1);
        }
    }
}