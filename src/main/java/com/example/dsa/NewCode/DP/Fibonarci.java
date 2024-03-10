package com.example.dsa.NewCode.DP;

import java.util.*;

/* DP : 4 ways 
 * 1. simple recursion :: time 0(n^2) , space O(n)
 * 2. recursion + memoization time 0(n) , space O(2n)
 * 3. tabulation :: time 0(n) , space O(n)
 * 4. space optimization :: time 0(n) , space O(1)
*/
public class Fibonarci {

    // it has overlappting sub problems , solving same thing again and again
    private int FibonarciOf(int n) {
        if (n <= 1)
            return 1;

        return FibonarciOf(n - 1) + FibonarciOf(n - 2);
    }

    Map<Integer, Integer> map = new HashMap<>();

    // storing result in map to remove the repeated work
    private int FibonarciWithMemoization(int n) {
        if (n <= 1)
            return 1;

        if (map.containsKey(n))
            return map.get(n);

        int fib = FibonarciWithMemoization(n - 1) + FibonarciWithMemoization(n - 2);
        map.put(n, fib);

        return fib;
    }

    private int FibonarciWithoutExtraSpace(int n) {
        int prev = 1;
        int prev2 = 0;
        for (int i = 1; i <= n; i++) {
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }

        return prev;
    }

    public static void main(String[] args) {
        Fibonarci b = new Fibonarci();
        System.out.println(" -> " + b.FibonarciOf(5));
        System.out.println(" -> " + b.FibonarciWithMemoization(5));
        System.out.println(" -> " + b.FibonarciWithoutExtraSpace(5));
    }
}
