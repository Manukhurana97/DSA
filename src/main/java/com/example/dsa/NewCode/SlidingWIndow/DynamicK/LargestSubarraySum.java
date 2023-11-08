package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

public class LargestSubarraySum {

    public static int getLargestSubarray(int[] arr, int k) {
        int i = 0, j = 0, n = arr.length, currentSum = 0, maxSubarray = 0;

        while (i <= j && j < n) {
            currentSum += arr[j];

             if (currentSum == k) {
                maxSubarray = Math.max(maxSubarray, j - i + 1);
            }

            while(currentSum>k && i<j){
                currentSum-=arr[i++];
            }

            j++;
        }

        return maxSubarray;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int s = 5;

        System.out.println(getLargestSubarray(arr, s));
    }
}
