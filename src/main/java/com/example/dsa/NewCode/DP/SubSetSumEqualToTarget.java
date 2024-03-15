package com.example.dsa.NewCode.DP;

public class SubSetSumEqualToTarget {

    public static boolean subsetSumToK(int n, int target, int arr[]) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        // return subsetSumToKRecursion(n - 1, target, arr);
        return subsetSumToKMemoization(n - 1, target, arr, dp);
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

    // tabulation
    public static boolean subsetSumToKTabulation(int n, int target, int arr[], boolean[][] dp) {

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {

                boolean take = dp[i][j] = (arr[i] < target) ? dp[i - 1][j - arr[i - 1]] : false;
                boolean notTake = dp[i][j] = dp[i - 1][j];
                dp[i][j] = take | notTake;
            }
        }

        return dp[n][target];
    }

}
