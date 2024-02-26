package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberOfConnectedComponent {

    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < n; i++)
            input.add(new ArrayList<>());

        for (var edge : edges)
            input.get(edge[0]).add(edge[1]);

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, input);
            }
        }

        return count;
    }

    private void dfs(int i, boolean[] visited, List<List<Integer>> adj) {

        visited[i] = true;

        for (var neighbour : adj.get(i)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj);
            }
        }

    }

    public static void main(String[] args) {

        NumberOfConnectedComponent component = new NumberOfConnectedComponent();

        int[][] arr = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(component.countComponents(5, arr));
    }
}
