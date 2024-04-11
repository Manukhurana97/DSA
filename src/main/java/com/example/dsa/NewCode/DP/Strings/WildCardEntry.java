package com.example.dsa.NewCode.DP.Strings;

// ?: matches with single char
// *: matches with sequence of length 0 or more
public class WildCardEntry {

    private static boolean wildCardEntry(String s1, String s2) {
        // return wildCardEntryRecursion(s1.length(), s2.length(), s1, s2);
        int[][] dp = new int[s1.length()][s2.length()];
        // return wildCardEntryMemoization(s1.length(), s2.length(), s1, s2, dp);
        return wildCardEntryTabulation(s1, s2);
    }

    // Recurssion
    private static boolean wildCardEntryRecursion(int i, int j, String pattern, String text) {

        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
            return false;
        if (j < 0 && i >= 0) {
            var temp = i;
            while (temp >= 0) {
                if (pattern.charAt(temp) != '*')
                    return false;
                temp--;
            }
            return true;
        }

        if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            return wildCardEntryRecursion(i - 1, j - 1, pattern, text);
        } else if (pattern.charAt(i) == '*') {
            return wildCardEntryRecursion(i - 1, j, pattern, text) || wildCardEntryRecursion(i, j - 1, pattern, text);
        }
        return false;
    }

    // Memoization
    private static boolean wildCardEntryMemoization(int i, int j, String pattern, String text, int[][] dp) {

        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
            return false;
        if (j < 0 && i >= 0) {
            var temp = i;
            while (temp >= 0) {
                if (pattern.charAt(temp) != '*')
                    return false;
                temp--;
            }
            return true;
        }

        if (dp[i][j] != 0)
            return dp[i][j] == 1;

        if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            var match = wildCardEntryMemoization(i - 1, j - 1, pattern, text, dp);
            dp[i][j] = match ? 1 : 2;
            return match;
        } else if (pattern.charAt(i) == '*') {
            var notMatch = wildCardEntryMemoization(i - 1, j, pattern, text, dp)
                    || wildCardEntryMemoization(i, j - 1, pattern, text, dp);
            dp[i][j] = notMatch ? 1 : 2;
            return notMatch;
        }
        dp[i][j] = 2;
        return false;
    }

    private static boolean wildCardEntryTabulation(String pattern, String text) {

        boolean[][] dp = new boolean[pattern.length()][text.length()];

        dp[0][0] = true;
        for (int i = 1; i < pattern.length(); i++) {
            boolean flag = true;
            for (int ii = 1; ii < i; ii++) {
                if (pattern.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int i = 1; i <= pattern.length(); i++) {
            for (int j = 1; j <= text.length(); j++) {
                if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[pattern.length()][text.length()];
    }

    private static boolean wildCardEntrySpaceOptimization(String pattern, String text) {

        boolean[] prev = new boolean[text.length()];
        boolean[] curr = new boolean[text.length()];

        prev[0] = curr[0] = true;
        for (int i = 1; i < pattern.length(); i++) {
            boolean flag = true;
            for (int ii = 1; ii < i; ii++) {
                if (pattern.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            prev[0] = flag;
        }

        for (int i = 1; i <= pattern.length(); i++) {
            for (int j = 1; j <= text.length(); j++) {
                if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (pattern.charAt(i - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            System.arraycopy(curr, 0, prev, 0, curr.length);
        }

        return prev[text.length()];
    }
}
