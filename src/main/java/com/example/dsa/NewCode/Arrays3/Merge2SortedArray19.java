package com.example.dsa.NewCode.Arrays3;

public class Merge2SortedArray19 {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - n - 1;
        int j = n - 1;
        int k = m - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        for (int i1 : nums1) System.out.println(i1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        merge(arr1, arr1.length, arr2, arr2.length);
    }
}
