package OldCode.Sorting;

import java.util.Arrays;

public class RadixSort {

    public static void radix(int[] arr, int i, int n) {
        int[] output = new int[n];
        int[] count = new int[10];

        for (int j = 0; j < n; j++)
            count[(arr[j] / i) % 10]++;


        for (int j = 1; j < count.length; j++)
            count[j] += count[j - 1];

        for (int j = n - 1; j >= 0; j--)
            output[--count[(arr[j] / i) % 10]] = arr[j];

        for (int j = 0; j < n; j++)
            arr[j] = output[j];


    }

    public static void sort(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr[i]);

        for (int i = 1; max / i > 0; i *= 10)
            radix(arr, i, n);

        return;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4, 22, 301, 33, 567};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
