package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class noOfSubsetContainingAllThreeChar {
    public int numberOfSubstrings(String s) {

        int i = 0, j = 0, n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();


        while (j < n) {
            var val = s.charAt(j);

            map.put(val, map.getOrDefault(val, 0) + 1);

            while (map.size() == 3 && i <= j) {
                var temp = map.get(s.charAt(i));
                if (temp > 1) {
                    map.put(val, temp - 1);
                } else {
                    map.remove(s.charAt(i));
                }
                i++;
            }

            j++;
        }

        return result;

    }
}
