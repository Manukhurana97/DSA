package com.example.dsa.NewCode.DP.LIS6;

public class LongestIncreasingSubSequence {

    public int lengthOfLIS(int[] nums) {
        return lengthOfLISRecurssion(1, nums);
    }

    public int lengthOfLISRecurssion(int index, int[] nums) {

        if (index < nums.length)
            return 1;

        if (nums[index - 1] < nums[index]) {
            int take = 1 + lengthOfLISRecurssion(index + 1, nums);
            return take;
        } else {
            lengthOfLISRecurssion(index + 1, nums);
            return 1;

        }

    }

}
