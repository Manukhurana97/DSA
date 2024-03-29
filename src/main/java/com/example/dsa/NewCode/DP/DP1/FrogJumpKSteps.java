package com.example.dsa.NewCode.DP.DP1;

import java.util.HashMap;
import java.util.Map;

public class FrogJumpKSteps {

    public static int frogwithkJump(int n, int heights[], int k) {
        if (n == 0)
            return 0;

        int minTillNow = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                minTillNow = Math.min(minTillNow,
                        frogwithkJump(n - i, heights, k) + Math.abs(heights[n] - heights[n - i]));
            }
        }

        return minTillNow;
    }

    public static int frogwithkJumpMemoization(int n, int heights[], int k, Map<Integer, Integer> map) {
        if (n == 0)
            return 0;

        if (map.containsKey(n))
            return map.get(n);

        int minTillNow = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                minTillNow = Math.min(minTillNow,
                        frogwithkJump(n - i, heights, k) + Math.abs(heights[n] - heights[n - i]));

            }
        }
        map.put(n, minTillNow);

        return minTillNow;
    }

    public static int frogwithkJumpMemoization(int n, int heights[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return frogwithkJumpMemoization(n, heights, k, map);
    }

    public static void main(String[] args) {
        int[] arr = { 30, 10, 60, 10, 60, 50 };
        System.out.println(frogwithkJump(5, arr, 2));
        System.out.println(frogwithkJumpMemoization(5, arr, 2));

    }

}
