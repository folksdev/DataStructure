package com.folksdev.Graph;

import java.util.Arrays;

public class Dijkstra {

    static class Graph {
        int[][] adjMatrix;
        int V;

        public Graph(int[][] adjMatrix, int v) {
            this.adjMatrix = adjMatrix;
            V = v;
        }

        void addEdge(int v, int w, int weight) {
            adjMatrix[v][w] = weight;
            adjMatrix[w][v] = weight;
        }
    }

    public static int getClosestVertex(int distance[], boolean visited[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min) {
                if (!visited[i]) {
                    min = distance[i];
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

    public static int[] dijsktra(Graph graph, int src) {
        int[] result = new int[graph.V];

        boolean[] visited = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[src] = 0;

        for (int i = 0; i < graph.V; i++) {
            int closetVertex = getClosestVertex(result, visited);
            visited[closetVertex] = true;
            for (int j = 0; j < graph.V; j++) {
                if (!visited[j]) {
                    if (graph.adjMatrix[closetVertex][j] != 0) {
                        int d = result[closetVertex] + graph.adjMatrix[closetVertex][j];
                        if (d < result[j]) {
                            result[j] = d;
                        }
                    }
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] adjMatrx = new int[6][6];
        Graph graph = new Graph(adjMatrx, 6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 4, 9);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 3, 3);
        graph.addEdge(4, 3, 4);
        graph.addEdge(4, 5, 6);
        graph.addEdge(3, 5, 2);

        System.out.println(Arrays.toString(dijsktra(graph,0)));
    }
}
