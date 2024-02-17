package com.example.dsa.NewCode.Graph;

import java.util.*;

public class CriticalConnections {

    int timer = 1;

    private List<List<Integer>> criticalComponent(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (var node : connections) {
            adj.get(node.get(0)).add(node.get(1));
            adj.get(node.get(1)).add(node.get(0));
        }

        int[] visited = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];

        List<List<Integer>> result = new ArrayList<>();
        dfs(0, -1, adj, visited, low, time, result);
        return result;

    }

    private void dfs(int node, int parent, List<List<Integer>> adj, int[] visited, int[] low, int[] time,
            List<List<Integer>> result) {
        visited[node] = 1;
        time[node] = low[node] = timer;
        timer++;

        for (var neighbours : adj.get(node)) {
            if (parent == neighbours)
                continue;
            if (visited[neighbours] == 0) {
                dfs(neighbours, node, adj, visited, low, time, result);

                low[node] = Math.min(low[neighbours], low[node]);

                if (low[neighbours] > time[node]) {
                    result.add(Arrays.asList(neighbours, node));
                }
            } else {
                low[node] = Math.min(low[neighbours], low[node]);
            }
        }
    }

    public static void main(String[] args) {
        CriticalConnections cc = new CriticalConnections();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        List<List<Integer>> result = cc.criticalComponent(4, connections);
        System.out.println(result);
    }

}
