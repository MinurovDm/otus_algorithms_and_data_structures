package hw_16;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        KruskalAlgorithm algorithm = new KruskalAlgorithm();

        KruskalAlgorithm.Edge[] graph = new KruskalAlgorithm.Edge[] {
                new KruskalAlgorithm.Edge(0, 1, 10),
                new KruskalAlgorithm.Edge(0, 2, 6),
                new KruskalAlgorithm.Edge(0, 3, 5),
                new KruskalAlgorithm.Edge(1, 3, 15),
                new KruskalAlgorithm.Edge(2, 3, 4)
        };

        KruskalAlgorithm.Edge[] mst = algorithm.findMinimumSpanningTree(graph);

        Arrays.stream(mst).sequential()
                .forEach(System.out::println);
    }
}
