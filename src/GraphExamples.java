import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphExamples {

    public List<Graph> generateGraphs20() {
        List<Graph> graphList = new ArrayList<>();
        int n = 20;

        Graph g1 = new Graph();
        for (int i = 1; i <= n; i++) g1.addVertex(i);
        for (int i = 1; i < n; i++) g1.addEdge(i, i + 1);
        g1.addEdge(1, 5);
        g1.addEdge(6, 12);
        g1.addEdge(13, 19);
        graphList.add(g1);

        Graph g2 = new Graph();
        for (int i = 1; i <= n; i++) g2.addVertex(i);
        for (int i = 1; i < n; i++) g2.addEdge(i, i + 1);
        g2.addEdge(n, 1);
        for (int i = 1; i <= n; i++) {
            g2.addEdge(i, ((i + 4) % n) + 1);
        }
        graphList.add(g2);

        Graph g3 = new Graph();
        for (int i = 1; i <= n; i++) g3.addVertex(i);
        for (int i = 2; i <= n; i++) g3.addEdge(1, i);
        g3.addEdge(2, 3);
        g3.addEdge(4, 5);
        g3.addEdge(6, 7);
        g3.addEdge(8, 10);
        g3.addEdge(12, 15);
        graphList.add(g3);

        Graph g4 = new Graph();
        int half = n / 2;
        for (int i = 1; i <= n; i++) g4.addVertex(i);
        for (int i = 1; i < half; i++) g4.addEdge(i, i + 1);
        g4.addEdge(half, 1);
        for (int i = half + 1; i < n; i++) g4.addEdge(i, i + 1);
        g4.addEdge(n, half + 1);
        g4.addEdge(1, half + 1);
        g4.addEdge(3, half + 3);
        g4.addEdge(5, half + 5);
        g4.addEdge(7, half + 7);
        graphList.add(g4);

        Graph g5 = new Graph();
        for (int i = 1; i <= n; i++) g5.addVertex(i);
        for (int i = 1; i <= n / 2; i++) {
            if (2 * i <= n) g5.addEdge(i, 2 * i);
            if (2 * i + 1 <= n) g5.addEdge(i, 2 * i + 1);
        }
        g5.addEdge(4, 7);
        g5.addEdge(5, 6);
        g5.addEdge(8, 12);
        g5.addEdge(9, 15);
        graphList.add(g5);

        Graph g6 = new Graph();
        for (int i = 1; i <= n; i++) g6.addVertex(i);
        for (int i = 1; i <= half; i++) {
            for (int j = half + 1; j <= n; j++) {
                if ((i + j) % 3 == 0) {
                    g6.addEdge(i, j);
                }
            }
        }
        graphList.add(g6);

        Graph g7 = new Graph();
        for (int i = 1; i <= n; i++) g7.addVertex(i);
        int numComponents = n / 4;
        for (int k = 0; k < numComponents; k++) {
            int base = 4 * k + 1;
            g7.addEdge(base, base + 1);
            g7.addEdge(base + 1, base + 2);
            g7.addEdge(base + 2, base + 3);
            g7.addEdge(base + 3, base);
        }
        for (int k = 0; k < numComponents - 1; k++) {
            int base1 = 4 * k + 1;
            int base2 = 4 * (k + 1) + 1;
            g7.addEdge(base1, base2);
            g7.addEdge(base1 + 1, base2 + 2);
        }
        graphList.add(g7);

        Graph g8 = new Graph();
        for (int i = 1; i <= n; i++) g8.addVertex(i);
        for (int i = 2; i <= n; i++) g8.addEdge(1, i);
        for (int i = 2; i < n; i++) g8.addEdge(i, i + 1);
        g8.addEdge(n, 2);
        graphList.add(g8);

        Graph g9 = new Graph();
        int rows = 4, cols = 5;
        for (int i = 1; i <= n; i++) g9.addVertex(i);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int u = i * cols + j + 1;
                if (j + 1 < cols) {
                    int v = u + 1;
                    g9.addEdge(u, v);
                }
                if (i + 1 < rows) {
                    int v = u + cols;
                    g9.addEdge(u, v);
                }
            }
        }
        graphList.add(g9);

        Graph g10 = new Graph();
        for (int i = 1; i <= n; i++) g10.addVertex(i);
        Random rand = new Random();
        int numEdges = n * 2;
        for (int i = 0; i < numEdges; i++) {
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if (u != v) g10.addEdge(u, v);
        }
        graphList.add(g10);

        return graphList;
    }

    public List<Graph> generateGraphs40() {
        List<Graph> graphList = new ArrayList<>();
        int n = 40;
        int half = n / 2;

        Graph g1 = new Graph();
        for (int i = 1; i <= n; i++) g1.addVertex(i);
        for (int i = 1; i < n; i++) g1.addEdge(i, i + 1);
        g1.addEdge(n, 1);
        for (int i = 1; i <= n; i++) {
            g1.addEdge(i, ((i + 7) % n) + 1);
            g1.addEdge(i, ((i + 13) % n) + 1);
        }
        graphList.add(g1);

        Graph g2 = new Graph();
        for (int i = 1; i <= n; i++) g2.addVertex(i);
        for (int i = 2; i <= n; i++) g2.addEdge(1, i);
        for (int i = 2; i < n; i++) g2.addEdge(i, i + 1);
        g2.addEdge(n, 2);
        graphList.add(g2);

        Graph g3 = new Graph();
        for (int i = 1; i <= n; i++) g3.addVertex(i);
        for (int i = 1; i < half; i++) g3.addEdge(i, i + 1);
        g3.addEdge(half, 1);
        for (int i = half + 1; i < n; i++) g3.addEdge(i, i + 1);
        g3.addEdge(n, half + 1);
        for (int i = 1; i <= 5; i++) {
            g3.addEdge(i, half + i);
            g3.addEdge(i * 2, half + i * 3);
        }
        graphList.add(g3);

        Graph g4 = new Graph();
        for (int i = 1; i <= n; i++) g4.addVertex(i);
        for (int i = 1; i <= half; i++) {
            for (int j = half + 1; j <= n; j++) {
                if ((i + j) % 4 == 0 || (i + j) % 5 == 1) {
                    g4.addEdge(i, j);
                }
            }
        }
        graphList.add(g4);

        Graph g5 = new Graph();
        for (int i = 1; i <= n; i++) g5.addVertex(i);
        int numComponents = n / 5;
        for (int k = 0; k < numComponents; k++) {
            int base = 5 * k + 1;
            g5.addEdge(base, base + 1);
            g5.addEdge(base + 1, base + 2);
            g5.addEdge(base + 2, base + 3);
            g5.addEdge(base + 3, base + 4);
            g5.addEdge(base + 4, base);
        }
        for (int k = 0; k < numComponents - 1; k++) {
            int base1 = 5 * k + 1;
            int base2 = 5 * (k + 1) + 1;
            g5.addEdge(base1, base2);
            g5.addEdge(base1 + 1, base2 + 2);
        }
        g5.addEdge(1, 5 * 3 + 1);
        graphList.add(g5);

        for (int i = 6; i <= 9; i++) {
            Graph g = new Graph();
            for (int k = 1; k <= n; k++) g.addVertex(k);
            Random rand = new Random(i);
            int numEdges = n * (i - 2);
            for (int j = 0; j < numEdges; j++) {
                int u = rand.nextInt(n) + 1;
                int v = rand.nextInt(n) + 1;
                if (u != v) g.addEdge(u, v);
            }
            graphList.add(g);
        }

        Graph g10 = new Graph();
        for (int i = 1; i <= n; i++) g10.addVertex(i);
        Random rand = new Random();
        int numEdges = n * 8;
        for (int i = 0; i < numEdges; i++) {
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if (u != v) g10.addEdge(u, v);
        }
        graphList.add(g10);

        return graphList;
    }

    public List<Graph> generateGraphs80() {
        List<Graph> graphList = new ArrayList<>();
        int n = 80;
        int half = n / 2;

        Graph g1 = new Graph();
        for (int i = 1; i <= n; i++) g1.addVertex(i);
        for (int i = 1; i < n; i++) g1.addEdge(i, i + 1);
        g1.addEdge(n, 1);
        for (int i = 1; i <= n; i++) {
            g1.addEdge(i, ((i + 9) % n) + 1);
            g1.addEdge(i, ((i + 21) % n) + 1);
        }
        graphList.add(g1);

        Graph g2 = new Graph();
        for (int i = 1; i <= n; i++) g2.addVertex(i);
        for (int i = 2; i <= n; i++) g2.addEdge(1, i);
        for (int i = 2; i < n; i++) g2.addEdge(i, i + 1);
        g2.addEdge(n, 2);
        graphList.add(g2);

        Graph g3 = new Graph();
        for (int i = 1; i <= n; i++) g3.addVertex(i);
        for (int i = 1; i < half; i++) g3.addEdge(i, i + 1);
        g3.addEdge(half, 1);
        for (int i = half + 1; i < n; i++) g3.addEdge(i, i + 1);
        g3.addEdge(n, half + 1);
        for (int i = 1; i <= 10; i++) {
            g3.addEdge(i, half + i);
            g3.addEdge(i * 2, half + i * 3);
        }
        graphList.add(g3);

        Graph g4 = new Graph();
        for (int i = 1; i <= n; i++) g4.addVertex(i);
        for (int i = 1; i <= half; i++) {
            for (int j = half + 1; j <= n; j++) {
                if ((i + j) % 5 == 0 || (i + j) % 7 == 1) {
                    g4.addEdge(i, j);
                }
            }
        }
        graphList.add(g4);

        Graph g5 = new Graph();
        for (int i = 1; i <= n; i++) g5.addVertex(i);
        int numComponents = n / 4;
        for (int k = 0; k < numComponents; k++) {
            int base = 4 * k + 1;
            g5.addEdge(base, base + 1);
            g5.addEdge(base + 1, base + 2);
            g5.addEdge(base + 2, base + 3);
            g5.addEdge(base + 3, base);
        }
        for (int k = 0; k < numComponents - 1; k++) {
            int base1 = 4 * k + 1;
            int base2 = 4 * (k + 1) + 1;
            g5.addEdge(base1, base2);
            g5.addEdge(base1 + 1, base2 + 2);
        }
        g5.addEdge(1, 4 * 4 + 1);
        g5.addEdge(2, 4 * 8 + 2);
        graphList.add(g5);

        for (int i = 6; i <= 9; i++) {
            Graph g = new Graph();
            for (int k = 1; k <= n; k++) g.addVertex(k);
            Random rand = new Random(i);
            int numEdges = n * i;
            for (int j = 0; j < numEdges; j++) {
                int u = rand.nextInt(n) + 1;
                int v = rand.nextInt(n) + 1;
                if (u != v) g.addEdge(u, v);
            }
            graphList.add(g);
        }

        Graph g10 = new Graph();
        for (int i = 1; i <= n; i++) g10.addVertex(i);
        Random rand = new Random();
        int numEdges = n * 10;
        for (int i = 0; i < numEdges; i++) {
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if (u != v) g10.addEdge(u, v);
        }
        graphList.add(g10);

        return graphList;
    }

    public List<Graph> generateGraphs160() {
        List<Graph> graphList = new ArrayList<>();
        int n = 160;
        int half = n / 2;

        Graph g1 = new Graph();
        for (int i = 1; i <= n; i++) g1.addVertex(i);
        for (int i = 1; i < n; i++) g1.addEdge(i, i + 1);
        g1.addEdge(n, 1);
        for (int i = 1; i <= n; i++) {
            g1.addEdge(i, ((i + 14) % n) + 1);
            g1.addEdge(i, ((i + 31) % n) + 1);
        }
        graphList.add(g1);

        Graph g2 = new Graph();
        for (int i = 1; i <= n; i++) g2.addVertex(i);
        for (int i = 2; i <= n; i++) g2.addEdge(1, i);
        for (int i = 2; i < n; i++) g2.addEdge(i, i + 1);
        g2.addEdge(n, 2);
        graphList.add(g2);

        Graph g3 = new Graph();
        for (int i = 1; i <= n; i++) g3.addVertex(i);
        for (int i = 1; i < half; i++) g3.addEdge(i, i + 1);
        g3.addEdge(half, 1);
        for (int i = half + 1; i < n; i++) g3.addEdge(i, i + 1);
        g3.addEdge(n, half + 1);
        for (int i = 1; i <= 20; i++) {
            g3.addEdge(i, half + i);
            g3.addEdge(i * 2, half + i * 3);
            g3.addEdge(i * 3, half + i * 2);
        }
        graphList.add(g3);

        Graph g4 = new Graph();
        for (int i = 1; i <= n; i++) g4.addVertex(i);
        for (int i = 1; i <= half; i++) {
            for (int j = half + 1; j <= n; j++) {
                if ((i + j) % 7 == 0 || (i + j) % 11 == 0 || (i + j) % 13 == 0) {
                    g4.addEdge(i, j);
                }
            }
        }
        graphList.add(g4);

        Graph g5 = new Graph();
        for (int i = 1; i <= n; i++) g5.addVertex(i);
        int numComponents = n / 4;
        for (int k = 0; k < numComponents; k++) {
            int base = 4 * k + 1;
            g5.addEdge(base, base + 1);
            g5.addEdge(base + 1, base + 2);
            g5.addEdge(base + 2, base + 3);
            g5.addEdge(base + 3, base);
        }
        for (int k = 0; k < numComponents - 1; k++) {
            int base1 = 4 * k + 1;
            int base2 = 4 * (k + 1) + 1;
            g5.addEdge(base1, base2);
            g5.addEdge(base1 + 1, base2 + 2);
        }
        g5.addEdge(1, 4 * 10 + 1);
        g5.addEdge(2, 4 * 20 + 2);
        g5.addEdge(3, 4 * 30 + 3);
        graphList.add(g5);

        for (int i = 6; i <= 9; i++) {
            Graph g = new Graph();
            for (int k = 1; k <= n; k++) g.addVertex(k);
            Random rand = new Random(i);
            int numEdges = n * (i + 4);
            for (int j = 0; j < numEdges; j++) {
                int u = rand.nextInt(n) + 1;
                int v = rand.nextInt(n) + 1;
                if (u != v) g.addEdge(u, v);
            }
            graphList.add(g);
        }

        Graph g10 = new Graph();
        for (int i = 1; i <= n; i++) g10.addVertex(i);
        Random rand = new Random();
        int numEdges = n * 20;
        for (int i = 0; i < numEdges; i++) {
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if (u != v) g10.addEdge(u, v);
        }
        graphList.add(g10);

        return graphList;
    }
}