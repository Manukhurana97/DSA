package com.example.dsa.NewCode.Arrays3;

public class RearrangeArrayBySign {

    /**
     * 3, 1, -2, -5, 2, -4
     */


    public static int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];

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


    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        arr = rearrangeArray1(arr);
        for (int i : arr) System.out.print(i + " ");

    }
}
