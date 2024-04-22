package com.example.dsa.NewCode.DP.LIS6;

import java.util.Arrays;

public class NumOfLongestIncreasingSubSequence {

    public int findLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];

        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int max = 0
        for(int i: count){
            max = Math.max(max, i);
        }

        return max;
    }

}
