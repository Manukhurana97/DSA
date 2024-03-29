package com.example.dsa.NewCode.DP.DP1;

import java.util.*;

public class MaximumSumOfNonAdjacentElement {

    // reccursion + memoization
    public static int maximumNonAdjacentSum(int n, ArrayList<Integer> nums, Map<Integer, Integer> map) {
        // if (n == 0)
        // return nums.get(n);
        if (n < 0)
            return 0;
        if (map.containsKey(n))
            return map.get(n);

        int pick = maximumNonAdjacentSum(n - 2, nums, map) + nums.get(n);
        int notPick = maximumNonAdjacentSum(n - 1, nums, map);

        int max = Math.max(pick, notPick);
        map.put(n, max);
        return max;

    }

    // tabluation
    public static int maximumNonAdjacentSumTabulation(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int pick = nums.get(i) + ((i > 1) ? arr[i - 2] : 0);
            int notPick = nums.get(i);

            arr[i] = Math.max(pick, notPick);
        }

        return Math.max(arr[n - 1], n - 2 >= 0 ? arr[n - 2] : 0);
    }

    // constant space
    public static int maximumNonAdjacentSumConstantSpace(ArrayList<Integer> nums) {
        int n = nums.size();

        int current = 0;
        int prev = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {

            result = Math.max(nums.get(i) + prev, current);

            prev = current;
            current = result;
        }

        return result;
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        return maximumNonAdjacentSum(nums.size() - 1, nums, map);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        System.out.println(maximumNonAdjacentSum(list));
        System.out.println(maximumNonAdjacentSumTabulation(list));
        System.out.println(maximumNonAdjacentSumConstantSpace(list));
    }

}
