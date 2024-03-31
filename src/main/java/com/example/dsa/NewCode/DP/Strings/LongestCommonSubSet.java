package com.example.dsa.NewCode.DP.Strings;

// subsequece : continus order (consecutive)
public class LongestCommonSubSet {

    private static int lcs(String s1, String s2) {
        return lcsTabulation(s1, s2);
    }

    // base case
    // iterate all path
    // return max;
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

    public static void main(String[] args) {

        String s1 = "abcdefghij";
        String s2 = "abzdefghij";
        System.out.println(lcs(s1, s2));
    }

}
