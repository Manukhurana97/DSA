package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberoFProvinces3 {

    private static int findCircleNum(int[][] isConnected) {

        // convert adjancey matrix to adjancey list
        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++)
            input.add(new ArrayList<>());

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    input.get(i).add(j);
                    input.get(j).add(i);
                }
            }
        }

        // perform dfs on all the nodes, it will mark visit to all the provience
        int provience = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int nodes = 0; nodes < visited.length; nodes++) {
            if (!visited[nodes]) { // true, if not in provience or other provience
                provience += 1;
                dfs(input, visited, nodes); // perform dfs to mark too the nodes in a provience
            }
        }

        return provience;
    }

    private static void dfs(List<List<Integer>> isConnected, boolean[] visited, int currentNode) {

        visited[currentNode] = true;

        for (var n : isConnected.get(currentNode))
            if (!visited[n])
                dfs(isConnected, visited, n);
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(arr));
    }

}
