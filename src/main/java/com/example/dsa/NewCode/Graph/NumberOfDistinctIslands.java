package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberOfDistinctIslands {

    public static int numDistinctIslands(int[][] grid) {
        Set<String> uniqueislands = new HashSet<>();
        int[][] visited = new int[grid.length][grid[0].length];

        /* iterate all the nodes */
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (visited[r][c] == 0 && grid[r][c] == 1) { // if not already visited and is island

                    StringBuilder builder = new StringBuilder();
                    getIslandsDFS(r, c, grid, visited, builder, r, c);

                    if (!uniqueislands.contains(builder.toString())) { // if similar shape iland exist , then ignore
                        uniqueislands.add(builder.toString());
                    }
                }
            }
        }

        return uniqueislands.size();
    }

    /* dfs to get all the adjasent islands (1) in 4 direction */
    private static void getIslandsDFS(int r, int c, int[][] grid, int[][] visited, StringBuilder builder,
            int baseR, int baseC) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == 1 || grid[r][c] == 0)
            return;

        visited[r][c] = 1;
        builder.append(Math.abs(baseR - r) + " ").append(Math.abs(baseC - c) + " "); // add all the island
                                                                                     // coordinate
        // (relative to base island)

        getIslandsDFS(r - 1, c, grid, visited, builder, baseR, baseC); // up
        getIslandsDFS(r, c - 1, grid, visited, builder, baseR, baseC); // left
        getIslandsDFS(r + 1, c, grid, visited, builder, baseR, baseC); // down
        getIslandsDFS(r, c + 1, grid, visited, builder, baseR, baseC); // right
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
        System.out.println(numDistinctIslands(arr));
        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };
        System.out.println(numDistinctIslands(grid));
    }
}
