package com.example.dsa.NewCode.SlidingWIndow;

public class minimumNumberOfFlipsToMakeBinary {

    public static int flip(int[] arr) {

        int i = 0, j = 0, n = arr.length, count = 0;

        while (j < n) {
            int val = arr[j];
            if (j / 2 == 0 && val == 1) {
                i = j;
            }
            if (j / 2 == 1 && val == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                count++;
            }

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0};
//        101010
    }
}
