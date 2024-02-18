package com.example.dsa.NewCode.Graph;

import java.util.*;

/* 
 * a graph is said to be a bipartite graph is parent and child dont have same color 
 *  1 -> (2,3) -> 4 : its a bipartite 
 *  1 -> (2, 3) ->  (2, 3->4 ) -> (2, 4) -> 5 : its not a bipartite because value of 2,4 is different from 5       
*/
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
            // BFS
            if (!bfs(i, list.size(), list, color))
                return false;

            // DFS
            if (!dfs(i, list, color))
                return false;
        }
        return true;
    }

    // bfs
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

    // dfs
    private static boolean dfs(int current, List<List<Integer>> list, int[] color) {
        for (int j : list.get(current)) {
            if (color[j] == -1) {
                color[j] = 1 - color[current];
                if (!dfs(j, list, color)) {
                    return false;
                }
            } else if (color[current] == color[j]) {
                return false;
            }
        }
        return true;
    }

}
