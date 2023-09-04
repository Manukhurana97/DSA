package com.example.dsa.OldCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetPeek {
    public static int peakElement(int[] arr, int n) {
        int localPeek = 0, globalPeek = 0;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) localPeek = 0;
        if (arr[n - 1] > arr[localPeek]) localPeek = n - 1;

        for (int i = 1; i < n - 1; i++) {
            localPeek = (arr[i] >= arr[i + 1] && arr[i] >= arr[i - 1] && arr[i] > localPeek) ? i : localPeek;
            globalPeek = (arr[globalPeek] < arr[localPeek]) ? localPeek : globalPeek;
        }
        return arr[globalPeek];
    }

    static int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey((k - arr[i]))) {
                count += map.get((k - arr[i])); // get the value
            }

            map.put(arr[i], (map.getOrDefault(arr[i], 0) + 1));
        }
        return count;

    }


    public static int equilibriumPoint(int arr[], int n) {

//        if (n == 1) return 1;
//        long index = 0;
//        for (int i = 1; i < n; i++) {
//            int left = 0, right = 0;
//            for (int j = 0; j < i; j++) {
//                left += arr[j];
//            }
//            for (int k = i+1; k < n; k++) {
//                right += arr[k];
//            }
//            if (left == right)
//                return i + 1;
//        }
//        return -1;

        if (n == 1) return 1;
        long total = 0;
        for (long i : arr)
            total += i;

        long localsum = arr[0];
        for (int i = 1; i < n; i++) {
            int temp = (int) (total - (arr[i] + localsum));

            if (temp == localsum) return i + 1;

            localsum += arr[i];

        }

        return -1;
    }


    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                result.add(max);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {17, 19, 9, 5, 3, 6, 17, 7, 18, 16, 18, 11, 3, 15, 2};
        System.out.println("peek " + peakElement(arr, arr.length));
        int[] arr1 = {1, 2, 2, 1};
        System.out.println("peek " + peakElement(arr1, arr1.length));

        int[] arr2 = {1, 1, 1, 1};
        int arr3[] = {1, 3, 5, 2, 2};
        System.out.println("pairs count " + getPairsCount(arr2, arr2.length, 2));
        System.out.println("pairs count " + getPairsCount(arr3, arr3.length, 4));

        System.out.println(equilibriumPoint(arr, arr.length));

    }


}
