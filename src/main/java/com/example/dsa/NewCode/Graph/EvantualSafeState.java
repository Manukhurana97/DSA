package com.example.dsa.NewCode.Graph;

import java.util.*;

// find all the nodes that are pointing to the end nodes / not pointing to the safe note
public class EvantualSafeState {
    private static List<Integer> evantualSafeState(List<List<Integer>> grid) {

        int[] visited = new int[grid.size()];
        int[] pathVisited = new int[grid.size()];
        int[] check = new int[grid.size()];

        for (int i = 0; i < grid.size(); i++) {
            if (visited[i] == 0) {
                dfs(i, grid, visited, pathVisited, check);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++)
            if (check[i] == 1)
                result.add(i);
        return result;
    }

    // detecting cycle in dfs
    private static boolean dfs(int i, List<List<Integer>> grid, int[] visited, int[] pathVisited, int[] check) {

        visited[i] = 1;
        pathVisited[i] = 1;
        check[i] = 0;

        for (var neighbour : grid.get(i)) {
            if (visited[neighbour] == 0) {
                if (dfs(neighbour, grid, visited, pathVisited, check))
                    return true;
            } else if (pathVisited[neighbour] == 1) {
                return true;
            }
        }

        check[i] = 1;// if element is not a check ot not pointing to a cycle we make it as 1
        pathVisited[i] = 0;
        return false;
    }

    public static void main(String[] args) {

    }
}
