package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*find longest substring with unique element*/
public class LongestSubstringWithoutRepeating {

//    using set we just store the element and , use the while loop to update the i.
    public static int getLongestString(char[] arr) {

        int i = 0, j = 0, n = arr.length, maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (j < n) {
            var ch = arr[j];
            while (set.contains(ch)) {
                set.remove(arr[i++]);
            }

            set.add(ch);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }

    /*using hashMap we can directly jump to the index of element and move to the next index for (i)*/
    public static int getLongestString1(char[] arr) {

        int i = 0, j = 0, n = arr.length, maxLen = 0;
        Map<Character, Integer> set = new HashMap();

        while (j < n) {
            var ch = arr[j];
            if (set.containsKey(ch)) {
                i = Math.max(i, set.get(ch) + 1);
            }

            set.put(ch, j);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(getLongestString("abcabcdefddazrtyhgd".toCharArray()));
        System.out.println(getLongestString1("abcabcdefddazrtyhgd".toCharArray()));
    }
}
