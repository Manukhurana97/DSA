package com.example.dsa.NewCode.DP.Strings;

// ?: matches with single char
// *: matches with sequence of length 0 or more
public class WildCardEntry {

    private boolean wildCardEntry(String s1, String s2) {
        return wildCardEntryRecursion(s1.length(), s2.length(), s1, s2);
    }

    // Recurssion
    private boolean wildCardEntryRecursion(int i, int j, String pattern, String text) {

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
    private boolean wildCardEntryMemoization(int i, int j, String pattern, String text, int[][] dp) {

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
}
