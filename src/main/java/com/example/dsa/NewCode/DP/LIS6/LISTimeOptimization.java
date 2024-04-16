package com.example.dsa.NewCode.DP.LIS6;

import java.util.ArrayList;
import java.util.List;

public class LISTimeOptimization {

    public static int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > result.get(result.size() - 1)) {
                result.add(nums[i]);
            } else {
                int j = 0;
                for (j = 0; j < result.size(); j++)
                    if (result.get(j) > nums[i]) {
                        result.set(j, nums[j]);
                        break;
                    }
                result.set(j, nums[j]);
            }
        }

        System.out.println(result);

        return result.size();

    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, 11, 1, 7, 16, 8 };

        System.out.println(lengthOfLIS(nums));

    }
}
