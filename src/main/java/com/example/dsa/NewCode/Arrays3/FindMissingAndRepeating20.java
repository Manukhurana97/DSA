package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;

public class FindMissingAndRepeating20 {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {

        /* s - sn: sum of numbers*/
        /* s2 - s2n: sum of square of number*/
        /* a^2-b^2 : (a+b)(a-b) */
        /* a+b = x/(a-b)*/



        long sn = n * (n + 1) / 2;
        long s2n = n * (n + 1) * (2 * n + 1) / 6;
        long s = 0;
        long s2 = 0;

        for (int i : arr) {
            s += i;
            s2 += i * i;
        }

        long v1 = s2 - s; // x-y
        long v2 = s2n - sn; // (x-y)(x+y)

        v2 = v2 / v1; // (x+y)

        long x = (v1 + v2) / 2; //(x+y) + (x-y): 2x = v1+v2: x = (v1+v2)/2
        long y = v2 - v1;

        return new int[]{(int) x, (int) y};

    }

    public static void main(String[] args) {

    }
}
