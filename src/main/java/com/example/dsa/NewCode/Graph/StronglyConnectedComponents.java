package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* 
* using kosaraju's algo 
 * valid for directed graph 
*/
public class StronglyConnectedComponents {

    private void dfs(int i, int[] visited, List<List<Integer>> adj, Stack<Integer> stack) {

        visited[i] = 1;
        for (var neighour : adj.get(i)) {
            if (visited[neighour] == 0) {
                dfs(neighour, visited, adj, stack);
            }
        }
        stack.add(i);
    }

    private void reverseGraph(List<List<Integer>> adj, List<List<Integer>> adj1, int V) {
        for (int i = 0; i < V; i++) {
            adj1.add(new ArrayList<>());
        }
        for (var nodes : adj) {
            adj1.get(nodes.get(1)).add(nodes.get(0));
        }
    }

    private void dfsReverse(int node, int[] visited, List<List<Integer>> adj) {
        visited[node] = 1;
        for (var neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                dfsReverse(node, visited, adj);
            }
        }
    }

    private int kosaraju(int V, List<List<Integer>> adj) {

        /* sort all the edges by the finishing time */
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++)
            if (visited[i] == 0)
                dfs(i, visited, adj, stack);

        /* Reverse a graph */
        List<List<Integer>> adj1 = new ArrayList<>();
        reverseGraph(adj, adj1, V);

        /* perform a dfs on a reversed graph */
        int SCC = 0;
        visited = new int[V];
        while (!stack.isEmpty()) {
            var node = stack.pop();
            if (visited[node] == 0) {
                SCC++; // count the component
                dfsReverse(node, visited, adj1);
            }
        }

        return SCC;
    }

}
