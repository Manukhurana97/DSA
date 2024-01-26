package com.example.dsa.NewCode.Graph;

import java.util.*;

public class BiPartiteGraph {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                list.get(i).add(graph[i][j]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (!bfs(i, list.size(), list, color))
                return false;
        }

        return false;
    }

    private static boolean bfs(int i, int v, List<List<Integer>> list, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        color[i] = 0;
        while (!queue.isEmpty()) {
            int current = queue.remove();

            for (int j : list.get(current)) {
                // if not colored
                if (color[j] == -1) {
                    color[j] = 1 - color[current];
                } else if (color[current] == color[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
