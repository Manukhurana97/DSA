package com.example.dsa.NewCode.DP.Strings;

// min insertion required to make a string palandrome
// using the longest palandrome logic, get the longest palandrome and subtract from total size eg:
// abcaa :: longest palandrome : aaa :- 2 :: total_len - longestPalandrome Length = total min insertion to make palandrome
public class MinInsertionToMakePalandrome {

    private static int longestPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);

        // return longestPalandromeRecursion(s.length(), s.length(), s,
        // builder.reverse().toString());

        // int[][] dp = new int[s.length() + 1][s.length() + 1];
        // return longestPalindromeMemoization(s.length(), s.length(), s,
        // builder.reverse().toString(), dp);

        // return longestPalindromeTabulation(s, builder.reverse().toString());

        return longestPalindromeSpaceOptimization(s, builder.reverse().toString());
    }

    // using recursion
    private static int longestPalandromeRecursion(int l1, int l2, String s1, String s2) {

        if (l1 <= 0 || l2 <= 0)
            return 0;

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return 1 + longestPalandromeRecursion(l1 - 1, l2 - 1, s1, s2);
        }
        return Math.max(longestPalandromeRecursion(l1 - 1, l2, s1, s2), longestPalandromeRecursion(l1, l2 - 1, s1, s2));
    }

    // using memoization
    private static int longestPalindromeMemoization(int l1, int l2, String s1, String s2, int[][] dp) {

        if (l1 <= 0 || l2 <= 0)
            return 0;

        if (dp[l1][l2] != 0)
            return dp[l1][l2];

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            var result = 1 + longestPalindromeMemoization(l1 - 1, l2 - 1, s1, s2, dp);
            dp[l1][l2] = result;
            return result;

        }
        var result = Math.max(
                longestPalindromeMemoization(l1 - 1, l2, s1, s2, dp),
                longestPalindromeMemoization(l1, l2 - 1, s1, s2, dp));
        dp[l1][l2] = result;
        return result;

    }

    // tabulation
    private static int longestPalindromeTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s1.length() + 1];

        for (int l1 = 0; l1 <= s1.length(); l1++) {
            for (int l2 = 0; l2 <= s2.length(); l2++) {
                if (l1 == 0 || l2 == 0)
                    dp[l1][l2] = 0;
                else {
                    if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                        dp[l1][l2] = 1 + dp[l1 - 1][l2 - 1];
                    } else {
                        dp[l1][l2] = Math.max(dp[l1 - 1][l2], dp[l1][l2 - 1]);
                    }
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    // space optimization
    private static int longestPalindromeSpaceOptimization(String s1, String s2) {
        int[] prev = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];

        for (int l1 = 0; l1 <= s1.length(); l1++) {
            for (int l2 = 0; l2 <= s2.length(); l2++) {
                if (l1 == 0 || l2 == 0)
                    prev[l2] = curr[l2] = 0;
                else {
                    if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                        curr[l2] = 1 + prev[l2 - 1];
                    } else {
                        curr[l2] = Math.max(prev[l2], curr[l2 - 1]);
                    }
                }
            }
        }

        return prev[s2.length()];
    }

    private static int minInsertion(String str) {
        return str.length() - longestPalindrome(str);
    }

    public static void main(String[] args) {
        String str = "abcaa";
        System.out.println(minInsertion(str));
    }
}
