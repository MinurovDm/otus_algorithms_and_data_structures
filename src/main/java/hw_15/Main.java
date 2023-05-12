package hw_15;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        DemucronAlgorithm algorithm = new DemucronAlgorithm();
        int[][] levels = algorithm.findLevels(graph);

        for (int i = 0; i < levels.length; i++) {
            System.out.println("Level " + i + ": " + Arrays.toString(levels[i]));
        }
    }
}
