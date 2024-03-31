package com.example.dsa.NewCode.DP.Strings;

public class PrintLongestCommonSubsequence {

    public static int[][] lcsTabulation(String s, String t) {
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

        return dp;
    }

    public static String lcss(String s, String t) {
        var dp = lcsTabulation(s, t);

        int i = s.length();
        int j = t.length();

        StringBuilder builder = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                builder.insert(0, s.charAt(i - 1));
                i -= 1;
                j -= 1;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i -= 1;
                } else {
                    j -= 1;
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";

        System.out.println(lcss(s1, s2));
    }
}
