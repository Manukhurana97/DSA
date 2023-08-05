package com.example.dsa.NewCode.Arrays3;

import java.util.Arrays;

public class NextPermutation8 {


    public static void reverseSort(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static int[] nextPermutation(int[] arr) {

        int flagPos = -1;
        int n = arr.length - 1;
        for (int i = n; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                flagPos = i - 1;
                break;
            }
        }

        if (flagPos == -1)
            reverseSort(arr, 0, n);

        for (int i = n; i > flagPos; i--) {
            if (arr[i] > arr[flagPos]) {
                swap(arr, i, flagPos);
                break;
            }
        }

        Arrays.sort(arr, flagPos + 1, arr.length);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        arr = nextPermutation(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
