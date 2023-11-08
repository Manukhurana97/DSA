package com.example.dsa.NewCode.SlidingWIndow.StaticK;


/*Max Sum subarray of size k*/
public class MaxSumSubarray {

    public static int getMaxSum(int[] arr, int k) {
        int i = 0, j = 0, n = arr.length, maxSum = 0, sum = 0;
        while (j < n) {
            if (j - i < k) {
                sum += arr[j++];
                continue;
            }

            maxSum = Math.max(maxSum, sum);
            sum -= arr[i++];
            sum += arr[j++];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;

        System.out.println(getMaxSum(arr, k));
    }
}
