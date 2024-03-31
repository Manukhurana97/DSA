package com.example.dsa.NewCode.DP.Sequence3;

import java.util.Arrays;

public class TargetSum {

    public static int findWaysRecurssion(int index, int num[], int tar) {

        if (tar == 0)
            return 1;
        if (index == 0)
            return num[index] == tar ? 1 : 0;

        // take + notTake
        return findWaysRecurssion(index - 1, num, tar - num[index]) + findWaysRecurssion(index - 1, num, tar);

    }

    // Resursion + Memoization , time: O(N) , space O(2N)
    public static int findWaysMemoization(int index, int num[], int tar, int[][] dp) {

        if (tar == 0)
            return 1;
        if (index == 0)
            return num[index] == tar ? 1 : 0;

        if (dp[index][tar] != 0)
            return dp[index][tar];

        // take + notTake
        int take = (num[index] > tar) ? 0 : findWaysMemoization(index - 1, num, tar - num[index], dp);
        int notTake = findWaysMemoization(index - 1, num, tar, dp);

        dp[index][tar] = take + notTake;

        return take + notTake;
    }

    // Tabulation , time: O(N) , space O(N)
    /*
     * 1. Base case
     * 2. took at the changing parameter and write nested loops
     * 3. copy the recursion
     */
    public static int findWaysTabulation(int num[], int tar) {
        int[][] dp = new int[num.length + 1][tar + 1];

        for (int i = 0; i < num.length; i++)
            dp[i][0] = 1;

        for (int index = 1; index <= num.length; index++) {
            for (int sum = 0; sum <= tar; sum++) {
                int take = (num[index - 1] > sum) ? 0 : dp[index - 1][sum - num[index - 1]];
                int notTake = dp[index - 1][sum];

                dp[index][sum] = (take + notTake) % 1000000007;
            }
        }

        return dp[num.length][tar];
    }

    public static int findWaysSpaceOptimization(int num[], int tar) {
        int[] curr = new int[tar + 1];

        for (int i = 0; i < num.length; i++)
            curr[0] = 1;

        for (int index = 1; index <= num.length; index++) {
            int[] prev = Arrays.copyOf(curr, curr.length);
            for (int sum = 0; sum <= tar; sum++) {
                int take = (num[index - 1] > sum) ? 0 : prev[sum - num[index - 1]];
                int notTake = prev[sum];

                curr[sum] = (take + notTake) % 1000000007;
            }

        }

        return curr[tar];
    }

    public int countPartition(int[] arr, int d) {
        int totalSum = 0;
        for (var i : arr)
            totalSum += i;

        if (totalSum - d < 0 || (totalSum - d) % 2 != 0)
            return 0;

        return findWaysSpaceOptimization(arr, (totalSum - d) / 2);

    }

    public int findTargetSumWays(int[] nums, int target) {
        return countPartition(nums, target);
    }

}