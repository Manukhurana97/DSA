package com.example.dsa.NewCode.DP;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static boolean subsetSumToKSpaceOptimization(int n, int target, int arr[]) {

        boolean[] prev = new boolean[target + 1];
        boolean[] cur = new boolean[target + 1];

        for (int i = 0; i <= n; i++) // it means that it's possible to achieve a sum of "0" with the subset
            prev[0] = cur[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) { // target
                boolean take = false;
                if (arr[i - 1] <= j)
                    take = prev[j - arr[i - 1]];
                boolean notTake = prev[j];

                cur[j] = take || notTake;
            }
            prev = Arrays.copyOf(cur, cur.length);
        }

        return prev[target];
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }

        if (totalSum % 2 != 0)
            return false;

        return subsetSumToKSpaceOptimization(nums.length - 1, totalSum / 2, nums);
    }

}
