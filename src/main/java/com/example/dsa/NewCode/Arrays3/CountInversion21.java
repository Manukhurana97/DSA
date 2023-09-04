package com.example.dsa.NewCode.Arrays3;

public class CountInversion21 {

    /*O(n^2)*/
    public static int count(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count += (arr[i] > arr[j]) ? 1 : 0;
            }
        }

        return count;
    }

    /* using merge sort*/
    public static int sort(int[] arr, int start, int mid, int end) {

        int i = start, j = mid + 1, k = start;
        int[] res = new int[arr.length];

        int count = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                res[k++] = arr[i++];
            } else {
                count += mid - i + 1;
                res[k++] = arr[j++];
            }
        }


        while (i <= mid) res[k++] = arr[i++];
        while (j <= end) res[k++] = arr[j++];


        System.arraycopy(res, start, arr, start, end - start + 1);

        return count;
    }


    public static int merge(int[] arr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += merge(arr, start, mid);
            count += merge(arr, mid + 1, end);
            count += sort(arr, start, mid, end);
        }
        return count;

    }

    public static int count1(int[] arr) {
        return merge(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(count(arr));
//        System.out.println(count1(arr));
    }
}
