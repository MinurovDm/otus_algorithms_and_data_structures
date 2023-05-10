package hw_14;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] adjList = {
                {1, 2},
                {2, 3, 4},
                {0, 3},
                {},
                {5},
                {4}
        };

        KosarajuAlgorithm graph = new KosarajuAlgorithm(adjList);
        List<List<Integer>> sccList = graph.getStronglyConnectedComponents();

        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccList) {
            System.out.println(scc.toString());
        }
    }
}
