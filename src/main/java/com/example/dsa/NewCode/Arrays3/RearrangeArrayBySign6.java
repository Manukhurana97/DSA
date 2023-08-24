package com.example.dsa.NewCode.Arrays3;

public class RearrangeArrayBySign6 {

    /**
     * 3, 1, -2, -5, 2, -4
     */


    public static int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];

        int i = 0, j = 0, k = 0;
        while (k < nums.length) {
            if (nums[k] > 0) pos[i++] = nums[k];
            else neg[j++] = nums[k];
            k++;
        }

        i = 0;
        j = 0;
        k = 0;
        while (k < nums.length) {
            if (k % 2 == 0) nums[k++] = pos[i++];
            else nums[k++] = neg[j++];
        }

        return nums;
    }


    public static int[] rearrangeArray1(int[] nums) {
        int pos = 0, neg = 1, k = 0;
        int[] aux = new int[nums.length];

        while (k < nums.length) {
            if (nums[k] > 0) {
                aux[pos] = nums[k++];
                pos += 2;
            } else {
                aux[neg] = nums[k++];
                neg += 2;
            }
        }
        return aux;
    }

    /* when pos & neg and negative are not equal*/
    public static int[] rearrangeArray2(int[] nums) {
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];

        int k = 0, i = 0, j = 0;
        while (k < nums.length) {
            if (nums[k] > 0) pos[i++] = nums[k++];
            else neg[j++] = nums[k++];
        }

        k = 0;
        int i1 = 0;
        int j1 = 0;
        while (i1 < i && j1 < j) nums[k++] = (k % 2 != 0) ? pos[i1++] : neg[j1++];
        while (i1 < i) nums[k++] = pos[i1++];
        while (j1 < j) nums[k++] = neg[j1++];


        return nums;
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        int[] arr1 = {3, 1, -2, -5, 2, -4, -1, -2};

        arr = rearrangeArray(arr);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();

        arr = rearrangeArray1(arr);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();

        arr = rearrangeArray2(arr);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();


    }
}
