package com.example.dsa.NewCode.DP.Grid2;

import java.util.List;

/* min path sum on a triangle 
 * can move in 2 direction :  bottom cell, bottom-right cell
*/
public class FixStartingVariableEnding {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] visited = new int[triangle.size()][triangle.get(triangle.size() - 1).size() + 1];
        // return minimumTotalRecurssion(0, 0, triangle);
        // return minimumTotalMemoization(0, 0, triangle, visited);
        return minimumTotalTabulation(triangle, visited);
        // return minimumTotalSpaceOptimization(triangle);
    }

    // recursion : top down
    public int minimumTotalRecurssion(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        int down = minimumTotalRecurssion(i + 1, j, triangle);
        int diag = minimumTotalRecurssion(i + 1, j + 1, triangle);

        return triangle.get(i).get(j) + Math.min(down, diag);
    }

    // recursion + memoization
    public int minimumTotalMemoization(int i, int j, List<List<Integer>> triangle, int[][] visited) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        if (visited[i][j] != 0)
            return visited[i][j];

        int down = minimumTotalMemoization(i + 1, j, triangle, visited);
        int diag = minimumTotalMemoization(i + 1, j + 1, triangle, visited);

        int min = triangle.get(i).get(j) + Math.min(down, diag);
        visited[i][j] = min;
        return min;
    }

    // tabulation
    public int minimumTotalTabulation(List<List<Integer>> triangle, int[][] visited) {

        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1)
                    visited[i][j] = triangle.get(i).get(j);
                else
                    visited[i][j] = triangle.get(i).get(j) + Math.min(visited[i + 1][j], visited[i + 1][j + 1]);

            }
        }

        return visited[0][0];
    }

    public int minimumTotalSpaceOptimization(List<List<Integer>> triangle) {

        int[] visited = new int[triangle.get(triangle.size() - 1).size() + 1];
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                visited[j] = triangle.get(i).get(j) + Math.min(visited[j], visited[j + 1]);
            }
        }

        return visited[0];
    }

}
