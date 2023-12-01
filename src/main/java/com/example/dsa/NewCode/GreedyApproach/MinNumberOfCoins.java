package com.example.dsa.NewCode.GreedyApproach;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinNumberOfCoins {

    static int minCoins(int coins[], int m, int v) {
        if (v == 0) return 0;

        Arrays.sort(coins);

        int count = 0;

        for (int i = m - 1; i >= 0; i--) {
            if (coins[i] <= v) {
                count++;
                v -= coins[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{25, 10, 5}, 3, 30));
    }
}
