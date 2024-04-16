package com.example.dsa.NewCode.DP.LIS6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestIDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        Arrays.sort(nums);

        int maxElement = 0;
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if ((nums[index] % nums[prev] == 0) && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    parent[index] = prev;
                }
            }
            if (dp[index] > dp[maxElement])
                maxElement = index;
        }

        List<Integer> result = new LinkedList<>();
        while (maxElement != -1) {
            result.add(0, nums[maxElement]);
            maxElement = parent[maxElement];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 16, 7, 8, 4 };
        System.out.println(largestDivisibleSubset(arr));
    }
}
