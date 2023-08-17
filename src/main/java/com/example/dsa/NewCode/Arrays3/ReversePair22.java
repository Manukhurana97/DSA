package com.example.dsa.NewCode.Arrays3;

public class ReversePair22 {

    public static void sortElement(int[] arr, int start, int mid, int end) {

        int[] sortedElement = new int[arr.length];
        int i = start, j = mid + 1, k = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sortedElement[k++] = arr[i++];
            } else {
                sortedElement[k++] = arr[j++];
            }
        }


        while (i <= mid) {
            sortedElement[k++] = arr[i++];
        }

        while (j <= end) {
            sortedElement[k++] = arr[j++];
        }

        for (i = start; i <= end; i++) {
            arr[i] = sortedElement[i];
        }

    }

    public static void mergeElement(int[] arr, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeElement(arr, start, mid);
            mergeElement(arr, mid + 1, end);
            sortElement(arr, start, mid, end);
        }


        return;
    }

    public static int getPair(int[] arr) {
        mergeElement(arr, 0, arr.length - 1);
        return 10;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 1};
        System.out.println(getPair(arr));
    }
}
