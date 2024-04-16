package com.example.dsa.NewCode.DP.LIS6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintLIS {

    public static int lengthOfLIS(int[] nums) {
        return lengthOfLISPrintSubSequence(nums);
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
