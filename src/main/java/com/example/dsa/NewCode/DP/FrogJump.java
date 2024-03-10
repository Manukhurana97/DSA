package com.example.dsa.NewCode.DP;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public static int frogJump(int n, int heights[], Map<Integer, Integer> map) {

        if (n == 0)
            return 0;

        if (map.containsKey(n))
            return map.get(n);

        int oneStep = frogJump(n - 1, heights, map) + Math.abs(heights[n] - heights[n - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (n > 1) {
            twoStep = frogJump(n - 2, heights, map) + +Math.abs(heights[n] - heights[n - 2]);
        }

        map.put(n, Math.min(oneStep, twoStep));
        return Math.min(oneStep, twoStep);
    }

    public static int frogJump(int n, int heights[]) {
        Map<Integer, Integer> map = new HashMap<>();

        return frogJump(n, heights, map);
    }

    // -------------------------------------------------------------------------------------------

    public static int frogJump1(int n, int heights[]) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 1; i < n - 1; i++) {
            int oneStep = Math.abs(heights[i] - heights[i + 1]);
            int twoStep = Integer.MAX_VALUE;
            if (n - i > 1) {
                twoStep = Math.abs(heights[i] - heights[i + 2]);
            }

            map.put(i, Math.min(oneStep, twoStep));
        }

        return map.get(map.size() - 1);
    }

    // -------------------------------------------------------------------------------------------

    public static int frogJump2(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n - 1; i++) {
            int oneStep = Math.abs(heights[i] - heights[i + 1]);
            int twoStep = Integer.MAX_VALUE;
            if (n - i > 1) {
                twoStep = Math.abs(heights[i] - heights[i + 2]);
            }

            prev2 = prev;
            prev = Math.min(oneStep, twoStep);
        }

        return prev;
    }

    // -------------------------------------------------------------------------------------------

    public static int frogwithkJump(int n, int heights[], int k) {
        if (n == 0)
            return 0;

        int minTillNow = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                minTillNow = Math.min(minTillNow,
                        frogwithkJump(n - i, heights, k) + +Math.abs(heights[n] - heights[n - i]));
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
                        frogwithkJump(n - i, heights, k) + +Math.abs(heights[n] - heights[n - i]));

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
        System.out.println(frogJump(5, arr));
        System.out.println(frogJump1(5, arr));
        System.out.println(frogJump2(5, arr));
        System.out.println(frogwithkJump(5, arr, 2));
        System.out.println(frogwithkJumpMemoization(5, arr, 2));

    }

}
