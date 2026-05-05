import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private final int id;
    private int color = -1;
    private final List<Integer> adjacencies = new ArrayList<>();

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDegree() {
        return this.adjacencies.size();
    }

    public List<Integer> getAdjacencies() {
        return this.adjacencies;
    }

    public void addAdjacency(int targetId) {
        if (!this.adjacencies.contains(targetId)) {
            this.adjacencies.add(targetId);
        }
    }
}