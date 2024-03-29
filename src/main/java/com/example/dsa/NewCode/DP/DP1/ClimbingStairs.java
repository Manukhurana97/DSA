package com.example.dsa.NewCode.DP.DP1;

import java.util.*;

/* give a number of stairs, starting from 0, user can climb either 1, 2 steps, return distinct way he can climb */
public class ClimbingStairs {

    private static int ClimbStairs(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int one = ClimbStairs(n - 1);
        int two = ClimbStairs(n - 2);

        return one + two;
    }

    private static int ClimbStairsMemoization(int n, Map<Integer, Integer> map) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (map.containsKey(n))
            return map.get(n);

        int one = ClimbStairsMemoization(n - 1, map);
        map.put(n, one);
        int two = ClimbStairsMemoization(n - 2, map);
        map.put(n, two);

        return one + two;
    }

    private static int ClimbStairsMemoization(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        return ClimbStairsMemoization(n, map);
    }

    public static void main(String[] args) {
        System.out.println(ClimbStairs(3));
        System.out.println(ClimbStairsMemoization(3));
    }

}
