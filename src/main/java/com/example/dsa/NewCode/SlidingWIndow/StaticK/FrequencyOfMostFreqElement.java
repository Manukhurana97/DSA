package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.Arrays;

public class FrequencyOfMostFreqElement {


    public static int maxFrequency(int[] nums, int k) {

        int i = 0, j = 0, n = nums.length, totalTillNow = 0, maxFreq = 0;

        Arrays.sort(nums);

        while (j < n) {
            int val = nums[j];
            totalTillNow += val;
            while (val * (j - i + 1) > totalTillNow + k && i<=j) {
                totalTillNow -= nums[i];
                i++;
            }

            maxFreq = Math.max(maxFreq, (j - i + 1));

            j++;
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 4};
        System.out.println(maxFrequency(arr, 2));
    }
}
