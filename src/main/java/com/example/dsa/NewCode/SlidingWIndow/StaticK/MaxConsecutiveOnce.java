package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveOnce {

    public static int longestOnes(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = nums.length, longestOnce = 0;

        while (j < n) {

            int val = nums[j];
            map.put(val, map.getOrDefault(val, 0) + 1);


            while (i < j && map.containsKey(1) && (j - i + 1) - map.get(1) > k) {

                int temp = map.get(nums[i]);
                if (temp == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], temp - 1);
                }

                i++;
            }

            if (map.containsKey(1) && (j - i + 1) - map.get(1) == k) {
                longestOnce = Math.max(longestOnce, (j - i + 1));
            }

            j++;
        }

        return longestOnce;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(arr, 2));
    }
}
