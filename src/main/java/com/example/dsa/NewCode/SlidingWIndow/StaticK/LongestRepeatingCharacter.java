package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {

    public static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> elementCount = new HashMap<>();

        int i = 0, j = 0, n = s.length(), maxLength = 0;

        while (j < n) {
            var ch = s.charAt(j);
            elementCount.put(ch, elementCount.getOrDefault(ch, 0) + 1);

            while (i<=j && j - i + 1 - Collections.max(elementCount.entrySet(), Map.Entry.comparingByValue()).getValue() > k) {
                char temp = s.charAt(i);
                elementCount.put(temp, elementCount.get(temp) - 1);
                i++;
            }

            System.out.println(elementCount);

            maxLength = Math.max(maxLength, (j - i + 1));

            j++;
        }

        return maxLength;
    }
    public static int characterReplacement1(String s, int k) {

        HashMap<Character, Integer> elementCount = new HashMap<>();

        int i = 0, j = 0, n = s.length(), maxLength = 0, maxf=0;

        while (j < n) {
            var ch = s.charAt(j);
            elementCount.put(ch, elementCount.getOrDefault(ch, 0) + 1);

            maxf = Math.max(maxf, elementCount.get(ch));
            while (i<=j && j - i + 1 - maxf > k) {
                char temp = s.charAt(i);
                elementCount.put(temp, elementCount.get(temp) - 1);
                i++;
            }

            maxLength = Math.max(maxLength, (j - i + 1));

            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement1("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacement1("AABABBA", 1));
    }
}
