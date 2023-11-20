package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

import java.util.HashSet;
import java.util.Set;

public class MaxLengthSubstringWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int i=0,j=0, n = s.length(), maxLengthSubString = 0;

        while(j<n){
            char ch = s.charAt(j);

            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(ch);
            maxLengthSubString = Math.max(maxLengthSubString, j-i+1);
            j++;
        }

        return maxLengthSubString;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
