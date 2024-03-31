package com.example.dsa.NewCode.DP.Strings;

// subsequece : continus order (consecutive)
public class LongestCommonSubSet {

    private static int lcs(String s1, String s2) {
        return lcsRecursion(s1.length() - 1, s1, s2.length() - 1, s2);

        // int[][] dp = new int[s1.length()][s1.length()];
        // return lcsMemoization(s1.length() - 1, s1, s2.length() - 1, s2, dp);
        // return lcsTabulation(s1, s2);
        // return lcsSpaceOptimization(s1, s2);
    }

    // base case
    // iterate all path
    // return max;
    private static int lcsRecursion(int l1, String s1, int l2, String s2) {

        if (l1 == 0 || l2 == 0)
            return 0;

        if (s1.charAt(l1) == s2.charAt(l2))
            return 1 + lcsRecursion(l1 - 1, s1, l2 - 1, s2);
        Math.max(lcsRecursion(l1 - 1, s1, l2, s2), lcsRecursion(l1, s1, l2 - 1, s2));
        return 0;
    }

    private static int lcsMemoization(int l1, String s1, int l2, String s2, int[][] dp) {

        if (l1 == 0 || l2 == 0)
            return 0;

        if (s1.charAt(l1) == s2.charAt(l2)) {
            int same = 1 + lcsMemoization(l1 - 1, s1, l2 - 1, s2, dp);
            dp[l1][l2] = same;
            return same;
        }
        Math.max(lcsMemoization(l1 - 1, s1, l2, s2, dp), lcsMemoization(l1, s1, l2 - 1, s2, dp));
        dp[l1][l2] = 0;
        return 0;
    }

    private static int lcsTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    private static int lcsSpaceOptimization(String s1, String s2) {
        int[] prev = new int[s2.length() + 1];
        int[] cur = new int[s2.length() + 1];

        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                    maxLength = Math.max(maxLength, cur[j]);
                } else {
                    cur[j] = 0;
                }
            }
            prev = cur;
            cur = new int[s2.length() + 1];

        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s1 = "abcdefghij";
        String s2 = "abzdefghij";
        System.out.println(lcs(s1, s2));
    }

}
