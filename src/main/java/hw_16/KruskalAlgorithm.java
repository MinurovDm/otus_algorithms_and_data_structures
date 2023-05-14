package hw_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KruskalAlgorithm {

    Edge[] findMinimumSpanningTree(Edge[] graph) {
        Arrays.sort(graph);
        int vertices = graph.length;

        UnionFind unionFind = new UnionFind(vertices);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : graph) {
            int root1 = unionFind.find(edge.v1);
            int root2 = unionFind.find(edge.v2);

            if (root1 != root2) {
                mst.add(edge);
                unionFind.union(root1, root2);
            }
        }

        return mst.toArray(new Edge[0]);
    }

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int weight;

        Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int rootX, int rootY) {
            if (rootX == rootY)
                return;

            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
