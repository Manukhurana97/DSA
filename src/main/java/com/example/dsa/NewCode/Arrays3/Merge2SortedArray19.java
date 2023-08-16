package com.example.dsa.NewCode.Arrays3;

import java.util.Arrays;

public class Merge2SortedArray19 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }

        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        merge(arr1, arr1.length, arr2, arr2.length);
    }
}
