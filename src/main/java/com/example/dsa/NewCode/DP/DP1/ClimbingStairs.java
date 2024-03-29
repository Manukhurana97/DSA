package com.example.dsa.NewCode.DP.DP1;

import java.util.*;

/* 
https://leetcode.com/problems/climbing-stairs/ 
give a number of stairs, starting from 0, user can climb either 1, 2 steps, return distinct way he can climb 
*/
public class ClimbingStairs {

    public int climbStairs(int n) {
        // return climbStairsRecursion(n);

        int[] dp = new int[n + 1];
        // return climbStairsMemoization(n, dp);
        // return climbStairsTabulation(n, dp);

        return climbStairSpaceOptimizarion(n);
    }

    // Recursion: Time: O(n^2), Space: O(n stack space)
    private int climbStairsRecursion(int n) {

        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        int oneStep = climbStairsRecursion(n - 1);
        int twoStep = climbStairsRecursion(n - 2);
        return oneStep + twoStep;
    }

    // Memoization: Time: O(n), Space: O(n dp + n stack space)
    private int climbStairsMemoization(int n, int[] dp) {

        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        if (dp[n] != 0)
            return dp[n];

        int oneStep = climbStairsRecursion(n - 1);
        int twoStep = climbStairsRecursion(n - 2);

        dp[n] = oneStep + twoStep;
        return oneStep + twoStep;
    }

    // Tabulation: Time: O(n), Space: O(n dp)
    private int climbStairsTabulation(int n, int[] dp) {

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int one = dp[i - 1];
            int two = (i - 2 >= 0) ? dp[i - 2] : 0;
            dp[i] = one + two;
        }

        return dp[n];
    }

    // Space Optimization: Time: O(n), Space: O(1)
    private int climbStairSpaceOptimizarion(int n) {

        int prev1 = 1;
        int prev2 = 0;

        for (int i = 1; i <= n; i++) {
            int cur = prev1 + ((i - 2 >= 0) ? prev2 : 0);
            prev2 = prev1;
            prev1 = cur;

        }

        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(ClimbStairsRecursion(3));
        System.out.println(ClimbStairsMemoization(3));
    }

}
