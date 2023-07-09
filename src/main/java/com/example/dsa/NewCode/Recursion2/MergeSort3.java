package com.example.dsa.NewCode.Recursion2;

public class MergeSort3 {


    private static void sort(int[] arr, int start, int mid, int end) {

//        int n1 = mid - start + 1;
//        int n2 = end - mid;
//
//        int[] l = new int[n1];
//        int[] r = new int[n2];
//
//
//        for (int i = 0; i < n1; i++) l[i] = arr[start + i];
//        for (int i = 0; i < n2; i++) r[i] = arr[mid + i + 1];
//
//
//        int i = 0, j = 0, k = start;
//        while (i < n1 && j < n2) arr[k++] = (l[i] < r[j]) ? l[i++] : r[j++];
//        while (i < n1) arr[k++] = l[i++];
//        while (j < n2) arr[k++] = r[j++];


        int[] res = new int[arr.length];

        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) res[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        while (i <= mid) res[k++] = arr[i++];
        while (j <= end) res[k++] = arr[j++];

        for(i=start;i<=end;i++){
            arr[i] = res[i];
        }

     }

    private static void merge(int[] arr, int i, int n) {

        if (i < n) {
            int m = i + (n - i) / 2;
            merge(arr, i, m);
            merge(arr, m + 1, n);
            sort(arr, i, m, n);
        }


    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 5, 2, 6, 4};
        merge(arr, 0, arr.length - 1);
        for (int i : arr) System.out.print(i + " ");
    }
}
