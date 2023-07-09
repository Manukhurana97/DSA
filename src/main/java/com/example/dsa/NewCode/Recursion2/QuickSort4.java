package com.example.dsa.NewCode.Recursion2;

public class QuickSort4 {


    private void swap(int[] arr, int from, int to) {
        if(from==to) return;
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }


    private int getPivot(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, i+1, high);
        return i + 1;
    }

    private void qSort(int[] arr, int low, int high) {

        if (low <=high) {
            int pivot = getPivot(arr, low, high);
            qSort(arr, low, pivot - 1);
            qSort(arr, pivot + 1, high);
        }
        return;
    }

    private void qSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 40, 50, 70};

        QuickSort4 quickSort4 = new QuickSort4();
        quickSort4.qSort(arr);

        for (int i : arr)
            System.out.println("i = " + i);

    }
}
