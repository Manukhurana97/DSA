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

                while (i < j && map.get(val) < 0) {
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


    public static void main(String[] args) {
        String[] arr = {"T", "O", "T", "M", "T", "A", "P", "T", "a", "T"};
        System.out.println(getWindow(arr, "TTA"));
    }
}
