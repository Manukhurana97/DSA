package com.example.dsa.NewCode.DP;

/* https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/ */
public class MaxCherryPickup {

    public static int cherryPickup(int[][] grid) {
        // return cherryPickup(0, 0, grid[0].length - 1, grid);
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        return cherryPickupMemoization(0, 0, grid[0].length - 1, grid, dp);
    }

    private static int cherryPickup(int i, int j1, int j2, int[][] grid) {

        if (i >= grid.length || j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length)
            return Integer.MIN_VALUE;

        if (i == grid.length - 1)
            return grid[i][j1] + ((j1 == j2) ? 0 : +grid[i][j2]);

        int cherries = grid[i][j1] + ((j1 == j2) ? 0 : grid[i][j2]);

        // Iterate through all possible movements for both robots
        int max = Integer.MIN_VALUE;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int newCol1 = j1 + r;
                int newCol2 = j2 + c;
                max = Math.max(max, cherryPickup(i + 1, newCol1, newCol2, grid));
            }
        }

        return max + cherries;
    }

    private static int cherryPickupMemoization(int i, int j1, int j2, int[][] grid, int[][][] dp) {

        if (i >= grid.length || j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length)
            return Integer.MIN_VALUE;

        if (i == grid.length - 1)
            return grid[i][j1] + ((j1 == j2) ? 0 : +grid[i][j2]);

        if (dp[i][j1][j2] != 0) {
            return dp[i][j1][j2];
        }

        int cherries = grid[i][j1] + ((j1 == j2) ? 0 : grid[i][j2]);

        // Iterate through all possible movements for both robots
        int max = Integer.MIN_VALUE;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int newCol1 = j1 + r;
                int newCol2 = j2 + c;
                max = Math.max(max, cherryPickupMemoization(i + 1, newCol1, newCol2, grid, dp));
                max = Math.max(max, cherryPickupMemoization(i + 1, newCol1, newCol2, grid, dp));
            }
        }

        dp[i][j1][j2] = max + cherries;

        return max + cherries;
    }

}
