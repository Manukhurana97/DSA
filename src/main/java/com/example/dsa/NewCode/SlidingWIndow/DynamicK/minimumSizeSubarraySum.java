package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

public class minimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, n = nums.length, resultMinLenSubArr = Integer.MAX_VALUE, sum = 0;

        while (j < n) {

            sum += nums[j];

            while (sum >= target) {
                sum -= nums[i];
                resultMinLenSubArr = Math.min(resultMinLenSubArr, (j - i + 1));
                i++;
            }


            j++;
        }

        return resultMinLenSubArr==Integer.MAX_VALUE?0:resultMinLenSubArr;
    }

    public static void main(String[] args) {

        System.out.println((minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})));
        System.out.println((minSubArrayLen(11, new int[]{1,2,3,4,5})));
    }
}
