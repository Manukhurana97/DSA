package com.example.dsa.NewCode.DP;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];

        // return minPathSumRecusssion(grid.length - 1, grid[0].length - 1, grid);
        // return minPathSumMemoization(grid.length - 1, grid[0].length - 1, grid, arr);
        // return minPathSumTabulation(grid, arr);
        return minPathSumSpaceOptimation(grid);

    }

    // recurssion: bottom -> up
    private int minPathSumRecusssion(int r, int c, int[][] grid) {
        if (r < 0 || c < 0)
            return Integer.MAX_VALUE;
        if (r == 0 && c == 0)
            return grid[r][c];

        int up = minPathSumRecusssion(r - 1, c, grid);
        int left = minPathSumRecusssion(r, c - 1, grid);

        return Math.min(up, left);
    }

    // Memiozation: bottom -> up
    private int minPathSumMemoization(int r, int c, int[][] grid, int[][] arr) {
        if (r < 0 || c < 0)
            return Integer.MAX_VALUE;
        if (r == 0 && c == 0)
            return grid[r][c];

        if (arr[r][c] != 0)
            return arr[r][c];

        int up = minPathSumMemoization(r - 1, c, grid, arr);
        int left = minPathSumMemoization(r, c - 1, grid, arr);

        int min = grid[r][c] + Math.min(up, left);
        arr[r][c] = min;

        return min;
    }

    // Tabulation: up -> bottom
    private int minPathSumTabulation(int[][] grid, int[][] arr) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    arr[i][j] = grid[i][j];
                else {
                    int up = i > 0 ? arr[i - 1][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? arr[i][j - 1] : Integer.MAX_VALUE;

                    int min = grid[i][j] + Math.min(up, left);
                    arr[i][j] = min;
                }
            }
        }
        return arr[grid.length - 1][grid[0].length - 1];
    }

    // Space optimization: up -> bottom
    private int minPathSumSpaceOptimation(int[][] grid) {
        int[] prev = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int[] curr = new int[grid[0].length];
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    curr[j] = grid[i][j];
                else {
                    int up = i > 0 ? prev[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? curr[j - 1] : Integer.MAX_VALUE;

                    int min = grid[i][j] + Math.min(up, left);
                    curr[j] = min;
                }
            }
            prev = curr;
        }
        return prev[prev.length - 1];

    }

    public static void main(String[] args) {
        MinimumPathSum min = new MinimumPathSum();

        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(min.minPathSum(grid));
    }

}
