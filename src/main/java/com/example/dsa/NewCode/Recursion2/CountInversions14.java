package com.example.dsa.NewCode.Recursion2;

public class CountInversions14 {


    public int conquer(int[] arr, int low, int mid, int high) {

        int count = 0;
        int i = low, j = mid + 1, k = low;
        int[] res = new int[arr.length];

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];
                count = high - mid + 1;
            }
        }
        while (i <= mid) {
            res[k++] = arr[i++];
        }
        while (j <= high) {
            res[k++] = arr[j++];
        }
        for (i = low; i <= high; i++) {
            arr[i] = res[i];
        }
        return count;
    }

    public int divide(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            divide(arr, low, mid);
            divide(arr, mid + 1, high);
            count += conquer(arr, low, mid, high);
        }

        return count;
    }

    public static void main(String[] args) {
        CountInversions14 countInversions = new CountInversions14();
        int arr[] = {5, 3, 2, 4, 1};
        var a = countInversions.divide(arr, 0, arr.length - 1);

        System.out.println(a);
    }
}
