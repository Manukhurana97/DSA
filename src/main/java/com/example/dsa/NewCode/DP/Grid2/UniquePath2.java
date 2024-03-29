package com.example.dsa.NewCode.DP;

// we can go down and right and find path from 0 to n-1 in grid
// we have give an obstacle (-1) , if we encounter obstacle we cant continue on the path
public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;
        // return uniquePathsWithObstaclesRecurssion(obstacleGrid.length - 1,
        // obstacleGrid[0].length - 1, obstacleGrid);
        // int[][] visited = new int[obstacleGrid.length][obstacleGrid[0].length];
        // return uniquePathsWithObstaclesMemoization(obstacleGrid.length - 1,
        // obstacleGrid[0].length - 1, obstacleGrid,visited);
        return uniquePathsWithObstaclesTabulation(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid);
    }

    public int uniquePathsWithObstaclesRecurssion(int n, int m, int[][] obstacleGrid) {
        if (n < 0 || m < 0 || obstacleGrid[n][m] == 1)
            return 0;
        if (n == 0 && m == 0)
            return 1;

        int up = uniquePathsWithObstaclesRecurssion(n - 1, m, obstacleGrid);
        int left = uniquePathsWithObstaclesRecurssion(n, m - 1, obstacleGrid);

        return up + left;

    }

    // memoizatrion: use space to increase speed
    public int uniquePathsWithObstaclesMemoization(int n, int m, int[][] obstacleGrid, int[][] visited) {
        if (n < 0 || m < 0 || obstacleGrid[n][m] == 1)
            return 0;
        if (n == 0 && m == 0)
            return 1;

        if (visited[n][m] != 0)
            return visited[n][m];

        int up = uniquePathsWithObstaclesMemoization(n - 1, m, obstacleGrid, visited);
        int left = uniquePathsWithObstaclesMemoization(n, m - 1, obstacleGrid, visited);

        visited[n][m] = up + left;

        return up + left;
    }

    // tabulation: remove extra stack space
    public int uniquePathsWithObstaclesTabulation(int n, int m, int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1)
            return 0;

        int[][] visited = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (obstacleGrid[i][j] == 1) {
                    visited[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    visited[i][j] = 1;
                } else {
                    int up = (i > 0) ? visited[i - 1][j] : 0;
                    int left = (j > 0) ? visited[i][j - 1] : 0;
                    visited[i][j] = (up + left);
                }
            }
        }

        return visited[n][m];
    }

    // space optimization

    // tabulation: remove extra stack space
    public int uniquePathsWithObstaclesSpaceOptimization(int n, int m, int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1)
            return 0;

        int[] visited = new int[m + 1];

        for (int i = 0; i <= n; i++) {
            int[] temp = new int[m + 1];
            for (int j = 0; j <= m; j++) {

                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                } else if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    int up = (i > 0) ? visited[j] : 0;
                    int left = (j > 0) ? temp[j - 1] : 0;
                    temp[j] = (up + left);
                }
            }

            visited = temp;
        }

        return visited[m];
    }

    public static void main(String[] args) {
        UniquePath2 uniquePath2 = new UniquePath2();
        int[][] arr = { { 0, 1 }, { 0, 0 } };
        System.out.println(uniquePath2.uniquePathsWithObstacles(arr));
        int[][] arr1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePath2.uniquePathsWithObstacles(arr1));
    }

}
