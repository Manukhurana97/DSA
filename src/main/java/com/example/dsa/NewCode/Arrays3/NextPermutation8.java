package com.example.dsa.NewCode.Arrays3;

import java.util.Arrays;

public class NextPermutation8 {


    /*
    1: search for the element with condition ar[i-1]<arr[i]
    2: Now iterate from last and get the first element that is greater the [i-1]
    3: swap the max and [i-1]
    4. sort the arr(i, n);
    * */
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

        if (flagPos != -1) {
            for (int i = n; i > flagPos; i--) {
                if (arr[i] > arr[flagPos]) {
                    swap(arr, i, flagPos);
                    break;
                }
            }
        }

        Arrays.sort(arr, flagPos + 1, arr.length);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 4, 3, 0, 0};
        arr = nextPermutation(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
//2 3 0 0 1 4 5
//2 1 5 3 0 0 2 4
