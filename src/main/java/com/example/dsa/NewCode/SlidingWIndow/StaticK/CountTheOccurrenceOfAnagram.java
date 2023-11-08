package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountTheOccurrenceOfAnagram {

    public static String swap(String str, int from, int to) {
        var chLst = str.toCharArray();
        char temp = chLst[from];
        chLst[from] = chLst[to];
        chLst[to] = temp;

        return new String(chLst);

    }

    /* O(!s.length)*/
    public static void getAnagram(String s, int i, int r, Set<String> set) {
        if (i == r) {
            set.add(s);
            return;
        }
        for (int j = i; j <= r; j++) {
            s = swap(s, i, j);
            getAnagram(s, i + 1, r, set);
            s = swap(s, i, j);
        }
    }

    // O(str.length - w.length+1);
    public static int countAnagrams(String str, String w) {

        if (w.isEmpty() || str.isEmpty()) return 0;

        Set<String> set = new HashSet<>();
        getAnagram(w, 0, w.length() - 1, set);

        str += " ";
        int i = 0, j = 0, k = w.length(), n = str.length(), noOfAnagram = 0;
        StringBuilder builder = new StringBuilder();

        while (j < n) {
            var value = str.charAt(j);

            if (j - i < k) {
                builder.append(value);
                j++;
                continue;
            }

            noOfAnagram += set.contains(builder.toString()) ? 1 : 0;
            builder.append(value);
            builder.deleteCharAt(0);
            i++;
            j++;
        }

        return noOfAnagram;
    }


    public static int countAnagrams1(String str, String w) {
        int[] actual = new int[26];
        int[] expected = new int[26];

        /*O(w), O(K)*/
        for (char c : w.toCharArray()) {
            actual[c - 'a'] += 1;
        }

        int i = 0, j = 0, k = w.length(), n = str.length(), noOfAnagram = 0;

        while (j < n) {
            expected[str.charAt(j++) - 'a'] += 1;

            while (j - i > k) {
                expected[str.charAt(i++) - 'a'] -= 1;

            }

            boolean flag = true;

            for (int idx = 0; idx <26; idx++) {
                if (actual[idx] != expected[idx]) {
                    flag = false;
                    break;
                }
            }

            if(flag) noOfAnagram ++;
        }

        return noOfAnagram;
    }

    public static void main(String args[]) {

        System.out.println(countAnagrams("foaxxorfxofx", "fox"));
        System.out.println(countAnagrams1("foaxxorfxofx", "fox"));
        System.out.println(countAnagrams("aabaabaa", "aaba"));
        System.out.println(countAnagrams1("aabaabaa", "aaba"));
    }
}
