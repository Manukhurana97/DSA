package com.example.dsa.NewCode.DP;

public class PartitionEqualSubsetSum {

    public static boolean subsetSumToKTabulation(int n, int target, int arr[], boolean[][] dp) {

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= target; i++)
            dp[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[n][target];
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }

        if (totalSum % 2 != 0)
            return false;

        boolean[][] dp = new boolean[nums.length][totalSum];
        return subsetSumToKTabulation(nums.length - 1, totalSum / 2, nums, dp);
    }

}
