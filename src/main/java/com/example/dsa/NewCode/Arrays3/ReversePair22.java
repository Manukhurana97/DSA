package com.example.dsa.NewCode.Arrays3;

public class ReversePair22 {

    public static int sortElement(int[] arr, int start, int mid, int end) {

        int[] sortedElement = new int[arr.length];
        int i = start, j = mid + 1, k = start, count = 0;

        while (i <= mid && j <= end) {
            if (arr[i] > 2 * arr[j]) {
                count += mid - i + 1; // Count pairs satisfying the condition
                j++;
            } else {
                i++;
            }
        }

        i = start;
        j = mid + 1;

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

        return count;

    }

    public static int countPairs(int[] arr, int start, int mid, int end) {
        int count = 0;
        int temp_mid = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (temp_mid <= end && arr[i] > 2 * arr[temp_mid]) {
                count++;
                temp_mid++;
            }
        }
        return count;
    }

    public static int mergeElement(int[] arr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            count += mergeElement(arr, start, mid);
            count += mergeElement(arr, mid + 1, end);
//            count += countPairs(arr, start, mid, end);
            count += sortElement(arr, start, mid, end);
        }

        return count;
    }

    public static int getPair(int[] arr) {
        return mergeElement(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 1};
        System.out.println(getPair(arr));
    }
}
