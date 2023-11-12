package com.example.dsa.NewCode.SlidingWIndow;

public class buyAndSellStock {

    public static int getMaxProfit(int[] arr) {
        int i = 0, j = 0, n = arr.length, min = Integer.MAX_VALUE, maxProfit = 0;

        while (j < n) {
            int val = arr[j];

            if (val < min) {
                i = j;
                min = val;
            }

            maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
            j++;
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        System.out.println(getMaxProfit(arr));
    }
}
