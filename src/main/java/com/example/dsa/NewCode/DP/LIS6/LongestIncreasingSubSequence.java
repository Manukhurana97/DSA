package com.example.dsa.NewCode.DP.LIS6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubSequence {

    public static int lengthOfLIS(int[] nums) {
        // return lengthOfLISRecurssion(0, -1, nums);

        // int[][] dp = new int[nums.length + 1][nums.length + 1];
        // return lengthOfLISMemoization(0, -1, nums, dp);

        // return lengthOfLISTabulation(nums);

        // return lengthOfLISSpaceOptimization(nums);

        // return lengthOfLISSpaceOptimization1(nums);

        return lengthOfLISPrintSubSequence(nums);
    }

    private static int lengthOfLISRecurssion(int index, int prev, int[] nums) {

        if (index == nums.length)
            return 0;

        int take = 0;
        if (prev == -1 || nums[prev] < nums[index])
            take = 1 + lengthOfLISRecurssion(index + 1, index, nums);

        int notTake = lengthOfLISRecurssion(index + 1, prev, nums);

        return Math.max(take, notTake);
    }

    private static int lengthOfLISMemoization(int index, int prev, int[] nums, int[][] dp) {

        if (index == nums.length)
            return 0;

        if (dp[index][prev + 1] != 0)
            return dp[index][prev + 1];

        int take = 0;
        if (prev == -1 || nums[prev] < nums[index])
            take = 1 + lengthOfLISMemoization(index + 1, index, nums, dp);

        int notTake = lengthOfLISMemoization(index + 1, prev, nums, dp);

        dp[index][prev + 1] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }

    private static int lengthOfLISTabulation(int nums[]) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int take = 0;
                if (prev == -1 || nums[prev] < nums[index])
                    take = 1 + dp[index + 1][index + 1];

                int notTake = dp[index + 1][prev + 1];

                dp[index][prev + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    private static int lengthOfLISSpaceOptimization(int nums[]) {
        int n = nums.length;
        int[] last = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int take = 0;
                if (prev == -1 || nums[prev] < nums[index])
                    take = 1 + last[index + 1];

                int notTake = last[prev + 1];

                curr[prev + 1] = Math.max(take, notTake);
            }
            last = curr;
        }

        return last[0];
    }

    private static int lengthOfLISSpaceOptimization1(int nums[]) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, 1);

        int LIS = 1;

        for (int index = 1; index < n; index++) {
            int maxTillNow = dp[index];
            for (int prev = 0; prev <= index; prev++)
                if (nums[prev] < nums[index])
                    maxTillNow = Math.max(maxTillNow, 1 + dp[prev]);

            dp[index] = maxTillNow;
            LIS = Math.max(LIS, dp[index]);
        }

        return LIS;
    }

    // printing a path
    private static int lengthOfLISPrintSubSequence(int nums[]) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxElement = 0;
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (nums[prev] < nums[index] && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    parent[index] = prev;
                }
            }
            if (dp[index] > dp[maxElement])
                maxElement = index;
        }

        List<Integer> result = new LinkedList<>(); // Changed to ArrayList for better performance
        var index = maxElement;
        while (maxElement != -1) {
            result.add(0, nums[maxElement]);
            maxElement = parent[maxElement];
        }

        System.out.println(result);

        return dp[index];
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, 11, 1, 16, 8 };

        System.out.println(lengthOfLIS(nums));
    }
}