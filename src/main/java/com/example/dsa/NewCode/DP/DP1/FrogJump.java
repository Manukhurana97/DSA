package com.example.dsa.NewCode.DP.DP1;

import java.util.HashMap;
import java.util.Map;

/* 
 * frog can from 1 step or 2 step energy consume is abs(height(j)-height(i)) , from min energy
 */
public class FrogJump {

    public static int frogJump(int n, int heights[]) {

        // return frogJumpRecursion(n, heights);
        Map<Integer, Integer> map = new HashMap<>();
        return frogJumpMemoization(n, heights, map);
    }

    public static int frogJumpRecursion(int n, int heights[]) {
        if (n == 0)
            return 0;

        int oneStep = frogJumpRecursion(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (n > 1)
            twoStep = frogJumpRecursion(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);

        return Math.min(oneStep, twoStep);
    }

    public static int frogJumpMemoization(int n, int heights[], Map<Integer, Integer> map) {

        if (n == 0)
            return 0;

        if (map.containsKey(n))
            return map.get(n);

        int oneStep = frogJumpMemoization(n - 1, heights, map) + Math.abs(heights[n] - heights[n - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (n > 1)
            twoStep = frogJumpMemoization(n - 2, heights, map) + Math.abs(heights[n] - heights[n - 2]);

        map.put(n, Math.min(oneStep, twoStep));
        return Math.min(oneStep, twoStep);
    }

    public static int frogJumpTabulation(int n, int heights[]) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 1; i < n - 1; i++) {
            int oneStep = map.get(i - 1) + Math.abs(heights[i] - heights[i + 1]);
            int twoStep = (n - i > 1) ? map.get(i - 2) + Math.abs(heights[i] - heights[i + 2]) : Integer.MAX_VALUE;
            map.put(i, Math.min(oneStep, twoStep));
        }

        return map.get(map.size() - 1);
    }

    public static int frogJumpSpaceOptimization(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n - 1; i++) {
            int oneStep = prev + Math.abs(heights[i] - heights[i + 1]);
            int twoStep = Integer.MAX_VALUE;
            if (n - i > 1)
                twoStep = prev2 + Math.abs(heights[i] - heights[i + 2]);

            prev2 = prev;
            prev = Math.min(oneStep, twoStep);
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] arr = { 30, 10, 60, 10, 60, 50 };
        System.out.println(frogJump(5, arr));
        System.out.println(frogJumpTabulation(5, arr));
        System.out.println(frogJumpSpaceOptimization(5, arr));

    }

}
