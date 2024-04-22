package com.example.dsa.NewCode.DP.LIS6;

import java.util.Arrays;

public class LongestBitonicSequence {

    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;
        int[] left = new int[nums.length];
        Arrays.fill(left, 1);
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }

        int[] right = new int[nums.length];
        Arrays.fill(right, 1);
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }

        int minRemoval = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++)
            if (left[i] > 1 && right[i] > 1)
                minRemoval = Math.min(minRemoval, n - (left[i] + right[i] - 1));

        return minRemoval;
    }

}
