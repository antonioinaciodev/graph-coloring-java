import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int EXECUTION_COUNT = 10;

    public static void main(String[] args) {
        GraphExamples examples = new GraphExamples();

        Map<String, List<Graph>> graphSets = new LinkedHashMap<>();
        graphSets.put("20 Vertices (Dense)", examples.generateGraphs20());
        graphSets.put("40 Vertices (Dense)", examples.generateGraphs40());
        graphSets.put("80 Vertices (Dense)", examples.generateGraphs80());
        graphSets.put("160 Vertices (Dense)", examples.generateGraphs160());

        List<ColoringAlgorithm> algorithms = List.of(
            new Greedy(), 
            new WelshPowell(), 
            new DSatur()
        );

        for (Map.Entry<String, List<Graph>> entry : graphSets.entrySet()) {
            executeTests(entry.getKey(), entry.getValue(), algorithms);
        }
    }

    public static void executeTests(String setName, List<Graph> graphs, List<ColoringAlgorithm> algorithms) {
        System.out.println("==============================================================");
        System.out.printf("STARTING TESTS FOR SET: %s\n", setName);
        System.out.println("==============================================================\n");

        int graphNumber = 1;
        for (Graph graph : graphs) {
            System.out.printf("--> Testing Graph #%d (Vertices: %d, Edges: %d)\n",
                    graphNumber,
                    graph.getVertices().size(),
                    calculateEdgeCount(graph));

            for (ColoringAlgorithm algo : algorithms) {
                runAndDisplayResults(algo, graph);
            }

            System.out.println();
            graphNumber++;
        }
    }

    private static void runAndDisplayResults(ColoringAlgorithm algo, Graph graph) {
        List<Long> times = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();

        for (int i = 0; i < EXECUTION_COUNT; i++) {
            graph.resetColors();

            long startTime = System.nanoTime();
            int numColors = algo.execute(graph);
            long endTime = System.nanoTime();

            times.add(endTime - startTime);
            colors.add(numColors);
        }

        double avgTimeNano = calculateLongAverage(times);
        double avgTimeMilli = avgTimeNano / 1_000_000.0;
        double avgColors = calculateIntAverage(colors);

        System.out.printf("     - %-15s | Avg Colors: %-5.1f | Avg Time: %.4f ms\n",
                algo.getName(), avgColors, avgTimeMilli);
    }

    public static double calculateLongAverage(List<Long> list) {
        if (list == null || list.isEmpty()) return 0.0;
        return list.stream().mapToLong(Long::longValue).average().orElse(0.0);
    }

    public static double calculateIntAverage(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0.0;
        return list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static int calculateEdgeCount(Graph graph) {
        int totalDegrees = 0;
        for (Vertex v : graph.getVertices()) {
            totalDegrees += v.getDegree();
        }
        return totalDegrees / 2;
    }
}