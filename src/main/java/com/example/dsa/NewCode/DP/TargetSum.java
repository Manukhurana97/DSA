package com.example.dsa.NewCode.DP;

import java.util.Arrays;

public class TargetSum {

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