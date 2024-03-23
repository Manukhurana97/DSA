package com.example.dsa.NewCode.DP;

/* 0/1 knapstack */

public class knapstack {

    static int knapsack(int[] wts, int[] arr, int n, int maxWeight) {

        // return maxProfitMinWeightRecursion(arr.length - 1, arr, wts, maxWeight, 0);

        // int[][] dp = new int[arr.length][maxWeight + 1];
        // return (maxProfitMinWeightMemoization(arr.length - 1, arr, wts, maxWeight, 0,
        // dp));

        // return maxProfitMinWeightTabulation(n, arr, wts, maxWeight);

        return maxProfitMinWeightSpaceOptimization(n, arr, wts, maxWeight);

    }

    /* recurtion */
    private static int maxProfitMinWeightRecursion(int n, int[] arr, int[] wts, int maxWeight, int total) {

        if (n < 0)
            return 0;

        int take = (maxWeight - wts[n] < 0) ? 0
                : arr[n] + maxProfitMinWeightRecursion(n - 1, arr, wts, maxWeight - wts[n], total);
        int notTake = maxProfitMinWeightRecursion(n - 1, arr, wts, maxWeight, total);

        return Math.max(take, notTake);
    }

    /* recursion + memoization */
    private static int maxProfitMinWeightMemoization(int n, int[] arr, int[] wts, int maxWeight, int total,
            int[][] dp) {

        if (n < 0)
            return 0;

        if (dp[n][maxWeight] != 0)
            return dp[n][maxWeight];

        int take = (maxWeight - wts[n] < 0) ? 0
                : arr[n] + maxProfitMinWeightMemoization(n - 1, arr, wts, maxWeight - wts[n], total, dp);
        int notTake = maxProfitMinWeightMemoization(n - 1, arr, wts, maxWeight, total, dp);

        dp[n][maxWeight] = Math.max(take, notTake);

        return Math.max(take, notTake);
    }

    // tabulation
    private static int maxProfitMinWeightTabulation(int n, int[] arr, int[] wts, int maxWeight) {

        int[][] dp = new int[n][maxWeight + 1];

        for (int j = wts[0]; j <= maxWeight; j++)
            dp[0][j] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                int take = (wts[i] > j) ? Integer.MIN_VALUE : arr[i] + dp[i - 1][j - wts[i]];
                int notTake = dp[i - 1][j];

                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][maxWeight];
    }

    // space Optimization
    private static int maxProfitMinWeightSpaceOptimization(int n, int[] arr, int[] wts, int maxWeight) {

        int[] curr = new int[maxWeight + 1];
        int[] prev = new int[maxWeight + 1];

        for (int j = wts[0]; j <= maxWeight; j++)
            prev[j] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                int take = (wts[i] > j) ? Integer.MIN_VALUE : arr[i] + prev[j - wts[i]];
                int notTake = prev[j];

                curr[j] = Math.max(take, notTake);
            }

            prev = curr;
            curr = new int[maxWeight + 1];
        }

        return prev[maxWeight];
    }

    // since we are dependent only on the last index, we dont need current we can
    // update in last as elemenet are not dependent withing a row
    private static int maxProfitMinWeightSpaceOptimizationKP(int n, int[] arr, int[] wts, int maxWeight) {

        int[] curr = new int[maxWeight + 1];
        int[] prev = new int[maxWeight + 1];

        for (int j = wts[0]; j <= maxWeight; j++)
            prev[j] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = maxWeight; j >= 0; j--) {
                int take = (wts[i] > j) ? Integer.MIN_VALUE : arr[i] + prev[j - wts[i]];
                int notTake = prev[j];

                curr[j] = Math.max(take, notTake);
            }

            prev = curr;
            curr = new int[maxWeight + 1];
        }

        return prev[maxWeight];
    }

}
