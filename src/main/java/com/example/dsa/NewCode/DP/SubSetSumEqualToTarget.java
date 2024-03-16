package com.example.dsa.NewCode.DP;

import java.util.Arrays;

public class SubSetSumEqualToTarget {

    public static boolean subsetSumToK(int n, int target, int arr[]) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        // return subsetSumToKRecursion(n - 1, target, arr);
        // return subsetSumToKMemoization(n - 1, target, arr, dp);
        return subsetSumToKTabulation(n, target, arr, dp);
    }

    // recursion
    public static boolean subsetSumToKRecursion(int n, int target, int arr[]) {

        if (target == 0)
            return true;
        if (n == 0)
            return (arr[0] == target); // if 0th element has target value

        if (arr[n] <= target)
            if (subsetSumToKRecursion(n - 1, target - arr[n], arr))
                return true;

        if (subsetSumToKRecursion(n - 1, target, arr))
            return true;

        return false;
    }

    // recursion + memoiation
    public static boolean subsetSumToKMemoization(int n, int target, int arr[], boolean[][] dp) {

        if (target == 0)
            return true;
        if (n == -1)
            return false; // visit till -1

        if (dp[n][target])
            return false;

        if (arr[n] <= target)
            if (subsetSumToKMemoization(n - 1, target - arr[n], arr, dp))
                return true;

        if (subsetSumToKMemoization(n - 1, target, arr, dp))
            return true;

        dp[n][target] = true;

        return false;
    }

    // tabulation :: "[1,5,11,5]"
    public static boolean subsetSumToKTabulation(int n, int target, int arr[], boolean[][] dp) {

        for (int i = 0; i <= n; i++) // it means that it's possible to achieve a sum of "0" with the subset
            dp[i][0] = true;

        // for (int i = 1; i <= target; i++) // since [0][0] is alrady initialize , its
        // not possible to achieve the sum greater the 0;
        // dp[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) { // target
                boolean take = false;
                if (arr[i - 1] <= j)
                    take = dp[i - 1][j - arr[i - 1]];
                boolean notTake = dp[i - 1][j];

                dp[i][j] = take || notTake;
            }
        }

        return dp[n][target];
    }

    // space optimization
    public static boolean subsetSumToKSpaceOptimization(int n, int target, int arr[]) {

        boolean[] prev = new boolean[target + 1];
        boolean[] cur = new boolean[target + 1];

        for (int i = 0; i <= n; i++) // it means that it's possible to achieve a sum of "0" with the subset
            prev[0] = cur[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) { // target
                boolean take = false;
                if (arr[i - 1] <= j)
                    take = prev[j - arr[i - 1]];
                boolean notTake = prev[j];

                cur[j] = take || notTake;
            }
            prev = Arrays.copyOf(cur, cur.length);
        }

        return prev[target];
    }

    private int minimumGenerateAllSubsetsTabulation(int n, int target, int[] arr) {
        if (target < 0)
            return -target;

        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i < n; i++) // it means that it's possible to achieve a sum of "0" with the subset
            dp[i][0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) { // target
                boolean take = false;
                if (arr[i - 1] <= j)
                    take = dp[i - 1][j - arr[i - 1]];
                boolean notTake = dp[i - 1][j];

                dp[i][j] = take || notTake;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= target; i++) {
            if (dp[n - 1][i]) {
                var absDiff = Math.abs(target - i);
                min = Math.min(min, Math.abs(i - absDiff));
            }
        }

        return min;
    }

}
