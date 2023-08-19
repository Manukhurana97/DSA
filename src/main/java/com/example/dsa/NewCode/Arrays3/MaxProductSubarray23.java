package com.example.dsa.NewCode.Arrays3;

public class MaxProductSubarray23 {

    public static void getProduct(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int product = arr[i];
            for (int j = i + 1; j < n; j++) {
                product = product * arr[j];
                max = Math.max(max, product);
            }
        }

        System.out.println(max);
    }

    public static void getProduct1(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int prod = arr[0];
        for (int i = 1; i < n; i++) {
            prod = arr[i] * prod;
            max = Math.max(max, prod);
        }

        System.out.println(max);
    }

    public static void getProduct2(int[] arr) {
        int n = arr.length;
        int prod = 0;
        int prodLeft = arr[0];
        int prodRight = arr[n - 1];
        for (int i = 1; i < n; i++) {
            prodLeft *= arr[i];
            prodRight *= arr[n - i - 1];

            if (prodLeft == 0) prodLeft = 1;
            if (prodRight == 0) prodRight = 1;

            prod = Math.max(prod, Math.max(prodRight, prodLeft));
        }

        System.out.println(prod);
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};

//        getProduct(arr);
//        getProduct1(arr);
        getProduct2(arr);
    }
}
