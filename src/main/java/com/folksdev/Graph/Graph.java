package com.folksdev.Graph;

import java.util.*;

public class Graph {

    private int V;
    private LinkedList<Integer> graph [];

    public Graph(int v) {
        V = v;
        graph = new LinkedList[v];

        for (int i = 0; i <  v; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        graph[v].add(w);
    }

    /* *********************************
     **************  DFS  **************
     * *********************************
     */
    List<Integer> dfsRecursive(int v) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();
        return dfsHelper(v, visited, result);
    }

    List<Integer> dfsHelper(int v, boolean visited[], List<Integer> result) {
        visited[v] = true;
        result.add(v);
        int a = 0;
        for (int i = 0; i < graph[v].size(); i++) {
            a = graph[v].get(i);
            if (!visited[a]) {
                dfsHelper(a, visited, result);
            }
        }

        return result;
    }

    //O(V + E)
    List<Integer> dfsIterative(int v) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];
        //[0=f][1=f][2=f][3=f][4=f]
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();
            if (!visited[v]) {
                result.add(v);
                visited[v] = true;
            }
            LinkedList<Integer> neighbours = graph[v];
            for (int i = 0; i < neighbours.size(); i++) {
                v = neighbours.get(i);
                if (!visited[v]) {
                    stack.push(v);
                }
            }

        }

        return result;
    }

    /* *********************************
     **************  BFS  **************
     * *********************************
     */
    List<Integer> bfsIterative(int v) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];
        //[0=f][1=f][2=f][3=f][4=f]
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            if (!visited[v]) {
                result.add(v);
                visited[v] = true;
            }
            LinkedList<Integer> neighbours = graph[v];
            for (int i = 0; i < neighbours.size(); i++) {
                v = neighbours.get(i);
                if (!visited[v]) {
                    queue.add(v);
                }
            }

        }

        return result;
    }


    public static void main(String[] args) {
        Graph graph1 = new Graph(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 0);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 1);
        graph1.addEdge(2, 4);
        graph1.addEdge(3, 0);
        graph1.addEdge(4, 2);
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 2);
        System.out.println(graph1.bfsIterative(0));

    }



}
