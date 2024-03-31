package com.example.dsa.NewCode.DP.Strings;

/* 
 * calculate longest palandrame using longest common sequence
 */
public class LongestPalandromicSequence {

    private static int longestPalandromicSequence(String s) {

        StringBuilder builder = new StringBuilder();
        builder.append(s);
        // return lcsRecursion(s.length() - 1, s.length() - 1, s,
        // builder.reverse().toString());

        // int[][] dp = new int[s.length() + 1][s.length() + 1];
        // return lcsMemoization(s.length() - 1, s.length() - 1, s,
        // builder.reverse().toString(), dp);

        // return lcsTabulation(s, builder.reverse().toString());
        return lcsSpaceOptimization(s, builder.reverse().toString());
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

    private static int lcsTabulation(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    private static int lcsSpaceOptimization(String s1, String s2) {

        int[] prev = new int[s1.length() + 1];
        int[] cur = new int[s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }

            prev = cur;
            cur = new int[s2.length() + 1];
        }

        return prev[s2.length()];
    }

    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.println(longestPalandromicSequence(s));
    }

}
