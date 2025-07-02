import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> vertices = new ArrayList<Vertice>();

    public void addVertice(int num) {
        vertices.add(new Vertice(num));
    }

    public void addAresta(int[] aresta) {
        if (aresta.length != 2) return;
        int num1 = aresta[0];
        int num2 = aresta[1];
        Vertice v1 = getVertice(num1);
        Vertice v2 = getVertice(num2);
        if(v1 == null){
            addVertice(num1);
            v1 = getVertice(num1);
        }
        if(v2 == null){
            addVertice(num2);
            v2 = getVertice(num2);
        }
        if (v1 != null && v2 != null) {
            v1.addAdjacencia(num2);
            v2.addAdjacencia(num1); 
        }
    }

    public Vertice getVertice(int num) {
        for (Vertice v : vertices) {
            if (v.getNum() == num) return v;
        }
        return null;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void zeraCores() {
        for (Vertice vertice : this.getVertices()) {
            vertice.setCor(-1);
        }
    }
}