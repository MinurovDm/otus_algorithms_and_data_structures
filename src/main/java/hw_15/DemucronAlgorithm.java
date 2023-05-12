package hw_15;

import java.util.*;

public class DemucronAlgorithm {

    public int[][] findLevels(int[][] graph) {
        int n = graph.length;
        int[] inDegrees = new int[n];
        List<List<Integer>> levels = new ArrayList<>();


        for (int[] ints : graph) {
            for (int i = 0; i < n; i++) {
                if (ints[i] != 0) {
                    inDegrees[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int vertex = queue.poll();
                level.add(vertex);

                for (int j = 0; j < n; j++) {
                    if (graph[vertex][j] != 0) {
                        inDegrees[j]--;

                        if (inDegrees[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
            }

            levels.add(level);
        }

        int[][] levelArray = new int[levels.size()][];
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> level = levels.get(i);
            levelArray[i] = new int[level.size()];

            for (int j = 0; j < level.size(); j++) {
                levelArray[i][j] = level.get(j);
            }
        }

        return levelArray;
    }
}



