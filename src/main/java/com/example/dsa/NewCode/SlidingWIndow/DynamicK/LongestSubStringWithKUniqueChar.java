package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

import java.util.*;

public class LongestSubStringWithKUniqueChar {

    public static int largestSequence(char[] arr, int k) {

        int i = 0, j = 0, n = arr.length, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>(); // store unique element

        while (j < n) {
            char ch = arr[j];
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            while (map.size() > k) {
                var c = arr[i++];
                if (map.containsKey(c)) {
                    var temp = map.get(c);
                    if (temp == 1) {
                        map.remove(c);
                    } else {
                        map.put(c, temp - 1);
                    }
                }
            }

            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(largestSequence("aabacbebebe".toCharArray(), 3));

    }
}
