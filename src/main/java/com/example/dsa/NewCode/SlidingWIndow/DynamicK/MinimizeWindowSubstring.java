package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimizeWindowSubstring {

    public static int getWindow(String[] arr, String t) {

        int i = 0, j = 0, n = arr.length, k = t.length(), minLength = Integer.MAX_VALUE, total = t.length();
        Map<String, Integer> map = new HashMap<>();

        for (int z = 0; z < k; z++) {
            var value = t.charAt(z);
            map.put(String.valueOf(value), map.getOrDefault(value, 0) + 1);
        }

        while (j < n) {
            var val = arr[j];

            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);

                while (i <= j && map.get(val) < 0) {
                    if (Objects.equals(arr[i], val)) map.put(val, 0);
                    i++;
                }

                if (map.get(val) == 0) total--;
            }

            if (total == 0)
                minLength = Math.min(minLength, j - i + 1);

            j++;
        }


        return minLength;
    }


    public static String minWindow(String s, String t) {

        int left = 0, right = 0, n = s.length(), minStart = 0, minLength = Integer.MAX_VALUE, requiredChars = 0;
        Map<Character, Integer> actual = new HashMap<>();
        Map<Character, Integer> expected = new HashMap<>();

        for (var z : t.toCharArray()) expected.put(z, expected.getOrDefault(z, 0) + 1);

        while (right < n) {
            var charRight = s.charAt(right);

            actual.put(charRight, actual.getOrDefault(charRight, 0) + 1);

            if (expected.containsKey(charRight) && actual.get(charRight).equals(expected.get(charRight))) {
                requiredChars--;
            }

            while (requiredChars == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                var charLeft  = s.charAt(left);
                actual.put(charLeft , actual.get(charLeft ) - 1);

                if (expected.containsKey(charLeft ) && expected.get(charLeft ) > actual.get(charLeft )) requiredChars++;
                left++;
            }
            right++;
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLength);
    }


    public static void main(String[] args) {
        String[] arr = {"T", "O", "T", "M", "T", "A", "P", "T", "A", "T"};
        System.out.println(getWindow(arr, "TTA"));

        System.out.println(minWindow("aa", "aa"));
    }
}
