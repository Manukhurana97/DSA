package com.example.dsa.NewCode.DP.Strings;

public class MinInsertionDeletionToMakeAtoB {

    private static int lca(String a, String b) {
        // return lcaRecursion(a.length(), b.length(), a, b);

        // int[][] dp = new int[a.length() + 1][b.length() + 1];
        // return lcaMemoization(a.length(), b.length(), a, b, dp);

        // return lcaTabulation(a, b);

        return lcaSpaceOptimization(a, b);
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

    // tabulation
    private static int lcaTabulation(String a, String b) {

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[a.length()][b.length()];
    }

    // space optimization
    private static int lcaSpaceOptimization(String a, String b) {

        int[] prev = new int[b.length() + 1];
        int[] curr = new int[b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    prev[j] = 0;
                } else {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        curr[j] = 1 + prev[j - 1];
                    } else {
                        curr[j] = Math.max(prev[j], curr[j - 1]);
                    }
                }
            }
            prev = curr;
            curr = new int[b.length() + 1];
        }

        return prev[b.length()];
    }

    private static int canYouMake(String a, String b) {

        return a.length() + b.length() - 2 * lca(a, b);
    }

    public static void main(String[] args) {
        System.out.println(canYouMake("heap", "pea"));
        System.out.println(canYouMake("geeksforgeeks", "geeks"));
    }
}
