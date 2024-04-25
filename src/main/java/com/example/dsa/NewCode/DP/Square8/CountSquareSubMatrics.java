package com.example.dsa.NewCode.DP.Square8;

public class CountSquareSubMatrics {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < m; j++)
            dp[0][j] = matrix[0][j];
        for (int j = 0; j < n; j++)
            dp[0][j] = matrix[j][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1)
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
            }
        }

        int count = 0;
        for (int[] i : dp) {
            for (int j : i) {
                count += j;
            }
        }

        return count;
    }
}
