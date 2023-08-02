package com.example.dsa.NewCode.Arrays3;

public class DNF3 {

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static int[] dnf(int[] arr, int n) {
        int l = 0, m = 0, h = n - 1;
        while (m < h) {
            if (arr[m] == 0) {
                swap(arr,  m, l);
                l++;
                m++;
            } else if (arr[m] == 1) {
                m++;
            } else {
                swap(arr, m, h);
                h--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 2,2,2,0,2,2,2,2};
        arr = dnf(arr, arr.length);
        for(int i: arr)
            System.out.print(i+" ");
    }
}
