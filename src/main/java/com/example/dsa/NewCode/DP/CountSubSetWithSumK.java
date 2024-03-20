package com.example.dsa.NewCode.DP;

/* 
 *  1 Express in terms of index
 *  2 explore all path/possibility
 *  3 retun count
 */
public class CountSubSetWithSumK {

    public static int findWays(int num[], int tar) {
        return findWaysRecurssion(num.length - 1, num, tar);

        // int[] dp = new int[num.length];
        // return findWaysMemoization(num.length - 1, num, tar, dp);
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
    public static int findWaysMemoization(int index, int num[], int tar, int[] dp) {

        if (tar == 0)
            return 1;
        if (index == 0)
            return num[index] == tar ? 1 : 0;

        if (dp[index] != 0)
            return dp[index];

        // take + notTake

        int take = (num[index] > tar) ? 0 : findWaysMemoization(index - 1, num, tar - num[index], dp);
        int notTake = findWaysMemoization(index - 1, num, tar, dp);

        dp[index] = take + notTake;

        return take + notTake;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };

        System.out.println(findWays(arr, 3));
    }

}
