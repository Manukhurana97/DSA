package com.example.dsa.NewCode.DP.LIS6;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public static int longestStrChain(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isMatch(words[i], words[j]) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);

        }

        return maxLength;
    }

    private static boolean isMatch(String s1, String s2) {
        if (s1.length() != s2.length() + 1)
            return false;
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }

        return i == s1.length() && j == s2.length();
    }

    public static void main(String[] args) {
        String[] arr = { "a", "b", "ba", "bca", "bda", "bdca" };
        System.out.println(longestStrChain(arr));
    }

}
