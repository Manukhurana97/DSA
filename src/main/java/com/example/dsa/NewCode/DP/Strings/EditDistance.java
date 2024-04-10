package com.example.dsa.NewCode.DP.Strings;

public class EditDistance {

    private int editDistance(String s1, String s2) {
        // return editDistanceRecursion(s1.length(), s2.length(), s1, s2);
        // int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // return editDistanceMemoization(s1.length(), s2.length(), s1, s2, dp);
        return editDistanceSpaceOptimization(s1.length(), s2.length(), s1, s2);
    }

    private int editDistanceRecursion(int l1, int l2, String s1, String s2) {

        if (l1 < 0)
            return l2 + 1;
        if (l2 < 0)
            return l1 + 1;

        if (s1.charAt(l1) == s2.charAt(l2)) {
            return editDistanceRecursion(l1 - 1, l2 - 1, s1, s2);
        } else {
            /* inserting an element in i, will reduce j as we added similar element */
            int insertion = editDistanceRecursion(l1, l2 - 1, s1, s2);
            /* deleting an element from i */
            int deletion = editDistanceRecursion(l1 - 1, l2, s1, s2);
            /* replacing element in i to make it similar to j, reduce reduce both */
            int replace = editDistanceRecursion(l1 - 1, l2 - 1, s1, s2);
            return 1 + Math.min(replace, Math.min(insertion, deletion));
        }
    }

    private int editDistanceMemoization(int l1, int l2, String s1, String s2, int[][] dp) {

        if (l1 < 0)
            return l2 + 1;
        if (l2 < 0)
            return l1 + 1;

        if (dp[l1][l2] != 0)
            return dp[l1][l2];

        int result;
        if (s1.charAt(l1) == s2.charAt(l2)) {
            result = editDistanceMemoization(l1 - 1, l2 - 1, s1, s2, dp);
        } else {
            int insertion = editDistanceMemoization(l1, l2 - 1, s1, s2, dp);
            int deletion = editDistanceMemoization(l1 - 1, l2, s1, s2, dp);
            int replace = editDistanceMemoization(l1 - 1, l2 - 1, s1, s2, dp);
            result = 1 + Math.min(replace, Math.min(insertion, deletion));
        }
        dp[l1][l2] = result;
        return result;
    }

    private int editDistanceTabulation(int l1, int l2, String s1, String s2, int[][] dp) {
        for (int i = 0; i <= l1; i++)
            dp[i][0] = i;

        for (int j = 0; j <= l2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[l1][l2];
    }

    private int editDistanceSpaceOptimization(int l1, int l2, String s1, String s2) {
        int[] prev = new int[l2 + 1];
        int[] curr = new int[l2 + 1];

        for (int i = 0; i <= l2; i++)
            prev[i] = i;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j], prev[j - 1]));
                }
            }
            System.arraycopy(prev, 0, curr, 0, prev.length + 1);
        }
        return prev[l2];
    }

    public static void main(String[] args) {

    }
}
