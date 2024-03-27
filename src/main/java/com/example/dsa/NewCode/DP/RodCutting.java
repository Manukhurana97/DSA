package com.example.dsa.NewCode.DP;

public class RodCutting {

    public static int cutRod(int price[], int n) {
        return cutRodRecursion(n - 1, price, n);
    }

    public static int cutRodRecursion(int ind, int price[], int n) {

        if (ind == 0) {
            return n * price[0];
        }

        int take = (ind + 1 < n) ? price[ind] + cutRodRecursion(ind, price, n - (ind + 1)) : Integer.MIN_VALUE;
        int nottake = cutRodRecursion(ind - 1, price, n);

        return Math.max(take, nottake);
    }

}
