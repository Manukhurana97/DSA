package com.example.dsa.NewCode.DP.Strings;

import java.util.Arrays;

// subsequence : part of a string in a sequence / order : abc :- a, b, c, ab, bc, ac, abc
// subString : can we in any order : abc :- , b, c, ba, acb, ....

public class LongestCommonSubSequence {

    /*
     * Largest Common SubString
     * Steps:
     * 1: Base Case
     * 2: explore all strings
     * 3: max
     */
    public static int lcs(String s, String t) {
        // return lcsRecursion(s.length() - 1, s, t.length() - 1, t);

        // int[][] dp = new int[s.length()][t.length()];
        // return lcsMemoization(s.length(), s, t.length(), t, dp);

        return lcsTabulation(s.length() - 1, s, t.length() - 1, t);
    }

    public static int lcsRecursion(int sl, String s, int tl, String t) {

        if (sl < 0 || tl < 0)
            return 0;

        if (s.charAt(sl) == t.charAt(tl))
            return 1 + lcsRecursion(sl - 1, s, tl - 1, t); // if both match , reduce index of both
        return Math.max(lcsRecursion(sl - 1, s, tl, t), lcsRecursion(sl, s, tl - 1, t)); // reduce index of both one by
        // one
    }

    public static int lcsMemoization(int sl, String s, int tl, String t, int[][] dp) {

        if (sl < 0 || tl < 0)
            return 0;

        if (dp[sl][tl] != 0)
            return dp[sl][tl];

        if (s.charAt(sl) == t.charAt(tl)) {
            var take = 1 + lcsMemoization(sl - 1, s, tl - 1, t, dp); // if both match , reduce index of both
            dp[sl][tl] = take;
            return take;
        }
        var notTake = Math.max(lcsMemoization(sl - 1, s, tl, t, dp), lcsMemoization(sl, s, tl - 1, t, dp));
        dp[sl][tl] = notTake;
        return notTake;

    }

    /*
     * Steps:
     * 1. Base case
     * 2. loop in opp of recursion
     * 3. return min/max/sum
     */
    public static int lcsTabulation(String s, String t) {
        // since the base case is (sl < 0 || tl < 0) : we dont have -ve we will shilf
        // element by 1

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    private static int lcsSpaceOptimization(String s, String t) {
        int[] cur = new int[t.length() + 1];
        int[] prev = new int[t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0 || j == 0)
                    prev[j] = 0;
                else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        cur[j] = 1 + prev[j - 1];
                    } else {
                        cur[j] = Math.max(prev[j], cur[j - 1]);
                    }
                }

                // copying value from cur to prev
                System.arraycopy(cur, 0, prev, 0, cur.length);
            }
        }

        return prev[t.length()];
    }

}
