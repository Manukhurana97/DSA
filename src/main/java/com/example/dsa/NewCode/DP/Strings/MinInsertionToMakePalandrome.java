package com.example.dsa.NewCode.DP.Strings;

// min insertion required to make a string palandrome
// using the longest palandrome logic, get the longest palandrome and subtract from total size eg:
// abcaa :: longest palandrome : aaa :- 2 :: total_len - longestPalandrome Length = total min insertion to make palandrome
public class MinInsertionToMakePalandrome {

    private static int longestPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);

        return longestPalandromeRecursion(s.length(), s.length(), s, builder.reverse().toString());
    }

    private static int longestPalandromeRecursion(int l1, int l2, String s1, String s2) {

        if (l1 <= 0 || l2 <= 0)
            return 0;

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return 1 + longestPalandromeRecursion(l1 - 1, l2 - 1, s1, s2);
        }
        return Math.max(longestPalandromeRecursion(l1 - 1, l2, s1, s2), longestPalandromeRecursion(l1, l2 - 1, s1, s2));
    }

    private int minInsertion(String str) {
        return str.length() - longestPalindrome(str);
    }

}
