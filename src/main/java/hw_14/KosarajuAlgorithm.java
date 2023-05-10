package hw_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {

    private final int V;
    private final int[][] adjList;
    private final boolean[] visited;
    private final Stack<Integer> stack;

    public KosarajuAlgorithm(int[][] adjList) {
        this.adjList = adjList;
        V = adjList.length;
        visited = new boolean[V];
        stack = new Stack<>();
    }

    public List<List<Integer>> getStronglyConnectedComponents() {
        List<List<Integer>> sccList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        int[][] revAdjList = getReverseAdjList();
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> scc = new ArrayList<>();
                dfsReverse(v, revAdjList, scc);
                sccList.add(scc);
            }
        }
        return sccList;
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int adj : adjList[v]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
        stack.push(v);
    }

    private void dfsReverse(int v, int[][] revAdjList, List<Integer> scc) {
        visited[v] = true;
        scc.add(v);
        for (int adj : revAdjList[v]) {
            if (!visited[adj]) {
                dfsReverse(adj, revAdjList, scc);
            }
        }
    }

    private int[][] getReverseAdjList() {
        int[][] revAdjList = new int[V][];
        for (int i = 0; i < V; i++) {
            revAdjList[i] = new int[0];
        }
        for (int i = 0; i < V; i++) {
            for (int adj : adjList[i]) {
                revAdjList[adj] = Arrays.copyOf(revAdjList[adj], revAdjList[adj].length + 1);
                revAdjList[adj][revAdjList[adj].length - 1] = i;
            }
        }
        return revAdjList;
    }
}
