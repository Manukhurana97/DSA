package com.example.dsa.NewCode.Arrays3;

public class KadaneAlgo5 {

    /*get the max element*/
    public static int maxSubArraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    /*get the position of start and end*/
    public static int maxSubArraySum1(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) start = i;
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > max) {
                max = sum;
                end = i;
            }
        }

        System.out.println(start+" "+end);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 2, 1, 5, -3};

        System.out.println(maxSubArraySum(arr));
        System.out.println(maxSubArraySum1(arr));
    }
}
