package com.example.dsa.NewCode.DP;

import java.util.Arrays;

/* 
 *  1 Express in terms of index
 *  2 explore all path/possibility
 *  3 retun count
 */
public class CountSubSetWithSumK {

    public static int findWays(int num[], int tar) {
        // return findWaysRecurssion(num.length - 1, num, tar);

        // int[][] dp = new int[num.length][tar + 1];
        // return findWaysMemoization(num.length - 1, num, tar, dp);

        // return findWaysTabulation(num, tar);

        return findWaysSpaceOptimization(num, tar);
    }

    // Resursion , time: O(N^2) , space O(n)
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
        int[] dp = new int[tar + 1];

        for (int i = 0; i < num.length; i++)
            dp[0] = 1;

        for (int index = 1; index <= num.length; index++) {
            int[] curr = Arrays.copyOf(dp, dp.length);
            for (int sum = 0; sum <= tar; sum++) {
                int take = (num[index - 1] > sum) ? 0 : curr[sum - num[index - 1]];
                int notTake = curr[sum];

                dp[sum] = (take + notTake) % 1000000007;
            }

        }

        return dp[tar];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };

        System.out.println(findWays(arr, 3));
    }

}
