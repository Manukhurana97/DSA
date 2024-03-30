package com.example.dsa.NewCode.DP;

public class RodCutting {

    public static int cutRod(int price[], int n) {
        return cutRodRecursion(n - 1, price, n);
    }

    public static int cutRodRecursion(int ind, int price[], int n) {

        if (ind == 0) {
            return n * price[0];
        }

        int take = (ind + 1 < n) ? price[ind] + cutRodRecursion(ind, price, n - (ind + 1)) : Integer.MIN_VALUE;
        int nottake = cutRodRecursion(ind - 1, price, n);

        return Math.max(take, nottake);
    }

    public static int cutRodMemoize(int ind, int price[], int n, int[][] dp) {

        if (ind == 0) {
            return n * price[0];
        }

        if (dp[n][ind] != 0)
            return dp[n][ind];

        int take = (ind + 1 < n) ? price[ind] + cutRodMemoize(ind, price, n - (ind + 1), dp) : Integer.MIN_VALUE;
        int nottake = cutRodMemoize(ind - 1, price, n, dp);

        dp[n][ind] = Math.max(take, nottake);

        return Math.max(take, nottake);
    }

    public static int cutRodTabulation(int[] price, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = n * price[0];
        }

        for (int ind = 1; ind <= n; ind++) {
            for (int w = 1; w <= n; w++) {
                int take = (ind <= w) ? price[ind - 1] + dp[ind][w - ind] : Integer.MIN_VALUE;
                int nottake = dp[ind - 1][w];

                dp[ind][w] = Math.max(take, nottake);
            }
        }

        return dp[n][n];
    }

}
