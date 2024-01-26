package com.example.dsa.NewCode.Graph;

import java.util.*;

public class DetectDirectedGraphIsCyclic {

    private static boolean isCyclic(List<List<Integer>> grid) {

        int[] visited = new int[grid.size()];
        int[] pathVisited = new int[grid.size()];

        for (int i = 0; i < grid.size(); i++)
            if (visited[i] == 0 && dfs(i, grid, visited, pathVisited))
                return true;

        return false;
    }

    private static boolean dfs(int current, List<List<Integer>> grid, int[] visited, int[] pathVisited) {
        visited[current] = 1;
        pathVisited[current] = 1;

        for (int neighbour : grid.get(current)) {
            if (visited[neighbour] == 0) {
                if (dfs(neighbour, grid, visited, pathVisited))
                    return true;
            } else if (pathVisited[neighbour] == 1) {
                return true;
            }
        }

        pathVisited[current] = 0;
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 3));
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3));
        input.add(Arrays.asList());

        System.out.println(isCyclic(input));
    }

}
