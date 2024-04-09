package com.example.dsa.NewCode.DP.Strings;

public class MinInsertionDeletionToMakeAtoB {

    private static int lca(String a, String b) {
        // return lcaRecursion(a.length(), b.length(), a, b);

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        return lcaMemoization(a.length(), b.length(), a, b, dp);
    }

    // recursion
    private static int lcaRecursion(int i, int j, String a, String b) {

        if (i == 0 || j == 0)
            return 0;

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return 1 + lcaRecursion(i - 1, j - 1, a, b);
        }
        return Math.max(lcaRecursion(i - 1, j, a, b), lcaRecursion(i, j - 1, a, b));

    }

    // memoization
    private static int lcaMemoization(int i, int j, String a, String b, int[][] dp) {

        if (i == 0 || j == 0)
            return 0;

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            var take = 1 + lcaMemoization(i - 1, j - 1, a, b, dp);
            dp[i][j] = take;
            return take;
        }
        var notTake = Math.max(lcaMemoization(i - 1, j, a, b, dp), lcaMemoization(i, j - 1, a, b, dp));
        dp[i][j] = notTake;
        return notTake;

    }

    private static int canYouMake(String a, String b) {

        return a.length() + b.length() - 2 * lca(a, b);
    }

    public static void main(String[] args) {
        System.out.println(canYouMake("heap", "pea"));
        System.out.println(canYouMake("geeksforgeeks", "geeks"));
    }
}
