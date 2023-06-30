package OldCode.Arrays;

import java.util.*;

public class GetPeek {
    public static int peakElement(int[] arr, int n) {
        int peek = 0, temp = 0;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) peek = 0;
        if (arr[n - 1] > arr[peek]) peek = n - 1;


        for (int i = 1; i < n - 1; i++)
            peek = (arr[i] >= arr[i + 1] && arr[i] >= arr[i - 1] && arr[i] > peek) ? i : peek;

        return peek;
    }

    static int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey((k - arr[i]))) {
                System.out.println(map.get((k - arr[i])));
                count += map.get((k - arr[i])); // get the value
            }
            map.putIfAbsent(arr[i], 0);// if not exist the add
            map.put(arr[i], (map.get(arr[i]) + 1)); // increment the value by 1
        }
        return count;

    }


    public static int equilibriumPoint(long arr[], int n) {

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
//        int[] arr = {17, 19, 9, 5, 3, 6, 17, 7, 18, 16, 18, 11, 3, 15, 2};
//        int[] arr = {1, 2, 2, 1};
//        System.out.println(peakElement(arr, arr.length));

//        int[] arr = {1, 1, 1, 1};
//        System.out.println("res " + getPairsCount(arr, 4, 2));

        long arr[] = {1, 3, 5, 2, 2};
        System.out.println(equilibriumPoint(arr, arr.length));

    }


}
