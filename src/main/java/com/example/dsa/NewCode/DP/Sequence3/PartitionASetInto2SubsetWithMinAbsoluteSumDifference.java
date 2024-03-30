package com.example.dsa.NewCode.DP.Sequence3;

import java.util.ArrayList;
import java.util.Arrays;

//  Partition A Set Into Two Subsets With Minimum Absolute Sum Difference
public class PartitionASetInto2SubsetWithMinAbsoluteSumDifference {

    public static int minimumDifference(int[] nums) {
        int totalSum = 0;

        for (int i : nums)
            totalSum += i;

        int[] min = { Integer.MAX_VALUE };
        minimumGenerateAllSubsetsRecursion(0, 0, 0, totalSum, min, nums);

        // long[][] dp = new long[nums.length][nums.length / 2 + 1];
        // minimumGenerateAllSubsetsMemoization(0, 0, 0, totalSum, min, nums, dp);

        return min[0];

    }

    // min = min(min, Math.abs(currentSum - (totalSum - currentSum)))
    private static void minimumGenerateAllSubsetsRecursion(int n, int count, int sum, int totalSum, int[] min,
            int[] nums) {
        if (count == nums.length / 2) {
            var absDiff = Math.abs(totalSum - 2 * sum);
            min[0] = Math.min(min[0], absDiff);
            return;
        }
        if (n == nums.length) {
            return;
        }

        minimumGenerateAllSubsetsRecursion(n + 1, count + 1, sum + nums[n], totalSum, min, nums);
        minimumGenerateAllSubsetsRecursion(n + 1, count, sum, totalSum, min, nums);
    }

    // recursion + memoization
    private static void minimumGenerateAllSubsetsMemoization(int n, int count, long sum, long totalSum, int[] min,
            int[] nums, long[][] dp) {
        if (count == nums.length / 2) {
            min[0] = (int) Math.min(min[0], Math.abs(totalSum - 2 * sum));
            return;
        }
        if (n == nums.length)
            return;

        if (dp[n][count] != 0)
            return;

        minimumGenerateAllSubsetsMemoization(n + 1, count + 1, sum + nums[n], totalSum, min, nums, dp);
        minimumGenerateAllSubsetsMemoization(n + 1, count, sum, totalSum, min, nums, dp);

        dp[n][count] = sum;
    }

    // tabulation
    private static int minimumGenerateAllSubsetsTabulation(int[] nums, int totalSum) {

        int[][] dp = new int[nums.length][nums.length / 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < totalSum; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = Integer.MAX_VALUE;
                int take = (nums[i] <= totalSum) ? dp[i - 1][j - nums[i - 1]] : Integer.MAX_VALUE;
                int notTake = dp[i - 1][j];

                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[dp.length][dp[0].length];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minimumDifference(arr));
    }

}
