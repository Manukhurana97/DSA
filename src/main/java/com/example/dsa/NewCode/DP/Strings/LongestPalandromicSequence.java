package com.example.dsa.NewCode.DP.Strings;

public class LongestPalandromicSequence {

    private static int longestPalandromicSequence(String s) {

        StringBuilder builder = new StringBuilder();
        builder.append(s);
        // return lcsRecursion(s.length() - 1, s.length() - 1, s,
        // builder.reverse().toString());

        int[][] dp = new int[s.length() + 1][s.length() + 1];
        return lcsMemoization(s.length() - 1, s.length() - 1, s, builder.reverse().toString(), dp);
    }

    private static int lcsRecursion(int l1, int l2, String s1, String s2) {

        if (l1 < 0 || l2 < 0)
            return 0;

        if (s1.charAt(l1) == s2.charAt(l2))
            return 1 + lcsRecursion(l1 - 1, l2 - 1, s1, s2);
        return Math.max(lcsRecursion(l1 - 1, l2, s1, s2), lcsRecursion(l1, l2 - 1, s1, s2));

    }

    private static int lcsMemoization(int l1, int l2, String s1, String s2, int[][] dp) {

        if (l1 < 0 || l2 < 0)
            return 0;

        if (dp[l1][l2] != 0)
            return dp[l1][l2];

        if (s1.charAt(l1) == s2.charAt(l2)) {
            int match = 1 + lcsMemoization(l1 - 1, l2 - 1, s1, s2, dp);
            dp[l1][l2] = match;
            return match;
        }
        int notMatch = Math.max(lcsMemoization(l1 - 1, l2, s1, s2, dp), lcsMemoization(l1, l2 - 1, s1, s2, dp));
        dp[l1][l2] = notMatch;
        return notMatch;

    }

    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.println(longestPalandromicSequence(s));
    }

}
