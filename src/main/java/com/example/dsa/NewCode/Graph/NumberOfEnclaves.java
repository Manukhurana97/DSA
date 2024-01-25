package com.example.dsa.NewCode.Graph;

public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {

        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        // get all the boundry nodes
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (visited[i][j] == 0 && grid[i][j] == 1 && isBoundary(i, j, m, n))
                    dfs(grid, visited, i, j);

        // all the nodes that are not boundry and if not visited , the is a internal
        // island
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (visited[i][j] == 0 && grid[i][j] == 1)
                    result += 1;

        return result;

    }

    private static void dfs(int[][] arr, int[][] boundryIsland, int r, int c) {

        if (r < 0 || c < 0 || r >= boundryIsland.length || c >= boundryIsland[r].length || boundryIsland[r][c] == 1
                || arr[r][c] == 0)
            return;

        boundryIsland[r][c] = 1;

        dfs(arr, boundryIsland, r - 1, c);
        dfs(arr, boundryIsland, r, c - 1);
        dfs(arr, boundryIsland, r + 1, c);
        dfs(arr, boundryIsland, r, c + 1);
    }

    private static boolean isBoundary(int r, int c, int m, int n) {
        return r == 0 || c == 0 || r == m - 1 || c == n - 1;
    }

}
