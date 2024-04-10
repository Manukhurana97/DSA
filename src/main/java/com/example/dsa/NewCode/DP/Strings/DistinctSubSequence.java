package com.example.dsa.NewCode.DP.Strings;

public class DistinctSubSequence {
    private static int numDistinct(String s, String t) {

        // return numDistinctRecursion(s.length() - 1, t.length() - 1, s, t);

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // return numDistinctMemoization(s.length() - 1, t.length() - 1, s, t, dp);

        // return numDistinctTabulation(s.length(), t.length(), s, t, dp);
        return numDistinctSpaceOptimization(s.length(), t.length(), s, t);

    }

    // recursion
    private static int numDistinctRecursion(int l1, int l2, String s, String t) {

        if (l2 < 0)
            return 1;
        if (l1 < 0)
            return 0;

        if (s.charAt(l1) == t.charAt(l2))
            return numDistinctRecursion(l1 - 1, l2 - 1, s, t) + numDistinctRecursion(l1 - 1, l2, s, t);

        return numDistinctRecursion(l1 - 1, l2, s, t);

    }

    private static int numDistinctMemoization(int l1, int l2, String s, String t, int[][] dp) {

        if (l2 < 0)
            return 1;
        if (l1 < 0)
            return 0;

        if (dp[l1][l2] != 0)
            return dp[l1][l2];

        int result;
        if (s.charAt(l1) == t.charAt(l2))
            result = numDistinctMemoization(l1 - 1, l2 - 1, s, t, dp) + numDistinctMemoization(l1 - 1, l2, s, t, dp);
        else
            result = numDistinctMemoization(l1 - 1, l2, s, t, dp);
        dp[l1][l2] = result;
        return result;

    }

    private static int numDistinctTabulation(int l1, int l2, String s, String t, int[][] dp) {

        for (int i = 0; i < l1; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= l1; i++)
            for (int j = 1; j <= l2; j++)
                dp[i][j] = dp[i - 1][j] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? dp[i - 1][j - 1] : 0);

        return dp[l1][l2];

    }

    private static int numDistinctSpaceOptimization(int l1, int l2, String s, String t) {

        int[] prev = new int[l2 + 1];
        int[] cur = new int[l2 + 1];

        prev[0] = cur[0] = 1;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                cur[j] = prev[j] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? prev[j - 1] : 0);
            }
            System.arraycopy(cur, 0, prev, 0, l2 + 1);
        }
        return prev[l2];
    }

    public static void main(String[] args) {
        // System.out.println(numDistinct("babgbag", "bag"));
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

}
